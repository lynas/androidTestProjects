package com.lynas.fragsipetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestFrag2 extends Fragment{
	View testFrag2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		testFrag2 = inflater.inflate(R.layout.testfrag2, container, false);
		return testFrag2;
	}

}
