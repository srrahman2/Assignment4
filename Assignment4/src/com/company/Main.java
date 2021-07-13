package com.company;

import java.util.*;

import static java.util.Arrays.*;

public class Main {

    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> comPos = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here

        Scanner input = new Scanner(System.in);
        String YN;

        do{
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("Do you want to be X or O?");
            char userSymbol = input.next().toUpperCase().charAt(0);
            char comSymbol;
            if(userSymbol == 'X')
            {
                comSymbol = 'O';
            }
            else
            {
                comSymbol = 'X';
            }

            char[][] printBoard = {{' ','|',' ', '|', ' '},
                    {'-','-','-','-','-','-'},
                    {' ','|',' ', '|', ' '},
                    {'-','-','-','-','-','-'},
                    {' ','|',' ', '|', ' '},};

            System.out.println("The computer will go first.");

            do{
                Random randomNum = new Random();
                int comInput = randomNum.nextInt(9)+1;
                while(playerPos.contains(comInput) || comPos.contains(comInput)){
                    //System.out.println("Invalid move. Try again.");
                    comInput = randomNum.nextInt(9)+1;
                }
                comPos.add(comInput);

                switch (comInput){
                    case 1:
                        printBoard[0][0] = comSymbol;
                        break;

                    case 2:
                        printBoard[0][2] = comSymbol;
                        break;

                    case 3:
                        printBoard[0][4] = comSymbol;
                        break;

                    case 4:
                        printBoard[2][0] = comSymbol;
                        break;

                    case 5:
                        printBoard[2][2] = comSymbol;
                        break;

                    case 6:
                        printBoard[2][4] = comSymbol;
                        break;

                    case 7:
                        printBoard[4][0] = comSymbol;
                        break;

                    case 8:
                        printBoard[4][2] = comSymbol;
                        break;

                    case 9:
                        printBoard[4][4] = comSymbol;
                        break;

                    default:
                        break;
                }

                System.out.println();
                for(char[] i: printBoard)
                {
                    for(char j: i)
                    {
                        System.out.print(j);
                    }
                    System.out.println();
                }

                String winner = selectWinner();
                if(winner.length() > 0)
                {
                    System.out.println(winner);
                    break;
                }

                System.out.println("What is your next move? (1-9)");
                int userInput = input.nextInt();
                while(playerPos.contains(userInput) || comPos.contains(userInput)){
                    System.out.println("Invalid move. Try again.");
                    userInput = input.nextInt();
                }

                playerPos.add(userInput);

                switch (userInput){
                    case 1:
                        printBoard[0][0] = userSymbol;
                        break;

                    case 2:
                        printBoard[0][2] = userSymbol;
                        break;

                    case 3:
                        printBoard[0][4] = userSymbol;
                        break;

                    case 4:
                        printBoard[2][0] = userSymbol;
                        break;

                    case 5:
                        printBoard[2][2] = userSymbol;
                        break;

                    case 6:
                        printBoard[2][4] = userSymbol;
                        break;

                    case 7:
                        printBoard[4][0] = userSymbol;
                        break;

                    case 8:
                        printBoard[4][2] = userSymbol;
                        break;

                    case 9:
                        printBoard[4][4] = userSymbol;
                        break;

                    default:
                        break;
                }

                System.out.println();
                for(char[] i: printBoard)
                {
                    for(char j: i)
                    {
                        System.out.print(j);
                    }
                    System.out.println();
                }

                winner = selectWinner();
                if(winner.length() > 0)
                {
                    System.out.println(winner);
                    break;
                }

            }while(true);

            System.out.println("Do you want to play again? (yes or no)");
            YN = input.nextLine().toLowerCase();

        }while(YN.equals("yes"));

    }

    public static String selectWinner(){
        List rowOne = Arrays.asList(1,2,3);
        List rowTwo = Arrays.asList(4,5,6);
        List rowThree = Arrays.asList(7,8,9);
        List colOne = Arrays.asList(1,3,7);
        List colTwo = Arrays.asList(2,5,8);
        List colThree = Arrays.asList(3,6,9);
        List crossOne = Arrays.asList(1,5,9);
        List crossTwo = Arrays.asList(3,5,7);

        List<List> win = new ArrayList<>();
        win.add(rowOne);
        win.add(rowTwo);
        win.add(rowThree);
        win.add(colOne);
        win.add(colTwo);
        win.add(colThree);
        win.add(crossOne);
        win.add(crossTwo);

        for(List l: win)
        {
            if(comPos.containsAll(l))
            {
                return "Computer wins! Sorry!";
            }
            else if(playerPos.containsAll(l))
            {
                return "You win!";
            }

            if(playerPos.size() + comPos.size() == 9)
                return "Its a Draw!";
        }
        return "";
    }
}
