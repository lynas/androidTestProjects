package com.lynas.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class Frag_handler extends FragmentActivity {
	private Fragment fa = new Side_a();
	private Fragment fb = new Side_b();

	Button switchButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frag_handler);
		
		FragmentManager mainFragManager = getSupportFragmentManager();
		FragmentTransaction fragtrans = mainFragManager.beginTransaction();
		fragtrans.replace(R.id.frag1, fa, "a");
		fragtrans.commit();

		switchButton = (Button) findViewById(R.id.buttonSW);
		switchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				swapFrag(v);

			}
		});

	}

	public void swapFrag(View V) {

		
		
		FragmentManager mainFragManager = getSupportFragmentManager();

		FragmentTransaction fragtrans = mainFragManager.beginTransaction();

		if (fa.isVisible()) {
			fragtrans.replace(R.id.frag1, fb, "b");
		} else {
			fragtrans.replace(R.id.frag1, fa, "a");
		}
		fragtrans.addToBackStack(null);
		fragtrans.commit();
	}

}
