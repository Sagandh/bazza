package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Deliver;
import com.bituum.spring.mvc.models.User;
import com.bituum.spring.mvc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DeliverDaoImpl implements DeliverDao{


    @Transactional
    public Deliver showById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Deliver.class, id);
    }
    @Transactional
    public void add(Deliver deliver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(deliver);
        session.close();
    }

/*    @Transactional
    public User login(Deliver deliver){
        String tmpLogin = deliver.getLogin();
        String tmpPassword = deliver.getPassword();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User check = (User)session.createQuery("from Deliver where login = '"+ tmpLogin +"' AND password = '" + tmpPassword+"'").getSingleResult();

        if((check.getLogin().contains(tmpLogin)) &&(check.getPassword().contains(tmpPassword))){
            return user;
        }else{
            return null;
        }

    }*/

    @Transactional
    public void update(Deliver deliver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(deliver);
        tx.commit();
        session.close();
    }

    @Transactional
    public void delete(Deliver deliver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(deliver);
        tx.commit();

        session.close();
    }

    @Transactional
    public List<Deliver> showAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Deliver> query = session.createQuery("from Deliver", Deliver.class);
        return query.getResultList();
    }
}
