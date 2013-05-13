package com.cloud4all.devicereporter;




import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.cloud4all.devicereporter.org.webinos.api.applauncher.AppLauncherCallback;
import com.cloud4all.devicereporter.org.webinos.api.applauncher.AppLauncherErrorCallback;
import com.cloud4all.devicereporter.org.webinos.api.applauncher.AppLauncherManager;

public class DeviceReporterAppLauncherManager extends AppLauncherManager implements IModule {

	IModuleContext ctx;	
	private Context androidContext;	
		
	
	@Override	public void launchApplication(AppLauncherCallback successCallback, AppLauncherErrorCallback errorCallback, String app) {
				
		try {			
			Intent i = new Intent(Intent.ACTION_VIEW);			
			i.setData(Uri.parse(app));			
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);			
			androidContext.startActivity(i);			
			successCallback.handleEvent("");		
		} catch (Exception e) {			
			errorCallback.handleEvent("");		
			}	
		}	
	
	public Object startModule(IModuleContext ctx) {		
		
		this.ctx = ctx;		
		androidContext = ((AndroidContext) ctx).getAndroidContext();       		
		return this;	
		}	
	
	public void stopModule() {		
			
		}
	
	
	// Device Reporter support
	
	private DeviceReporterEngine deviceReporterEngine;
	
	
	public Map<String, String> getResults() {
		deviceReporterEngine = new DeviceReporterEngine(this.ctx);
		return deviceReporterEngine.getResults();
	}


	private String getValueFromResultsForKey(String keyParam) {
		Map<String, String> data = getResults();
		String result = "ERROR";
		Map<String,String> mapData = new TreeMap<String, String>(data);
		Iterator<Map.Entry<String,String>> it = mapData.entrySet().iterator();
		while (it.hasNext()) {
	Map.Entry<String, String> e = (Map.Entry<String, String>) it.next();
	if (keyParam.equalsIgnoreCase(e.getKey()) ) {
		result = e.getValue();
		break;
		}
	}
		return result;
	}
	
	
	
}
