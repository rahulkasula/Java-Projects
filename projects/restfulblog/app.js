var express =require("express"),
app=express(),
methodOverride=require("method-override"),
bdyparser=require("body-parser"),
mongoose=require("mongoose");

// our website will have title url and body (description) n a date

mongoose.connect("mongodb://localhost/restful_blog_app");
app.use(express.static("public"));
app.use(bdyparser.urlencoded({extended : true }));
app.use(methodOverride("_method"));
// mongoose/model/config
var blogSchema=mongoose.Schema({
    title :String,
    image :String,
    body: String,
    created: {type: Date, defauls:Date.now() } 
});
var blog=mongoose.model("blog",blogSchema);

app.get("/",function(req,res){
res.redirect("/blogs");    
});
//index route
app.get("/blogs",function(req,res){
blog.find({},function(err,blogs){
    if(!err){
        res.render("index.ejs",{blogs : blogs});
    }
    
});


   
});




// new route
app.get("/blogs/new",function(req,res){

    res.render("new.ejs");
});

//create post route
app.post("/blogs",function(req,res){

blog.create(req.body.blog,function(err,newcallback){
if(!err){
    console.log("its successful and here are the details"+newcallback);
        res.redirect("/blogs");
}else{
    res.render("new.ejs");
}    
});    
});
//readme route
app.get("/blogs/:id",function(req,res){
// res.render("show.ejs");

blog.findById(req.params.id,function(err,foundblog){
if(!err){
    res.render("show.ejs",{blog :foundblog });
}else{
    
    res.redirect("/blogs");
}
    
});
});

//edit route
app.get("/blogs/:id/edit",function(req,res){
blog.findById(req.params.id,function(err,foundBlog){
    
    if(!err){
        res.render("edit.ejs",{blog :foundBlog});           
    }else{
        res.render("index.ejs");
    }
    
});



});


//update route
app.put("/blogs/:id",function(req,res){
//(id,newData,callBackData)
blog.findByIdAndUpdate(req.params.id,req.body.blog,function(err,updatedBlog){
  
  if(!err){
          console.log("updated blog"+updatedBlog);
        //   res.redirect("/blogs"+req.params._id);
    res.render("show.ejs",{blog :req.body.blog});

  }//if condition
  else{
      res.redirect("/blogs");
  }    
});

    
});




//Delete Route
app.delete("/blogs/:id",function(req,res){
blog.findByIdAndRemove(req.params.id,function(err){

if(!err){
    res.redirect("/blogs");
    
}
    
});  

    
});


app.listen(process.env.PORT,process.env.IP,function(){
    console.log("server is running");
});