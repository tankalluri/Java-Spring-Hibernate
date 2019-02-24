/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

/**
 *
 * @author tankalluri
 */

import com.pojo.Movie;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class MoviesDao {
    
     public List<Movie> getMovies(String criteria, String searchCriteria) {
        Connection connection = null;
        List<Movie> result = null;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
            //if(searchCriteria)
            String query = "select * from movies where "+criteria+" like ?";
            result = queryRunner.query(connection, query, h, '%'+searchCriteria+'%');
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
     
       public int addMovie(String title,String actor,String actress, String genre, int year) {
        Connection connection = null;
        int result = 0;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "insert into movies values (?,?,?,?,?)";
            result = queryRunner.update(connection, query,title,actor, actress, genre, year);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
