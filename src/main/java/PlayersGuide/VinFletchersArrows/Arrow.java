package PlayersGuide.VinFletchersArrows;

public class Arrow {
    enum ArrowHead{
        STEEL,
        WOOD,
        OBSIDIAN
    }
    enum Fletching{
        PLASTIC,
        TURKEY_FEATHERS,
        GOOSE_FEATHERS
    }
    private final int arrowLength;
    private final Fletching fletching;
    private final ArrowHead arrowHead;
    public Arrow(int length, String arrowHead, String fletching){
        arrowLength = length;
        this.arrowHead = ArrowHead.valueOf(arrowHead);
        this.fletching = Fletching.valueOf(fletching);
    }
    public static Arrow createEliteArrow(){
        return new Arrow(95, "STEEL", "PLASTIC");
    }
    //The Beginner Arrow, made from a wood arrowhead, goose feathers, and a 75 cm shaft.
    public static Arrow createBeginnerArrow(){
        return new Arrow(75, "WOOD", "GOOSE_FEATHERS");
    }
    //The Marksman Arrow, made from a steel arrowhead, goose feathers, and a 65 cm shaft.
    public static Arrow createMarksmanArrow(){
        return new Arrow(65, "STEEL", "GOOSE_FEATHERS");
    }
    public float getCost(){
        float cost = 0.0f;
        cost += switch(arrowHead){
            case STEEL -> 10;
            case WOOD -> 3;
            case OBSIDIAN -> 5;
        };
        cost += switch(fletching){
            case PLASTIC -> 10;
            case TURKEY_FEATHERS -> 5;
            case GOOSE_FEATHERS -> 3;
        };
        cost += (float)(arrowLength * 0.05);
        return cost;
    }

    public String getFletching(){
        return fletching.toString();
    }
    public String getArrowHead(){
        return arrowHead.toString();
    }
    public int getArrowLength(){
        return arrowLength;
    }
}
