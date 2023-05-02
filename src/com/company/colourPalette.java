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

        //get main Colour and add it to the palette
        this.mainColour=mainColour;
        this.colours.add(mainColour);

        this.numOfColours=numberOfColours;

        //if palette has more than 1 colours make a contrasting colour
        if(numberOfColours>1){
            //opposite colour amounts to the main
            int newColourR=255-mainColour.red;
            int newColourG=255-mainColour.green;
            int newColourB=255-mainColour.blue;
            //make and add contrasting colour to the palette
            colour temp=new colour(newColourR,newColourG,newColourB,mainColour.commonName+"'s compliment");
            colours.add(temp);
            //make similar colours to the main colours
                for (int i = 0; i < numberOfColours-1; i++) {
                    if(rand.nextInt(2)==1){
                        temp = makePaletteColour(mainColour, "Analogous colour " + numberOfColours);
                    }
                    else{
                        temp=makePaletteColour(newColourR,newColourB,newColourG,"Analogous colour " + numberOfColours);
                    }
            colours.add(temp);
                }
        }
    }

    colourPalette(colour firstKeyColour, colour secondKeyColour,int numOfColours){
        rand=new Random();

        this.colours=new ArrayList<>();
        this.mainColour=firstKeyColour;
        this.numOfColours=numOfColours;
        //add both key colours to the palette
        this.colours.add(firstKeyColour);
        this.colours.add(secondKeyColour);



        //generate additiional palette colours



        if(this.numOfColours>2){
            int red=(firstKeyColour.red+secondKeyColour.red)/2;
            int green=(firstKeyColour.green+secondKeyColour.green)/2;
            int blue=(firstKeyColour.blue+secondKeyColour.blue)/2;

            colour temp =new colour(red,green,blue,"Key colours average");
            this.colours.add(temp);
            if (this.numOfColours>3) {
                temp = new colour(255 - firstKeyColour.red, 255 - firstKeyColour.green, 255 - firstKeyColour.blue, firstKeyColour.commonName + "'s compliment");
                this.colours.add(temp);

                if (this.numOfColours > 4) {
                    temp = new colour(255 - secondKeyColour.red, 255 - secondKeyColour.green, 255 - secondKeyColour.blue, secondKeyColour.commonName + "'s compliment");

                    this.colours.add(temp);
                    if (this.numOfColours > 5) {
                        //fourth colour is the compliment of the average
                        temp = new colour(255 - red, 255 - green, 255 - blue, "Average's complement");
                        this.colours.add(temp);

                        for (int i = 0; i < numOfColours - 5; i++) {
                            int random=rand.nextInt(10);
                            if (random == 0 || random==1 ||random==2) {
                                temp = makePaletteColour(mainColour, "Analogous colour " + i);
                            } else if(random==3|| random==4 ||random==5){
                                temp = makePaletteColour(secondKeyColour, "Analogous colour " + i);
                            }
                            else if(random==6 || random==7){
                                temp=makePaletteColour(255-red,255-green,255-blue, "Analogous colour "+i);
                            }
                            else if(random==8){
                            temp=makePaletteColour(255-firstKeyColour.red,255-firstKeyColour.green,255-firstKeyColour.blue, "Analogous colour "+i);
                            }
                            else if(random==9){
                                temp=makePaletteColour(255-secondKeyColour.red,255-secondKeyColour.green,255-secondKeyColour.blue, "Analogous colour "+i);
                            }
                            colours.add(temp);
                            }

                        }
                    }
                }
            }
        }


        colourPalette(ArrayList colours){
        this.colours=colours;
        }



    void display(){
        //display each colour
        for (colour c:colours) {
            c.displayColour();
        }


    }

    private int RGBChange(int colour){
        int output=-300;

        //while colour isn't a possible amount for RGB
        while(colour+output<0 || colour+output>255){
            //randomize number change to the inputted colour
            output=(rand.nextInt(10)-5)*5;
        }
        return  colour+output;

    }
    private colour makePaletteColour(colour Colour, String colourName){
        //make colour and output it
        colour output=new colour(RGBChange(Colour.red),RGBChange(Colour.green),RGBChange(Colour.blue),colourName);
        return output;
    }

    private colour makePaletteColour(int red, int green,int blue, String colourName){
        //make colour and output it
        colour output=new colour(RGBChange(red),RGBChange(green),RGBChange(blue),colourName);
        return output;
    }


    void addColour(colour Colour){
        colours.add(Colour);
    }
}
