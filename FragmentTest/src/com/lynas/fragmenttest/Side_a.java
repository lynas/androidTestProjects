package com.lynas.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Side_a extends Fragment {

	
	View view_a;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			
		view_a = inflater.inflate(R.layout.activity_side_a, container, false);
		
		return view_a;
	}

}
