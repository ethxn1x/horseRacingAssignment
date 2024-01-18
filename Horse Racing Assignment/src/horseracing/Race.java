package horseracing;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Horse> horses;
    private double raceLength; // in furlongs
    private String raceSurface; // "grass", "dirt", or "mud" (Uses HorseRacingHelper constants)
    private int currentHorse;
    private List<Horse> results;

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

    public void displayRaceInfo() {
        System.out.println("Race Information:");
        System.out.println("Race Surface: " + raceSurface);
        System.out.println("Race Length: " + raceLength + " furlongs");
        System.out.println("List of Horses:");
        for (Horse horse : horses) {
            System.out.println("- " + horse.getName() + " | Grass Rating: " + horse.getGrassRating()
                    + " | Dirt Rating: " + horse.getDirtRating() + " | Mud Rating: " + horse.getMudRating()
                    + " | Preferred length:" + horse.getPreferredLength());
        }
    }

    public void displayResults() {
        System.out.println("\n\nRace Results");
        System.out.println("------------");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ": " + results.get(i).getName() + "(" + results.get(i).getNumber() + ")");
        }
    }

    public void startRace(){
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
