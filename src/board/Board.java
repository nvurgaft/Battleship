package board;

public class Board {

    private Point[][] board;

    public Board() {
        board = new Point[10][10];
    }

    public void hit(int x, int y) {
        this.board[x][y].setHit(true);
    }

    public void occupy(int x, int y) {
        this.board[x][y].setOccupied(true);
    }

    public boolean isOccupied(int x, int y) {
        return this.board[x][y].isOccupied();
    }

    public boolean isHit(int x, int y) {
        return this.board[x][y].isHit();
    }

    public void resetBoard() {
        board = new Point[10][10];
    }
}
