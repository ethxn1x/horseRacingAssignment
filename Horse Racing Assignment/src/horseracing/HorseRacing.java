package horseracing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HorseRacing {

     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        HorseRacingHelper.prepareHorseRacingSimulation();
        boolean gameOver = false;
        while(!gameOver){
            HorseRacingHelper.clearConsole();

            int numHorsesInRace = (int)(Math.random()*7)+5;
            int wallet = 10; 
            boolean win = false;
            boolean place = false; 
            boolean show = false; 

            Race race = HorseRacingHelper.createRace(numHorsesInRace, HorseRacingHelper.SHORT, HorseRacingHelper.DIRT);
            race.displayRaceInfo();

            System.out.println("would you like to bet? : (y/n) ");
            String betResult = in.nextLine();

            if (betResult.equals("y")){

                int i = 0;

                while(i <= 0 ){ //loop that will keep on running until valid number has been entered. 
                 try {
                           System.out.println("how much would you like to bet:"); 
                int BetAmount = in.nextInt(); // ask user how much they want to bet and saves that amount in variable BetAmount

                 if (BetAmount > wallet) // checks the the amount in BetAmount if greater then what you have in wallet then a message will print, user will then be able to input new amount. 
                System.out.println("you don't have enough money you poor");

                if (BetAmount <= 0) // if player bets a number below or equal to zero a message will appear and player will be able to rebet. 
                System.out.println("pick a number that is greater than 0:");


                if (BetAmount > 0 && BetAmount <= wallet) // if bet amount if within range of the wallet amount and greater then 0 the while loop will stop 
                i ++; 
                
                 } catch (InputMismatchException e) { // makes sure that user can only type numbers and no other charcter if user attempts to type latter or special character a message will appear. 

                    System.out.println("pick a number not a letter idiot"); 
                    in.next(); // clears the scanner buffer, this prevents the program from getting stuck in a infinite loop due to the invald input in the buffer. 
                 }     

            }
            int b = 0;
            while (b == 0){ // while loop that will run until you type Win, place or show
           System.out.println("would you like to bet Win, Place, or Show:");
           String BetPlace = in.next();
          
           if ( BetPlace.equals("Win")){
            win = true; 
            b++; //loop will stop when you type either Win, Place, and Show 
           }
        
           else if (BetPlace.equals("Place")){
           place = true;
           b++;
           }

           else if (BetPlace.equals("Show")){
           show = true; 
           b++;
           }

           else 
           System.out.println("pick Win, Place, or Show");
            }

        

       

        
        }

            race.startRace();

            System.out.println("Race is Over");
            gameOver = playAgain(in);
        }

        
    }

    private static boolean playAgain(Scanner in) {
        System.out.print("Play Again: (y/n): ");
        String result = in.nextLine();

        if (result.equals("n"))
            return true;

        return false;

    }
}
