package com.dukepu.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
			//	 public static final String url = "jdbc:mysql://127.0.0.1/test";  
		 public static final String url = "dbc:oracle:thin:@192.168.8.40:1521:dukepu";  
		 //public static final String name = "com.mysql.jdbc.Driver";  
		 public static final String name = "oracle.jdbc.driver.OracleDriver";  
		    public static final String user = "dukepu";  
		    public static final String password = "GuXiangQing2019"; 
		    public Connection conn = null;  
		    public PreparedStatement pst = null;  
		    public DBHelper(String sql) {  
		    	 try {  
		             Class.forName(name);//指定连接类型  
		             conn = DriverManager.getConnection(url, user, password);//获取连接  
		             pst = conn.prepareStatement(sql);//准备执行语句  
		         } catch (Exception e) {  
		             e.printStackTrace();  
		         }  
		    }
		    public void close() {  
		        try {  
		            this.conn.close();  
		            this.pst.close();  
		        } catch (SQLException e) {  
		            e.printStackTrace();  
		        }  
		    }  
	}

