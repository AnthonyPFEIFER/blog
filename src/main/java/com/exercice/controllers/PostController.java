package com.exercice.controllers;

import com.exercice.models.Details;
import com.exercice.models.Post;
import com.exercice.repositories.PostRepository;
import com.exercice.services.Utilitaires;
import com.exercice.views.PostView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class PostController {
    EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("com.exercice");
    EntityManager entityManager = entityFactory.createEntityManager();
    PostRepository postRepo = new PostRepository(entityManager);
    boolean postMenuIsOn = true;
    public void postMenu() {
        do{
            PostView.postView();
            switch (Utilitaires.saisieString()) {
                case "1" :
                    PostView.creationPost();
                    Post post = new Post();
                    post.setTitle(Utilitaires.saisieString());
                    Details details = new Details();
                    details.setCreatedBy("Anthony");
                    details.setCreatedOn(LocalDateTime.now());
                    post.setDetails(details);
                    postRepo.createPost(post);
                    break;
                case "2" :
                    PostView.printAllPosts(postRepo.getPosts());
                    break;
                case "4" :
                    break;
                case "5" :
                    PostView.suppressionPost();
                    //postRepo.getPost()
                    //postRepo.deletePost(Utilitaires.saisieInt());
            }
        }while(postMenuIsOn);
    }
}
