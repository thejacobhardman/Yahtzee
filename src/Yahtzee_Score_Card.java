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
	
	//null is used to denote that the score value is 'empty'
	private Integer onesScore = null;
	private Integer twosScore = null;
	private Integer threesScore = null;
	private Integer foursScore = null;
	private Integer fivesScore = null;
	private Integer sixesScore = null;
	private int bonusScore = 0;
	{
		if (this.onesScore + this.twosScore + this.threesScore + this.foursScore + this.fivesScore + this.sixesScore >= 63) {
			this.bonusScore = 35;
		} else {
			this.bonusScore = 0;
		}
	}
	private Integer threeKindScore = null;
	private Integer fourKindScore = null;
	private Integer fullHouseScore = null;
	private Integer smallStraightScore = null;
	private Integer largeStraightScore = null;
	private Integer yahtzeeScore = null;
	private Integer chanceScore = null;
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
	
	/***********************************************************************
	 * Method:  rollDice	                                                *
	 * Background:  This function allows us to roll all of the dice in the  *
	 * Yahtzee Hand.                                                        *
	 * Purpose:  rolls all of the dice in the hand				            *
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void rollDice() {
		hand.rollDice();
	}
	
	/***********************************************************************
	 * Method:  rollDice	                                                *
	 * Background:  This function allows us to roll specific dice in the    *
	 * hand.                                                                *
	 * Purpose:  rolls specified dice in the hand				            *
	 * Parameters:                                                          *
	 *    d1: boolean representing whether the first die should be rolled	*
	 *    d2: boolean representing whether the second die should be rolled	*
	 *    d3: boolean representing whether the third die should be rolled	*
	 *    d4: boolean representing whether the fourth die should be rolled	*
	 *    d5: boolean representing whether the fifth die should be rolled	*
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void rollDice(boolean d1, boolean d2, boolean d3, boolean d4, boolean d5) {
		hand.rollDice(d1, d2, d3, d4, d5);
	}
	
	/***********************************************************************
	 * Method:  recalculateBonusScore	                                    *
	 * Background:  This function recalculates the bonus score value of     *
	 * the scoresheet. This will save code space since we have to           *
	 * recalculate this often.                                              *
	 * Purpose:  Recalculates the bonus score value of the scoresheet.	    *
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	private void recalculateBonusScore() {
		if (this.onesScore + this.twosScore + this.threesScore + this.foursScore + this.fivesScore + this.sixesScore >= 63) {
			this.bonusScore = 35;
		} else {
			this.bonusScore = 0;
		}
	}
	
	/***********************************************************************
	 * Method:  recalculateTotalScore	                                    *
	 * Background:  This function recalculates the total score value of     *
	 * the scoresheet. This will save code space since we have to           *
	 * recalculate this often.                                              *
	 * Purpose:  Recalculates the total score value of the scoresheet.	    *
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value:  none                                                  *
	 ***********************************************************************/
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
	
	/***********************************************************************
	 * Method:  scoreOnes	                                                *
	 * Background:  This function updates the onesScore value of the        *
	 * scoresheet by accessing the hand's value for score of 1's in the hand.*
	 * Purpose:  Updates the onesScore value of the scoresheet.	            *
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void scoreOnes() {
		this.onesScore = hand.faceValue(1);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	/***********************************************************************
	 * Method:  scoreTwos	                                                *
	 * Background:  This function updates the scoreTwos value of the        *
	 * scoresheet by accessing the hand's value for score of 2's in the hand.*
	 * Purpose:  Updates the scoreTwos value of the scoresheet.	            *
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void scoreTwos() {
		this.onesScore = hand.faceValue(2);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	/***********************************************************************
	 * Method:  scoreThrees	                                                *
	 * Background:  This function updates the scoreThrees value of the      *
	 * scoresheet by accessing the hand's value for score of 3's in the hand.*
	 * Purpose:  Updates the scoreThrees value of the scoresheet.	        *
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void scoreThrees() {
		this.onesScore = hand.faceValue(3);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	/***********************************************************************
	 * Method:  scoreFours	                                                 *
	 * Background:  This function updates the scoreFours value of the        *
	 * scoresheet by accessing the hand's value for score of 4's in the hand.*
	 * Purpose:  Updates the scoreFours value of the scoresheet.	         *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ***********************************************************************/
	public void scoreFours() {
		this.onesScore = hand.faceValue(4);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	/***********************************************************************
	 * Method:  scoreFives	                                                 *
	 * Background:  This function updates the scoreFives value of the        *
	 * scoresheet by accessing the hand's value for score of 5's in the hand.*
	 * Purpose:  Updates the scoreFives value of the scoresheet.	         *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ***********************************************************************/
	public void scoreFives() {
		this.onesScore = hand.faceValue(5);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	/***********************************************************************
	 * Method:  scoreSixes	                                                 *
	 * Background:  This function updates the scoreSixes value of the        *
	 * scoresheet by accessing the hand's value for score of 6's in the hand.*
	 * Purpose:  Updates the scoreSixes value of the scoresheet.	         *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ***********************************************************************/
	public void scoreSixes() {
		this.onesScore = hand.faceValue(6);
		this.recalculateBonusScore();
		this.recalculateTotalScore();
	}
	
	/*************************************************************************
	 * Method:  scoreThreeKind	                                             *
	 * Background:  This function updates the scoreThreeKind value of the    *
	 * scoresheet by accessing the hand's value for score of                 *
	 * three of a kinds in the hand.                                         *
	 * Purpose:  Updates the scoreThreeKind value of the scoresheet.	     *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void scoreThreeKind() {
		this.threeKindScore = hand.threeKindValue();
		this.recalculateTotalScore();
	}
	
	/*************************************************************************
	 * Method:  scoreFourKind	                                             *
	 * Background:  This function updates the scoreFourKind value of the     *
	 * scoresheet by accessing the hand's value for score of                 *
	 * four of a kinds in the hand.                                          *
	 * Purpose:  Updates the scoreFourKind value of the scoresheet.	         *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void scoreFourKind() {
		this.threeKindScore = hand.fourKindValue();
		this.recalculateTotalScore();
	}
	
	/*************************************************************************
	 * Method:  scoreFullHouse	                                             *
	 * Background:  This function updates the scoreFullHouse value of the    *
	 * scoresheet by accessing the hand's value for score of                 *
	 * full houses in the hand.                                              *
	 * Purpose:  Updates the scoreFullHouse value of the scoresheet.	     *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void scoreFullHouse() {
		this.fullHouseScore = hand.fullHouseValue();
		this.recalculateTotalScore();
	}
	
	/*************************************************************************
	 * Method:  scoreSmallStraight	                                         *
	 * Background:  This function updates the scoreSmallStraight value       *
	 * of the scoresheet by accessing the hand's value for score of          *
	 * small straights in the hand.                                          *
	 * Purpose:  Updates the scoreSmallStraight value of the scoresheet.     *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void scoreSmallStraight() {
		this.smallStraightScore = hand.smallStraightValue();
		this.recalculateTotalScore();
	}
	
	/*************************************************************************
	 * Method:  scoreLargeStraight	                                         *
	 * Background:  This function updates the scoreLargeStraight value       *
	 * of the scoresheet by accessing the hand's value for score of          *
	 * large straights in the hand.                                          *
	 * Purpose:  Updates the scoreLargeStraight value of the scoresheet.     *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void scoreLargeStraight() {
		this.largeStraightScore = hand.largeStraightValue();
		this.recalculateBonusScore();
	}
	
	/*************************************************************************
	 * Method:  scoreYahtzee	                                             *
	 * Background:  This function updates the scoreYahtzee value             *
	 * of the scoresheet by accessing the hand's value for score of          *
	 * Yahtzee's in the hand.                                                *
	 * Purpose:  Updates the scoreYahtzee value of the scoresheet.           *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void scoreYahtzee() {
		this.yahtzeeScore = hand.yahtzeeValue();
		this.recalculateTotalScore();
	}
	
	/*************************************************************************
	 * Method:  scoreChance	                                                 *
	 * Background:  This function updates the scoreChance value              *
	 * of the scoresheet by accessing the hand's value for score of          *
	 * chance in the hand.                                                   *
	 * Purpose:  Updates the scoreChance value of the scoresheet.            *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void scoreChance() {
		this.chanceScore = hand.chanceValue();
		this.recalculateTotalScore();
	}
	
	/*************************************************************************
	 * Method:  displayScoreSheet	                                         *
	 * Background:  This function displays all values for the scoresheet     *
	 * in a neat table. This will be used at the start of each turn to       *
	 * update the player on their current score and what combinations remain.*
	 * Purpose:  Displays the score sheet.                                   *
	 * Parameters:                                                           *
	 *    none												                 *
	 * Return value:  none                                                   *
	 ************************************************************************/
	public void displayScoreSheet() {
		System.out.println("\nCurrent Scoresheet:");
		System.out.format("\n1.  Ones:        %2d %n", this.onesScore);
		System.out.format("2.  Twos:        %2d %n", this.twosScore);
		System.out.format("3.  Threes:        %2d %n", this.threesScore);
		System.out.format("4.  Fours:        %2d %n", this.foursScore);
		System.out.format("5.  Fives:        %2d %n", this.fivesScore);
		System.out.format("6.  Sixes:        %2d %n", this.sixesScore);
		System.out.format("BONUS:        %2d %n", this.bonusScore);
		System.out.format("7.  3-Kind:        %2d %n", this.threeKindScore);
		System.out.format("8.  4-Kind:        %2d %n", this.fourKindScore);
		System.out.format("9.  Full House:        %2d %n", this.fullHouseScore);
		System.out.format("10. Small Straight:        %2d %n", this.smallStraightScore);
		System.out.format("11. Large Straight:        %2d %n", this.largeStraightScore);
		System.out.format("12. Yahtzee:        %2d %n", this.yahtzeeScore);
		System.out.format("13. Chance:        %2d %n", this.chanceScore);
		System.out.format("TOTAL:        %2d %n", this.totalScore);
	}
}
