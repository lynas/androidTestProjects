package com.lynas.dialogboxtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ArtistActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView texv = new TextView(this);
		texv.setText("Artist Content");
		setContentView(texv);
		
		
	}
}
