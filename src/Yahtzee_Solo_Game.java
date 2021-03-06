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

import java.text.MessageFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Yahtzee_Solo_Game {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean isRunning = true;
		while (isRunning) {
			Yahtzee_Score_Card scoreCard = new Yahtzee_Score_Card();
			ArrayList<Integer> diceNums = new ArrayList<Integer>();
			
			for (int i = 1; i < 14; i++) {
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				Boolean d1 = false, d2 = false, d3 = false, d4 = false, d5 = false;
				System.out.println(MessageFormat.format("Turn {0} of 13", i));
				
				scoreCard.displayScoreSheet();
				scoreCard.rollDice();
				
				System.out.print("\nDice Throw #1: ");
				System.out.print(scoreCard.hand.toString());
				
				for (int j = 0; j < 3; j++) {
					boolean validInput = false;
					while (!validInput) {
						validInput = true;
						System.out.println("\nDice to throw (enter 0 to keep roll): ");
						String dice = input.nextLine();
						
						String[] diceArray = dice.split(" ");
						
						try {
							for (int k = 0; k < diceArray.length; k++) {
								diceNums.add(Integer.parseInt(diceArray[k]));
							}
						} catch(Exception e) {
							System.out.println("Please enter a valid input.");
							validInput = false;
						}
						
						if (validInput) {
							for (int k = 0; k < diceNums.size(); k++) {
								if (diceNums.get(k) > 5 || diceNums.get(k) < 0) {
									System.out.println("Please enter a valid input.");
									validInput = false;
									break;
								}
							}
						}
					}
					
					for (int k = 0; k < diceNums.size(); k++) {
						switch (diceNums.get(k)) {
							case 0:
								j = 3;
								break;
							case 1:
								d1 = true;
								break;
							case 2:
								d2 = true;
								break;
							case 3:
								d3 = true;
								break;
							case 4:
								d4 = true;
								break;
							case 5:
								d5 = true;
								break;
							default:
								System.out.println("Invalid input.");
								break;
						}
					}
					
					if (diceNums.get(0) != 0) {
						scoreCard.rollDice(d1, d2, d3, d4, d5);
					} else if (diceNums.get(0) == 0) {
						j = 3;
					}
				}
				
				int rowToUse = 0;
				boolean validInput = false;
				while (!validInput) {
					validInput = true;
					System.out.print("Use in Row: ");
					String row = input.next();
					
					try {
						rowToUse = Integer.parseInt(row);
					} catch (Exception e) {
						System.out.println("Please enter a valid input.");
						validInput = false;
					}
					
					if (validInput) {
						if (rowToUse < 1 || rowToUse > 13) {
							System.out.println("Please enter a valid input.");
							validInput = false;
						}
					}
					
					if (validInput) {
						switch (rowToUse) {
						case 1:
							if (scoreCard.onesScore == -1) {
								scoreCard.scoreOnes();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.onesScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 2:
							if (scoreCard.twosScore == -1) {
								scoreCard.scoreTwos();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.twosScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 3:
							if (scoreCard.threesScore == -1) {
								scoreCard.scoreThrees();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.threesScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 4:
							if (scoreCard.foursScore == -1) {
								scoreCard.scoreFours();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.foursScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 5:
							if (scoreCard.fivesScore == -1) {
								scoreCard.scoreFives();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.fivesScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 6:
							if (scoreCard.sixesScore == -1) {
								scoreCard.scoreSixes();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.sixesScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 7:
							if (scoreCard.threeKindScore == -1) {
								scoreCard.scoreThreeKind();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.threeKindScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 8:
							if (scoreCard.fourKindScore == -1) {
								scoreCard.scoreFourKind();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.fourKindScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 9:
							if (scoreCard.fullHouseScore == -1) {
								scoreCard.scoreFullHouse();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.fullHouseScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 10:
							if (scoreCard.smallStraightScore == -1) {
								scoreCard.scoreSmallStraight();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.smallStraightScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 11:
							if (scoreCard.largeStraightScore == -1) {
								scoreCard.scoreLargeStraight();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.largeStraightScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 12:
							if (scoreCard.yahtzeeScore == -1) {
								scoreCard.scoreYahtzee();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.yahtzeeScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						case 13:
							if (scoreCard.chanceScore == -1) {
								scoreCard.scoreChance();
								System.out.println(MessageFormat.format("Score of {0} saven in row {1}.", scoreCard.chanceScore, rowToUse));
								break;
							} else {
								System.out.println("That row has already been used.");
								validInput = false;
								break;
							}
						}
					}
				}				
			}
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			scoreCard.displayScoreSheet();
			System.out.println(MessageFormat.format("{0} is your final score.", scoreCard.totalScore));
			
			boolean userConfirm = false;
			while (!userConfirm) {
				System.out.print("\nWould you like to play again? (Y/N): ");
				String choice = input.next();
				
				if (choice.toUpperCase() == "Y") {
					userConfirm = true;
				} else if (choice.toUpperCase() == "N") {
					userConfirm = true;
					isRunning = false;
				} else {
					System.out.println("Please enter a valid selection.");
				}
			}
		}
		input.close();
	}

}
