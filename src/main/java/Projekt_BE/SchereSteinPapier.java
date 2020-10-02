package Projekt_BE;

import java.util.Random;

public class SchereSteinPapier {

    public String playerTwo(){
        Random random = new Random();
        int x = random.nextInt(3);

        switch (x){
            case 0:
                return "Stein";
            case 1:
                return "Schere";
            case 2:
                return "Papier";
            default:
                return " ";
        }
    }

 public String compareDecisions(String decisionPlayerOne, String decisionPlayerTwo){

     if (decisionPlayerOne.equals(decisionPlayerTwo)){
         return "Unentschieden";
     }

     switch(decisionPlayerOne){

         case "Stein":
             if (decisionPlayerTwo.equals("Schere")){
                 return "Player 1";
             }
             else {
                 return "Player 2";
             }
         case "Schere":
             if (decisionPlayerTwo.equals("Papier")){
                 return "Player 1";
             }
             else {
                 return "Player 2";
             }
         case "Papier":
             if (decisionPlayerTwo.equals("Stein")){
                 return "Player 1";
             }
             else {
                 return "Player 2";
             }
     }

     return " ";


 }

}
