package com.gmerin.mathwing.listeners;

import android.widget.SeekBar;

import com.gmerin.mathwing.HitsActivity;

public class SeekBarAttackDiceListener implements SeekBar.OnSeekBarChangeListener {
	HitsActivity parentActivity;
	
	/**
	 * Constructor. Necesita la actividad padre para guardar los cambios
	 * y actualizar el contenido de la interfaz.
	 * @param parentActivity la actividad padre.
	 */
	public SeekBarAttackDiceListener(HitsActivity parentActivity) {
		this.parentActivity = parentActivity;
	}
	
    public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
		parentActivity.setAttackDice(progress+1);
		parentActivity.updateValues();
    }

    public void onStartTrackingTouch(SeekBar seekBar) {}

    public void onStopTrackingTouch(SeekBar seekBar) {}

}
