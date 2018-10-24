import entity.Ship;

public class Main {
    public static void main(String[] args) {
        Ship ship1 = new Ship(100, 50);
        Ship ship2 = new Ship(100, 50);
        Ship ship3 = new Ship(100, 50);
        Ship ship4 = new Ship(100, 50);
        Ship ship5 = new Ship(100, 50);

        new Thread(ship1).start();
        new Thread(ship2).start();
        new Thread(ship3).start();
        new Thread(ship4).start();
        new Thread(ship5).start();
    }
}
