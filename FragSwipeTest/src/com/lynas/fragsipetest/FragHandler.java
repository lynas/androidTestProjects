

package com.lynas.fragsipetest;

import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class FragHandler extends SherlockFragmentActivity{
	
	
	Fragment frag1 = new Frag1();
	
	Button sbShow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frag_host);
		/*
		FragmentManager mainFragManager = getSupportFragmentManager();
		FragmentTransaction fragtrans = mainFragManager.beginTransaction();
		fragtrans.replace(R.id.frame_holder,frag1);
		
		fragtrans.commit();
		*/
		sbShow = (Button) findViewById(R.id.buttonSW);
		sbShow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showFrags(v);
				
			}

			
		});
		
		
		
		
	}
	
	private void showFrags(View v) {
		
		FragmentManager mainFragManager = getSupportFragmentManager();
		FragmentTransaction fragtrans = mainFragManager.beginTransaction();
		fragtrans.replace(R.id.frame_holder,frag1);
		
		fragtrans.commit();
		
		
	}

}
