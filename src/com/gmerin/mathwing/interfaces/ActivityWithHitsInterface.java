package com.gmerin.mathwing.interfaces;

public interface ActivityWithHitsInterface extends ActivityWithCommonInterface {
	
	public void setTargetLock(boolean targetLock);
	
	public void setAttackDice(int dice);
	
	public void setNumberOfHits(int hits);
	
	public void setAttackFocus(boolean focus);
}
