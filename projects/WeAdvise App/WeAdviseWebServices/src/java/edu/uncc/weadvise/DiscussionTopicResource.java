/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise;

import com.google.gson.Gson;
import edu.uncc.weadvise.beans.DiscussionComment;
import edu.uncc.weadvise.beans.DiscussionTopic;
import edu.uncc.weadvise.beans.Training;
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
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Kapil
 */
@Path("DiscussionTopic")
public class DiscussionTopicResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DiscussionTopicResource
     */
    public DiscussionTopicResource() {
    }

    /**
     * Retrieves representation of an instance of edu.uncc.weadvise.DiscussionTopicResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() throws Exception {
        ArrayList<DiscussionTopic> discussionList = new ArrayList<DiscussionTopic>();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
           String query= "select * from discussion_topic;";
           System.out.println("Query="+query);
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                DiscussionTopic discussion
                        = new DiscussionTopic();
                discussion.setId(rs.getLong("id"));
                discussion.setContent(rs.getString("content"));
                discussion.setCreated(rs.getString("create_date"));
                discussion.setCreatedBy(TrainingResource.getUser(rs.getLong("created_by")));
                discussion.setComments(DiscussionCommentResource.getComments(discussion.getId()));
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
     * PUT method for updating or creating an instance of DiscussionTopicResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    public Response postJson(String content) throws Exception {
//        INSERT INTO `we_advise`.`discussion_topic` (`content`, `create_date`, `created_by`) VALUES ('How can I crack Google aptitude test', '2015-02-02', '2');
        try {
            Gson gson = new Gson();
            DiscussionTopic discussion = gson.fromJson(content, DiscussionTopic.class);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query = "INSERT INTO `we_advise`.`discussion_topic` (`content`, `create_date`, `created_by`) VALUES ( ?, now(), ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, discussion.getContent());
            ps.setLong(2, discussion.getCreatedBy().getId());

            ps.executeUpdate();

            return Response.ok().build();
        } catch (Exception ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw ex;
        }
    }
    
    /**
     * PUT method for updating or creating an instance of TrainingResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public Response putJson(String content) throws Exception {
//        UPDATE `we_advise`.`training` SET `name`='Intelligent Robotics', `trainer_name`='Abhishek Kabra', `is_approved`='t' WHERE `id`='5';
        try {
            Gson gson = new Gson();
            DiscussionTopic training = gson.fromJson(content, DiscussionTopic.class);
//            UPDATE `we_advise`.`discussion_topic` SET `content`='What is minimum TOEFL requirement for UNC Charlotte', `create_date`='2015-04-23 00:42:30', `created_by`='2' WHERE `id`='11';
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query= "UPDATE `we_advise`.`discussion_topic` SET `content`= ? WHERE `id`="+training.getId()+";";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,training.getContent());
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
            System.out.println("@@@@@@@@@@@@deleting discussion");
            Gson gson = new Gson();
            DiscussionTopic discussion = gson.fromJson(content, DiscussionTopic.class);
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query= "DELETE FROM `we_advise`.`discussion_topic` WHERE `id`='"+discussion.getId()+"';";
            
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
}
