/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.facade;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.uncc.weadvise.careers.beans.Job;
import edu.uncc.weadvise.careers.beans.University;
import edu.uncc.weadvise.discussion.beans.DiscussionComment;
import edu.uncc.weadvise.discussion.beans.DiscussionTopic;
import edu.uncc.weadvise.trainings.beans.Training;
import edu.uncc.weadvise.trainings.beans.TrainingRegistration;
import edu.uncc.weadvise.usermanagement.beans.User;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class WebServiceFacade {
    private static final String BASE_URL = "http://localhost:8084/WeAdviseWebServices/webresources";
    private static final String POST_USER_URL = BASE_URL+"/User";
    private static final String GET_USER_URL = BASE_URL+"/User/name/";
    private static final String TRAINING_URL = BASE_URL+"/Training";
    private static final String TRAINING_REGISTRATION_URL = BASE_URL+"/TrainingRegistration";
    private static final String DISCUSSION_TOPIC_URL = BASE_URL+"/DiscussionTopic";
    private static final String DISCUSSION_COMMENT_URL = BASE_URL+"/DiscussionComment";
    private static final String UNIVERSITY_URL = BASE_URL+"/University";
    private static final String JOB_URL = BASE_URL+"/Job";
    public static void registerUser(User user){
        Gson gson = new Gson();
        
        // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL(POST_USER_URL);
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(gson.toJson(user));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }

    }
    public static User getUser(String username){
        
        
        // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL(GET_USER_URL+username);
                URLConnection connection = url.openConnection();
//                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
//                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//                out.write(username);
//                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line = null;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                return new Gson().fromJson(response.toString(), User.class);
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
            
            return null;

    }
    public static ArrayList<Training> getTrainings(){
        
        
        // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL(TRAINING_URL);
                URLConnection connection = url.openConnection();
//                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
//                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//                out.write(username);
//                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line = null;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                
                java.lang.reflect.Type listType = new TypeToken<ArrayList<Training>>() {
                    }.getType();
                
                return new Gson().fromJson(response.toString(), listType);
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
            
            return null;

    }

    public static int createTraining(Training training) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(TRAINING_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(training));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }
    public static int updateTraining(Training training) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(TRAINING_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestMethod("PUT");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(training));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }
    
    public static int deleteTraining(Training training) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(TRAINING_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestMethod("DELETE");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(training));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }
    
    public static ArrayList<TrainingRegistration> getTrainingRegistrations(){
        
        
        // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL(TRAINING_REGISTRATION_URL);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line = null;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                
                java.lang.reflect.Type listType = new TypeToken<ArrayList<TrainingRegistration>>() {
                    }.getType();
                
                return new Gson().fromJson(response.toString(), listType);
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
            
            return null;

    }
    
    public static int createTrainingRegistration(TrainingRegistration training) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(TRAINING_REGISTRATION_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(training));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }

    public static ArrayList<DiscussionTopic> getDiscussions() {
        // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL(DISCUSSION_TOPIC_URL);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line = null;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("@@ Reposne : "+response);
                in.close();
                
                java.lang.reflect.Type listType = new TypeToken<ArrayList<DiscussionTopic>>() {
                    }.getType();
                
                return new Gson().fromJson(response.toString(), listType);
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
            
            return null;

    }

    public static int createDiscussion(DiscussionTopic discussion) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(DISCUSSION_TOPIC_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(discussion));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }

    public static int postComment(DiscussionComment comment) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(DISCUSSION_COMMENT_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(comment));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }

    public static int updateDiscussion(DiscussionTopic training) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(DISCUSSION_TOPIC_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestMethod("PUT");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(training));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }
    
    public static int deleteDiscussion(DiscussionTopic discussion) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(DISCUSSION_TOPIC_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestMethod("DELETE");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(discussion));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }
    
    public static int deleteDiscussionComment(DiscussionComment comment) {
        HttpURLConnection connection = null;
        try {
                URL url = new URL(DISCUSSION_COMMENT_URL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestMethod("DELETE");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(new Gson().toJson(comment));
                out.close();
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
 
                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
                return connection.getResponseCode();
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
        return 0;
    }
    
    public static ArrayList<University> getUniversities() {
        // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL(UNIVERSITY_URL);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line = null;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("@@ Reposne : "+response);
                in.close();
                
                java.lang.reflect.Type listType = new TypeToken<ArrayList<University>>() {
                    }.getType();
                
                return new Gson().fromJson(response.toString(), listType);
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
            
            return null;

    }
    public static ArrayList<Job> getJobs() {
        // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL(JOB_URL);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
 
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line = null;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("@@ Reposne : "+response);
                in.close();
                
                java.lang.reflect.Type listType = new TypeToken<ArrayList<Job>>() {
                    }.getType();
                
                return new Gson().fromJson(response.toString(), listType);
            } catch (Exception e) {
                System.out.println("\nError while calling REST Service");
                System.out.println(e);
            }
            
            return null;

    }
}
