var mongoose=require("mongoose");
var campgroundSchema = new mongoose.Schema({
    name : String,
    img :  String,
    des : String,
    comments : [
        {
        
        type : mongoose.Schema.Types.ObjectId,
        ref : "comment"
                
        }
        ] 
});

module.exports =mongoose.model("Campground",campgroundSchema);

