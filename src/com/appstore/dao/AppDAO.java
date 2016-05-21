package com.appstore.dao;

import java.util.List;

import com.appstore.entity.App;

public interface AppDAO {
	
	public App readApp(String appid);
	public List<App> readRecomApps(List<String> appIDs);
	public List<App> readTopNApps();
}
