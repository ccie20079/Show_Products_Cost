package com.dukepu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class DbHibernate {
	
	private static SessionFactory  factory=null;
	
	static{
		try {
			AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
			factory=cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	/**
	 * 获得JDBC链接接口
	 * @return
	 */
	public  static Connection getConnection(){
		return factory.openSession().connection();
	}
	public static Session getSession(){
		return factory.openSession();
	}
	
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
	/**
	 * 关闭JDBC链接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
