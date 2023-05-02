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

    public static int intIsRGBValue(int input) {
        if (input < 0) {
            return 0;
        } else if (input > 255) {
            return 255;
        }
        return input;
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


        String colourName = INPUT.nextLine();
        return new colour(red, green, blue, colourName);
    }

    public static colourPalette twoColourMakePalette(Scanner INPUT) {
        System.out.println("\nLets start making your colour palette");

        //make colour
        System.out.println("\nFirst Colour:");
        colour firstColour = toolBox.makeColour(INPUT);
        System.out.println("\nSecond Colour:");
        colour secondColour = toolBox.makeColour(INPUT);

        //get amount of colours in your palette, make sure it is an int
        int paletteAmount = toolBox.makeSureInputisInteger("How many colours do you want in your palette?\n>", INPUT);

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

    public static colourPalette makePalette(Scanner INPUT) {
        System.out.println("\nLets start making your colour palette");

        //make colour
        colour mainColour = toolBox.makeColour(INPUT);

        //get amount of colours in your palette, make sure it is an int
        int paletteAmount = toolBox.makeSureInputisInteger("How many colours do you want in your palette?\n>", INPUT);

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
                    try {
                        num = Integer.parseInt(splitHexCode[1]);
                    } catch (Exception e) {
                        num = 0;
                    }
                }
                save += (8.5 * num);
            }
            System.out.println(save);
            output[i] = (int) save;
        }
        return output;
    }

    public static colour hexCodeToColour(String hexCode, String name) {
        int[] rgb = hexCodeToRGB(hexCode);
        return new colour(rgb[0], rgb[1], rgb[2], name);
    }

    public static colourPalette premadeChristmasPalette() {
        ArrayList<colour> colours = new ArrayList<>();
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


    public static colourPalette makePaletteOptions(Scanner INPUT) {
        boolean twoPalettes = false;
        while (true) {
            System.out.print("Do you want to make the palette based on 1 or 2 colours?\n>");
            String userInput = INPUT.nextLine();
            if (userInput.equalsIgnoreCase("1") || userInput.equalsIgnoreCase("one")) {
                twoPalettes = false;
                break;
            } else if (userInput.equalsIgnoreCase("2") || userInput.equalsIgnoreCase("two")) {
                twoPalettes = true;
                break;
            } else {
                System.out.println(userInput + " isn't an option that this system understands");
            }
            while (true) {
                System.out.print("Do you wna to use Rgb or Hexcode for your colours? (Rgb, Hexcode)\n>");
                userInput = INPUT.nextLine();
                if (userInput.equalsIgnoreCase("rgb") || userInput.equalsIgnoreCase("1")) {
                    if (twoPalettes) {
                        toolBox.twoColourMakePalette(INPUT);
                    } else {
                        toolBox.makePalette(INPUT);
                    }
                } else if (userInput.equalsIgnoreCase("hexcode") || userInput.equalsIgnoreCase("2")) {
                    System.out.print("Input the hexCode\n>");
                    userInput = INPUT.nextLine();
                    System.out.print("Colour's name?\n>");
                    colour tempColour = toolBox.hexCodeToColour(userInput, INPUT.nextLine());
                    if (twoPalettes) {
                        System.out.print("Second hexCode\n>");
                        userInput = INPUT.nextLine();
                        System.out.print("Colour's name?\n>");

                        colourPalette temp = new colourPalette(tempColour, toolBox.hexCodeToColour(userInput, INPUT.nextLine()), toolBox.makeSureInputisInteger("Amount of colours in the palette?\n>", INPUT));
                        return temp;
                    } else {
                        colourPalette temp = new colourPalette(tempColour, toolBox.makeSureInputisInteger("Amount of colours in the palette?\n>", INPUT));
                        return temp;
                    }

                } else {
                    System.out.println(userInput + " isn't an option that this system understands");
                }
            }
        }
        return temp;
    }




}


