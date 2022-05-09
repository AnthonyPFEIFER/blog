package com.exercice.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column
    @NotNull
    private String title;

    @OneToMany(mappedBy = "post", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Details details;

    @ManyToMany(mappedBy = "posts", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    })
    private List<Tag> tags = new ArrayList<Tag>();

    public Post() {

    }
    public Post(Integer postId, String title, List<Comment> comments, Details details, List<Tag> tags) {
        this.postId = postId;
        this.title = title;
        this.comments = comments;
        this.details = details;
        this.tags = tags;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
        details.setPost(this);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getPosts().add(this);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", comments=" + comments +
                ", details=" + details +
                ", tags=" + tags +
                '}';
    }
}
