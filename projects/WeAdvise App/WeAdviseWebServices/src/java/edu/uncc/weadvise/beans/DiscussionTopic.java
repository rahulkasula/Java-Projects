/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.beans;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kapil
 */
public class DiscussionTopic {
    long id;
    String content;
    String created;
    User createdBy;
    ArrayList<DiscussionComment> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public ArrayList<DiscussionComment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<DiscussionComment> comments) {
        this.comments = comments;
    }
    
}
