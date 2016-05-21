package com.appstore.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.appstore.dao.AppDAO;
import com.appstore.entity.App;
import com.appstore.service.AppService;

public class AppServiceImpl implements AppService{
	@Resource
	private AppDAO appDao;

	@Override
	public App getApp(String appid) {
		// TODO Auto-generated method stub
		return this.appDao.readApp(appid);
	}

	@Override
	public List<App> readRecomApps(List<String> appIDs) {
		// TODO Auto-generated method stub
		return this.appDao.readRecomApps(appIDs);
	}

	@Override
	public List<App> readTopNApps() {
		// TODO Auto-generated method stub
		return this.appDao.readTopNApps();
	}

	public AppDAO getAppDao() {
		return appDao;
	}

	public void setAppDao(AppDAO appDao) {
		this.appDao = appDao;
	}
	
	
}