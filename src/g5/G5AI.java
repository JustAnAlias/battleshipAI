/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g5;

import battleship.interfaces.*;
import java.util.ArrayList;

import java.util.Random;

/**
 *
 * @author Tobias
 */
public class G5AI implements BattleshipsPlayer
{
    private final static Random rnd = new Random();
    private int sizeX;
    private int sizeY;
    
    private int nextX;
    private int nextY;

    private ShootingAlgo shooter;
    private Compute cmp;

    private int currentRound;
      
    public G5AI()
    {


    }

    @Override
    public void placeShips(Fleet fleet, Board board)
    {
        nextX = 0;
        nextY = 0;
        sizeX = board.sizeX();
        sizeY = board.sizeY();
        for(int i = 0; i < fleet.getNumberOfShips(); ++i)
        {
            Ship s = fleet.getShip(i);
            boolean vertical = rnd.nextBoolean();
            Position pos;
            if(vertical)
            {
                int x = rnd.nextInt(sizeX);
                int y = rnd.nextInt(sizeY-(s.size()-1));
                pos = new Position(x, y);
            }
            else
            {
                int x = rnd.nextInt(sizeX-(s.size()-1));
                int y = rnd.nextInt(sizeY);
                pos = new Position(x, y);
            }
            board.placeShip(pos, s, vertical);
        }
    }

    @Override
    public void incoming(Position pos)
    {
        
        //Do nothing
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips)
    {
        int[] cords = this.shooter.fireCords();
        return new Position(cords[0], cords[1]);
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {
        //Do nothing
    ArrayList<Integer> enemyShipSizes = new ArrayList();
    for (int i = 0; i < enemyShips.getNumberOfShips(); i++)
    {
      Ship ship = enemyShips.getShip(i);
      enemyShipSizes.add(Integer.valueOf(ship.size()));
    }
    this.shooter.adjustMapInfo(hit, enemyShipSizes);
}

    @Override
    public void startMatch(int rounds)
    {
        //Do nothing
    }

    @Override
    public void startRound(int round)
    {
        //Do nothing
    this.shooter = new ShootingAlgo(round);
    this.currentRound = round;
    }

    @Override
    public void endRound(int round, int points, int enemyPoints)
    {
        //Do nothing
    }

    @Override
    public void endMatch(int won, int lost, int draw)
    {
        //Do nothing
    }
}
