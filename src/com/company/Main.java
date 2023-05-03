//Owen Riske

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //preset variables
        Scanner INPUT=new Scanner(System.in);
        ArrayList<colourPalette> palettes=new ArrayList<>();
        int index=1;

        //welcome message
        System.out.println("Welcome User\n");

        while(true) {
            //options
            System.out.print("1. Make palette 2. Premade Palettes 3. View colour 4. Previous Palettes 5. Quit\n>");
            String userInput=INPUT.nextLine();
            //option 1 make palette
            if(userInput.equalsIgnoreCase("1")||userInput.equalsIgnoreCase("1.")||userInput.equalsIgnoreCase("Make palette")||userInput.equalsIgnoreCase("Make")){
                palettes.add(toolBox.makePaletteOptions(INPUT));
            }
            //option 2 pre-made Palettes
            else if(userInput.equalsIgnoreCase("2")||userInput.equalsIgnoreCase("2.")||userInput.equalsIgnoreCase("Premade")||userInput.equalsIgnoreCase("Premade Palette")){
                System.out.println("\nChristmas Palette");
                toolBox.premadeChristmasPalette().display();

                System.out.println("\nHalloween Palette");
                toolBox.premadeHalloweenPalette().display();

                System.out.println("\nEaster Palette");
                toolBox.premadeEasterPalette().display();

                //give extra room after pre-made palettes
                System.out.println("\n\n");

            }
            //option 3 display specified colour
            else if(userInput.equalsIgnoreCase("3")||userInput.equalsIgnoreCase("3.")||userInput.equalsIgnoreCase("View colour")||userInput.equalsIgnoreCase("View")||userInput.equalsIgnoreCase("colour")){
                //make colour
                colour temp=toolBox.makeColour(INPUT);
                //display the colour
                temp.displayColour();
            }
            //option 4 show previous palettes that have been made
            else if(userInput.equalsIgnoreCase("4")||userInput.equalsIgnoreCase("4.")||userInput.equalsIgnoreCase("Previous palette")||userInput.equalsIgnoreCase("Previous")){
                //for each in the list palettes
                for (colourPalette palette:palettes) {
                    //display their information
                    System.out.println(index +". Palette");
                    palette.display();
                    System.out.println("\n");
                    index++;
                }
                index=1;
            }
            //quit program
            else if(userInput.equalsIgnoreCase("5")||userInput.equalsIgnoreCase("5.")||userInput.equalsIgnoreCase("Quit")){
                break;
            }
            else{
                System.out.println(userInput+" isn't an option that this system understands");

            }
            }




    }

}
