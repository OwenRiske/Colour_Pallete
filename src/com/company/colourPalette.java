package com.company;

import java.util.ArrayList;
import java.util.Random;

public class colourPalette{

    ArrayList<colour> colours;
    colour mainColour;
    int numOfColours;
    Random rand;


    //generative constructors
    //will make colour palettes
    colourPalette(colour mainColour, int numberOfColours){
        //preset variables
        this.colours=new ArrayList<colour>();//don't have this don't work
        rand=new Random();

        this.mainColour=mainColour;
        this.numOfColours=numberOfColours;
        this.colours.add(mainColour);

        if(numberOfColours>1){
            int newColourR=255-mainColour.red;
            int newColourG=255-mainColour.green;
            int newColourB=255-mainColour.blue;
            colour temp=new colour(newColourR,newColourG,newColourB,mainColour.commonName+"'s compliment");
            colours.add(temp);
            if(numberOfColours>3){
                numberOfColours--;
                temp=makePaletteColour(temp,temp.commonName+"'s palette colour");
                colours.add(temp);
            }
                for (int i = 0; i < numberOfColours-2; i++) {
                    temp=makePaletteColour(mainColour,"Palette colour "+numberOfColours);
            colours.add(temp);
                }
        }
    }


    void display(){
        for (colour c:colours) {
            c.displayColour();
        }


    }
    private int RGBChange(int colour){
        int output=-300;

        while(colour+output<0 || colour+output>255){
            output=(rand.nextInt(20)-10)*10;
        }
        return  colour+output;

    }
    private colour makePaletteColour(colour Colour, String colourName){
        colour output=new colour(RGBChange(Colour.red),RGBChange(Colour.green),RGBChange(Colour.blue),colourName);
        return output;
    }

    void addColour(colour Colour){
        colours.add(Colour);
    }
}
