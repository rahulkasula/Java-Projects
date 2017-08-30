/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.profileevaluation.beans;

import java.util.ArrayList;

/**
 *
 * @author Kapil
 */
public class Profile {
    int academicInfoCount;
    int workInfoCount;
    int greVerbal;
    int greQuant;
    float greAWA;
    int toefl;
    String technologies;
    ArrayList<AcademicInfo> acadInfoList = new ArrayList<AcademicInfo>();
    ArrayList<WorkInfo> workInfoList = new ArrayList<WorkInfo>();

    public int getAcademicInfoCount() {
        return academicInfoCount;
    }

    public void setAcademicInfoCount(int academicInfoCount) {
        this.academicInfoCount = academicInfoCount;
    }

    public int getWorkInfoCount() {
        return workInfoCount;
    }

    public void setWorkInfoCount(int workInfoCount) {
        this.workInfoCount = workInfoCount;
    }

    public int getGreVerbal() {
        return greVerbal;
    }

    public void setGreVerbal(int greVerbal) {
        this.greVerbal = greVerbal;
    }

    public int getGreQuant() {
        return greQuant;
    }

    public void setGreQuant(int greQuant) {
        this.greQuant = greQuant;
    }

    public float getGreAWA() {
        return greAWA;
    }

    public void setGreAWA(float greAWA) {
        this.greAWA = greAWA;
    }

    public int getToefl() {
        return toefl;
    }

    public void setToefl(int toefl) {
        this.toefl = toefl;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public ArrayList<AcademicInfo> getAcadInfoList() {
        return acadInfoList;
    }

    public void setAcadInfoList(ArrayList<AcademicInfo> acadInfoList) {
        this.acadInfoList = acadInfoList;
    }

    public ArrayList<WorkInfo> getWorkInfoList() {
        return workInfoList;
    }

    public void setWorkInfoList(ArrayList<WorkInfo> workInfoList) {
        this.workInfoList = workInfoList;
    }

    @Override
    public String toString() {
        return "Profile{" + "academicInfoCount=" + academicInfoCount + ", workInfoCount=" + workInfoCount + ", greVerbal=" + greVerbal + ", greQuant=" + greQuant + ", greAWA=" + greAWA + ", toefl=" + toefl + ", technologies=" + technologies + ", acadInfoList=" + acadInfoList + ", workInfoList=" + workInfoList + '}';
    }
    
    
    
    
    public static class AcademicInfo{
        int gpa;
        String degreeName;
        String univeristyName;

        public int getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return "AcademicInfo{" + "gpa=" + gpa + ", degreeName=" + degreeName + ", univeristyName=" + univeristyName + '}';
        }

        public void setGpa(int gpa) {
            this.gpa = gpa;
        }

        public String getDegreeName() {
            return degreeName;
        }

        public void setDegreeName(String degreeName) {
            this.degreeName = degreeName;
        }

        public String getUniveristyName() {
            return univeristyName;
        }

        public void setUniveristyName(String univeristyName) {
            this.univeristyName = univeristyName;
        }
        
    }
    public static class WorkInfo{
        int experience;
        String designation;
        String employer;

        @Override
        public String toString() {
            return "WorkInfo{" + "experience=" + experience + ", designation=" + designation + ", employer=" + employer + '}';
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getEmployer() {
            return employer;
        }

        public void setEmployer(String employer) {
            this.employer = employer;
        }
        
    }
    
}
