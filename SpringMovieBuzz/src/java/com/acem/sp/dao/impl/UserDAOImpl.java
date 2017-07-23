/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acem.sp.dao.impl;

import com.acem.sp.dao.UserDAO;
import com.acem.sp.entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

/**
 *
 * @author AshwinKArki
 */
@Repository
public class UserDAOImpl implements UserDAO {
     
   @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;
    
    @Override
    public List<User> getAll() {
      session=sessionFactory.openSession();
    Query query=session.getNamedQuery("User.findAll");
   List<User> catList=query.list();
    session.close();
    return catList;
    }

    @Override
    public User getById(int id) {
       session=sessionFactory.openSession();
  User cat=(User)session.get(User.class, id);
    session.close();
    return cat;
    }
    

    @Override
    public void insert(User t) {
      session=sessionFactory.openSession();
        
        trans=session.beginTransaction();
        
        session.save(t);
        trans.commit();
        session.close();
    }

    @Override
    public void update(User t) {
        session=sessionFactory.openSession();
        
        trans=session.beginTransaction();
       
        session.saveOrUpdate(t);
        trans.commit();
        session.close(); 
    }

    @Override
    public void delete(int id) {
        session=sessionFactory.openSession();
      trans=session.beginTransaction();
    session.delete(getById(id));
      trans.commit();
      
    }

   
    
}
