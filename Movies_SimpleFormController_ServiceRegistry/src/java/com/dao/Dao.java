package com.dao;

import com.Bean.Movie;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Tanmayee Kalluri
 */
public class Dao {
 
    private SessionFactory sessionFactory;
    private static Session session;
    
    protected SessionFactory setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        try {
            this.sessionFactory = configuration.buildSessionFactory(registry);
            
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        
        return sessionFactory;
    }
    
    public Session getSession() throws Exception {
        if(session == null) {
            session = setUp().openSession();
        }
        return session;
    }
    
    private void beginTransaction() throws Exception {
        getSession().beginTransaction();
    }

    private void commit() throws Exception {
        getSession().getTransaction().commit();;
    }

    private void close() throws Exception {
        getSession().close();
    }

    private void rollbackTransaction() throws Exception {
        getSession().getTransaction().rollback();
    }
    
    
     public int addMovie(Movie movie) {
        int registerSuccess = 0;
        try {
            try {
                beginTransaction();
                getSession().save(movie);
                commit();
            } catch (Exception ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
            registerSuccess = 1;
        } catch (HibernateException e) {
            try {
                e.printStackTrace();
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return registerSuccess;

    }

    public List<Movie> SearchByID(int id) {
        List<Movie> result = null;
      try {
            try {
                beginTransaction();
            } catch (Exception ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
          Query q = null;
            try {
                q = getSession().createQuery("from Movie where id= :id");
            } catch (Exception ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
          q.setInteger("id", id);
          result = q.list();
            try {
                commit();
            } catch (Exception ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
      } catch (HibernateException e) {
            try {
                e.printStackTrace();
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      return result;
            }

}
