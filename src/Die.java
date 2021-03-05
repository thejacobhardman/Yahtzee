/*******************************************************************************
*                      Assignment 5 -- Yahtzee Hand Object                     *
*                                                                              *
* PROGRAMMER:        Jacob Hardman hard7293@bears.unco.edu                     *
* CLASS:             CS200 – Object Oriented Programming                       *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2021                                               *
* SUBMISSION DATE:   2/26/2021	                                               *
*                                                                              *
* DESCRIPTION                                                                  *
* This file implements the functionality of a single die.		               *
*                                                                              *
* ATTRIBUTES:                                                                  *
*         name:   The name of the die, stored as a string. Ex: D6, D20, etc.   *
*     numSides:   The number of sides that the die has stored as an int.       *
* currentValue:   The current value of the die stored as an int.               *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c)2021 Dean Zeller and Jacob Hardman.             *
*                                                                              *
*******************************************************************************/

import java.text.MessageFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Die {
	
	private String name;
	private int numSides;
	private int currentValue;
	
	/***********************************************************************
	 * Method:   Constructor (both parameters)                              *
	 * Purpose:  Create a Die based on user parameters                      *
	 * Parameters:                                                          *
	 *    name_ -- the name of the die                                      *
	 *    numSides_ -- the number of sides that the die has                 *
	 * Return value:  no return value type                                  *
	 ***********************************************************************/
	public Die(String name_, int numSides_) {
		this.name = name_;
		this.numSides = numSides_;
	}
	
	/***********************************************************************
	 * Method:   Constructor (name parameter)                               *
	 * Purpose:  Create a card based on a user parameter for the name.      * 
	 * Defaults to a 6 sided die for the numOfSides parameter.              *
	 * Parameters:                                                          *
	 *    name_ -- the name of the die                                      *
	 * Return value:  no return value type                                  *
	 ***********************************************************************/
	public Die(String name_) {
		this.name = name_;
		this.numSides = 6;
	}
	
	/***********************************************************************
	 * Method:   Constructor (numOfSides parameter)                         *
	 * Purpose:  Create a card based on a user parameter for the numOfSides.* 
	 * Generates a name based on the input of the numOfSides parameter.     *
	 * Parameters:                                                          *
	 *    numOfSides_ -- the number of sides that the die has.              *
	 * Return value:  no return value type                                  *
	 ***********************************************************************/
	public Die(int numSides_) {
		this.name = "D" + String.valueOf(numSides_);
		this.numSides = numSides_;
	}
	
	/***********************************************************************
	 * Method:   Constructor (no parameters)                                *
	 * Purpose:  Create a Die with default parameters                       *
	 * Parameters:   none                                                   *
	 *    Creates a default die with 6 sides                                *
	 * Return value:  no return value type                                  *
	 ***********************************************************************/
	public Die() {
		this.name = "D6";
		this.numSides = 6;
	}
	
	/***********************************************************************
	 * Method:  getNumSides                                                 *
	 * Background:  If we need to see the current number of sides that a    *
	 * die has, this method allows us to do that. We could also use this    *
	 * value for comparisons.												*
	 * Purpose:  return the number of sides that the die has                *
	 * Parameters: none                                                     *
	 * Return value:  the number of sides on the die, as an integer         *
	 ***********************************************************************/
	public int getNumSides() {
		return this.numSides;
	}
	
	/***********************************************************************
	 * Method:  setNumSides                                                 *
	 * Background:  This function allows us to set the number of sides that *
	 * the die has manually. The set side must be greater than 0.           *
	 * Purpose:  sets the number of sides than an existing die has          *
	 * Parameters:                                                          *
	 *    numOfSides_ -- the number of sides that the die has.              *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void setNumSides(int numSides_) {
		if (numSides_ > 0) {
			this.numSides = numSides_;
		} else {
			System.out.println("ERROR: Number of sides must be at least 1 or greater.");
		}
	}
	
	/***********************************************************************
	 * Method:  getCurrentValue                                             *
	 * Background:  This function allows us to retrieve and work with       *
	 * the current value of the die. This is useful for comparing the       *
	 * value of the die with set values which will be done a lot in games.  *
	 * Purpose:  return the current value of the die                        *
	 * Parameters: none                                                     *
	 * Return value:  the current value of the die, as an integer           *
	 ***********************************************************************/
	public int getCurrentValue() {
		return this.currentValue;
	}
	
	/***********************************************************************
	 * Method:  toString	                                                *
	 * Background:  This function is very similar to the getCurrent Value   *
	 * function. Except that this function returns a string. Which will be  *
	 * handy when we want to display info about the die.                    *
	 * Purpose:  return the current value of the die converted to a String  *
	 * for display purposes.						                        *
	 * Parameters: none                                                     *
	 * Return value:  the current value of the die, as a String             *
	 ***********************************************************************/
	public String toString() {
		return String.valueOf(this.currentValue);
	}
	
	/***********************************************************************
	 * Method:  printSummary	                                            *
	 * Background:  This function allows us to quickly print out info about *
	 * a given die. Namely the die's name and range of potential values.    *
	 * Purpose:  prints a 3-line summary of info about the die.             *
	 * Parameters: none                                                     *
	 * Return value:  none	                                                *
	 ***********************************************************************/
	public void printSummary() {
		System.out.println(MessageFormat.format("\nSummary:\n   Name: {0}\n   Range: 1 to {1}\n", this.name, this.numSides));
	}
	
	/***********************************************************************
	 * Method:  roll        	                                            *
	 * Background:  This is the main function for the die. Whenever we      *
	 * want to roll the die to get a new value, we call this function.		*
	 * Purpose:  Rolls the die and sets its current value to a random int   *
	 * Parameters: none                                                     *
	 * Return value:  none	                                                *
	 ***********************************************************************/
	public void roll() {
		this.currentValue = ThreadLocalRandom.current().nextInt(1, this.numSides + 1);
	}
	
	/***********************************************************************
	 * Method:  setCurrentValue                                             *
	 * Background:  Should we need to manually set the value of a die       *
	 * (in other words cheat) this function allows us to do that. Some	    *
	 * checks are in place to keep the die's current value valid.		    *
	 * Purpose:  sets the current value of the die				            *
	 * Parameters:                                                          *
	 *    currentValue_ -- the new value for the die	                    *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void setCurrentValue(int currentValue_) {
		if (currentValue_ > 0 && currentValue_ <= this.numSides) {
			this.currentValue = currentValue_;
		} else {
			System.out.println("ERROR: New value must be greater than 1 and less than or equal the number of sides on the die.");
		}
	}
	
	/***********************************************************************
	 * Method:  setCurrentValueOverride                                     *
	 * Background:  Basically the exact same as the setCurrentValue         *
	 * function except with no invalid values. set the die to whatever you  *
	 * want!																*
	 * Purpose:  sets the current value of the die				            *
	 * Parameters:                                                          *
	 *    currentValue_ -- the new value for the die	                    *
	 * Return value:  none                                                  *
	 ***********************************************************************/
	public void setCurrentValueOverride(int currentValue_) {
		this.currentValue = currentValue_;
	}
}
