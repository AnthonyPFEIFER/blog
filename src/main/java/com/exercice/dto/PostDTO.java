package com.exercice.dto;

import java.time.LocalDateTime;

public class PostDTO {

    private Integer id;
    private String name;
    private String createdBy;
    private LocalDateTime createdOn;

    public PostDTO() {
    }

    public PostDTO(Integer id, String name, String createdBy, LocalDateTime createdOn) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
