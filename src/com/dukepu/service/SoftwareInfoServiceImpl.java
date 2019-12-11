package com.dukepu.service;

import java.util.ArrayList;
import java.util.List;

import com.dukepu.dao.BaseDao;
import com.dukepu.dao.BaseDaoImpI;
import com.dukepu.entity.SoftwareInfo;

public class SoftwareInfoServiceImpl implements SoftwareInfoService {
	private BaseDao baseDao = new BaseDaoImpI();
	@SuppressWarnings("unchecked")
	@Override
	public List<SoftwareInfo> getSoftwareInfo(String page,String rows,String softwareName) {
		int pageParam = 0;
		int rowsParam = 0;
		List<SoftwareInfo> softwareInfoResponseList = new ArrayList<SoftwareInfo>();
		StringBuffer HQL = new StringBuffer(
				" from SoftwareInfo where 1=1");
		if (!"".equals(softwareName) && softwareName != null) {
			HQL.append("  and  software_name like '%" + softwareName + "%'  ");
		}
		try {
			pageParam = Integer.parseInt(page);
			rowsParam = Integer.parseInt(rows);
			softwareInfoResponseList = (List<SoftwareInfo>) baseDao.findWithPage(pageParam,
					rowsParam, HQL.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return softwareInfoResponseList;
	}
	@Override
	public int getRows(String softwareName) {
		StringBuffer HQL = new StringBuffer(
				"select count(*) from SoftwareInfo where 1=1 ");
		if (!"".equals(softwareName) && softwareName != null) {
			HQL.append(" and software_name like '%" + softwareName + "%'");
		}
		Object obj = baseDao.getObject(HQL.toString());
		if (obj != null) {
			long tempObj = (Long) obj;
			return (int) tempObj;
		}
		return 0;
	}
}
