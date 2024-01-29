package playersguide.SimulasSoup;

public class Soup {
    enum Type {
        SOUP,
        STEW,
        GUMBO
    }

    enum MainIngredient {
        MUSHROOM,
        CHICKEN,
        CARROTS,
        POTATO
    }

    enum Seasoning {
        SPICY,
        SALTY,
        SWEET
    }

    private Type type = Type.SOUP;
    private MainIngredient ingredient = MainIngredient.CHICKEN;
    private Seasoning seasoning = Seasoning.SWEET;

    public Soup() {
        System.out.println("Default dish is: " + this);
    }

    public String toString() {
        return seasoning + " " + ingredient + " " + type;
    }

    void setType(Type type) {
        this.type = type;
    }

    void setIngredient(MainIngredient ingredient) {
        this.ingredient = ingredient;
    }

    void setSeasoning(Seasoning seasoning) {
        this.seasoning = seasoning;
    }
}
/*
type (soup, stew, gumbo), main ingredient
(mushrooms, chicken, carrots, potatoes), and seasoning (spicy, salty, sweet)
 */
