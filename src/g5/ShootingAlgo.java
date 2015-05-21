package g5;

import java.util.ArrayList;
import java.util.Random;

public class ShootingAlgo {
    private ArrayList<Integer> enemyShips;
    private int[][] map;
    private int longitude;
    private int availablecells;
    private int lastX;
    private int lastY;
    
    private int currentRound;

    private Random rand;
    
    private int[][] chosen;

    
    public ShootingAlgo(int round) {
        this.map = new int[10][10];
        this.longitude = 10;
        this.availablecells = 100;

        this.enemyShips = new ArrayList();
        this.enemyShips.add(2);
        this.enemyShips.add(3);
        this.enemyShips.add(3);
        this.enemyShips.add(4);
        this.enemyShips.add(5);

        this.currentRound = round;
        
        this.rand = new Random();
    }

    public int[] fireCords() {
        this.chosen = new int[10][10];

        for (Integer enemyShip : this.enemyShips) {
            checkHorizontal(enemyShip);
            checkVertical(enemyShip);
        }

        int[] cell = {0, 0};
        int tmpCell = this.chosen[0][0];

        for (int x = 0; x < this.longitude; x++)
            for (int y = 0; y < this.longitude; y++)
                if (this.chosen[x][y] > tmpCell) {
                    cell[0] = x;
                    cell[1] = y;
                    tmpCell = this.chosen[x][y];
                }

        this.lastX = cell[0];
        this.lastY = cell[1];
        return cell;
    }

    private void checkHorizontal(int enemyShipSize) {
        int y = 0;
        while (y <= 9)
        {
            for (int x = 0; x <= this.longitude - enemyShipSize; x++)
            {
                boolean fits = true;
                for (int tempX = x; tempX < x + enemyShipSize; tempX++)
                    if ((this.map[tempX][y] == 2) || (this.map[tempX][y] == 3))
                        fits = false;

                if (fits)
                {
                    for (int tempX = x; tempX < x + enemyShipSize; tempX++)
                        if (this.map[tempX][y] == 0)
                            this.chosen[tempX][y] = this.chosen[tempX][y] + 1;

                    boolean isHit = false;

                    for (int tempX = x; tempX < x + enemyShipSize; tempX++)
                        if (this.map[tempX][y] == 1)
                            isHit = true;

                    if (isHit)
                        for (int tempX = x; tempX < x + enemyShipSize; tempX++)
                            if (this.map[tempX][y] == 0)
                                this.chosen[tempX][y] = this.chosen[tempX][y] + this.availablecells;
                }
            }
            y = y + 1;
        }
    }

    private void checkVertical(int enemyShipSize) {
        int x = 0;
        while (x <= 9)
        {
            for (int y = 0; y <= this.longitude - enemyShipSize; y++)
            {
                boolean fits = true;
                for (int tempY = y; tempY < y + enemyShipSize; tempY++)
                    if ((this.map[x][tempY] == 2) || (this.map[x][tempY] == 3))
                        fits = false;

                if (fits)
                {
                    for (int tempY = y; tempY < y + enemyShipSize; tempY++)
                        if (this.map[x][tempY] == 0)
                            this.chosen[x][tempY] = this.chosen[x][tempY] + 1;

                    boolean isHit = false;

                    for (int tempY = y; tempY < y + enemyShipSize; tempY++)
                        if (this.map[x][tempY] == 1)
                            isHit = true;

                    if (isHit)
                        for (int tempY = y; tempY < y + enemyShipSize; tempY++)
                            if (this.map[x][tempY] == 0)
                                this.chosen[x][tempY] = this.chosen[x][tempY] + this.availablecells;
                }
            }
            x = x + 1;
        }
    }


    private int calcshipSize(ArrayList<Integer> updatedEnemyShips) {
        int shipSize = -1;
        boolean done = true;

        for (Integer enemyShip : this.enemyShips)
            if (!updatedEnemyShips.contains(enemyShip)) {
                shipSize = (Integer) enemyShip;
                done = false;
            }

        if (done) shipSize = 3;
        return shipSize;
    }

    private void findShipWreck(int shipSize) {
        for (int x = 0; x <= this.longitude - shipSize; x++) 
        {
            boolean found = true;

            for (int tempX = x; tempX < x + shipSize; tempX++)
                if (this.map[tempX][this.lastY] != 1)
                    found = false;

            if (found)
                for (int tempX = x; tempX < x + shipSize; tempX++)
                    this.map[tempX][this.lastY] = 3;
        }

        for (int y = 0; y <= this.longitude - shipSize; y++) 
        {
            boolean found = true;

            for (int tempY = y; tempY < y + shipSize; tempY++)
                if (this.map[this.lastX][tempY] != 1)
                    found = false;

            if (found)
                for (int tempY = y; tempY < y + shipSize; tempY++)
                    this.map[this.lastX][tempY] = 3;
        }
    }

    public void adjustMapInfo(boolean hit, ArrayList<Integer> updatedEnemyShips) {

        if (!hit)
            //
            this.map[this.lastX][this.lastY] = 2;
        else if (this.enemyShips.size() == updatedEnemyShips.size())
            this.map[this.lastX][this.lastY] = 1;
        else {
            int shipSize = calcshipSize(updatedEnemyShips);
            this.enemyShips = updatedEnemyShips;
            this.map[this.lastX][this.lastY] = 1;
            findShipWreck(shipSize);
        }
    }

}
