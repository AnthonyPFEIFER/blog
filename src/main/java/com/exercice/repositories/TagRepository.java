package com.exercice.repositories;

import com.exercice.models.Post;
import com.exercice.models.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class TagRepository {

    private EntityManager entityManager;

    public TagRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createTag(Tag tag){
        entityManager.getTransaction().begin();
        entityManager.persist(tag);
        entityManager.getTransaction().commit();
    }

    public Tag getTag(Integer id) {
        return entityManager.find(Tag.class, id);
    }

    public List<Tag> getTags() {
        String strQuery =
                "FROM Tag";
        Query query = entityManager.createQuery(strQuery);
        return query.getResultList();
    }

    public void updateTag(Tag tag) {
        entityManager.getTransaction().begin();
        entityManager.merge(tag);
        entityManager.getTransaction().commit();
    }

    public void deleteTag(Tag tag) {
        entityManager.getTransaction().begin();
        entityManager.remove(tag);
        entityManager.getTransaction().commit();
    }
}
