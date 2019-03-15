package com.IMBA.model;

import com.IMBA.entity.posts;

public class postdetailmodel {
    postmodel post;
    int comments;

    public postmodel getPost() {
        return post;
    }

    public void setPost(postmodel post) {
        this.post = post;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
}
