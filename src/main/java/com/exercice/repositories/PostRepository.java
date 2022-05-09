package com.exercice.repositories;

import com.exercice.dto.PostDTO;
import com.exercice.models.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class PostRepository {

    private EntityManager entityManager;

    public PostRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createPost(Post post){
        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
    }

    public Post getPost(Integer id) {
        return entityManager.find(Post.class, id);
    }

    public List<Post> getPosts() {
        String strQuery = "FROM Post p ";
        Query query = entityManager.createQuery(strQuery);
        return query.getResultList();
    }
    public List<PostDTO> getPostsDTO() {
        String strQuery =
                "SELECT new "
                        + "com.exercice.dto.PostDTO("
                        + "p.id, p.title, d.createdBy, d.createdOn)"
                        + "FROM Post p "
                        + "join p.details d";
        Query query = entityManager.createQuery(strQuery);
        return query.getResultList();
    }

    public void updatePost(Post post) {
        entityManager.getTransaction().begin();
        entityManager.merge(post);
        entityManager.getTransaction().commit();
    }

    public void deletePost(Post post) {
        entityManager.getTransaction().begin();
        entityManager.remove(post);
        entityManager.getTransaction().commit();
    }

    public void deletePostById(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getPost(id));
        entityManager.getTransaction().commit();
    }








}
