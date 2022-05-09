package com.exercice.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailsId;

    @Column
    @NotNull
    private String createdBy;

    @Column
    @NotNull
    private LocalDateTime createdOn;

    @OneToOne
    @JoinColumn(name= "postId")
    private Post post;

    public Details() {

    }
    public Details(Integer detailsId, String createdBy, LocalDateTime createdOn, Post post) {
        this.detailsId = detailsId;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.post = post;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
