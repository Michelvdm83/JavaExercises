package PlayersGuide.ThePoint;

public class ThePoint {
    public static void main(String[] args){
        Point origin = Point.ORIGIN;
        Point first = new Point(2, 3);
        Point second = new Point(-4, 0);
        System.out.println(origin + "\n" + first + "\n" + second);
    }
}
