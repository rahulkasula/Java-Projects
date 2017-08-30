/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.utils;

import edu.uncc.weadvise.facade.WebServiceFacade;
import edu.uncc.weadvise.profileevaluation.beans.Profile;
import edu.uncc.weadvise.profileevaluation.beans.Result;

/**
 *
 * @author Kapil
 */
public class ProfileEvaluater {
    public static Result evaluateProfile(Profile profile){
        Result result = new Result();
        
        result.setJobList(WebServiceFacade.getJobs());
        result.setUniversityList(WebServiceFacade.getUniversities());
        result.setTrainingList(WebServiceFacade.getTrainings());
        
        return result;
    }
}
