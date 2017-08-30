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
public class DiscussionComment {
    long id;
    long discussionId;

    public long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(long trainingId) {
        this.discussionId = trainingId;
    }
    User comentedUser;
    String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getComentedUser() {
        return comentedUser;
    }

    public void setComentedUser(User comentedUser) {
        this.comentedUser = comentedUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
