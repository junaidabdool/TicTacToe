package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	 
	static ArrayList<Integer> payerPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// The Game Board 
		 char [] [] gameBoard = {{'1', '|', '2', '|', '3'}, 
				{'-', '+', '-', '+', '-'} ,
				{'4', '|', '5', '|', '6'} ,
				{'-', '+', '-', '+', '-'} ,
				{'7', '|', '8', '|', '9'} };
	
		 printgameBoard(gameBoard);
	
		 while (true) {
			 Scanner input = new Scanner(System.in);
			 System.out.println("Enter yout placement (1-9):");
			 int position = input.nextInt(); 
			 while(payerPosition.contains(position) || cpuPosition.contains(position)) {
				 System.out.println("Position Taken !Enter a correct Position");
				 position = input.nextInt();
			 }
			 placeposition(gameBoard, position , "player");
			
			 String result = checkWinner();
			 if(result.length() > 0) {
					System.out.print(result);
					break;
				}
			 
			 Random rand = new Random();
			 int cpuPOs = rand.nextInt(9)+1;
			 while(payerPosition.contains(cpuPOs) || cpuPosition.contains(cpuPOs)) {
				
				 cpuPOs = rand.nextInt(9)+1;
			 }
			 placeposition(gameBoard , cpuPOs , "cpu");
			 
			printgameBoard(gameBoard);
			
			 result = checkWinner();
			if(result.length() > 0) {
				System.out.print(result);
				break;
			}
			
		
		}
		 }
	
	public static void printgameBoard(char [] [] gameBoard) {
		// print the gameBoard
				for(char[] row: gameBoard) {
					for(char c : row) {
						System.out.print(c);
					}
					System.out.println();
					}
	}
	
	public static void placeposition(char [] [] gameBoard,int position ,String User) {
		
		char symbol = ' ';
		
		
		if(User.equals("player")) {
			symbol = 'X';
			payerPosition.add(position);
		}else if(User.equals("cpu")) {
			symbol = 'O';
			cpuPosition.add(position);
		}
		
		switch (position) {
		case 1: 
			gameBoard[0][0] = symbol;
			break;
		case 2: 
			gameBoard[0][2] = symbol;
			break;
		case 3: 
			gameBoard[0][4] = symbol;
			break;
		case 4: 
			gameBoard[2][0] = symbol;
			break;
		case 5: 
			gameBoard[2][2] = symbol;
			break;
		case 6: 
			gameBoard[2][4] = symbol;
			break;
		case 7: 
			gameBoard[4][0] = symbol;
			break;
		case 8: 
			gameBoard[4][2] = symbol;
			break;
		case 9: 
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	
	public static String checkWinner() {
		// Winning Position
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rigCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rigCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l:winning) {
			if(payerPosition.containsAll(l)) {
				return "Congratulation you won! ";
			}else if(cpuPosition.containsAll(l)) {
				return "CPU WINS! SORRY :(";
			}else if(payerPosition.size() + cpuPosition.size() ==9) {
				return "CAT !";
			}
		}
		
		return "";
	}

}
