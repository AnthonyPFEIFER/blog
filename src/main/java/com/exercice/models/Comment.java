package com.exercice.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column
    @NotNull
    private String review;

    @ManyToOne
    @JoinColumn(name = "postId")
    @NotNull
    private Post post;

    public Comment() {

    }
    public Comment(Integer commentId, String review, Post post) {
        this.commentId = commentId;
        this.review = review;
        this.post = post;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
