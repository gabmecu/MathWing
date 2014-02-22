package com.gmerin.mathwing.listeners;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.gmerin.mathwing.interfaces.ActivityWithHitsInterface;

public class CheckBoxAttackFocusListener implements OnCheckedChangeListener {
	private ActivityWithHitsInterface parentActivity;
	
	/**
	 * Constructor. Necesita la actividad padre para guardar los cambios
	 * y actualizar el contenido de la interfaz.
	 * @param parentActivity la actividad padre.
	 */
	public CheckBoxAttackFocusListener(ActivityWithHitsInterface parentActivity) {
		this.parentActivity = parentActivity;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
		parentActivity.setAttackFocus(isChecked);
		parentActivity.updateValues();
	}

}
