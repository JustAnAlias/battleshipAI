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
public class Shooting {

    
    private int[][] mapInfo;
    private ArrayList<Integer> enemyShips;
    
    
    public Shooting(int rounds) 
    {
    this.mapInfo = new int[10][10];
    
    // ArrayList of Enemyships
    this.enemyShips = new ArrayList();
    this.enemyShips.add(Integer.valueOf(2));
    this.enemyShips.add(Integer.valueOf(3));
    this.enemyShips.add(Integer.valueOf(3));
    this.enemyShips.add(Integer.valueOf(4));
    this.enemyShips.add(Integer.valueOf(5));
    
    }
    
}
