package com.IMBA.entity;

public class posts_commentsKey {
    private Integer id;

    private Integer postsId;

    private Integer studentId;

    private Integer subCommentId;

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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubCommentId() {
        return subCommentId;
    }

    public void setSubCommentId(Integer subCommentId) {
        this.subCommentId = subCommentId;
    }
}