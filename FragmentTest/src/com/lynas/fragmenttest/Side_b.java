package com.lynas.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Side_b extends Fragment {
	
	
	
	View view_b;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			
		
		view_b = inflater.inflate(R.layout.activity_side_b, container, false);
		
		return view_b;
	}

}
