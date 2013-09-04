package com.lynas.dialogboxtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SongActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView texv = new TextView(this);
		texv.setText("Song Content");
		setContentView(texv);
		
		
	}

}
