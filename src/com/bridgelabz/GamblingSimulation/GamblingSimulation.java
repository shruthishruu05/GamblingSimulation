package com.bridgelabz.GamblingSimulation;
import java.util.*;
public class GamblingSimulation 
{
	public static final int STARTING_STAKE = 100;
	public static final int EVERY_GAME_BET = 1;
	public static final int DAYS_PLAYED = 30;
	public static int currentStake;
	
	public static void makeBet() {
		
		if(Math.random() > 0.5) {
			currentStake+=EVERY_GAME_BET;
		}
		else {
			currentStake-=EVERY_GAME_BET;
			
		}
		
	}
	public static void checkResignGame() {
		Boolean shouldResign=false;
		while(!shouldResign) {
			makeBet();
			if(currentStake >= STARTING_STAKE*1.5 || currentStake <= STARTING_STAKE*0.5) {
				shouldResign= true;
			}
			else
				shouldResign= false;
		}
		
	}
	public static void playFor20Days() {
		int totalWinnings = 0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResignGame();
			totalWinnings+=currentStake;
			System.out.println("Resigning Day "+i+" with $"+currentStake);
		}
		System.out.println("Total winnings after "+DAYS_PLAYED+" days: "+totalWinnings);
	}
	
	public static void playForAMonth() {
		int gamesWon=0, gamesLost=0, totalWinnings=0, totalLost=0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResignGame();
			if(currentStake >= STARTING_STAKE*1.5) {
				gamesWon++;
				totalWinnings+=currentStake-STARTING_STAKE;
			}
			else {
				gamesLost++;
				totalLost+=STARTING_STAKE-currentStake;
			}
		}
		System.out.println("Games Won: "+gamesWon+". Won $"+totalWinnings);
		System.out.println("Games Lost: "+gamesLost+". Lost $"+totalLost);
	}
	
	public static void luckiestAndUnluckiestDay() {
		int maxWinnings=0, maxLost=0, luckiestDay=0, unluckiestDay=0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResignGame();
			if(currentStake >= STARTING_STAKE*1.5) {
				if(maxWinnings < (currentStake-STARTING_STAKE)) {
					luckiestDay=i;
					maxWinnings = currentStake-STARTING_STAKE;
				}
			}
			else {
				if(maxLost < (STARTING_STAKE-currentStake)) {
					unluckiestDay=i;
					maxLost = STARTING_STAKE-currentStake;
				}
			}
		}
		System.out.println("Lucky Day : "+luckiestDay);
		System.out.println("Unlucky Day : "+unluckiestDay);
	}
       public static void continueNextMonth() {
		
		int gamesWon=0, gamesLost=0, monthsPlayed=0;
		while(true) {
			monthsPlayed++;
			for (int i = 1; i <= DAYS_PLAYED; i++) {
				currentStake = STARTING_STAKE;
				checkResignGame();
				if(currentStake >= STARTING_STAKE*1.5) {
					gamesWon++;
				}
				else {
					gamesLost++;
				}
			}
			if(gamesWon<gamesLost)
				break;
		}
		
		System.out.println("Months: "+monthsPlayed);
		
	}
	
	
	public static void main(String[] args) {
		
		luckiestAndUnluckiestDay();
		
	}

}
