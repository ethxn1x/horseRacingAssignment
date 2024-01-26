package horseracing;

public class Horse{
        private String name;
        private int mudRating;
        private int grassRating;
        private int dirtRating;
        private double preferredLength;
        private int WinOdds ;
        private int PlaceOdds ; 
        private int ShowOdds;

        private int currentPosition;
        private boolean finishedRace;
        private int number;
        

        public Horse(String name, int mudRating, int grassRating, int dirtRating, double preferredLength){
            this.mudRating = mudRating;
            this.grassRating = grassRating;
            this.dirtRating = dirtRating;
            this.preferredLength = preferredLength;
            this.currentPosition = 2;
            this.finishedRace = false;

            this.number = 0;
            this.name = name;   
            this.WinOdds = 3; 
            this.PlaceOdds = 4; 
            this.ShowOdds = 5;    

            this.number = 0;  
            this.name = name;      

        }


        
        public void setNumber(int number){
            this.number = number;
        }




        public void MinOdd(){
            if (this.WinOdds == 1 )
            this.WinOdds ++;

            if (this.WinOdds == 0)
            this.WinOdds += 2;

            if (this.ShowOdds == 1 )
            this.ShowOdds ++;

            if (this.ShowOdds == 0)
            this.ShowOdds += 2;

            
            if (this.PlaceOdds == 1 )
            this.PlaceOdds ++;

            if (this.PlaceOdds == 0)
            this.PlaceOdds += 2;
        }






        public void WinGrass(){
            if (this.getGrassRating() <= 4 )
            this.WinOdds ++;
        }

        public void WinDirt(){
            if (this.getDirtRating() <= 4 )
            this.WinOdds ++;
        }

        public void WinMud(){
            if (this.getMudRating() <= 4 )
            this.WinOdds ++;
        }

        public void LossGrass(){
            if (this.getGrassRating() >= 6 )
            this.WinOdds --;
        }

        public void LossDirt(){
            if (this.getDirtRating() >= 6 )
            this.WinOdds --;
        }


        public void LossMud(){
            if (this.getMudRating() >= 6 )
            this.WinOdds --;
        }

        



        public void PlaceGrasslose(){
            if (this.grassRating >= 7)
        this.PlaceOdds --;
        }

        public void PlaceDirtLose(){
            if (this.dirtRating >= 7)
        this.PlaceOdds --;
        }

        public void PlaceMudlose(){
            if (this.mudRating >= 7)
        this.PlaceOdds --;
        }

        public void PlaceGrassWin(){
            if (this.mudRating <= 5)
        this.PlaceOdds ++;
        }

        public void PlaceDirtWin(){
            if (this.dirtRating <= 5)
        this.PlaceOdds ++;
        }

        public void PlaceMudWin(){
            if (this.mudRating <= 5)
        this.PlaceOdds ++;
        }

        public void PlaceCal(){
        if (this.PlaceOdds % 2 == 0 )
        this.PlaceOdds = this.PlaceOdds/2; 
        
        }
        
        
        

        public void ShowGrasslose(){
            if (this.grassRating >= 8)
        this.ShowOdds --;
        }

        public void ShowDirtLose(){
            if (this.dirtRating >= 8)
        this.ShowOdds --;
        }

        public void ShowMudlose(){
            if (this.mudRating >= 8)
        this.ShowOdds --;
        }

        public void ShowGrassWin(){
            if (this.mudRating <= 6)
        this.ShowOdds ++;
        }

        public void ShowDirtWin(){
            if (this.dirtRating <= 6)
        this.ShowOdds ++;
        }

        public void ShowMudWin(){
            if (this.mudRating <= 6)
        this.ShowOdds ++;
        }

        public void ShowCal(){
            if (this.ShowOdds % 3 == 0 )
            this.ShowOdds = this.ShowOdds/3;
            
            }






        public void addWinOdds(){
            this.WinOdds ++;
            this.PlaceOdds ++;
            this.ShowOdds ++;
        }

        public void SubWinOdds(){
            this.WinOdds --;
            this.PlaceOdds --;
            this.ShowOdds --;
        }









public int GetPlaceOdds(){
    return this.PlaceOdds;
}


        public int GetWinOdds(){
            return this.WinOdds;
        }

        public int GetShowOdds(){
            return this.ShowOdds; 
        }










        public int getNumber(){
            return this.number;
        }


        public void setRaceFinished(boolean finished){
            finishedRace = finished;
        }

    
        public boolean raceFinished(){
            return finishedRace;
        }
        public String getName() {
            return name;
        }

        public int getMudRating() {
            return mudRating;
        }

        public int getGrassRating() {
            return grassRating;
        }

        public int getDirtRating() {
            return dirtRating;
        }

      
        public double getPreferredLength() {
            return preferredLength;
        }

        public void incrementPosition(int inc){
            currentPosition += inc;
        }

        public int getCurrentPosition(){
            return currentPosition;
        }

        public void resetCurrenPosition(){
            currentPosition = 2;
            finishedRace = false;
        }
       
    }