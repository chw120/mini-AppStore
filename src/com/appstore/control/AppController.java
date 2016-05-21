package com.appstore.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appstore.entity.App;
import com.appstore.service.AppService;

@Controller
public class AppController {
	@Resource
	private AppService appServ;
	
	//read top n
	@RequestMapping(value = "/app/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<App>> getTopNApps() {
		List<App> apps = this.getAppServ().readTopNApps();
		if(apps == null) {
			System.out.println("no apps found");
			return new ResponseEntity<List<App>>(HttpStatus.NOT_FOUND);
		}
		System.out.println("retrieve top 10 apps");
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<List<App>>(apps, header, HttpStatus.OK);
	}
	
	//retrieve recommended apps
	@RequestMapping(value = "/app/getRecom/similarapp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<App>> getRecomApps(@RequestBody List<String> appIDs) {
		List<App> apps = this.getAppServ().readRecomApps(appIDs);
		if(apps == null || apps.size() == 0) {
			System.out.println("no recommendation apps found");
			return new ResponseEntity<List<App>>(HttpStatus.NOT_FOUND);
		}
		System.out.println(apps.size() + " " + (apps.size()==0 ? null:apps.get(0).getAppid() + " " + appIDs.get(0)));
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<App>>(apps, headers, HttpStatus.OK);
		
	}

	public AppService getAppServ() {
		return appServ;
	}

	public void setAppServ(AppService appServ) {
		this.appServ = appServ;
	}
	
	
}