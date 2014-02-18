package com.gmerin.mathwing.model;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.AbstractIntegerDistribution;
import org.apache.commons.math.distribution.DiscreteDistribution;
import org.apache.commons.math.util.MathUtils;

/**
 * Provides various probability density functions for a Binomial
 * Distribution. Definitions and formulae for Binomial Distribution
 * can be found here:
 * {@link http://stattrek.com/Lesson2/Binomial.aspx?Tutorial=AP}
 */
public class BinomialDistribution extends AbstractIntegerDistribution 
    implements DiscreteDistribution {

  private static final long serialVersionUID = -1858690105951636184L;

  private int n;    // number of trials
  private double p; // probability of success on an individual trial
  
  /**
   * Construct a Binomial Distribution experiment instance.
   * @param n the number of trials.
   * @param p the probability of success on an individual trial.
   */
  public BinomialDistribution(int n, double p) {
    super();
    this.n = n;
    this.p = p;
  }

  /**
   * Using logs is useful for very large values of n.
   * @param x the number of successes.
   * @return the log of the probability.
   */  
  public double logProbability(int x) {
    return MathUtils.binomialCoefficientLog(n, x) + 
      (x * Math.log(p)) + ((n - x) * Math.log(1 - p));
  }
  
  /**
   * Computes the probability that the experiment results in 
   * exactly x successes. The computation is done with logarithms
   * internally and converted back to the probability value to
   * prevent overflow.
   * @param x the number of successes, should be an integer.
   * @return probability the probability of exactly x successes.
   */
  @Override
  public double probability(int x) {
    return Math.exp(MathUtils.binomialCoefficientLog(n, x) + 
      (x * Math.log(p)) + ((n - x) * Math.log(1 - p)));
  }

  /**
   * Computes the probability that the experiment results in at 
   * least x (x-n) successes.
   * @param x the number of successes, should be an integer.
   * @return the probability of at least x successes.
   */
  @Override
  public double cumulativeProbability(int x) throws MathException {
    double cumulativeProbability = 0.0D;
    for (int i = x; i <= n; i++) {
      cumulativeProbability += probability(i);
    }
    return cumulativeProbability;
  }
  
  public double cumulativeProbabilityWithRerolls(int x, int rerolls) throws MathException {
	  // Probabilidad acumulada sin repeticiones de tiradas  
	  double cumulativeProbability = cumulativeProbability(x);
	  
	  //Probabilidad acumulada repitiendo los fallos
	  double rerollsProbabilitiy = 0.0D;
	  double aux1 = 0.0D;
	  double aux2 = 0.0D;
	  BinomialDistribution auxBinomial;
	  for(int i = 1; i <= x; i++) {
		  aux1 = probability(x-i);
		  auxBinomial = new BinomialDistribution(n-(x-i), p);
		  aux2 = auxBinomial.cumulativeProbability(i);
		  rerollsProbabilitiy += aux1*aux2;
	  }
	  
	  return cumulativeProbability+rerollsProbabilitiy;
  }

  @Override
  protected int getDomainLowerBound(double p) {
    return 0;
  }

  @Override
  protected int getDomainUpperBound(double p) {
    return 1;
  }
}