import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        char[][] gameBoard = new char[3][3];

        System.out.println("~~~Tic Tac Toe~~~");
        System.out.println("Welcome to the Game ");
        System.out.println("~~~~~~~~~~~~~~~~\n");

        System.out.print("What is your name?, player 1: ");
        String p1 = input.nextLine();
        String p2 = "Computer";
        System.out.println(p1.toUpperCase() + " VS " + p2.toUpperCase() + "\nLet's go ");
        System.out.println("~~~~~~~~~~~~~~~~");

        int numberOfRounds = 0;
        while (true) {
            System.out.print("Enter the number of rounds you want to play: ");
            try {
                numberOfRounds = input.nextInt();
                if (numberOfRounds <= 0) {
                    System.out.println("Number of rounds must be a positive integer.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }

        int playerWins = 0;
        int computerWins = 0;

        for (int round = 1; round <= numberOfRounds; round++) {
            System.out.println("\n~~~ Round " + round + " ~~~");
            resetBoard(gameBoard);

            while (true) {
                drawBoard(gameBoard);
                System.out.println("(" + p1.toUpperCase() + ") Enter Your Position from 1 to 9 :)");
                int playerPosition = 0;
                while (true) {
                    try {
                        System.out.print("Position: ");
                        playerPosition = input.nextInt();
                        if (playerPosition < 0) {
                            System.out.println("Position must be a positive integer.");
                            continue;
                        }
                        if (isValidMove(playerPosition, gameBoard)) {
                            break;
                        } else System.out.println("Position already taken. Try again.");

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 9.");
                        input.next();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Please enter from 1 to 9");
                    }
                }
                placeMove(playerPosition, gameBoard, "player");

                if (checkWin(gameBoard, 'X')) {
                    drawBoard(gameBoard);
                    System.out.println(p1.toUpperCase() + " wins this round!");
                    playerWins++;
                    break;
                }
                if (isBoardFull(gameBoard)) {
                    System.out.println("It's a draw this round!");
                    break;
                }

                int computerPosition;
                do {
                    computerPosition = random.nextInt(9) + 1;
                } while (!isValidMove(computerPosition, gameBoard));


                System.out.println("Computer's move:" + computerPosition+"\n");
                placeMove(computerPosition, gameBoard, p2);

                if (checkWin(gameBoard, 'O')) {
                    drawBoard(gameBoard);
                    System.out.println(p2.toUpperCase() + " wins this round!");
                    computerWins++;
                    break;
                }
                if (isBoardFull(gameBoard)) {
                    System.out.println("It's a draw this round!");
                    break;
                }
            }
        }//enf for

        System.out.println("\n~~ Game Ended! ~~");
        System.out.println(p1.toUpperCase() + " won " + playerWins + " rounds.");
        System.out.println(p2.toUpperCase() + " won " + computerWins + " rounds.");

        if (playerWins > computerWins) {
            System.out.println(p1.toUpperCase() + " is the overall winner!");
        } else if (computerWins > playerWins) {
            System.out.println(p2.toUpperCase() + " is the overall winner!");
        } else {
            System.out.println("It's a tie overall!");
        }
    }

    public static void drawBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void resetBoard(char[][] gameBoard) {
        char value = '1';
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = value++;
            }
        }
    }

    public static void placeMove(int position, char[][] gameBoard, String player) {
        char symbol = (player.equalsIgnoreCase("player")) ? 'X' : 'O';
        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][1] = symbol;
                break;
            case 3:
                gameBoard[0][2] = symbol;
                break;
            case 4:
                gameBoard[1][0] = symbol;
                break;
            case 5:
                gameBoard[1][1] = symbol;
                break;
            case 6:
                gameBoard[1][2] = symbol;
                break;
            case 7:
                gameBoard[2][0] = symbol;
                break;
            case 8:
                gameBoard[2][1] = symbol;
                break;
            case 9:
                gameBoard[2][2] = symbol;
                break;
        }
    }

    public static boolean isValidMove(int position, char[][] gameBoard) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return gameBoard[row][col] >= '1' && gameBoard[row][col] <= '9';
    }

    public static boolean checkWin(char[][] gameBoard, char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol) ||
                    (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol)) {
                return true;
            }
        }

        // Check diagonals
        return (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
    }

    public static boolean isBoardFull(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char cell : row) {
                if (cell >= '1' && cell <= '9') {
                    return false;
                }
            }
        }
        return true;
    }
}
