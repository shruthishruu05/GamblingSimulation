package com.bridgelabz.GamblingSimulation;
import java.util.*;
public class GamblingSimulation {
	public static final int STARTING_STAKE = 100;
	public static final int GAME_BET = 1;
	public static int currentStake;
	
	
	public static void Bet() {
		
		if(Math.random() > 0.5) {
			currentStake=currentStake+GAME_BET;
			System.out.println("Won $"+GAME_BET);
		}
		else {
			currentStake-=GAME_BET;
			System.out.println("Lost $"+GAME_BET);
		}
		
	}
	public static Boolean checkResign() {
		
		if(currentStake >= 1.5*STARTING_STAKE || currentStake <=0.5* STARTING_STAKE) {
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		currentStake = STARTING_STAKE;
		Boolean Resign=false;
		while(!Resign) {
			Bet();
			Resign=checkResign();
		}
		System.out.println("Resigning game with the stake as: $"+currentStake);
	}

}




