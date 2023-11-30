package PlayersGuide.TheCard;

import java.util.ArrayList;

public class TheCard {
    public static void main(String[] args){
        //Card[] deck = new Card[Color.values().length * Rank.values().length];
        ArrayList<Card> deck = new ArrayList<>();
        for(Color c: Color.values()){
            for(Rank r: Rank.values()){
                deck.add(new Card(c.toString(), r.toString()));
            }
        }
        deck.forEach(c -> System.out.println(c.toString()));
    }
}
