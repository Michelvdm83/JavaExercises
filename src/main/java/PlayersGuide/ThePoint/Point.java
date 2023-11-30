package PlayersGuide.ThePoint;

public class Point {
    //not private means they are mutable,
    // private == immutable externally, needs setters
    // final means immutable, but can be read without getters
    private final int x;
    private final int y;
    public static final Point ORIGIN = new Point(0,0);

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
