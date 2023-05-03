package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class toolBox {

    public static int UserColourAmount(String colour, Scanner INPUT) {
        //loop until return
        while (true) {
            //ask for amount colour, check to see if integer
            int output = makeSureInputisInteger("What amount of " + colour + " do you want?\n>", INPUT);

            //if it is between 0 and 255 then output number
            if (0 <= output && output <= 255) {
                return output;
            }
        }
    }

    public static int makeSureInputisInteger(String message, Scanner INPUT) {
        //make it loop until input is an int
        while (true) {
            try {
                System.out.print(message);

                int output = INPUT.nextInt();
                //clear INPUT
                INPUT.nextLine();
                return output;
            }
            //tells if input isn't an int
            catch (Exception e) {
                INPUT.nextLine();
                System.out.println("Sorry but an integer needs to be inputted");
            }
        }
    }



    public static colour makeColour(Scanner INPUT) {
        //get amount of red
        int red = toolBox.UserColourAmount("red", INPUT);
        //get amount of green
        int green = toolBox.UserColourAmount("green", INPUT);
        //get amount of blue
        int blue = toolBox.UserColourAmount("blue", INPUT);
        //get colour name
        System.out.print("What is the name of your colour?\n>");

        //get name for the colour
        String colourName = INPUT.nextLine();

        return new colour(red, green, blue, colourName);
    }

    public static colourPalette twoColourMakePalette(colour firstColour, colour secondColour, int paletteAmount, Scanner INPUT) {

        //make colour palette
        colourPalette palette = new colourPalette(firstColour, secondColour, paletteAmount);

        //loop until user doesn't want to add any more colours
        while (true) {
            //display palette
            palette.display();
            System.out.print("\nDo you want to add a colour to the palette? (y/n)\n>");
            String userInput = INPUT.nextLine();
            //add colour to palette if user wants to add a colour
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                palette.addColour(toolBox.makeColour(INPUT));
            } else {
                return palette;
            }
        }
    }
    public static colourPalette makePalette(colour mainColour,int paletteAmount,Scanner INPUT) {

        //make colour palette
        colourPalette palette = new colourPalette(mainColour, paletteAmount);

        //loop until user doesn't want to add any more colours
        while (true) {
            //display palette
            palette.display();
            System.out.print("\nDo you want to add a colour to the palette? (y/n)\n>");
            String userInput = INPUT.nextLine();
            //add colour to palette if user wants to add a colour
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                palette.addColour(toolBox.makeColour(INPUT));
            } else {
                return palette;
            }
        }

    }


    public static int[] hexCodeToRGB(String hexCode) {
        String[] splitHexCode = hexCode.split("");
        int[] output = new int[3];
        int num = 0;
        for (int i = 0; i < 3; i++) {
            double save = 0d;

            for (int j = 0; j < 2; j++) {
                //turn the letters into their number equivalent
                if (splitHexCode[i + j].equalsIgnoreCase("a")) {
                    num = 10;
                } else if (splitHexCode[j + i * 2].equalsIgnoreCase("b")) {
                    num = 11;
                } else if (splitHexCode[j + i * 2].equalsIgnoreCase("c")) {
                    num = 12;
                } else if (splitHexCode[j + i * 2].equalsIgnoreCase("d")) {
                    num = 13;
                } else if (splitHexCode[j + i * 2].equalsIgnoreCase("e")) {
                    num = 14;
                } else if (splitHexCode[j + i * 2].equalsIgnoreCase("f")) {
                    num = 15;
                } else {
                    //the rest turn into numbers
                    try {
                        num = Integer.parseInt(splitHexCode[1]);
                    } catch (Exception e) {
                        num = 0;
                    }
                }//get numbers into rgb values
                save += (8.5 * num);
            }
            //turn them into ints
            output[i] = (int) save;
        }
        return output;
    }

    public static colour hexCodeToColour(String hexCode, String name) {
        //turn hex code into rgb values
        int[] rgb = hexCodeToRGB(hexCode);
        //get colour form rgb values
        return new colour(rgb[0], rgb[1], rgb[2], name);
    }

    public static colourPalette premadeChristmasPalette() {
        ArrayList<colour> colours = new ArrayList<>();

        //make and add all the colours needed to colours list
        colour brightRed = new colour(255, 0, 0, "Bright Red");
        colours.add(brightRed);
        colour lightRed = new colour(255, 120, 120, "Light Red");
        colours.add(lightRed);
        colour white = new colour(225, 225, 225, "White");
        colours.add(white);
        colour lightGreen = new colour(115, 215, 130, "Light Green");
        colours.add(lightGreen);
        colour darkGreen = new colour(40, 145, 45, "Dark Green");
        colours.add(darkGreen);


        return new colourPalette(colours);
    }

    public static colourPalette premadeHalloweenPalette(){
        ArrayList<colour> colours=new ArrayList<>();

        //make and add all the colours needed to colours list
        colour darkOrange=new colour(247, 95, 28,"Dark Orange");
        colours.add(darkOrange);
        colour orange=new colour(55, 154, 0,"Orange");
        colours.add(orange);
        colour green=new colour(133, 226, 31, "Green");
        colours.add(green);
        colour purple=new colour(136, 30, 228, "Purple");
        colours.add(purple);
        colour black=new colour(0,0,0,"Black");
        colours.add(black);
        return new colourPalette(colours);
    }

    public static colourPalette premadeEasterPalette(){
        ArrayList<colour> colours=new ArrayList<>();

        //make and add all the colours needed to colours list
        colour pastelPink=new colour(255,212,230,"Pastel Pink");
        colours.add(pastelPink);
        colour pastelPurple=new colour(225,205,255,"Pastel Purple");
        colours.add(pastelPurple);
        colour pastelBlue=new colour(190,230,240,"Pastel Blue");
        colours.add(pastelBlue);
        colour pastelGreen=new colour(183,215,132, "Pastel Green");
        colours.add(pastelGreen);
        colour pastelYellow=new colour(255,255,162,"Pastel Yellow");
        colours.add(pastelYellow);
        return new colourPalette(colours);
    }

