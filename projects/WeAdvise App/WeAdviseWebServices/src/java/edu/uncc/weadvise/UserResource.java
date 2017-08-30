/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise;

import edu.uncc.weadvise.beans.User;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;


@Path("User")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of edu.uncc.weadvise.UserResource
     * @param param
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    public String getJson(@PathParam("name") String param) throws Exception {
        User user = new User();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
           String query= "select * from user where username='"+param+"';";
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
            }
            else
            {
                System.out.println("Empty");
                rs.close();
                throw new Exception("No User Found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return new Gson().toJson(user);
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    public void postJson(String content) throws Exception {
        try {
            Gson gson = new Gson();
            User user = gson.fromJson(content, User.class);
            System.out.println("@@ Username : "+user.getUsername());
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query= "INSERT INTO `we_advise`.`user` (`first_name`, `last_name`, `password`, `username`, `phonenumber`, `email`, `address`) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getPassowrd());
            ps.setString(4,user.getUsername());
            ps.setString(5,user.getPhoneNumber());
            ps.setString(6,user.geteMail());
            ps.setString(7,user.getAddress());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw ex;
        }
    }
}
