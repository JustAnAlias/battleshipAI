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

/**
 *
 * @author Tobias
 */
public class G5AI implements BattleshipsPlayer
{

    private int currentRound;
    
    public G5AI()
    {
    }

    @Override
    public void placeShips(Fleet fleet, Board board)
    {
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
        //Do nothing
    }

    @Override
    public void hitFeedBack(boolean hit, Fleet enemyShips)
    {
        //Do nothing
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
