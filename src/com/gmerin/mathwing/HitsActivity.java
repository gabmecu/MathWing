package com.gmerin.mathwing;

import com.gmerin.mathwing.listeners.CheckBoxFocusListener;
import com.gmerin.mathwing.listeners.CheckBoxTargetLockListener;
import com.gmerin.mathwing.listeners.SeekBarAttackDiceListener;
import com.gmerin.mathwing.listeners.SeekBarHitsListener;
import com.gmerin.mathwing.model.MathWingProbability;
import com.gmerin.mathwing.visuals.VisualAspect;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class HitsActivity extends Activity {
	
	private int dice = 1;
	private int hits = 1;
	private boolean focus = false;
	private boolean targetLock = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hits);
		
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
		// Establecemos los valores del n�mero de dados y el n�mero de impactos
		TextView txtAttackDiceValue = (TextView) findViewById(R.id.textViewAttackDiceValue);
		TextView txtHitsValue = (TextView) findViewById(R.id.textViewHitsValue);
		txtAttackDiceValue.setText(Integer.toString(dice));
		txtHitsValue.setText(Integer.toString(hits));
		
		// Actualizamos la probabilidad de obtener, como m�nimo, el n�mero de impactos seleccionados
		TextView txtNumHitsProbValue = (TextView) findViewById(R.id.textViewNumHitsProbValue);
		double prob = MathWingProbability.getHitsProbability(focus, targetLock, dice, hits);
		txtNumHitsProbValue.setText(VisualAspect.doubleToString(prob));
		txtNumHitsProbValue.setTextColor(VisualAspect.getColorFromProbability(prob));
		
		// Actualizamos el n�mero medio de impactos
		TextView txtAvgNumHitsValue = (TextView) findViewById(R.id.textViewAvgNumHitsValue);
		double num = MathWingProbability.getAvgNumHits(focus, targetLock, dice);
		txtAvgNumHitsValue.setText(Double.toString(num));
	}
	
	/**
	 * Tareas de inicializaci�n de los componentes gr�ficos.
	 */
	protected void initTasks() {
		// Establecemos los valores m�ximos de los SeekBar
		SeekBar sbarAttackDice = (SeekBar) findViewById(R.id.seekBarAttackDice);
		SeekBar sbarHits = (SeekBar) findViewById(R.id.seekBarHits);
		
		Resources res = getResources();
		int maxDice = res.getInteger(R.integer.max_dice);
		sbarAttackDice.setMax(maxDice-1);
		sbarHits.setMax(maxDice-1);
		
		// A�adimos los listeners a los SeekBar
		sbarAttackDice.setOnSeekBarChangeListener(new SeekBarAttackDiceListener(this));
		sbarHits.setOnSeekBarChangeListener(new SeekBarHitsListener(this));
		
		// A�adimos los listeners a los CheckBox
		CheckBox cBoxFocus = (CheckBox) findViewById(R.id.checkBoxFocus);
		cBoxFocus.setOnCheckedChangeListener(new CheckBoxFocusListener(this));
		
		CheckBox cBoxTargetLock = (CheckBox) findViewById(R.id.checkBoxTargetLock);
		cBoxTargetLock.setOnCheckedChangeListener(new CheckBoxTargetLockListener(this));
	}
	
	/**
	 * Indica a la actividad el n�mero de dados del ataque.
	 * @param dice n�mero de dados del ataque.
	 */
	public void setAttackDice(int dice) {
		this.dice = dice;
	}
	
	/**
	 * Indica a la actividad el n�mero de impactos m�nimo que deseamos conseguir.
	 * @param hits n�mero de impactos.
	 */
	public void setNumberOfHits(int hits) {
		this.hits = hits;
	}
	
	/**
	 * Indica a la actividad si el atque va a ser concentrado.
	 * @param focus si el ataque es concentrado.
	 */
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	
	/**
	 * Indica a la actividad si el ataque es con blanco fijado.
	 * @param targetLock si el ataque es con blanco fijado.
	 */
	public void setTargetLock(boolean targetLock) {
		this.targetLock = targetLock;
	}
}
