package com.cloud4all.devicereporter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

public class CloudIntent extends Intent {
	private static final String EXTRA_PARAMS = "params";
	private static final String EXTRA_EVENT = "idEvent";
	private static final String EXTRA_MODULE = "idModule";
	public String params;
	
	private JSONObject json;

	/*
	 * Static method to transform a normal received intent to a Specific Cloudintent
	 */
	public static CloudIntent intentToCloudIntent(Intent inte) throws Exception {
		int evento = inte.getIntExtra(EXTRA_EVENT, 0);
		int modulo = inte.getIntExtra(EXTRA_MODULE, 0);
		CloudIntent i;
		if (evento == 0 && modulo == 0) {
			i = null;

		} else {
			i = new CloudIntent(inte.getAction(), evento, modulo);
			i.setStringParams(inte.getStringExtra(EXTRA_PARAMS));
		}
		return i;

	}
	/*
	 * Constructor, need the action(Who should listen), the idEvent(What should do) and the idModulo(Who am I, the Intent origin)
	 */
	public CloudIntent(String action, int idEvento, int idModulo) {
		super(action);
		this.setFlags(FLAG_INCLUDE_STOPPED_PACKAGES| Intent.FLAG_DEBUG_LOG_RESOLUTION | Intent.FLAG_ACTIVITY_NEW_TASK);
//		this.setAction(action);
		this.putExtra(EXTRA_EVENT, idEvento);
		this.putExtra(EXTRA_MODULE, idModulo);
		

	}

	/*
	 * Return the event identifier, if there are any error return 0
	 */
	public int getIdEvent() {
		return this.getIntExtra(EXTRA_EVENT, 0);

	}

	/*
	 * Return the origin module identifier, if there are any error return 0
	 */
	public int getIdModule() {
		return this.getIntExtra(EXTRA_EVENT, 0);

	}

	/*
	 * To add a new Param (Key/value)
	 */
	public void setParams(String id, String value) throws JSONException {

		if (json == null) {

			writeJson(id, value);

		} else {

			writeNewJsonObject(json, id, value);
		}
		params = json.toString();
		this.putExtra(EXTRA_PARAMS, params);

	}

	private void setStringParams(String params) throws JSONException {
		
		
		JSONObject str= new JSONObject(params);
		
		JSONArray root =str.getJSONObject("jsonfile").getJSONArray("params");
		
		for(int i=0;i<root.length();i++){
			JSONObject obj= root.getJSONObject(i);
			this.setParams(obj.getString("id"), obj.getString("value"));
		
		}

	}

	private void writeJson(String id, String value) throws JSONException {

		json = new JSONObject();
		JSONObject jsonObjectParams = new JSONObject();
		JSONObject jsonObjectData = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		jsonObjectData.put("id", id);
		jsonObjectData.put("value", value);

		jsonArray.put(jsonObjectData);

		jsonObjectParams.put("params", jsonArray);
		json.put("jsonfile", jsonObjectParams);
		

	}

	private void writeNewJsonObject(JSONObject json, String id, String value)
			throws JSONException {

		JSONObject jsonObjectNewData = new JSONObject();

		jsonObjectNewData.put("id", id);
		jsonObjectNewData.put("value", value);

		json.getJSONObject("jsonfile").getJSONArray("params")
				.put(jsonObjectNewData);

	}
	
	/*
	 * Return the keys IDs list
	 */
	public String[] getArrayIds() throws JSONException {

		

		JSONArray jsonArray = json.getJSONObject("jsonfile").getJSONArray(
				"params");
		String[] arrayIds = new String[jsonArray.length()];
		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject result = jsonArray.getJSONObject(i);

			arrayIds[i] = result.getString("id");

		}
		
		
		return arrayIds;

	}

	/*
	 * Return an specific String value for a specific key
	 */
	public String getValue(String id) throws JSONException {

		String value;

		JSONArray jsonArray = json.getJSONObject("jsonfile").getJSONArray(
				"params");

		for (int i = 0; i < jsonArray.length(); i++) {

			if (id.equals(jsonArray.getJSONObject(i).getString("id"))) {

				value = jsonArray.getJSONObject(i).getString("value");

				return value;
			}
		}
		return null;

	}
	
	
	
	
	

}
