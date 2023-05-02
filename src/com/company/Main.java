package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //preset variables
        Scanner INPUT=new Scanner(System.in);
        ArrayList<colourPalette> palettes=new ArrayList<>();
        int index=1;

        int[] oldtemp=toolBox.hexCodeToRGB("74d680");
        colour newTemp=new colour(oldtemp[0],oldtemp[1],oldtemp[2],"?");
        newTemp.displayColour();
toolBox.premadeChristmasPalette().display();



        boolean twoPalettes=false;
        System.out.println("Welcome User\n");




        while(true) {
            //options
            System.out.print("1. Make palette 2. View colour 3. Previous Palettes\n>");
            String userInput=INPUT.nextLine();
            //option 1 make palette
            if(userInput.equalsIgnoreCase("1")||userInput.equalsIgnoreCase("1.")||userInput.equalsIgnoreCase("Make palette")||userInput.equalsIgnoreCase("Make")){
                palettes.add(toolBox.makePaletteOptions(INPUT));
            }
            //option 2 display specified colour
            else if(userInput.equalsIgnoreCase("2")||userInput.equalsIgnoreCase("2.")||userInput.equalsIgnoreCase("View colour")||userInput.equalsIgnoreCase("View")||userInput.equalsIgnoreCase("colour")){
                colour temp=toolBox.makeColour(INPUT);
                temp.displayColour();
            }
            //option 3 show previous palettes that have been made
            else if(userInput.equalsIgnoreCase("3")||userInput.equalsIgnoreCase("3.")||userInput.equalsIgnoreCase("Previous palette")||userInput.equalsIgnoreCase("Previous")){
                for (colourPalette palette:palettes) {
                    System.out.println(index +". Palette");
                    palette.display();
                    System.out.println("\n");
                    index++;
                }
                index=1;
            }
            else{
                System.out.println(userInput+" isn't an option that this system understands");

            }
            }




    }

}
