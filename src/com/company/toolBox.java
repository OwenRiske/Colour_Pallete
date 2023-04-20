package com.company;

import java.util.Scanner;

public class toolBox {

    public static int UserColourAmount(String colour, Scanner INPUT) {
        while (true) {
            int output = makeSureInputisInteger("What amount of " + colour + " do you want?\n>", INPUT);

            if (0 <= output && output <= 255) {
                return output;
            }
        }
    }

    public static int makeSureInputisInteger(String message, Scanner INPUT) {
        while (true) {
            try {
                System.out.print(message);

                int output = INPUT.nextInt();
                INPUT.nextLine();
                return output;
            } catch (Exception e) {
                INPUT.nextLine();
                System.out.println("Sorry but an integer needs to be inputted");
            }
        }
    }

    public static colour makeColour(Scanner INPUT) {
        int red = toolBox.UserColourAmount("red", INPUT);
        int green = toolBox.UserColourAmount("green", INPUT);
        int blue = toolBox.UserColourAmount("blue", INPUT);
        System.out.print("What is the name of your colour?\n>");
        String colourName = INPUT.nextLine();
        colour output = new colour(red, green, blue, colourName);
        return output;
    }

    public static colourPalette makePalette(Scanner INPUT) {
        System.out.println("Lets start making your colour palette");
        colour mainColour = toolBox.makeColour(INPUT);

        int paletteAmount = toolBox.makeSureInputisInteger("How many colours do you want in your palette?\n>", INPUT);

        colourPalette palette = new colourPalette(mainColour, paletteAmount);
        while (true) {
            palette.display();
            System.out.print("\nDo you want to add a colour to the palette? (y/n)\n>");
            String userInput = INPUT.nextLine();
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                palette.addColour(toolBox.makeColour(INPUT));
            } else {
                return palette;
            }
        }

    }
}

