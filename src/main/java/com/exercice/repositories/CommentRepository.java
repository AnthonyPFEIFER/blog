package com.exercice.repositories;

import com.exercice.models.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CommentRepository {

    private EntityManager entityManager;

    public CommentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createComment(Comment comment){
        entityManager.getTransaction().begin();
        entityManager.persist(comment);
        entityManager.getTransaction().commit();
    }

    public Comment getComment(Integer id) {
        return entityManager.find(Comment.class, id);
    }

    public void updateComment(Comment comment) {
        entityManager.getTransaction().begin();
        entityManager.merge(comment);
        entityManager.getTransaction().commit();
    }

    public void deleteComment(Comment comment) {
        entityManager.getTransaction().begin();
        entityManager.remove(comment);
        entityManager.getTransaction().commit();
    }
}
