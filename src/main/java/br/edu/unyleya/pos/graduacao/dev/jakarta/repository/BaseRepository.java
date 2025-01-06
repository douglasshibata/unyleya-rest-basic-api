package br.edu.unyleya.pos.graduacao.dev.jakarta.repository;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

import br.edu.unyleya.pos.graduacao.dev.jakarta.model.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class BaseRepository<T extends BaseEntity> {
    private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseRepository() {
    }

    private Class<T> type;

    public BaseRepository(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }

    @Transactional
    public T save(T entity) {
        logger.info("Criando empresa " + entity.getClass());
        this.entityManager.persist(entity);
        this.entityManager.flush();
        this.entityManager.refresh(entity);
        return entity;
    }

    @Transactional
    public T update(T entity) {
        logger.info("Atualizando empresa " + entity.getClass());
        return this.entityManager.merge(entity);
    }

    @Transactional
    public T find(Long id) {
        logger.info("Procurando empresa por id " + id);
        if (id == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        return this.entityManager.find(this.type, id);
    }

    @Transactional
    public List<T> findAll(Class<T> type) {
        logger.info("Getting all " + type.getSimpleName());
        return this.entityManager.createQuery("SELECT c FROM " + type.getSimpleName() + " c", type).getResultList();
    }

    @Transactional
    public T find(Class<T> type, Object id) {
        logger.info("Procurando empresa " + type.getClass());
        if (id == null)
            return null;
        return this.entityManager.find(type, id);
    }

    @Transactional
    public void delete(T entity) {
        logger.info("Removendo empresa " + entity.getClass());
        if (this.entityManager.contains(entity)) {
            this.entityManager.remove(entity);
        } else {
            T attached = find(entity.getId());
            this.entityManager.remove(attached);
        }

        this.entityManager.flush();
    }

}