package com.cloud4all.devicereporter;
/*

DeviceReporterService
This class is the interface for the Device reporter connnection service.
Use binding connection service to use it.	

Developed by Technosite.
This resource is under New BSD license.
Please, use this license for distribution.

 */
import java.util.Map;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class DeviceReporterService extends Service{
	
	// ** Service management
	
	private final IBinder mBinder = new MyBinder();
	private DeviceReporterEngine deviceReporterEngine;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return Service.START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return mBinder;
	}

	public class MyBinder extends Binder {
		DeviceReporterService getService() {
			return DeviceReporterService.this;
		}
	}

	// ** Methods for results
	
	// method for getting data from the Device reporter
	public Map<String, String> getResults() {
		deviceReporterEngine = new DeviceReporterEngine(getApplicationContext());
		return deviceReporterEngine.getResults();
	}

	// method for getting data from the Device reporter using a custom context
	public Map<String, String> getResultsWithContext(Context context) {
		deviceReporterEngine = new DeviceReporterEngine(context);
		return deviceReporterEngine.getResults();
	}

}
