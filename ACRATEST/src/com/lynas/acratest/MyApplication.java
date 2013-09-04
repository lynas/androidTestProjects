package com.lynas.acratest;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import android.app.Application;
import android.util.Log;

@ReportsCrashes(
		formKey = "", 
		formUri = "https://szlynas.cloudant.com/acra-beshtotalkie/_design/acra-storage/_update/report", 
		reportType = org.acra.sender.HttpSender.Type.JSON, 
		httpMethod = org.acra.sender.HttpSender.Method.PUT, 
		formUriBasicAuthLogin = "ardstoreatteductilliesta", 
		formUriBasicAuthPassword = "JFyO1iyMf4hEOXttstcLCwrM",
		// 	Your usual ACRA configuration
		mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text
        )
public class MyApplication extends Application {

	@Override
	public final void onCreate() {
		super.onCreate();
		ACRA.init(this);
		
		Log.wtf("app", "here");
	}
}