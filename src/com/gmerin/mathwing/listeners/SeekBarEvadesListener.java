package com.gmerin.mathwing.listeners;

import android.widget.SeekBar;

import com.gmerin.mathwing.interfaces.ActivityWithEvadesInterface;

public class SeekBarEvadesListener implements SeekBar.OnSeekBarChangeListener {
	ActivityWithEvadesInterface parentActivity;
	
	/**
	 * Constructor. Necesita la actividad padre para guardar los cambios
	 * y actualizar el contenido de la interfaz.
	 * @param parentActivity la actividad padre.
	 */
	public SeekBarEvadesListener(ActivityWithEvadesInterface parentActivity) {
		this.parentActivity = parentActivity;
	}
	
    public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
		parentActivity.setNumberOfEvades(progress+1);
		parentActivity.updateValues();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {}

    public void onStopTrackingTouch(SeekBar seekBar) {}

}
