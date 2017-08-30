/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.beans;

/**
 *
 * @author Kapil
 */
public class University {
    long id;
    String name;
    String homeUrl;
    int minGre;
    int minGpa;
    int minToefl;
    int minExperience;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public int getMinGre() {
        return minGre;
    }

    public void setMinGre(int minGre) {
        this.minGre = minGre;
    }

    public int getMinGpa() {
        return minGpa;
    }

    public void setMinGpa(int minGpa) {
        this.minGpa = minGpa;
    }

    public int getMinToefl() {
        return minToefl;
    }

    public void setMinToefl(int minToefl) {
        this.minToefl = minToefl;
    }

    public int getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(int minExperience) {
        this.minExperience = minExperience;
    }
    
}
