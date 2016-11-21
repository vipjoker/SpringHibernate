package com.test.dao;

import com.test.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by omakhobei on 11/14/2016.
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    Logger logger = Logger.getLogger(ItemDaoImpl.class.getName());
    @PersistenceUnit(unitName = "myPersistence")
    private EntityManagerFactory entityManager;


    public void addItem(Item item) {

//        Session currentSession = this.sessionFactory.getCurrentSession();
//        currentSession.persist(item);

        EntityManager entityManager = this.entityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
        logger.info("added item");
    }

    public void updateItem(Item item) {
//        Session currentSession = this.sessionFactory.getCurrentSession();
//        currentSession.update(item);
        logger.info("Item updated");
    }

    @SuppressWarnings("unchecked")
    public List<Item> listItems() {
//        Session currentSession = this.sessionFactory.getCurrentSession();
//        List<Item> items = currentSession.createQuery("from Item").list();
//        for(Item i : items) logger.info("list items" + i);
//        return items;
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistence");

        EntityManager em = this.entityManager.createEntityManager();
        Query query = em.createQuery("Select b from Item b");
        List <Item> items= query.getResultList();
        List<Item> items2 = Arrays.asList(
                new Item("Oleh", "dev"),
                new Item("Ivan", "slesar"),
                new Item("Vasia", "phpDev"),
                new Item("Liuba", "Manager"),
                new Item("Stephan", "CTO")
        );


        logger.info("entity manager " + items);
        return items == null ? items2:items;
    }

    public Item getItemById(long id) {
//
//        Session currentSession = this.sessionFactory.getCurrentSession();
//        Item item = (Item) currentSession.load(Item.class,new Long(id));
//        logger.info("get item by id" + item);
//        return item;
        return null;
    }


    public void removeItem(long id) {
//
//        Session currentSession = this.sessionFactory.getCurrentSession();
//        Item item = (Item)currentSession.load(Item.class,new Long(id));
//        if(item != null){
//            currentSession.delete(item);
//        }
//        logger.info("Item removed");
    }
}
