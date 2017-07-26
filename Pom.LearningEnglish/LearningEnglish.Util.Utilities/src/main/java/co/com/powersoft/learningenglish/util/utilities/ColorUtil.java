/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.utilities;

/**
 *
 * @author Leonardo
 */
public class ColorUtil {

    public static String getColorRandom() {
        String[] colors = {"blue", "green", "red", "pink", "orange", "yellow", "gray", "purple", "brown"};
        int numrandom = (int) Math.floor(Math.random() * colors.length);
        return colors[numrandom];
    }

    public static String getColorPosition(int position) {

        String color;

        switch (position) {
            case 1:
                color = "blue";
                break;
            case 2:
                color = "gray";
                break;
            case 3:
                color = "orange";
                break;
            case 4:
                color = "red";
                break;
            case 5:
                color = "purple";
                break;
            case 6:
                color = "green";
                break;
            case 7:
                color = "yellow";
                break;
            case 8:
                color = "brown";
                break;
            case 9:
                color = "pink";
                break;

            default:
                color = "blue";
        }
        return color;
    }

}
