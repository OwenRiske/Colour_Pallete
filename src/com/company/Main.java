package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner INPUT=new Scanner(System.in);
        ArrayList<colourPalette> palettes=new ArrayList<>();
        int index=1;


        System.out.println("Welcome User\n");

        while(true) {
            System.out.print("1. Make palette 2. View colour 3. Previous Palettes\n>");
            String userInput=INPUT.nextLine();
            if(userInput.equalsIgnoreCase("1")||userInput.equalsIgnoreCase("1.")||userInput.equalsIgnoreCase("Make palette")||userInput.equalsIgnoreCase("Make")){
                palettes.add(toolBox.makePalette(INPUT));
            }
            else if(userInput.equalsIgnoreCase("2")||userInput.equalsIgnoreCase("2.")||userInput.equalsIgnoreCase("View colour")||userInput.equalsIgnoreCase("View")||userInput.equalsIgnoreCase("colour")){
                colour temp=toolBox.makeColour(INPUT);
                temp.displayColour();
            }
            else if(userInput.equalsIgnoreCase("3")||userInput.equalsIgnoreCase("3.")||userInput.equalsIgnoreCase("Previous palette")||userInput.equalsIgnoreCase("Previous")){
                for (colourPalette palette:palettes) {
                    System.out.println(index +". Palette");
                    palette.display();
                    System.out.println("\n");
                    index++;
                }
                index=1;
            }
            }



    }

}
