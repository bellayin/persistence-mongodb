package com.backend.services;

import com.backend.entities.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ShopProductService implements Serializable {

    private static final Logger log = Logger.getLogger(ShopProductService.class.getName());
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SHOPPU");
    private final EntityManager em = emf.createEntityManager();

    public ShopProductService() {

    }

    @PostConstruct
    public void init() {
        log.info("Init  called");

    }

    public void save(Product product) {

        log.log(Level.INFO, "Persisting product instance ...");

        javax.transaction.TransactionManager tx = com.arjuna.ats.jta.TransactionManager.transactionManager();
        // javax.transaction.UserTransaction tx = com.arjuna.ats.jta.UserTransaction.userTransaction();

        try {
            tx.begin();
            em.joinTransaction();
            em.persist(product);
            tx.commit();
            log.log(Level.INFO, "Persist successful...");
        } catch (Exception re) {
            try {
                tx.rollback();
                log.log(Level.SEVERE, "Persist failed...", re);
                throw re;
            } catch (Exception ex) {
                Logger.getLogger(ShopProductService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update(Product product) {

        log.log(Level.INFO, "Persisting product instance ...");
        javax.transaction.TransactionManager tx = com.arjuna.ats.jta.TransactionManager.transactionManager();
        try {
            tx.begin();
            em.joinTransaction();

            em.merge(product);
            tx.commit();
            log.log(Level.INFO, "Persist successful...");
        } catch (Exception re) {
            try {
                tx.rollback();
                log.log(Level.SEVERE, "Persist failed...", re);
                throw re;
            } catch (Exception ex) {
                Logger.getLogger(ShopProductService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void removeAction(Long id) {

        log.info("Deleting Product instance ...");
        if (id != null) {
            Product existing_player = em.find(Product.class, id);
            if (existing_player != null) {
                em.remove(existing_player);
            } else {
                log.warning("Cannot find player to delete ...");
            }
        } else {
            log.warning("You must specify a player to delete ...");
        }
        log.info("Delete successful ...");
    }

    public Product findById(Long id) {

        log.info("Finding Product instance ...");
        if (id != null) {
            Product product = em.find(Product.class, id);
            if (product != null) {
                return product;
            }
        } else {
            log.warning("You have to select an id ...");
        }
        log.info("Find successful ...");
        return null;
    }

    public int getProductCount() {

        int size = 0;
        try {
            // size = (int) em.createQuery("SELECT count(*) FROM Product").getSingleResult();
            size = em.createQuery("SELECT h FROM Product h ", Product.class).getResultList().size();
        } finally {
            //em.close();
        }
        return size;
    }

}
