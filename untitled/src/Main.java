import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String playagain;


        System.out.println("***********************");
        System.out.println("welcome to slot machine");
        System.out.println("***********************");
        System.out.println("Symbols: 🍒 🍉 🍋 🔔 ✨ ");


        while (balance > 0) {
            System.out.println("current balance: " + balance);
            System.out.println("Place your bet amount: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet > balance) {
                System.out.println("no fund");
                continue;

            } else if (bet <= 0) {
                System.out.println("cant be 0");
                continue;


            } else {
                balance = balance - bet;


            }

            System.out.println("Spinning >>>>>>");
            row = spinrow();
            printrow(row);
            payout =getpayout( row, bet);
            if (payout>0){
                System.out.println("you won: "+ payout);
                balance = balance+payout;
            }
            else{
                System.out.println("you lost");
            }
            System.out.println("do you want to play again ?: (Y/N)");
            playagain = scanner.nextLine().toUpperCase();
            if(!playagain .equals("Y")){
                break;



            }





        }
        System.out.println("thank you for playing you final balance is: " + balance );
        scanner.close();
    }

    static String[] spinrow() {
        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "✨"};
        String[] row = new String[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }

            return row;
        }
    static void printrow(String[] row) {
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }
    static int getpayout(String[] row, int bet){
        if(row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
                case "🍒" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 4;
                case "✨" -> bet * 4;
                default -> 0;

            };
        }
            else if(row[0].equals(row[1])) {
                return switch (row[0]) {
                    case "🍒" -> bet * 2;
                    case "🍉" -> bet * 3;
                    case "🍋" -> bet * 4;
                    case "🔔" -> bet * 5;
                    case "✨" -> bet * 10;
                    default -> 0;

                };

            }
            else if(row[1].equals(row[2])) {
                return switch (row[1]) {
                    case "🍒" -> bet * 2;
                    case "🍉" -> bet * 3;
                    case "🍋" -> bet * 4;
                    case "🔔" -> bet * 5;
                    case "✨" -> bet * 10;
                    default -> 0;

                };
            }


        return bet;
    }
}

