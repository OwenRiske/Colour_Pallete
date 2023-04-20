package com.company;

public class colour {
    int red;
    int green;
    int blue;
    String commonName;

    colour(int R, int G, int B, String commonName){
        this.red=R;
        this.green=G;
        this.blue=B;
        this.commonName=commonName;
    }

    int getRed(){
        return red;
    }

    int getGreen(){
        return green;
    }

    int getBlue(){
        return blue;
    }

    int[] getRGB(){
        return new int[] {red,green,blue};
    }


    /*
    String getHexCode(){
        String hexCode="#";

        //add red to the end of the hex string
        if(Integer.toHexString(red).length()<2){
            hexCode+="0";
        }
        hexCode+=Integer.toHexString(red);

        //add green to the end of the hex string
        if(Integer.toHexString(green).length()<2){
            hexCode+="0";
        }
        hexCode+=Integer.toHexString(green);

        //add blue to the end of the hex string
        if(Integer.toHexString(blue).length()<2){
            hexCode+="0";
        }
        hexCode+=Integer.toHexString(blue);

        return hexCode;
    }

     */

    //removes the redundant code
    String getHexCodeEfficiently(){
        String hexCode="#";
        for (int c:getRGB()) {
            if(Integer.toHexString(c).length()<2){
                hexCode+="0";
            }
            hexCode+=Integer.toHexString(c);
        }
        return hexCode;
    }
    void displayColour(){
        //display the colour in the console
        System.out.println("\033[48;2;"+red+";"+green+";"+blue+"m"+"\n\n");

        //reset colour and print the colours hex code
        System.out.println("\033[0m"+getHexCodeEfficiently());

    }
}