//to remove code from the main class
    public static colourPalette makePaletteOptions(Scanner INPUT) {
        //preset varaibales
        boolean twoPalettes = false;
        String userInput="";
        while (true) {
            System.out.print("Do you want to make the palette based on 1 or 2 colours?\n>");
             userInput = INPUT.nextLine();
             //set if there will be twoPalettes based on the user's answer
            if (userInput.equalsIgnoreCase("1") || userInput.equalsIgnoreCase("one")) {
                twoPalettes = false;
                break;
            } else if (userInput.equalsIgnoreCase("2") || userInput.equalsIgnoreCase("two")) {
                twoPalettes = true;
                break;
            } else {
                System.out.println(userInput + " isn't an option that this system understands");
            }
        }
            while (true) {
                System.out.print("Do you want to use Rgb or Hex code for your colours? (Rgb, Hex code)\n>");
                userInput = INPUT.nextLine();

                //make palette with RGB or Hex code based on user's input
                if (userInput.equalsIgnoreCase("rgb") || userInput.equalsIgnoreCase("1")) {
                    //make first colour
                    colour mainColour = toolBox.makeColour(INPUT);

                    if (twoPalettes) {System.out.println("\nLets start making your colour palette");
                        //get amount of colours in your palette, make sure it is an int

                        System.out.println("\nSecond Colour:");
                        colour secondColour = toolBox.makeColour(INPUT);

                        //get amount of colours in your palette, make sure it is an int
                        int paletteAmount = toolBox.makeSureInputisInteger("How many colours do you want in your palette?\n>", INPUT);

                        return toolBox.twoColourMakePalette(mainColour,secondColour,paletteAmount,INPUT);
                    } else {
                        int paletteAmount = toolBox.makeSureInputisInteger("How many colours do you want in your palette?\n>", INPUT);

                        return makePalette(mainColour,paletteAmount,INPUT);
                    }

                } else if (userInput.equalsIgnoreCase("hexcode") || userInput.equalsIgnoreCase("hex code")||userInput.equalsIgnoreCase("2")) {
                    //first colour
                    System.out.print("Input the hexCode\n>");
                    userInput = INPUT.nextLine();
                    System.out.print("Colour's name?\n>");
                    colour tempColour = toolBox.hexCodeToColour(userInput, INPUT.nextLine());

                    if (twoPalettes) {
                        //two colour palette make
                        System.out.print("Second hexCode\n>");
                        userInput = INPUT.nextLine();
                        System.out.print("Colour's name?\n>");

                        return twoColourMakePalette(tempColour,hexCodeToColour(userInput,INPUT.nextLine()),makeSureInputisInteger("Amount of colours in the palette?\n>", INPUT), INPUT);

                    } else {
                        return makePalette(tempColour,toolBox.makeSureInputisInteger("Amount of colours in the palette?\n>", INPUT), INPUT);

                    }

                } else {
                    System.out.println(userInput + " isn't an option that this system understands");
                }
            }

    }




}


