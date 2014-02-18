package com.gmerin.mathwing.listeners;

import com.gmerin.mathwing.HitsActivity;

import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckBoxFocusListener implements OnCheckedChangeListener {
	private HitsActivity parentActivity;
	
	/**
	 * Constructor. Necesita la actividad padre para guardar los cambios
	 * y actualizar el contenido de la interfaz.
	 * @param parentActivity la actividad padre.
	 */
	public CheckBoxFocusListener(HitsActivity parentActivity) {
		this.parentActivity = parentActivity;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
		parentActivity.setFocus(isChecked);
		parentActivity.updateValues();
	}

}
