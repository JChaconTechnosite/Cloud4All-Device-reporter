package com.cloud4all.devicereporter;

public class CommunicationPersistence {
	
	//ACTION Strings
	public final static String ACTION_ORCHESTRATOR= "cloudOrchestrator";
	public final static String ACTION_DEVICE_REPORTER= "cloudDeviceReporter";
	public final static String ACTION_NFC_USER_LISTENER= "cloudNFCListener";
	public final static String ACTION_SYSTEM_SETTING_HANDLER ="cloudSystemSetting";
	public final static String ACTION_SYSTEM_SETTING_HANDLER_PREICS ="cloudSystemSettingPreICS";
	public final static String ACTION_SYSTEM_SETTING_HANDLER_ROOT ="cloudSystemSettingRoot";
	public final static String ACTION_SYSTEM_SETTING_HANDLER_PREICS_ROOT ="cloudSystemSettingPREICSROOT";
	public final static String ACTION_MINI_MATCH_MAKER ="cloudMiniMatchMaker";
	public final static String ACTION_HAPTIC_FEEDBACK_HANDLER ="cloudHapticFeedback";
	public final static String ACTION_HTTP_CLIENT ="cloudHttpClient";
	public final static String ACTION_ENVIRONMENTAL_REPORTER= "cloudEnvironmentalReporter";


	//EVENT Strings
	public final static int EVENT_CONFIGURE_SYSTEM_SETTINGS = 110;
	public final static int EVENT_CONFIGURE_SYSTEM_SETTINGS_RESPONSE = 111;
	
	public final static int EVENT_RESTORE_SYSTEM_SETTINGS = 115;
	public final static int EVENT_RESTORE_SYSTEM_SETTINGS_RESPONSE = 116;
	
	public final static int EVENT_GET_FEATURES = 130;
	public final static int EVENT_GET_FEATURES_RESPONSE = 131;
	
	public final static int EVENT_VALIDATE_USER = 170;
	public final static int EVENT_VALIDATE_USER_RESPONSE = 171;
	
	public final static int EVENT_CONFIGURE_HAPTIC_FEEDBACK = 160;
	public final static int EVENT_CONFIGURE_HAPTIC_FEEDBACK_RESPONSE = 161;
	
	public final static int EVENT_RESTORE_HAPTIC_FEEDBACK = 165;
	public final static int EVENT_RESTORE_HAPTIC_FEEDBACK_RESPONSE = 166;
	
	public final static int EVENT_GET_CONFIGURATION = 227;
	public final static int EVENT_GET_CONFIGURATION_RESPONSE = 228;
	
	public final static int EVENT_GET_REPORTER = 170;
	public final static int EVENT_GET_REPORTER_RESPONSE = 171;
	
	public final static int EVENT_ARE_REPORTER = 220;
	public final static int EVENT_ARE_REPORTER_RESPONSE = 221;
	
	public final static int EVENT_USER_DETECTED = 140;
	
	public final static int EVENT_USER_LOGOUT = 141;
	
	public final static int EVENT_STORAGE_REPORTER = 225;
	public final static int EVENT_STORAGE_REPORTER_RESPONSE = 226;
	
	public final static int EVENT_GET_ENVIRONMENT_FEATURE = 180;
	public final static int EVENT_GET_ENVIRONMENT_FEATURE_RESPONSE = 181;
	
	//MODULE Strings
	public final static int MODULE_ORCHESTRATOR = 21;
	public final static int MODULE_DEVICE_REPORTER = 13;
	public final static int MODULE_SYSTEM_SETTING_HANDLER = 11;
	public final static int MODULE_USER_LISTENER = 14;
	public final static int MODULE_MINI_MATCH_MAKER = 22;
	public final static int MODULE_HAPTIC_FEEDBACK_HANDLER = 16;
	public final static int MODULE_HTTP_CLIENT = 17;
    public final static int MODULE_ENVIRONMENTAL_REPORTER = 18;
	public final static int MODULE_PRUEBAS = 3;

}
