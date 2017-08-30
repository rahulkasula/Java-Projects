/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise;

import com.google.gson.Gson;
import edu.uncc.weadvise.beans.DiscussionTopic;
import edu.uncc.weadvise.beans.University;
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
@Path("University")
public class UniversityResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UniversityResource
     */
    public UniversityResource() {
    }

    /**
     * Retrieves representation of an instance of edu.uncc.weadvise.UniversityResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() throws Exception {
        ArrayList<University> universityList = new ArrayList<University>();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/we_advise", "root", "root");
           String query= "select * from university;";
           System.out.println("Query="+query);
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                University university
                        = new University();
                university.setId(rs.getLong("id"));
                university.setName(rs.getString("name"));
                university.setHomeUrl(rs.getString("home_url"));
                university.setMinGre(rs.getInt("min_gre"));
                university.setMinGpa(rs.getInt("min_gpa"));
                university.setMinToefl(rs.getInt("min_toefl"));
                university.setMinExperience(rs.getInt("min_experience"));
                universityList.add(university);
                
            }
            rs.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return new Gson().toJson(universityList);
    }

    /**
     * PUT method for updating or creating an instance of UniversityResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
