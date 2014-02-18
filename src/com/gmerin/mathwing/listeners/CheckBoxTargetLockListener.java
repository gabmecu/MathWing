package com.gmerin.mathwing.listeners;


import com.gmerin.mathwing.HitsActivity;

import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckBoxTargetLockListener implements OnCheckedChangeListener {
	private HitsActivity parentActivity;
	
	/**
	 * Constructor. Necesita la actividad padre para guardar los cambios
	 * y actualizar el contenido de la interfaz.
	 * @param parentActivity la actividad padre.
	 */
	public CheckBoxTargetLockListener(HitsActivity parentActivity) {
		this.parentActivity = parentActivity;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
		parentActivity.setTargetLock(isChecked);
		parentActivity.updateValues();
	}

}
