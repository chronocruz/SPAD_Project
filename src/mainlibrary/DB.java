/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author bikash
 */
public class DB {

    private static String user = System.getenv("DB_NAME");
    private static String connection = System.getenv("DB_CONNECTION_STRING");
    private static String password = System.getenv("DB_PASSWORD");
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Properties props = new Properties();
            props.put("user", user);
     //change the password to the password  ↓↓↓↓↓↓↓↓↓↓↓   you enteredwhen setting up mysql
            props.put("password", password);
            props.put("useUnicode", "true");
            props.put("useServerPrepStmts", "false"); // use client-side prepared statement
            props.put("characterEncoding", "UTF-8"); // ensure charset is utf8 here

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connection, props);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
/*public class DB {

    public static String user = "root";
    public static String connection = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false";
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Properties props = new Properties();
            props.put("user", user);
     //change the password to the password  ↓↓↓↓↓↓↓↓↓↓↓   you enteredwhen setting up mysql
            props.put("password", "strongPassword!");
            props.put("useUnicode", "true");
            props.put("useServerPrepStmts", "false"); // use client-side prepared statement
            props.put("characterEncoding", "UTF-8"); // ensure charset is utf8 here

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connection, props);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}*/
