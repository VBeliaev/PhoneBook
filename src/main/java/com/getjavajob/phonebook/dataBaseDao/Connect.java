/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getjavajob.phonebook.dataBaseDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Виталий
 */
public class Connect {
   
    
    public Connect() {
    }

    public Connection connect() {
        Connection con = null;
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("jdbc.properties"));
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return con;
    }
}
