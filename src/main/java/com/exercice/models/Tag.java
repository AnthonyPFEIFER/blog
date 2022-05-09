package com.exercice.models;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column
    @NotNull
    private String name;


    @ManyToMany( cascade =
            {
                    CascadeType.PERSIST, CascadeType.MERGE
            })
    @JoinTable(
            name = "tag_post",
            joinColumns = @JoinColumn(name = "tagId"),
            inverseJoinColumns = @JoinColumn(name ="postId")
    )
    private List<Post> posts = new ArrayList<Post>();

    public Tag() {
    }

    public Tag(Integer tagId, String name, List<Post> posts) {
        this.tagId = tagId;
        this.name = name;
        this.posts = posts;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
