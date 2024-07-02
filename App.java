
package guessinggame;
import java.util.Random;
import java.util.Scanner;


public class GuessingGame {

    public static void main(String[] args) {
        
        String name;
        int menuChoice;
        int returnToMenu = 1;
        int guessMenuChoice;
        int guessedNumber;
        int chances;
        int low;
        int high;
        int correctNumber;
        int highScoreNumber = 0;
        int highScoreLetter = 0;
        char correctLetter;
        char guessedLetter;        
        int exit = 1;
        int keepNumber;
        int keepLetter;
        char vowelLetters[] = {'a', 'i', 'u', 'e', 'o'};
        char consonantLetters[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'y', 'z'};
        int timesOfPlayNumbers = 0;
        int timesOfPlayLetters = 0;

        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Guessing Game");
        System.out.println("Please enter your name");
        name = input.next();
        System.out.println("Hello " + name);
        
        while(exit != 0){

        while(returnToMenu != 0){
            returnToMenu = 0;

            System.out.println("Press the number of your choice from the menu");
            menu();
        
            menuChoice = input.nextInt();
 
            while(menuChoice > 5 ||  menuChoice < 0){
           
                System.out.println("You entered a number out of the menu range please try again");
                menu();
        
                menuChoice = input.nextInt();
            }
            switch(menuChoice) {
                
                case 1:
                    keepNumber = 1;
                    timesOfPlayNumbers++;
                    while(keepNumber != 0){
                        System.out.println("Let's guess some numbers");
                        levelChoice();
                        guessMenuChoice = input.nextInt();
                    
                        while(guessMenuChoice > 4 ||  guessMenuChoice < 0){
           
                            System.out.println("You entered a number out of the menu range please try again");
                            levelChoice();
                            guessMenuChoice = input.nextInt();

                        }
                        switch(guessMenuChoice){
                            case 1 : 
                                chances = 5;
                                low = 1;
                                high = 15;
                                correctNumber = rand.nextInt(high-low) + low;
                            
                                System.out.println("Welcom to the easy level");
                                instructionsNumbers(chances, low, high);
                                
                                guessedNumber = input.nextInt();
                                if(guessingNumber(correctNumber, guessedNumber, low, high, chances,guessMenuChoice)){
                                    highScoreNumber++; 
                                }
                                else{
                                    System.out.println("You lost Good luck next time you are out of chances");
                                }
                                break;
                            case 2 : 
                                chances = 4;
                                low = 1;
                                high = 20;
                                correctNumber = rand.nextInt(high-low) + low;
                            
                                System.out.println("Welcom to the mid level");
                                instructionsNumbers(chances, low, high);
                                System.out.println("");
                 
                                guessedNumber = input.nextInt();
                                if(guessingNumber(correctNumber, guessedNumber, low, high, chances,guessMenuChoice)){
                                    highScoreNumber++; 
                                }
                                else{
                                    System.out.println("You lost Good luck next time you are out of chances");
                                }
                                break;
                            case 3 : 
                                chances = 3;
                                low = 1;
                                high = 40;
                                correctNumber = rand.nextInt(high-low) + low;
                            
                                System.out.println("Welcom to the hard level");
                                instructionsNumbers(chances, low, high);
                                
                                guessedNumber = input.nextInt();
                                if(guessingNumber(correctNumber, guessedNumber, low, high, chances,guessMenuChoice)){
                                    highScoreNumber++; 
                                }
                                else{
                                    System.out.println("You lost Good luck next time you are out of chances");
                                }
                                break; 
                            case 4 :
                                returnToMenu = 1;
                                keepNumber = 0;
                                break;
                        }                        
                        }
                        break;
                case 2:
                    keepLetter = 1;
                    timesOfPlayLetters++;
                    while(keepLetter != 0){     
                        System.out.println("Let's guess some letters");
                        levelChoice();
                        guessMenuChoice = input.nextInt();
                    
                        while(guessMenuChoice > 4 ||  guessMenuChoice < 0){
           
                            System.out.println("You entered a number out of the menu range please try again");
                            levelChoice();
                        
                            guessMenuChoice = input.nextInt();

                        }
                        switch(guessMenuChoice){
                            case 1:
                                chances = 2;
                                
                                correctLetter = vowelLetters[rand.nextInt(5)];
                                System.out.println("Welcome to Easy level");
                                instructionsLetters(chances, guessMenuChoice);
                                System.out.println("");
                                System.out.println("Please guess a letter ");
                                guessedLetter = input.next().charAt(0);
                                if(guessingLetter(correctLetter, guessedLetter,chances)){
                                    highScoreLetter++; 
                                }
                                else{
                                    System.out.println("Good luck next time");
                                }
                            break;
                        
                            case 2:
                                chances = 4;
                                correctLetter = consonantLetters[rand.nextInt(21)];
                                System.out.println("Welcome to mid level");
                                instructionsLetters(chances, guessMenuChoice);
                                System.out.println("");                                
                                System.out.println("Please guess a letter ");
                                guessedLetter = input.next().charAt(0);
                                if(guessingLetter(correctLetter, guessedLetter,chances)){
                                    highScoreLetter++; 
                                }
                                else{
                                    System.out.println("Good luck next time");
                                }
                            break;   
                            case 3:
                                chances = 5;
                                correctLetter = (char) ('a' + rand.nextInt(26));
                                System.out.println("Welcome to Hard level");
                                instructionsLetters(chances, guessMenuChoice);
                                System.out.println("");                                                          
                                System.out.println("Please guess a letter ");
                                guessedLetter = input.next().charAt(0);
                                if(guessingLetter(correctLetter, guessedLetter,chances)){
                                    highScoreLetter++; 
                                }
                                else{
                                    System.out.println("Good luck next time");
                                }
                            break; 
                            case 4 :
                                returnToMenu = 1;
                                keepLetter = 0;
                                break;
                        }
                    }
                    break;
                    
                case 3:
                    if(timesOfPlayNumbers == 0 && timesOfPlayLetters != 0){
                        System.out.println("You don't have a high score in guess number game because you didn't play yet");
                        System.out.println("The High score of the winnings of guessing letter game is " + highScoreLetter );
                        returnToMenu = 1;
                        break;
                    }
                    if(timesOfPlayLetters == 0 && timesOfPlayNumbers != 0){
                        System.out.println("The High score of the winnings of guessing number game is " + highScoreNumber );
                        System.out.println("You don't have a high score in guess letter game because you didn't play yet");
                        returnToMenu = 1;
                        break;
                    }
                    System.out.println("The High score of the winnings of guessing number game is " + highScoreNumber );
                    System.out.println("The High score of the winnings of guessing letter game is " + highScoreLetter );
                    returnToMenu = 1;    
                    break;
                    
                case 4:
                    System.out.println("Credit to Alaa AL Jebbeh");
                    System.out.println("Student Id 210209930");
                    System.out.println("Second Year software engineering student");
                    returnToMenu = 1;
                    break; 
                case 5:
                    exit = 0;
                    System.out.println("Thank you for playing with us till next time be safe");
                    
                    break;                    
            }
             
        } 
        }
        System.exit(0);
   
   } 
   public static boolean guessingNumber(int correctNumber, int guessedNumber, int low, int high, int chances,int guessMenuChoice){
       Scanner input = new Scanner(System.in);
       chances = chances-1;
       while(guessedNumber > high || guessedNumber < low){
           System.out.println("out of range please enter your guess again");
           guessedNumber = input.nextInt();
       }
       while(chances >= 0){
           if(guessedNumber == correctNumber){
               chances++;
               System.out.println("You won with " + chances + " chances left");
               return true;
           }
           else if(chances == 0){
               System.out.println("The correct number is " + correctNumber);
               chances--;     
           }
           else{
                if(chances == 1){
                    System.out.println("This is your last chance");
                }
                else{
                    System.out.println("Your guess is not correct try again");
                }
               System.out.println("You have " + chances + " chances left");
               if(guessMenuChoice == 1){
                   if(guessedNumber > correctNumber){
                   System.out.println("Your next guess should be lower");
                   }
                    else{
                       System.out.println("Your next guess should be higher");
                    }
               }
               System.out.println("Enter another guess");
               
               guessedNumber = input.nextInt();
               chances--;
           }
       }
       return false; 
    }
    public static boolean guessingLetter(char correctLetter, char guessedLetter, int chances){
        Scanner input = new Scanner(System.in);
        int asciiOfCorrectLetter = correctLetter;
        int asciiOfGuessedLetter = guessedLetter;
        chances = chances-1;
        while(chances >= 0){
            if(guessedLetter == correctLetter){
                chances++;
               System.out.println("You won with " + chances  + " chances left");
               return true;
           }
           else if(chances == 0){
               System.out.println("The correct letter is " + correctLetter);
               chances--;     
           }            
            
            else{ 
                if(chances == 1){
                    System.out.println("This is your last chance");
                }
                else{
                    System.out.println("Your guess is not correct try again");
                }
                
                System.out.println("You have " + chances + " chances left");
                if(asciiOfGuessedLetter > asciiOfCorrectLetter){
                   System.out.println("Your next guess should be a letter before the letter " + guessedLetter );
               }
               else{
                   System.out.println("Your next guess should be a letter after the letter " + guessedLetter);
               }
                System.out.println("Enter another guess");
                guessedLetter = input.next().charAt(0);
                chances--;
                asciiOfGuessedLetter = guessedLetter;
            }
        }
        return false;
    }
    public static void menu(){
    
        System.out.println("1. Guess the number ");
        System.out.println("2. Guess the alphabet ");
        System.out.println("3. High score ");
        System.out.println("4. Credit ");
        System.out.println("5. Exit ");
    }
    
    public static void levelChoice(){
        System.out.println("choose the level of the game");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("4. Return to main menu");
    }
    
        
    public static void instructionsLetters(int chances, int guessMenuChoice ){
        System.out.println("Instructions:");
        switch (guessMenuChoice) {
            case 1:
                System.out.println("1. Guess the vowel alphabet.");
                break;
            case 2:
                System.out.println("1. Guess the consonant alphabet.");
                break;
            default: 
                System.out.println("1. Guess the alphabet.");
                break;
        }
        
        System.out.println("2. You are allowed to make one guess at a time");
        System.out.println("3. Each game has " + chances + " chances to guess the correct alphabet.");
        System.out.println("4. Once you have used up all your chances, you lose the game.");
        }
    public static void instructionsNumbers(int chances, int low, int high ){
        System.out.println("Instructions:");
        System.out.println("1. Enter a number between " + low + " and " + high );
        System.out.println("2. You are allowed to make one guess at a time");
        System.out.println("3. Each game has " + chances + " chances to guess the correct alphabet.");
        System.out.println("4. Once you have used up all your chances, you lose the game.");
        System.out.println("guess a number between " + low + " and " + high);
        
  
    }

    
    
   
}


