package com.dukepu.mapping;

import junit.framework.TestCase;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.dukepu.dao.BaseDao;
import com.dukepu.dao.BaseDaoImpI;


public class TestMapping extends TestCase {
	static BaseDao baseDao = new BaseDaoImpI();
	/*
	 * 执行此方法,会删除相应表,之后会再次创建相应表,谨慎使用.
	 * 
	 * */
	public void testTabMapping() {

		AnnotationConfiguration cfg = new AnnotationConfiguration().configure();

		SchemaExport ex = new SchemaExport(cfg);
		ex.create(true, true);
	}

}
