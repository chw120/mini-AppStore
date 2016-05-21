package com.appstore.service;

import java.util.List;

import com.appstore.entity.App;

public interface AppService {
	public App getApp(String appid);
	public List<App> readRecomApps(List<String> appIDs);
	public List<App> readTopNApps();
}
