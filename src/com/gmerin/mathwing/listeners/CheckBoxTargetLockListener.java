package com.gmerin.mathwing.listeners;


import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.gmerin.mathwing.interfaces.ActivityWithHitsInterface;

public class CheckBoxTargetLockListener implements OnCheckedChangeListener {
	private ActivityWithHitsInterface parentActivity;
	
	/**
	 * Constructor. Necesita la actividad padre para guardar los cambios
	 * y actualizar el contenido de la interfaz.
	 * @param parentActivity la actividad padre.
	 */
	public CheckBoxTargetLockListener(ActivityWithHitsInterface parentActivity) {
		this.parentActivity = parentActivity;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
		parentActivity.setTargetLock(isChecked);
		parentActivity.updateValues();
	}

}
