package com.gmerin.mathwing.model;

import org.apache.commons.math.MathException;

public class MathWingProbability {
	public static final double HIT_PROB_NO_FOCUS = (double) 4/8;
	public static final double HIT_PROB_FOCUS = (double) 6/8;
	public static final double CRITICAL_HIT_PROB = (double) 1/8;
	public static final double MISS_PROB = (double) 4/8;
	
	public static double getHitsProbability(boolean focus, boolean targetLock, int dice, int hits) {
		// Si el número de impactos es mayor que el número de dados, devolvemos 0
		if (hits > dice)
			return 0;
		
		// Obtenemos probabilidad de conseguir un impacto
		double prob = getHitProb(focus);
		double result = -1;
		
		// Obtenemos la distribución binomial
		BinomialDistribution binomial = new BinomialDistribution(dice, prob);
		
		// Obtenemos la probabilidad acumulada
		try {
			if (targetLock)
				result = binomial.cumulativeProbabilityWithRerolls(hits, hits);
			else
				result = binomial.cumulativeProbability(hits);
			
		} catch (MathException e) {
			e.printStackTrace();
		}
		
		// Devolvemos la probabilidad (valor entre 0-1)
		return result;
	}
	
	public static double getAvgNumHits(boolean focus, boolean targetLock, int dice) {
		// Obtenemos la probabilidad de conseguir un impacto
		double prob = getHitProb(focus);
		
		// Número medio de impactos
		double num = prob*dice;
		
		// Si está el targetLock activado, sumamos su correspondiente probabilidad
		if (targetLock)
			num += dice*prob*(1-prob);
		
		return num;
	}
	
	public static double getHitProb(boolean focus) {
		double prob = HIT_PROB_NO_FOCUS;
		if (focus)
			prob = HIT_PROB_FOCUS;
		return prob;
	}
}
