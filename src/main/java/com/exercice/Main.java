package com.exercice;

import com.exercice.controllers.MenuController;
import com.exercice.dto.PostDTO;
import com.exercice.models.Comment;
import com.exercice.models.Details;
import com.exercice.models.Post;
import com.exercice.models.Tag;
import com.exercice.repositories.CommentRepository;
import com.exercice.repositories.PostRepository;
import com.exercice.repositories.TagRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello wooooorld!");

        EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("com.exercice");
        EntityManager entityManager = entityFactory.createEntityManager();

        PostRepository postRepo = new PostRepository(entityManager);
        CommentRepository commentRepo = new CommentRepository(entityManager);
        TagRepository tagRepo = new TagRepository(entityManager);


        MenuController menuController = new MenuController();
        menuController.runMenu();

/*        Post post1 = new Post();
        Tag tag2 = new Tag();
        Comment comment1 = new Comment();
        Details details1 = new Details();

        post1.setTitle("Ca fonctionne enfin");

        details1.setCreatedBy("Anthony");
        details1.setCreatedOn(LocalDateTime.now());
        post1.setDetails(details1);

        tag2.setName("#soulagement");
        tagRepo.createTag(tag2);

        post1.addTag(tag2);
        postRepo.createPost(post1);

        comment1.setReview("Franchement c'est beau");
        comment1.setPost(post1);
        commentRepo.createComment(comment1);*/




        entityManager.close();
        entityFactory.close();
    }
}