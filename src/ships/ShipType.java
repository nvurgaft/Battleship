package ships;

public enum ShipType {
    CARRIER ("Aircraft Carrier"), // length of 5
    BATTLESHIP ("Battleship"), // length of 4
    DESTROYER ("Destroyer"), // length of 3
    BOAT ("Patrol Boat"); // length of 2

    private String type;

    ShipType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Ship Type: " + type;
    }
}
