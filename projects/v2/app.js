var exp=require("express");
var app=exp();
var bodyparser=require("body-parser");
var mongoose =require("mongoose");
var passport= require("passport");
var localStrategy=require("passport-local")
var campgroundModel=require("./models/campground");

// var userLogin=require("./models/userlogin");
var seedDB=require("./seeds");
var comment = require("./models/comment");
var user=require("./models/user");
mongoose.connect("mongodb://localhost/yelcamp_v2");



// campgroundModel.create({
//      name:"salman" ,
//      img:"http://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5115421.jpg"
    
// },function(err,obj){
//     if(!err){
//         console.log(obj);
//     }else{
//         console.log("error in creating database");
//     }
// });



app.use(bodyparser.urlencoded({extended : true}));
app.use(exp.static("public"));

// seedDB();

//  var data=[
       
//       {name:"salman" ,img:"http://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5115421.jpg"},
//       {name:"summer camp" ,img:"http://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5115421.jpg"},
//       {name:"gorilla camp" ,img:"http://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5115421.jpg"}
//       ,
//       {name:"salman" ,img:"http://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5115421.jpg"},
//       {name:"summer camp" ,img:"http://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5115421.jpg"},
//       {name:"gorilla camp" ,img:"http://www.fs.usda.gov/Internet/FSE_MEDIA/stelprdb5115421.jpg"}
    
//       ];




//passport configuration
app.use(require("express-session")({
 
  secret : "rahul kasula",
  resave :  false,
  saveUninitialized : false
 
}));

app.use(passport.initialize());
app.use(passport.session());
passport.use(new localStrategy(user.authenticate()));
passport.serializeUser(user.serializeUser());
passport.deserializeUser(user.deserializeUser());

app.get("/",function(req,res){
    res.render("home.ejs");
});

//registration routes

app.get("/register",function(req,res){
    res.render("register.ejs");
});

//sign up post route
app.post("/register",function(req,res){
// console.log(req.body.username);
var newUser=new user({userName: req.body.username});
// console.log(newUser);
  user.register(new user({userName: req.body.username}),req.body.password,function(err,User){
    if(err){
        console.log(err);
        res.render("register.ejs");
    }else{
        console.log(user+" new user");
        
        passport.authenticate("local")(req,res,function(){
        res.redirect("/campground");    
        });
        
        
    }
        
  });
  //here it stores the password as hash 
});


app.get("/campground",function(req,res){
 
       campgroundModel.find({},function(err,allCampgrounds){


if(!err){
    res.render("campground.ejs",{campground:allCampgrounds});
}else{
    console.log("error");
}           
       });
       
       
    //   res.render("campground.ejs",{campground:data});
   
});

app.post("/campground",function(req,res){
  var n=req.body.name;
  var u=req.body.url;
  var d=req.body.des;
  var newData={name:n,img:u,des:d};
  campgroundModel.create(newData,function(err,objReturned){
      if(!err){
            console.log("successfully created");
            res.redirect("/campground");

      }else{
          console.log("error creating campground data");
      }
  });
//   data.push(newData);
 
  console.log(n,u);
  //   res.render("new.ejs");
});
app.get("/campground/new",function(req,res){
  
  res.render("new.ejs");
});

app.get("/campground/:id",function(req,res){

campgroundModel.findById(req.params.id).populate("comments").exec(function(err,returnedObj){
    
    if(err){
        console.log("error finding the campground id");
    }else{
//   comment.create({
//     text : "lol",
//     author :"rahul kasula"
// },function(err,something){
//     if(!err){
        
//         console.log(something);
//         returnedObj.comments.push(something);
//         returnedObj.save();
//         console.log(returnedObj);
//     }
    
// });

          res.render("show.ejs",{foundCampground : returnedObj});    
     
    }
});
});

//============================
//comment routes
//============================

app.get("/campground/:id/comment/new",function(req,res){
    //res.send("this is new comments page");
    
    campgroundModel.findById(req.params.id,function(err,foundObj){

if(!err){
    res.render("newcomment.ejs",{campground:foundObj});   
}

        
    });
 
});

//post route of comment
app.post("/campground/:id/comment",function(req,res){


 campgroundModel.findById(req.params.id,function(err,foundObj){
if(!err){
  //creating comment 
  comment.create(req.body.comment,function(err,something){
      console.log("from the new comment page"+req.body.comment.author+" "+req.body.comment.text);
    if(!err){
        
        console.log("returned comment after creation in db"+something);
        foundObj.comments.push(something);
        foundObj.save();
        res.redirect("/campground/"+foundObj._id);
        console.log(foundObj);
    }
    
});

  }else{
    res.redirect("/campgrounds");
}
     
 });


});




app.listen(process.env.PORT,process.env.IP,function(){
    console.log("connection setup");
});