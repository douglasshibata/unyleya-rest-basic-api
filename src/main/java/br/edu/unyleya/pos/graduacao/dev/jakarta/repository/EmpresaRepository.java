package br.edu.unyleya.pos.graduacao.dev.jakarta.repository;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import br.edu.unyleya.pos.graduacao.dev.jakarta.model.Empresa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class EmpresaRepository {
      private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
      
    @PersistenceContext
    private EntityManager em;

    public Empresa create(Empresa empresa) {
        logger.info("Criando empresa " + empresa.getNome());
        em.persist(empresa);

        return empresa;
    }

    public List<Empresa> findAll() {
        logger.info("Getting all empresa");
        return em.createQuery("SELECT c FROM Empresa c", Empresa.class).getResultList();
    }

    public Optional<Empresa> findById(Long id) {
        logger.info("Getting empresa by id " + id);
        return Optional.ofNullable(em.find(Empresa.class, id));
    }

    public void delete(Long id) {
        logger.info("Removendo empresa by id " + id);
        var empresa = findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid empresa Id:" + id));
        em.remove(empresa);
    }

    public Empresa update(Empresa empresa) {
        logger.info("Atualizando empresa " + empresa.getNome());
        return em.merge(empresa);
    }
}
