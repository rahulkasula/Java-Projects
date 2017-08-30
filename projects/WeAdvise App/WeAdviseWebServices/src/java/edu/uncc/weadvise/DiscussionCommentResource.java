/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise;

import edu.uncc.weadvise.beans.DiscussionComment;
import com.google.gson.Gson;
import edu.uncc.weadvise.beans.DiscussionTopic;
import edu.uncc.weadvise.beans.Training;
import edu.uncc.weadvise.beans.TrainingRegistration;
import edu.uncc.weadvise.beans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;


@Path("DiscussionComment")
public class DiscussionCommentResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DiscussionCommentResource
     */
    public DiscussionCommentResource() {
    }

    /**
     * Retrieves representation of an instance of edu.uncc.weadvise.DiscussionCommentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/topic_id/{topic_id}")
    @Produces("application/json")
    public String getJson(@PathParam("topic_id") String param) throws Exception {
        ArrayList<DiscussionComment> discussionList = new ArrayList<DiscussionComment>();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
           String query= "select * from discussion_comment where discussion_topic_id='"+param+"';";
           System.out.println("Query="+query);
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                DiscussionComment discussion = new DiscussionComment();
                discussion.setId(rs.getLong("id"));
                discussion.setDiscussionId(Long.parseLong(param));
                discussion.setComment(rs.getString("comment"));
                discussion.setComentedUser(TrainingResource.getUser(rs.getLong("user_id")));
                //TODO: comments
                discussionList.add(discussion);
                
            }
            rs.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return new Gson().toJson(discussionList);
    }

    /**
     * PUT method for updating or creating an instance of DiscussionCommentResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    public Response postJson(String content) throws Exception {
        try {
            Gson gson = new Gson();
            DiscussionComment comment = gson.fromJson(content, DiscussionComment.class);

//            INSERT INTO `we_advise`.`discussion_comment` (`comment`, `user_id`, `discussion_topic_id`) VALUES ('ETS book is good', '2', '1');
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query = "INSERT INTO `we_advise`.`discussion_comment` (`comment`, `user_id`, `discussion_topic_id`) VALUES ( ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, comment.getComment());
            ps.setLong(2, comment.getComentedUser().getId());
            ps.setLong(3, comment.getDiscussionId());

            ps.executeUpdate();

            return Response.ok().build();
        } catch (Exception ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw ex;
        }
    }
    
    @DELETE
    @Consumes("application/json")
    public Response deleteJson(String content) throws Exception {
        try {
            System.out.println("@@@@@@@@@@@@deleting discussion comment");
            Gson gson = new Gson();
            DiscussionComment discussion = gson.fromJson(content, DiscussionComment.class);
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query= "DELETE FROM `we_advise`.`discussion_comment` WHERE `id`='"+discussion.getId()+"';";
            
            System.out.println("Executing : "+query);
            PreparedStatement ps= con.prepareStatement(query);
            int result = ps.executeUpdate();
            System.out.println("Result : "+result);
            
            return Response.ok().build();
        } catch (Exception ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw ex;
        }
        
    }
    
    public static ArrayList<DiscussionComment> getComments(long id) throws Exception {
        ArrayList<DiscussionComment> discussionList = new ArrayList<DiscussionComment>();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
           String query= "select * from discussion_comment where discussion_topic_id='"+id+"';";
           System.out.println("Query="+query);
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                DiscussionComment discussion = new DiscussionComment();
                discussion.setId(rs.getLong("id"));
                discussion.setDiscussionId(id);
                discussion.setComment(rs.getString("comment"));
                discussion.setComentedUser(TrainingResource.getUser(rs.getLong("user_id")));
                //TODO: comments
                discussionList.add(discussion);
                
            }
            rs.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return discussionList;
    }
}
