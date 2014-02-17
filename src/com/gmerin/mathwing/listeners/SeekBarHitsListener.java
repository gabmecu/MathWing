package com.gmerin.mathwing.listeners;

import android.widget.SeekBar;

import com.gmerin.mathwing.HitsActivity;

public class SeekBarHitsListener implements SeekBar.OnSeekBarChangeListener {
	HitsActivity parentActivity;
	
	public SeekBarHitsListener(HitsActivity parentActivity) {
		this.parentActivity = parentActivity;
	}
	
    public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
		parentActivity.setNumberOfHits(progress+1);
		parentActivity.updateValues();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {}

    public void onStopTrackingTouch(SeekBar seekBar) {}

}
