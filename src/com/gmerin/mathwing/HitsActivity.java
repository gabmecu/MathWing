package com.gmerin.mathwing;

import com.gmerin.mathwing.listeners.CheckBoxFocusListener;
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
		
		// Tareas de inicio: valores máximos de los seekbar, añadir sus listeners, etc.
		initTasks();
		
		// Actualizamos los valores estadísticos
		updateValues();
	}
	
	public void updateValues() {
		// Establecemos los valores del número de dados y el número de impactos
		TextView txtAttackDiceValue = (TextView) findViewById(R.id.textViewAttackDiceValue);
		TextView txtHitsValue = (TextView) findViewById(R.id.textViewHitsValue);
		txtAttackDiceValue.setText(Integer.toString(dice));
		txtHitsValue.setText(Integer.toString(hits));
		
		// Actualizamos la probabilidad de obtener, como mínimo, el número de impactos seleccionados
		TextView txtNumHitsProbValue = (TextView) findViewById(R.id.textViewNumHitsProbValue);
		double prob = MathWingProbability.getHitsProbability(focus, targetLock, dice, hits);
		txtNumHitsProbValue.setText(VisualAspect.doubleToString(prob));
		txtNumHitsProbValue.setTextColor(VisualAspect.getColorFromProbability(prob));
		
		// Actualizamos el número medio de impactos
		TextView txtAvgNumHitsValue = (TextView) findViewById(R.id.textViewAvgNumHitsValue);
		double num = MathWingProbability.getAvgNumHits(focus, targetLock, dice);
		txtAvgNumHitsValue.setText(Double.toString(num));
	}
	
	protected void initTasks() {
		// Establecemos los valores máximos de los SeekBar
		SeekBar sbarAttackDice = (SeekBar) findViewById(R.id.seekBarAttackDice);
		SeekBar sbarHits = (SeekBar) findViewById(R.id.seekBarHits);
		
		Resources res = getResources();
		int maxDice = res.getInteger(R.integer.max_dice);
		sbarAttackDice.setMax(maxDice-1);
		sbarHits.setMax(maxDice-1);
		
		// Añadimos los listeners a los SeekBar
		sbarAttackDice.setOnSeekBarChangeListener(new SeekBarAttackDiceListener(this));
		sbarHits.setOnSeekBarChangeListener(new SeekBarHitsListener(this));
		
		// Añadimos los listeners a los CheckBox
		CheckBox cBox = (CheckBox) findViewById(R.id.checkBoxFocus);
		cBox.setOnCheckedChangeListener(new CheckBoxFocusListener(this));
	}
	
	public void setAttackDice(int dice) {
		this.dice = dice;
	}
	
	public void setNumberOfHits(int hits) {
		this.hits = hits;
	}
	
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
}
