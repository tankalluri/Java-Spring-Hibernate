/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.relique.jdbc.csv.CsvDriver;

/**
 *
 * @author tankalluri
 */
public class Dao {
    private Connection connection;

    public Connection getConnection() throws Exception {
        try {
            String path = "D:\\MSIS\\Web Tools\\Assignment-Questions";
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            connection = DriverManager.getConnection("jdbc:relique:csv:"+path);
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            ex.printStackTrace();
            throw new Exception();
        }
        return connection;
    } 
}
