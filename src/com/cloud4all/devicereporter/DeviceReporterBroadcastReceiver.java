package com.cloud4all.devicereporter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DeviceReporterBroadcastReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent)
	{
		intent.setClass(context, DeviceReporterService.class);
		context.startService(intent);
	}

}
