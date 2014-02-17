package com.gmerin.mathwing;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Nos quedamos con el TabHost para poblarlo
		TabHost tabHost = getTabHost();
		
		// Nos quedamos con los recursos
		Resources res = getResources();
		
		String txtTabHits = res.getString(R.string.main_tab_hits);
		
		// Pestaña para los impactos
		TabSpec hitsTabSpec = tabHost.newTabSpec(txtTabHits);
		hitsTabSpec.setIndicator(txtTabHits);
		Intent hitsIntent = new Intent(this, HitsActivity.class);
		hitsTabSpec.setContent(hitsIntent);
		
		// Añadimos las pestañas al TabHost
		tabHost.addTab(hitsTabSpec);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
