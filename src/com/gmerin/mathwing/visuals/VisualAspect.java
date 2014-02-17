package com.gmerin.mathwing.visuals;

import android.annotation.SuppressLint;
import android.graphics.Color;

public class VisualAspect {

	public static int getColorFromProbability(double x) {
		return Color.rgb((int)(255*(1-x)), (int)(128*x), 0);
	}
	
	@SuppressLint("DefaultLocale")
	public static String doubleToString(double d) {
		
		return String.format("%.2f", d*100)+"%";
	}
}
