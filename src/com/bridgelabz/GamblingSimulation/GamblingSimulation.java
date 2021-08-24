package com.bridgelabz.GamblingSimulation;
import java.util.*;
public class GamblingSimulation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter the stake value");
		int stake = in.nextInt();
		System.out.println("enter the bet value");
		int bet = in.nextInt();
		if(stake ==100 ||bet ==1)
		{
			System.out.println("The player can start the game");
		}
		else
		{
			System.out.println("the player cannot start the game");
		}
		
	}
}
