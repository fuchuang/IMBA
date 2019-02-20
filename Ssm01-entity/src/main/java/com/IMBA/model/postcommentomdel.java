package com.IMBA.model;

import java.util.Date;

public class postcommentomdel {
    private Integer id;

    private Integer postsId;

    private studentmodel studentmodel;

    private Integer subCommentId;
    private String  commentstime;

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent;
    }

    private String commentsContent;




    public String getCommentstime() {
        return commentstime;
    }

    public void setCommentstime(String commentstime) {
        this.commentstime = commentstime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostsId() {
        return postsId;
    }

    public void setPostsId(Integer postsId) {
        this.postsId = postsId;
    }

    public com.IMBA.model.studentmodel getStudentmodel() {
        return studentmodel;
    }

    public void setStudentmodel(com.IMBA.model.studentmodel studentmodel) {
        this.studentmodel = studentmodel;
    }

    public Integer getSubCommentId() {
        return subCommentId;
    }

    public void setSubCommentId(Integer subCommentId) {
        this.subCommentId = subCommentId;
    }
}
