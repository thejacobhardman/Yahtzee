/*******************************************************************************
*                      Assignment 6 -- Yahtzee Solo Game                       *
*                                                                              *
* PROGRAMMER:        Jacob Hardman hard7293@bears.unco.edu                     *
* CLASS:             CS200 – Object Oriented Programming                       *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2021                                               *
* SUBMISSION DATE:   3/5/2021	                                               *
*                                                                              *
* DESCRIPTION                                                                  *
* This file implements the functionality of a score card used in the game      *
* of Yahtzee.                                                                  *
*                                                                              *
* ATTRIBUTES:                                                                  *
*         dice: an ArrayList that holds each individual die in the hand.       *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.             *
*                                                                              *
*******************************************************************************/

public class Yahtzee_Score_Card {
	
	//-1 is used to denote that the score value is 'empty'
	private int onesScore = -1;
	private int twosScore = -1;
	private int threesScore = -1;
	private int foursScore = -1;
	private int fivesScore = -1;
	private int sixesScore = -1;
	private int bonusScore = -1;
	{
		if (this.onesScore + this.twosScore + this.threesScore + this.foursScore + this.fivesScore + this.sixesScore >= 63) {
			this.bonusScore = 35;
		} else {
			this.bonusScore = 0;
		}
	}
	private int threeKindScore = -1;
	private int fourKindScore = -1;
	private int fullHouseScore = -1;
	private int smallStraightScore = -1;
	private int largeStraightScore = -1;
	private int yahtzeeScore = -1;
	private int chanceScore = -1;
	private int totalScore = this.onesScore +
							 this.twosScore +
							 this.threesScore +
							 this.foursScore +
							 this.fivesScore +
							 this.sixesScore +
							 this.bonusScore +
							 this.threeKindScore +
							 this.fourKindScore +
							 this.fullHouseScore +
							 this.smallStraightScore +
							 this.largeStraightScore +
							 this.yahtzeeScore +
							 this.chanceScore;
	private Yahtzee_Hand hand = new Yahtzee_Hand();
	
	public void rollDice() {
		hand.rollDice();
	}
	
	public void rollDice(boolean d1, boolean d2, boolean d3, boolean d4, boolean d5) {
		hand.rollDice(d1, d2, d3, d4, d5);
	}
	
	private void recalculateBonusScore() {
		if (this.onesScore + this.twosScore + this.threesScore + this.foursScore + this.fivesScore + this.sixesScore >= 63) {
			this.bonusScore = 35;
		} else {
			this.bonusScore = 0;
		}
	}
	
	private void recalculateTotalScore() {
		this.totalScore = this.onesScore +
				 this.twosScore +
				 this.threesScore +
				 this.foursScore +
				 this.fivesScore +
				 this.sixesScore +
				 this.bonusScore +
				 this.threeKindScore +
				 this.fourKindScore +
				 this.fullHouseScore +
				 this.smallStraightScore +
				 this.largeStraightScore +
				 this.yahtzeeScore +
				 this.chanceScore;
	}
	
	public void scoreOnes() {
		this.onesScore = hand.faceValue(1);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	public void scoreTwos() {
		this.onesScore = hand.faceValue(2);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	public void scoreThrees() {
		this.onesScore = hand.faceValue(3);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	public void scoreFours() {
		this.onesScore = hand.faceValue(4);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	public void scoreFives() {
		this.onesScore = hand.faceValue(5);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	public void scoreSixes() {
		this.onesScore = hand.faceValue(6);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	public void scoreThreeKind() {
		this.threeKindScore = hand.threeKindValue();
		this.recalculateTotalScore();
	}
	
	public void scoreFourKind() {
		this.threeKindScore = hand.fourKindValue();
		this.recalculateTotalScore();
	}
	
	public void scoreFullHouse() {
		this.fullHouseScore = hand.fullHouseValue();
		this.recalculateTotalScore();
	}
	
	public void scoreSmallStraight() {
		this.smallStraightScore = hand.smallStraightValue();
		this.recalculateTotalScore();
	}
	
	public void scoreLargeStraight() {
		this.largeStraightScore = hand.largeStraightValue();
		this.recalculateBonusScore();
	}
	
	public void scoreYahtzee() {
		this.yahtzeeScore = hand.yahtzeeValue();
		this.recalculateTotalScore();
	}
	
	public void scoreChance() {
		this.chanceScore = hand.chanceValue();
		this.recalculateTotalScore();
	}
	
	public void displayScoreSheet() {
		
	}
}
