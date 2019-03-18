/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.Bean.Movie;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Tanmayee Kalluri
 */
public class Dao {
    private static final SessionFactory sf = new  Configuration().configure().buildSessionFactory();
    private Session session = null;
    private Session getSession(){
        if (session == null || !session.isOpen()){
            session = sf.openSession();
        }
        return session;
    }

    public Dao() {
    }
    
    private void beginTransaction(){
        getSession().beginTransaction();
    }
    
    private void commit(){
        getSession().getTransaction().commit();;
    }
    
    
    private void close(){
        if (session !=null)
        {
            getSession().close();
        }
    }
    
    private void rollbackTransaction(){
        getSession().getTransaction().rollback();
    }
    
     public int addMovie(Movie movie) {
        int registerSuccess = 0;
        try {
            beginTransaction();
            getSession().save(movie);
            commit();
            registerSuccess = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }
        return registerSuccess;

    }

    public List<Movie> searchMovie(int id) {
        List<Movie> result = null;
      try {
          beginTransaction();
          Query q= getSession().createQuery("from Movie where id= :id");
          q.setInteger("id", id);
          result = q.list();
          commit();
      } catch (HibernateException e) {
          e.printStackTrace();
          rollbackTransaction();
      }
      finally {
          close();
      }
      return result;
            }

}
