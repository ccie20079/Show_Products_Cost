package com.dukepu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.dukepu.utils.DbHibernate;



public class BaseDaoImpI implements BaseDao {

	private static Connection conn = DbHibernate.getConnection();
	public List<?> findWithPage(int page, int rows, String HQL) {
		@SuppressWarnings("rawtypes")
		List<?> list = new ArrayList();
		Session session = DbHibernate.getSession();
		try {
			list = session.createQuery(HQL)
					.setFirstResult(Math.abs(page - 1) * rows)
					.setMaxResults(rows).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHibernate.closeSession(session);
		}
		return list;
	}

	public Object getObject(String HQL) {
		Session session = DbHibernate.getSession();
		Object obj = null;
		try {
			obj = session.createQuery(HQL).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHibernate.closeSession(session);
		}
		return obj;
	}

	public void saveObject(Object obj) {
		Session session = DbHibernate.getSession();
		try {
			session.getTransaction().begin();
			session.save(obj);
			// session.flush();
			// session.clear();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			DbHibernate.closeSession(session);
		}

	}

	public boolean updateObject(Object obj) {
		Session session = DbHibernate.getSession();
		try {
			session.getTransaction().begin();
			session.update(obj);
			session.flush();
			session.clear();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			DbHibernate.closeSession(session);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<?> findAllInfo(String HQL) {
		List<?> list = new ArrayList();
		Session session = DbHibernate.getSession();
		try {
			list = session.createQuery(HQL).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHibernate.closeSession(session);
		}
		return list;
	}

	@Override
	public ResultSet findWithSQLPage(String SQL) {
		ResultSet rs = null;
		try {
			rs = conn.prepareStatement(SQL).executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

}
