package com.lynas.fragsipetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestFrag1 extends Fragment{
	View testFrag1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		testFrag1 = inflater.inflate(R.layout.testfrag1, container, false);
		return testFrag1;
	}
	
	
	

}
