/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise;

import com.google.gson.Gson;
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
import javax.ws.rs.Produces;
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
@Path("TrainingRegistration")
public class TrainingRegistrationResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TrainingRegistrationResource
     */
    public TrainingRegistrationResource() {
    }

    /**
     * Retrieves representation of an instance of
     * edu.uncc.weadvise.TrainingRegistrationResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() throws Exception {
        ArrayList<TrainingRegistration> registrationList = new ArrayList<TrainingRegistration>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query = "select * from training_registration;";
            System.out.println("Query=" + query);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                TrainingRegistration registration = new TrainingRegistration();
                registration.setUser(getUser(rs.getLong("user_id")));
                registration.setTraining(getTraining(rs.getLong("training_id")));
                registration.setRegistrationDate(rs.getString("registration_date"));
                registrationList.add(registration);

            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return new Gson().toJson(registrationList);
    }

    /**
     * PUT method for updating or creating an instance of
     * TrainingRegistrationResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("application/json")
    public Response postJson(String content) throws Exception {
        try {
            Gson gson = new Gson();
            TrainingRegistration registration = gson.fromJson(content, TrainingRegistration.class);

//            INSERT INTO `we_advise`.`training_registration` (`user_id`, `training_id`, `registration_date`) VALUES ('2', '2', '2015-22-04');
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query = "INSERT INTO `we_advise`.`training_registration` (`user_id`, `training_id`, `registration_date`) VALUES ( ?, ?, now());";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, registration.getUser().getId());
            ps.setLong(2, registration.getTraining().getId());

            ps.executeUpdate();

            return Response.ok().build();
        } catch (Exception ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw ex;
        }
    }

    private Training getTraining(long id) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query = "select * from training where id=" + id + ";";
            System.out.println("Query=" + query);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                Training training = new Training();
                training.setId(rs.getLong("id"));
                training.setName(rs.getString("name"));
                training.setDescription(rs.getString("description"));
                training.setCreated(rs.getString("created"));
                training.setTrainer_name(rs.getString("trainer_name"));
                training.setCreated_by(getUser(rs.getLong("created_by")));

                training.setApproved((rs.getString("is_approved").equals("t")) ? true : false);

                rs.close();
                return training;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    private User getUser(long id) {
        try {
            User user = new User();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
            String query = "select * from user where id=" + id + ";";
            System.out.println("Query=" + query);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassowrd(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setPhoneNumber(rs.getString("phonenumber"));
                user.seteMail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setAdmin(rs.getString("user_type").equals("a") ? true : false);

                System.out.println("@@@@@@@@@@@@@Password: " + user.getPassowrd());
                rs.close();
                return user;
            } else {
                System.out.println("Empty");
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
