package MainGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //the tree has to have 3 nodes at the beginning as a starting questions of the game
        //the user will fill in other questions and answers later
        Animal theStages = new Animal("Does it Fly?", "Bird", null, null);
        theStages.yes = new Animal("is it a Bird? ", null, null, null);
        theStages.No = new Animal("is it a Lion? ", null, null, null);
        Scanner myInput = new Scanner(System.in);
        int quit=1;
        while (quit==1){
            Play(theStages);
            System.out.println("Thanks for Playing, Try Again? ");
            quit = myInput.nextInt();
        }
    }
    public static Animal Play(Animal theStage){
        //since the scanner will be used anyway, it will be here
        Scanner myScan = new Scanner(System.in);
        //if the stage is null in play method, this means our guesses are wrong
        if (theStage==null){
            //when we run out of options we will ask the suer to enter more data to help us
            System.out.println("Cannot Find it:( Pleas Provide us with More Info, Choose from the Following: \n" +
                    "1. Question\n" +
                    "2. Answer");
            String answer = myScan.nextLine();
            // if the user enters a question as a clue we will restart the game from the beginning
            String response;
            if (answer.equals("Question")){
                System.out.println("Enter the Question: ");
                response = myScan.nextLine();
                theStage = new Animal(response, null, null, null);
            }
            else {
                System.out.println("Enter the Name of the MainGame.Animal: ");
                //if the user choses the answer, same thing, but this time we will have to construct a question
                //based on that answer
                response = myScan.nextLine();
                theStage = new Animal(null, response, null, null);
                theStage.ConstructQuest();
            }
            return theStage;
        }
        System.out.println(theStage.Question);
        String Answer = myScan.nextLine();
        if (Answer.equals("no")){
            theStage.No = Play(theStage.No);
        }
        else {
            //we want to make sure that when we reach the question that contains the name of the animal
            //the game stops as that is the last stage
            if (theStage.name==null){
                System.out.println("Yeesssss!!!");
                return theStage;
            }
            theStage.yes = Play(theStage.yes);
        }
        return theStage;
    }
}

