/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package g5;

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;

/**
 *
 * @author Tobias Grundtvig
 */
public class G5 implements PlayerFactory<BattleshipsPlayer>
{

    public G5(){}
    
    
    @Override
    public BattleshipsPlayer getNewInstance()
    {
        return new RandomPlayer();
    }

    @Override
    public String getID()
    {
        return "G5";
    }

    @Override
    public String getName()
    {
        return "Team G5 - "
                + "Daniel Krarup, " +
                "RL, &" +
                "Mads Køie";
    }
    
}
