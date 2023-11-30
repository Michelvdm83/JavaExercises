package PlayersGuide.TheCard;

enum Color{
    Red,
    Green,
    Blue,
    Yellow
}
enum Rank{
    One,
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Dollar,
    Percent,
    Caret,
    Ampersand
}
public class Card {
    private final Color color;
    private final Rank rank;

    public Card(String color, String rank){
        this.color = Color.valueOf(color);
        this.rank = Rank.valueOf(rank);
    }

    public String toString(){
        return "The " + color + " " + rank;
    }
}
