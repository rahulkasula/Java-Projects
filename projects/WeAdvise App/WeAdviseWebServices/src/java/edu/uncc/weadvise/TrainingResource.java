/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise;

import com.google.gson.Gson;
import edu.uncc.weadvise.beans.Training;
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
@Path("Training")
public class TrainingResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TrainingResource
     */
    public TrainingResource() {
    }

    /**
     * Retrieves representation of an instance of edu.uncc.weadvise.TrainingResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() throws Exception {
        ArrayList<Training> trainingList = new ArrayList<Training>();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
           String query= "select * from training;";
           System.out.println("Query="+query);
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                Training training = new Training();
                System.out.println("we are in if statement");
                training.setId(rs.getLong("id"));
                training.setName(rs.getString("name"));
                training.setDescription(rs.getString("description"));
                training.setCreated(rs.getString("created"));
                training.setTrainer_name(rs.getString("trainer_name"));
                training.setCreated_by(getUser(rs.getLong("created_by")));
                
                training.setApproved((rs.getString("is_approved").equals("t")) ? true : false);
                trainingList.add(training);
                
                System.out.println("@@@@@@@@@@@@@Training: "+training.getName());
            }
            rs.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return new Gson().toJson(trainingList);
    }
    
    public static User getUser(long id){
        try{
           User user = new User();
           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
           String query= "select * from user where id="+id+";";
           System.out.println("Query="+query);
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(query);
            if(rs.next())
            {
                System.out.println("we are in if statement");
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassowrd(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setPhoneNumber(rs.getString("phonenumber"));
                user.seteMail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setAdmin(rs.getString("user_type").equals("a") ? true : false);
                
                System.out.println("@@@@@@@@@@@@@Password: "+user.getPassowrd());
                rs.close();
                return user;
            }
            else
            {
                System.out.println("Empty");
                rs.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @POST
    @Consumes("application/json")
    public Response postJson(String content) throws Exception {
        try {
            Gson gson = new Gson();
            Training training = gson.fromJson(content, Training.class);
            System.out.println("@@ Training : "+training.getName());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query= "INSERT INTO `we_advise`.`training` (`name`, `description`, `created`, `created_by`, `trainer_name`, `is_approved`) VALUES (?, ?, now(), ?, ?, 'f');";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,training.getName());
            ps.setString(2,training.getDescription());
            ps.setLong(3,(training.getCreated_by() != null) ? training.getCreated_by().getId() : 1L );
            ps.setString(4,training.getTrainer_name());
            
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
            Training training = gson.fromJson(content, Training.class);
            System.out.println("@@ Training : "+training.getName());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query= "UPDATE `we_advise`.`training` SET `name`=?, `description`=?, `trainer_name`=?, `is_approved`=? WHERE `id`="+training.getId()+";";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,training.getName());
            ps.setString(2,training.getDescription());
            ps.setString(3,training.getTrainer_name());
            ps.setString(4,training.isApproved() ? "t" : "f");
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
//        UPDATE `we_advise`.`training` SET `name`='Intelligent Robotics', `trainer_name`='Abhishek Kabra', `is_approved`='t' WHERE `id`='5';
        try {
            Gson gson = new Gson();
            Training training = gson.fromJson(content, Training.class);
            System.out.println("@@ Training : "+training.getName());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query= "DELETE FROM `we_advise`.`training` WHERE `id`='"+training.getId()+"';";
            PreparedStatement ps= con.prepareStatement(query);
            ps.executeUpdate();
            
            return Response.ok().build();
        } catch (Exception ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw ex;
        }
        
    }
}
