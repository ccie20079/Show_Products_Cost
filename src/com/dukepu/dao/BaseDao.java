package com.dukepu.dao;

import java.sql.ResultSet;
import java.util.List;

public interface BaseDao {

	List<?> findWithPage(int page, int rows, String HQL);

	Object getObject(String HQL);

	void saveObject(Object obj);

	boolean updateObject(Object obj);

	List<?> findAllInfo(String HQL);

	ResultSet findWithSQLPage(String SQL);

}
