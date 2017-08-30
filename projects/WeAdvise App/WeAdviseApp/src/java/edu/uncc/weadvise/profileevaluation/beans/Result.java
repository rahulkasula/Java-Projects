/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.profileevaluation.beans;

import edu.uncc.weadvise.careers.beans.Job;
import edu.uncc.weadvise.careers.beans.University;
import edu.uncc.weadvise.trainings.beans.Training;
import java.util.ArrayList;

/**
 *
 * @author Kapil
 */
public class Result {
    ArrayList<University> universityList = new ArrayList<University>();
    ArrayList<Job> jobList = new ArrayList<Job>();
    ArrayList<Training> trainingList = new ArrayList<Training>();

    public ArrayList<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(ArrayList<University> universityList) {
        this.universityList = universityList;
    }

    public ArrayList<Job> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    public ArrayList<Training> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(ArrayList<Training> trainingList) {
        this.trainingList = trainingList;
    }
    
    
}
