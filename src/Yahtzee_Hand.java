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
* This file implements the functionality of a "hand" of dice used to play      *
* Yahtzee.                                                                     *
*                                                                              *
* ATTRIBUTES:                                                                  *
*         dice: an ArrayList that holds each individual die in the hand.       *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.             *
*                                                                              *
*******************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yahtzee_Hand {
	
	private ArrayList<Die> dice = new ArrayList<Die>();
	
	//CONSTRUCTOR METHODS
	/***********************************************************************
	 * Method:   Constructor (two parameters)                               *
	 * Purpose:  Create a new hand based on user parameters                 *
	 * Parameters:                                                          *
	 *    numOfDice_ -- the number of dice to add to the hand               *
	 *    numSides_ -- the number of sides that each die has                *
	 * Return value:  no return value type                                  *
	 ***********************************************************************/
	public Yahtzee_Hand(int numOfDice_, int numOfSides_) {
		for (int i = 0; i < numOfDice_; i++) {
			Die dieToAdd = new Die(numOfSides_);
			this.dice.add(dieToAdd);
		}
	}
	
	/***********************************************************************
	 * Method:   Constructor (one parameters)                               *
	 * Purpose:  Create a new hand based on user parameters                 *
	 * Parameters:                                                          *
	 *    numOfDice_ -- the number of dice to add to the hand               *
	 * Return value:  no return value type                                  *
	 ***********************************************************************/
	public Yahtzee_Hand(int numOfDice_) {
		for (int i = 0; i < numOfDice_; i++) {
			Die dieToAdd = new Die();
			this.dice.add(dieToAdd);
		}
	}
	
	/***********************************************************************
	 * Method:   Constructor (no parameters)                                *
	 * Purpose:  Create a new default hand of dice			                *
	 * Parameters:                                                          *
	 *    none											                    *
	 * Return value:  no return value type                                  *
	 ***********************************************************************/
	public Yahtzee_Hand() {
		for (int i = 0; i < 5; i++) {
			Die dieToAdd = new Die();
			this.dice.add(dieToAdd);
		}
	}
	
	//HELPER METHODS
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
		for (int i = 0; i < this.dice.size(); i++) {
			this.dice.get(i).roll();
		}
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
		if (d1 == true) {
			this.dice.get(0).roll();
		}
		if (d2 == true) {
			this.dice.get(1).roll();
		}
		if (d3 == true) {
			this.dice.get(2).roll();
		}
		if (d4 == true) {
			this.dice.get(3).roll();
		}
		if (d5 == true) {
			this.dice.get(4).roll();
		}
	}
	
	/***********************************************************************
	 * Method:  toString	                                                *
	 * Background:  This function allows us to return each current value    *
	 * of each die in the Yahtzee hand in a one line report.                *
	 * Purpose:  returns the values of each die in the hand as as a string	*
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value: the current values of each die in the hand as a string *
	 ***********************************************************************/
	public String toString() {
		String values = "";
		
		for (int i = 0; i < this.dice.size(); i++) {
			values += (this.dice.get(i).toString() + " ");
		}
		
		return values;
	}
	
	/***********************************************************************
	 * Method:  countDice	                                                *
	 * Background:  This function allows us to compare each die in the hand *
	 * against an input value. The number of total dice matching that value *
	 * is then returned.                                                    *
	 * Purpose:  returns the total number of dice in the hand that matches  *
	 * an input value.														*
	 * Parameters:                                                          *
	 *    n -- the value that we are checking the value of each die against *
	 * Return value: the total number of dice in the hand that match the    *
	 * input value.														    *
	 ***********************************************************************/
	public int countDice(int n) {
		int num = 0;
		
		for (int i = 0; i < this.dice.size(); i++) {
			if (n == this.dice.get(i).getCurrentValue()) {
				num++;
			}
		}
		
		return num;
	}
	
	/***********************************************************************
	 * Method:  setDice 	                                                *
	 * Background:  This function allows us to manually set the value of    *
	 * each die in the hand. The new values must be passed to this method   *
	 * as an ArrayList that is the same size as the Yahtzee Hand.	        *
	 * Purpose:  sets the current value of each die in the hand based on    *
	 * user input.      													*
	 * Parameters:                                                          *
	 *    nums -- the numbers that we want to set the dice in the hand to   *
	 * Return value: none												    *
	 ***********************************************************************/
	public void setDice(ArrayList<Integer> nums) {
		if (nums.size() == this.dice.size()) {
			for (int i = 0; i < this.dice.size(); i++) {
				this.dice.get(i).setCurrentValue(nums.get(i));
			}
		} else {
			System.out.println("ERROR: ArrayList of input values must be the same size as the Yahtzee Hand.");
		}
	}
	
	//SCORING METHODS
	/***********************************************************************
	 * Method:  faceValue	                                                *
	 * Background:  This function calculates what the sum of each die with  *
	 * a specified current value is. This is used for the first 6 rows of   *
	 * the Yahtzee scoring.											        *
	 * Purpose:  Used to calculate the first 6 rows of the Yahtzee score    *
	 * board.		    													*
	 * Parameters:                                                          *
	 *    n -- the number that we are checking for score/face value		    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int faceValue(int n) {
		int score = 0;
		
		for (int i = 0; i < this.dice.size(); i++) {
			if (n == this.dice.get(i).getCurrentValue()) {
				score++;
			}
		}
		
		score *= n;
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  chanceValue	                                                *
	 * Background:  This function calculates the total sum of the Yahtzee   *
	 * hand as is. Meaning that it simply calculates what the total value   *
	 * the current hand is. This is used for the chance scoring row and     *
	 * for scoring other rounds such as the three of a kind round.			*
	 * Purpose:  Used to calculate current value of the hand.    			*
	 * Parameters:                                                          *
	 *    none															    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int chanceValue() {
		int score = 0;
		
		for (int i = 0; i < this.dice.size(); i++) {
			score += this.dice.get(i).getCurrentValue();
		}
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  threeKindValue	                                            *
	 * Background:  This function checks the hand to see if there is a      *
	 * three of a kind present. If so, then the chance value method is      *
	 * used to calculate the score which is then returned.					*
	 * Purpose:  Used to check for a three of a kind.						*
	 * Parameters:                                                          *
	 *    none										            		    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int threeKindValue() {
		int score = 0;
		
		for (int i = 0; i < this.dice.size(); i++) {
			for (int j = i + 1; j < this.dice.size(); j++) {
				for (int k = j + 1; k < this.dice.size(); k++) {
					if (i != j && j != k && this.dice.get(i).getCurrentValue() == this.dice.get(j).getCurrentValue() && this.dice.get(j).getCurrentValue() == this.dice.get(k).getCurrentValue()) {
						score = chanceValue();
					}
				}
			}
		}
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  fourKindValue	                                            *
	 * Background:  This function checks the hand to see if there is a      *
	 * four of a kind present. If so, then the chance value method is       *
	 * used to calculate the score which is then returned.					*
	 * Purpose:  Used to check for a four of a kind. 						*
	 * Parameters:                                                          *
	 *    none										            		    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int fourKindValue() {
		int score = 0;
		
		for (int i = 0; i < this.dice.size(); i++) {
			for (int j = i + 1; j < this.dice.size(); j++) {
				for (int k = j + 1; k < this.dice.size(); k++) {
					for (int l = k + 1; l < this.dice.size(); l++) {
						if (i != j && j != k && k != l &&
							this.dice.get(i).getCurrentValue() == this.dice.get(j).getCurrentValue() && 
							this.dice.get(j).getCurrentValue() == this.dice.get(k).getCurrentValue() &&
							this.dice.get(k).getCurrentValue() == this.dice.get(l).getCurrentValue()) {
							score = chanceValue();
						}
					}
				}
			}
		}
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  fullHouseValue	                                            *
	 * Background:  This function checks the hand to see if there is a      *
	 * full house is present. If so, then the score is set to               *
	 * 25 and returned. 													*
	 * Purpose:  Used to check for a full house.    						*
	 * Parameters:                                                          *
	 *    none										            		    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int fullHouseValue() {
		int score = 0;
		
		List<Integer> diceValues = new ArrayList<Integer>();
		
		for (int i = 0; i < this.dice.size(); i++) {
			diceValues.add(this.dice.get(i).getCurrentValue());
		}
		
		Collections.sort(diceValues);
		
		if (diceValues.get(0) == diceValues.get(1) && diceValues.get(1) == diceValues.get(2)) {
			if (diceValues.get(3) == diceValues.get(4)) {
				score = 25;
			}
		} else if (diceValues.get(2) == diceValues.get(3) && diceValues.get(3) == diceValues.get(4)) {
			if (diceValues.get(0) == diceValues.get(1)) {
				score = 25;
			}
		} 
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  smallStraightValue	                                        *
	 * Background:  This function checks the hand to see if there is a      *
	 * small straight present. If so, then the score is set to              *
	 * 30 and returned. 													*
	 * Purpose:  Used to check for a small straight.    				    *
	 * Parameters:                                                          *
	 *    none										            		    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int smallStraightValue() {
		int score = 0;
		
		int numOfOnes = this.countDice(1);
		int numOfTwos = this.countDice(2);
		int numOfThrees = this.countDice(3);
		int numOfFours = this.countDice(4);
		int numOfFives = this.countDice(5);
		
		if (numOfOnes >= 1 && numOfTwos >= 1 && numOfTwos >= 1 && numOfThrees >= 1 && numOfFours >= 1) {
			score = 30;
		} else if (numOfTwos >= 1 && numOfTwos >= 1 && numOfThrees >= 1 && numOfFours >= 1 && numOfFives >= 1){
			score = 30;
		}
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  largeStraightValue	                                        *
	 * Background:  This function checks the hand to see if there is a      *
	 * large straight present. If so, then the score is set to              *
	 * 40 and returned. 													*
	 * Purpose:  Used to check for a small straight.    				    *
	 * Parameters:                                                          *
	 *    none										            		    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int largeStraightValue() {
		int score = 40;
		
		List<Integer> diceValues = new ArrayList<Integer>();
		
		for (int i = 0; i < this.dice.size(); i++) {
			diceValues.add(this.dice.get(i).getCurrentValue());
		}
		
		Collections.sort(diceValues);
		
		for (int i = 0; i < 4; i++) {
			if (diceValues.get(i) + 1 != diceValues.get(i + 1)) {
				score = 0;
				break;
			}
		}
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  yahtzeeValue	                                            *
	 * Background:  This function checks the hand to see if every die in    *
	 * hand is equal to each other. If so, the player has scored a Yahtzee  *
	 * and the score is set to 50 and returned.								*
	 * Purpose:  Used to check for a Yahtzee.    	        			    *
	 * Parameters:                                                          *
	 *    none										            		    *
	 * Return value: the total score value returned as an int.				*
	 ***********************************************************************/
	public int yahtzeeValue() {
		int score = 50;
		
		for (int i = 0; i < this.dice.size(); i++) {
			if (this.dice.get(i).getCurrentValue() != this.dice.get(0).getCurrentValue()) {
				score = 0;
				break;
			}
		}
		
		return score;
	}
	
	/***********************************************************************
	 * Method:  reportHeader	                                            *
	 * Background:  This function prints out the header line of the report. *
	 * Purpose:  used to clarify the report generated by the reportLine     *
	 * function.                                                        	*
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value: none                                                   *
	 ***********************************************************************/
	public void reportHeader() {
		System.out.println("     Dice         1s   2s   3s   4s   5s   6s   3k   4k   FH   Sm   Lg   Yt   Ch");
	}
	
	/***********************************************************************
	 * Method:  reportLine	                                                *
	 * Background:  This function prints out a line of scoring data.        *
	 * Purpose:  used to tabulate scoring results for the hand.             *
	 * Parameters:                                                          *
	 *    none												                *
	 * Return value: none                                                   *
	 ***********************************************************************/
	public void reportLine (int lineNum) {
		System.out.format(
				"%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s%5s\n", 
				lineNum+". ", this.toString(), this.faceValue(1), this.faceValue(2), this.faceValue(3), this.faceValue(4), this.faceValue(5), this.faceValue(6),
				this.threeKindValue(), this.fourKindValue(), this.fullHouseValue(), this.smallStraightValue(), this.largeStraightValue(), this.yahtzeeValue(), this.chanceValue());
	}
}
