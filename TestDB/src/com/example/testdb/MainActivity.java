package com.example.testdb;

import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private  ArrayList<String> contacts = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		UploadTask test = new UploadTask();
		test.execute();

	}

	private class UploadTask extends AsyncTask<Void, Void, Void> {
		protected Void doInBackground(Void... filePaths) {

			try {
				DBConnection d = new DBConnection();
				
				contacts.add("8801729091088");
				contacts.add("8801712781274");
				String listInLine="";
				for(int i=0; i<contacts.size();i++){
					listInLine+=contacts.get(i).toString()+",";
				}
				listInLine = listInLine.substring(0, listInLine.length()-1);
				//Log.d("Test", listInLine);
				
				Log.d("Test", d.getInfoFromDB2(listInLine,"8801716885456"));
			} catch (Exception ex) {

				Log.i("FILEUPLOAD", "There was a problem uploading file");

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void fileName) {

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
