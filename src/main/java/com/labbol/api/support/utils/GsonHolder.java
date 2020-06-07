/**
 * 
 */
package com.labbol.api.support.utils;

import org.yelong.support.json.gson.adapter.IntegerTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author PengFei
 */
public final class GsonHolder {

	private static final ThreadLocal<Gson> GSON = new ThreadLocal<Gson>();
	
	private GsonHolder() {}
	
	public static Gson getGson() {
		Gson gson = GSON.get();
		if( null == gson ) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Integer.class, new IntegerTypeAdapter("",null));
			gson = gsonBuilder.create();
		}
		return gson;
	}
	
	public static void setGson(Gson gson) {
		GSON.set(gson);
	}
	
}
