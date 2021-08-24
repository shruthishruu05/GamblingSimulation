package com.bridgelabz.GamblingSimulation;
import java.util.*;
public class GamblingSimulation 
{
	public static final int STARTING_STAKE = 100;
	public static final int GAME_BET = 1;
	public static final int DAYS_PLAYED = 30;
	public static int currentStake;
	
	public static void Bet() {
		
		if(Math.random() > 0.5) {
			currentStake=currentStake+GAME_BET;
		}
		else {
			currentStake=currentStake-GAME_BET;
			
		}
		
	}
	public static void checkResign() {
		Boolean shouldResign=false;
		while(!shouldResign) {
			Bet();
			if(currentStake >= STARTING_STAKE*1.5 || currentStake <= STARTING_STAKE*0.5) {
				shouldResign= true;
			}
			else
				shouldResign= false;
		}
		
	}
	public static void playFor20Days() {
		int totalWin = 0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResign();
			totalWin =totalWin+currentStake;
			System.out.println("Resigning Day "+i+" with $"+currentStake);
		}
		System.out.println("Total win after "+DAYS_PLAYED+" days: "+totalWin);
	}
	
	public static void playForAMonth() {
		int gamesWon=0, gamesLost=0, totalWinnings=0, totalLost=0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResign();
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
	
	public static void luckiestAndUnluckiest() {
		int maxWinnings=0, maxLost=0, luckiestDay=0, unluckiestDay=0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResign();
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
		
		int gameWon=0, gameLost=0, monthsPlayed=0;
		while(true) {
			monthsPlayed++;
			for (int i = 1; i <= DAYS_PLAYED; i++) {
				currentStake = STARTING_STAKE;
				checkResign();
				if(currentStake >= STARTING_STAKE*1.5) {
					gameWon++;
				}
				else {
					gameLost++;
				}
			}
			if(gameWon<gameLost)
				break;
		}
		
		System.out.println("Months played is.: "+monthsPlayed);
		
	}
	
	
	public static void main(String[] args) {
		
		luckiestAndUnluckiest();
		
	}

}
