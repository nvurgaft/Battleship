package ships;

import board.Point;

import java.util.logging.Logger;

public abstract class Ship extends Sprite {

    public static Logger logger = Logger.getLogger(Ship.class.getName());

    private ShipType shipType;
    private int length;
    private Point[] position;
    private boolean isAfloat;
    private int hitPoints;

    public Ship(Sprite sprite, ShipType type) {
        super(sprite.getImage(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        this.shipType = type;
        isAfloat = true;
        switch (shipType) {
            case CARRIER:
                this.hitPoints = 5;
                break;
            case BATTLESHIP:
                this.hitPoints = 4;
                break;
            case DESTROYER:
                this.hitPoints = 3;
                break;
            case BOAT:
                this.hitPoints = 2;
                break;
            default:
                logger.warning("Invalid ship type value");
        }
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public void positionOnBoard(Point[] position) {

    }

    public boolean isAfloat() {
        return this.isAfloat;
    }

    public void hit() {
        this.hitPoints--;
        if (this.hitPoints==0) {
            this.sinkShip();
        }
    }

    private void sinkShip() {
        this.isAfloat = false;
    }
}