package com.cloud4all.devicereporter;

/*

Viewer
This class is a sample code to use Device reporter service and how to show all data from the Device reporter.	

Developed by Technosite.
This resource is under New BSD license.
Please, use this license for distribution.

 */
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class Viewer extends Activity  {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewer);
		doBindService();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_viewer, menu);
		return true;
	}

	/*
	 * Methods for Logger engine to show results
	 */


	public boolean outputOnConsole = true;
	public boolean outputOnScreen = true;


	public void showLogMessage(String data) {
		if (this.outputOnConsole) {
			Log.i("Debug information", "\n - " + data); 
		}
		if (this.outputOnScreen) {
			TableLayout tl = (TableLayout)findViewById(R.id.logTable);
			TableRow tr = new TableRow(this);
			tr.setLayoutParams(new LayoutParams(
					LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
			TextView td = new TextView(this);
			td.setText(data);
			td.setFocusable(true);
			// Adding new row
			tr.addView(td);
			tl.addView(tr,new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));
		}
	}

	public void showMapResults(Map<String, String> mapParam) {
		Map<String,String> mapData = new TreeMap<String, String>(mapParam);
		String logString = "";
		Iterator<Map.Entry<String,String>> it = mapData.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>) it.next();
			logString = e.getKey() + ": " + e.getValue();
			this.showLogMessage(logString);
		}
	}

	// Shows data from Device reporter
	public void showDeviceReporterResults() {
		showMapResults((Map<String,String>) sDeviceReporter.getResults()); 
	}

	// ** Service connection

	private DeviceReporterService sDeviceReporter;

	private ServiceConnection mConnection = new ServiceConnection() {

		public void onServiceConnected(ComponentName className, IBinder binder) {
			sDeviceReporter = ((DeviceReporterService.MyBinder) binder).getService();
			if (sDeviceReporter != null) showDeviceReporterResults();
		}

		public void onServiceDisconnected(ComponentName className) {
			sDeviceReporter = null;
		}
	};

	// starts the service connection using bindings
	void doBindService() {
		bindService(new Intent(this, DeviceReporterService.class), mConnection,
				Context.BIND_AUTO_CREATE);
	}

}