package horseracing;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Race {
    private List<Horse> horses;
    private double raceLength; // in furlongs
    private String raceSurface; // "grass", "dirt", or "mud" (Uses HorseRacingHelper constants)
    private int currentHorse;
    private List<Horse> results;
    private String Win = "-1";
    private String Place = "-2";
    int wallet = 100; 
    boolean win = false;
    boolean place = false; 
    boolean show = false; 
    boolean CorrectHorse = false; 
Scanner in = new Scanner(System.in); 
String name = "name";
String DirtRating = "DirtRating";
String MudRating = "MudRating";
String GrassRating = "GrassRating";
String preferredLength = "preferredLength";
String WInOdds = "WinOdds";
String PlaceOdds = "PlaceOdds";
String ShowOdds = "ShwoOdds";
String WinnerHorse = "";






    public Race(List<Horse> horses, double raceLength, String raceSurface) {
        this.horses = horses;
        this.raceLength = raceLength;
        this.raceSurface = raceSurface;
        this.currentHorse = 0;
        this.results = new ArrayList<Horse>();

    }


    
    public List<Horse> getHorses() {
        return horses;
    }

    public int numHorses() {
        return horses.size();
    }

    public Horse getNextHorse() {
        if (currentHorse == horses.size())
            currentHorse = 0;

        return horses.get(currentHorse++);
    }

    public double getRaceLength() {
        return raceLength;
    }

    public String getRaceSurface() {
        return raceSurface;
    }



    public void displayHorseTable(){
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|"+"      "+ name + "                |"   + DirtRating + "| "  +GrassRating + " | " + MudRating + "   | " + preferredLength + "|   " + WInOdds + " |  " + PlaceOdds + "|   " + ShowOdds + "   |") ;
        for (int i = 0; i < horses.size(); i++) {   // iterates through the horses list
            Horse horse = horses.get(i);
           if (getRaceSurface().equals("Grass")){
            horse.WinGrass();
            horse.LossGrass();
            horse.PlaceGrassWin();
            horse.PlaceGrasslose();
            horse.ShowGrassWin();
            horse.ShowGrasslose();
           }

           else if(getRaceSurface().equals("Dirt")){
            horse.WinDirt();
            horse.LossDirt();
            horse.PlaceDirtWin();
            horse.PlaceDirtLose();
            horse.ShowDirtWin();
            horse.ShowDirtLose();
           }

           else if(getRaceSurface().equals("Mud")){
            horse.WinMud();
            horse.LossMud();
            horse.PlaceMudWin();
            horse.PlaceMudlose();
            horse.ShowMudWin();
            horse.ShowMudlose();
           }

           if ( horse.getPreferredLength() == getRaceLength())
           horse.SubWinOdds();

           if( horse.getPreferredLength() != getRaceLength())
           horse.addWinOdds();

           horse.PlaceCal();
        horse.ShowCal();
        horse.MinOdd();
        


            String s1 = "" + horse.getName();
            String s2 = "" + horse.getDirtRating();
            String s3 = "" + horse.getGrassRating();
            String s4 = "" + horse.getMudRating();
            String s5 = "" + horse.getPreferredLength();
            String s6 = "" + horse.GetWinOdds() + Win;
            String s7 = "" + horse.GetPlaceOdds();
            String s8 = "" + horse.GetShowOdds();
            if (horse.GetPlaceOdds() == 5){
            s7 += Place;
            }
            
            else {
                s7 += Win;
            }

            if (horse.GetShowOdds() == 5 || horse.GetShowOdds() == 7){
                s8 += "-2";
            }

            else {
                s8 += Win;
            }
        
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
    
            System.out.printf("|%-26s|%10s|%13s|%13s|%16s|%11s|%11s|%14s|\n", s1, s2, s3, s4,s5, s6, s7,s8) ;
        }
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
    }






    public void displayRaceInfo() {
        System.out.println("Race Information:");
        System.out.println("Race Surface: " + raceSurface);
        System.out.println("Race Length: " + raceLength + " furlongs");
        System.out.println("List of Horses:");
 

    displayHorseTable();
     }

    public void displayResults() {
        System.out.println("\n\nRace Results");
        System.out.println("------------");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ": " + results.get(i).getName() + "(" + results.get(i).getNumber() + ")");

    }
    }

    public void startRace(){

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

        int v = 0;

       
        System.out.println("what horse do you want to bet on: ");
while (v == 0){

    
    
    String UserHorse = in.nextLine();
    boolean Valid = false;



if (UserHorse.length() > 0){


    for( int c =0; c < horses.size(); c++){
        Horse horseName = horses.get(c);

        if (UserHorse.equals(horseName.getName())){
            Valid = true;
            v++;
            WinnerHorse += UserHorse;
            

        }
  

    }

    if(Valid != true)
            System.out.println("type a vaild horse:");

}


}       

    
    


   
    
  
   
    
 


        resetHorses();
        int numSpaces = (int)(raceLength*10);
        boolean done = false;
        HorseRacingHelper.pauseForMilliseconds(1000);
        HorseRacingHelper.playBackgroundMusicAndWait("Race.wav");
        HorseRacingHelper.playBackgroundMusic("horse_gallop.wav", true);

        while(!done){
            HorseRacingHelper.pauseForMilliseconds(100);
            HorseRacingHelper.clearConsole();
            HorseRacingHelper.updateTrack(numSpaces, horses);
            Horse horse = getNextHorse();

            if(horse.getDirtRating() >= horse.getGrassRating() || horse.getDirtRating() >= horse.getGrassRating() && raceSurface.equals("dirt")){
                horse.incrementPosition((int)(Math.random()*(9-4)+4));
                /*  if the dirt rating is greater than grass and mud rating and the race is dirt,
                 there will be an increase for the horse with these traits*/
            }else if(horse.getGrassRating() >=horse.getMudRating() || horse.getGrassRating() >= horse.getDirtRating() && raceSurface.equals("grass")){
                horse.incrementPosition((int)(Math.random()*(9-4)+4));
                /*  if the grass rating is greater than mud and dirt rating and the race is grass,
                 there will be an increase for the horse with these traits*/
            }else if (horse.getMudRating() >= horse.getGrassRating() || horse.getMudRating()>= horse.getDirtRating() && raceSurface.equals("mud")){
                horse.incrementPosition((int)(Math.random()*(9-4)+4));
                /*  if the mud rating is greater than grass and dirt rating and the race is mud,
                 there will be an increase for the horse with these traits*/
            }else if(horse.getPreferredLength() >= raceLength){
                horse.incrementPosition((int)(Math.random()*(9-4)+4));
                /*  if the preferred length is equal or greater to the length of the race,
                 there will be an increase for the horse with these traits*/
            }else{
                break;
            }

        

           

            if(!horse.raceFinished() && horse.getCurrentPosition() >= numSpaces){
                results.add(horse);
                horse.setRaceFinished(true);
            } else if(!horse.raceFinished()){
                horse.incrementPosition(getIncrementForHorse(horse));
            }

           


            displayResults();

            if (results.size() == horses.size())
                done = true;


               
                
            
            
           

        }
    }
        HorseRacingHelper.stopMusic();
    }
    // Other methods for simulating the race, calculating winners, etc., can be
    // added as needed

    private int getIncrementForHorse(Horse horse) {
        horse.getDirtRating();
        horse.getGrassRating();
        horse.getMudRating();
        horse.getPreferredLength();

        //this.raceLength;
        //this.raceSurface;
        return ((int)(Math.random()*(9-4)+4));
        

        
    }

    private void resetHorses() {
        for (Horse horse : horses) {
            horse.resetCurrenPosition();
        }
    }
}
