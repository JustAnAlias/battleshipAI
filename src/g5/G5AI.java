/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g5;

import battleship.interfaces.BattleshipsPlayer;
import battleship.interfaces.Fleet;
import battleship.interfaces.Position;
import battleship.interfaces.Board;
import battleship.interfaces.Ship;
import java.util.ArrayList;

/**
 *
 * @author Tobias
 */
public class G5AI implements BattleshipsPlayer
{

    // Defining other classes to be used/called in methods
    private Shooter shoot;
    private PlaceFleet fleet;
    private Radar radar;

    private int currentRound;
    
    public G5AI()
    {
        this.fleet = new PlaceFleet();
    }

    @Override
    public void placeShips(Fleet fleet, Board board)
    {
        //Call check if cell is taken
        
        // Get each ship
        for (int i = 0; i < fleet.getNumberOfShips(); i++)
        {
            Ship s = fleet.getShip(i);
            //PlaceShips
            
        }
        //Do nothing
    }

    @Override
    public void incoming(Position pos)
    {
        //Do nothing
    }

    @Override
    public Position getFireCoordinates(Fleet enemyShips)
    {
        // Get best coordinates from radar
        int[] coordinates = this.radar.locateBestFireCoordinates();

        //return new Position(x,y);
        return new Position(coordinates[0], coordinates[1]);

    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {
        //Do nothing
        ArrayList<Integer> enemyShipSizes = new ArrayList();
        for (int i = 0; i < enemyShips.getNumberOfShips(); i++)
        {
            Ship es = enemyShips.getShip(i);
            enemyShipSizes.add(Integer.valueOf(es.size()));
        }
        // Update MapInfo
        this.radar.adjustMapInfo(hit, enemyShipSizes);
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
        this.shoot = new Shooter(round);
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
