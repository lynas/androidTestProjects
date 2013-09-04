package com.lynas.swipewithviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag2 extends Fragment{
	View a;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		a = inflater.inflate(R.layout.f2, container);
		
		return a;
	}

}
