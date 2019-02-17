/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author tankalluri
 */
public class CsvDao {
    public List<File> getRows(String fileName) {
        Connection connection = null;
        List<File> result = null;
        try {
            Dao dbdao = new Dao();
            connection = dbdao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<File>> h = new BeanListHandler<File>(File.class);
            String query = "select * from "+fileName;
            result = queryRunner.query(connection, query, h);
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
}
