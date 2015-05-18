/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g5;

import java.util.ArrayList;

/**
 *
 * @author Rasmuss
 */
public class Radar {

    private Shooter shoot;
    
    private int lastFiredX;
    private int lastFiredY;
    private int[][] cords;
    private int[][] currentMap;
    
    
    
    public Radar(){
        
    }

    int[] locateBestFireCoordinates() {
        
        // Make function that checks probability of a possible hit
        // Both horizontal and vertical
        
        int[] cord = findCord();
        
        this.lastFiredX = cord[0];
        this.lastFiredY = cord[1];
        
        return cord;
        
    }

    void adjustMapInfo(boolean hit, ArrayList<Integer> enemyShipSizes) {
        
        if(!hit)
        {
            this.currentMap[this.lastFiredX][this.lastFiredY] = 2;
        }

        

    }

    private int[] findCord() {
        
        int[] cord = {0,0};
        
        int bestCord = this.cords[0][0];
        for(int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                if (this.cords[x][y] > bestCord) 
                {
                    cord[0] = x;
                    cord[1] = y;
                    bestCord = this.cords[x][y];
                }
            }
        }
        
        return cord;        
    }

    
    
}
