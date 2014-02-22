package com.gmerin.mathwing;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gmerin.mathwing.interfaces.ActivityWithEvadesInterface;
import com.gmerin.mathwing.listeners.CheckBoxDefenseFocusListener;
import com.gmerin.mathwing.listeners.SeekBarDefenseDiceListener;
import com.gmerin.mathwing.listeners.SeekBarEvadesListener;
import com.gmerin.mathwing.model.MathWingProbability;
import com.gmerin.mathwing.visuals.VisualAspect;

public class EvadesActivity  extends Activity implements ActivityWithEvadesInterface {
	private int dice = 1;
	private int evades = 1;
	private boolean focus = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evades);
		
		// Tareas de inicio: valores m�ximos de los seekbar, a�adir sus listeners, etc.
		initTasks();
		
		// Actualizamos los valores estad�sticos
		updateValues();
	}
	
	/**
	 * Actualiza la interfaz de usuario en funci�n de los cambios que se vayan produciendo
	 * en los valores: dice, hits, focus y targetLock.
	 */
	public void updateValues() {
		// Establecemos los valores del n�mero de dados y el n�mero de evasiones
		TextView txtDefenseDiceValue = (TextView) findViewById(R.id.textViewDefenseDiceValue);
		TextView txtEvadesValue = (TextView) findViewById(R.id.textViewEvadesValue);
		txtDefenseDiceValue.setText(Integer.toString(dice));
		txtEvadesValue.setText(Integer.toString(evades));
		
		// Actualizamos la probabilidad de obtener, como m�nimo, el n�mero de evasiones seleccionado
		TextView txtNumEvadesProbValue = (TextView) findViewById(R.id.textViewNumEvadesProbValue);
		double prob = MathWingProbability.getEvadesProbability(focus, dice, evades);
		txtNumEvadesProbValue.setText(VisualAspect.doubleToString(prob*100)+"%");
		txtNumEvadesProbValue.setTextColor(VisualAspect.getColorFromProbability(prob));
		
		// Actualizamos el n�mero medio de evasiones
		TextView txtAvgNumEvadesValue = (TextView) findViewById(R.id.textViewAvgNumEvadesValue);
		double num  = MathWingProbability.getAvgNumEvades(focus, dice);
		txtAvgNumEvadesValue.setText(VisualAspect.doubleToString(num));
		
		// Mostramos los iconos de los dados s�lo de los elementos activos
		ImageView imgFocus = (ImageView) findViewById(R.id.imageViewEvadeFocus);
		if (focus) imgFocus.setVisibility(View.VISIBLE);
		else imgFocus.setVisibility(View.GONE);
	}
	
	/**
	 * Tareas de inicializaci�n de los componentes gr�ficos.
	 */
	protected void initTasks() {
		// Establecemos los valores m�ximos de los SeekBar
		SeekBar sbarDefenseDice = (SeekBar) findViewById(R.id.seekBarDefensekDice);
		SeekBar sbarEvades = (SeekBar) findViewById(R.id.seekBarEvades);
		
		Resources res = getResources();
		int maxDice = res.getInteger(R.integer.max_dice);
		sbarDefenseDice.setMax(maxDice-1);
		sbarEvades.setMax(maxDice-1);
		
		// A�adimos los listener a los SeekBar
		sbarDefenseDice.setOnSeekBarChangeListener(new SeekBarDefenseDiceListener(this));
		sbarEvades.setOnSeekBarChangeListener(new SeekBarEvadesListener(this));
		
		// A�adimos los listeners al CheckBox
		CheckBox cBoxFocus = (CheckBox) findViewById(R.id.checkBoxDefenseFocus);
		cBoxFocus.setOnCheckedChangeListener(new CheckBoxDefenseFocusListener(this));
		
		// Mostramos los iconos de los dados s�lo de los elementos activos
		ImageView imgFocus = (ImageView) findViewById(R.id.imageViewEvadeFocus);
		
		if(focus) imgFocus.setVisibility(View.VISIBLE);
		else imgFocus.setVisibility(View.GONE);
	}
	
	/**
	 * Indica a la actividad el n�mero de dados del defensa.
	 * @param dice n�mero de dados de defensa.
	 */
	public void setDefenseDice(int dice) {
		this.dice = dice;
	}
	
	/**
	 * Indica a la actividad el n�mero de evasiones m�nimo que deseamos conseguir.
	 * @param hits n�mero de evasiones.
	 */
	public void setNumberOfEvades(int evades) {
		this.evades = evades;
	}

	/**
	 * Indica a la actividad si la defensa va a ser concentrada.
	 * @param focus si la defensa es concentrada.
	 */
	@Override
	public void setDefenseFocus(boolean focus) {
		this.focus = focus;
		
	}

}
