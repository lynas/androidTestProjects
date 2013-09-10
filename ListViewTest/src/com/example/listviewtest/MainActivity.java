package com.example.listviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
			"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
			"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
		
		
		
		lv = (ListView) findViewById(R.id.listView1);
		
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.eachv,FRUITS);
		
		lv.setAdapter(adp);
		
		
	}



}
