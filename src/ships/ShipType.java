package ships;

public enum ShipType {
    CARRIER ("Aircraft Carrier"),
    BATTLESHIT ("Battleship"),
    DESTROYER ("Destroyer"),
    BOAT ("Patrol Boat");

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
