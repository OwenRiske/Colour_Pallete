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
        System.out.println("\033[0m"+"Name: "+commonName+"  Red: "+red+" Green: "+green+"  Blue: "+blue+"  Hex code: "+getHexCodeEfficiently());

    }
}
