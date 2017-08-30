/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.beans;

import edu.uncc.weadvise.beans.Training;
import edu.uncc.weadvise.beans.User;
import java.util.Date;

/**
 *
 * @author Kapil
 */
public class TrainingRegistration {
    Training training;
    User user;
    String registrationDate;

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
}
