package com.gmerin.mathwing.listeners;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.gmerin.mathwing.interfaces.ActivityWithEvadesInterface;

public class CheckBoxDefenseFocusListener implements OnCheckedChangeListener {
	private ActivityWithEvadesInterface parentActivity;
	
	/**
	 * Constructor. Necesita la actividad padre para guardar los cambios
	 * y actualizar el contenido de la interfaz.
	 * @param parentActivity la actividad padre.
	 */
	public CheckBoxDefenseFocusListener(ActivityWithEvadesInterface parentActivity) {
		this.parentActivity = parentActivity;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
		parentActivity.setDefenseFocus(isChecked);
		parentActivity.updateValues();
	}

}
