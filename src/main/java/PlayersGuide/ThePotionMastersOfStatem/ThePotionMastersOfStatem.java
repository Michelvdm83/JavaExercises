package PlayersGuide.ThePotionMastersOfStatem;

import java.util.Scanner;

public class ThePotionMastersOfStatem {
    enum Ingredient {
        STARDUST,
        SNAKE_VENOM,
        DRAGON_BREATH,
        SHADOW_GLASS,
        EYESHINE_GEM
    }

    enum PotionType {
        WATER,
        ELIXER,
        POISON_POTION,
        FLYING_POTION,
        INVISIBILITY_POTION,
        NIGHT_SIGHT_POTION,
        CLOUDY_BREW,
        WRAITH_POTION,
        RUINED_POTION;

        //this can also be made an abstract method and then implemented in each state separately
        PotionType addIngredient(Ingredient ingredient) {
            return switch (this) {
                case WATER -> ingredient.equals(Ingredient.STARDUST) ? PotionType.ELIXER : PotionType.RUINED_POTION;
                case ELIXER -> {
                    if (ingredient.equals(Ingredient.SNAKE_VENOM)) yield PotionType.POISON_POTION;
                    else if (ingredient.equals(Ingredient.DRAGON_BREATH)) yield PotionType.FLYING_POTION;
                    else if (ingredient.equals(Ingredient.SHADOW_GLASS)) yield PotionType.INVISIBILITY_POTION;
                    else if (ingredient.equals(Ingredient.EYESHINE_GEM)) yield PotionType.NIGHT_SIGHT_POTION;
                    else yield PotionType.RUINED_POTION;
                }
                case INVISIBILITY_POTION ->
                        ingredient.equals(Ingredient.EYESHINE_GEM) ? PotionType.CLOUDY_BREW : PotionType.RUINED_POTION;
                case NIGHT_SIGHT_POTION ->
                        ingredient.equals(Ingredient.SHADOW_GLASS) ? PotionType.CLOUDY_BREW : PotionType.RUINED_POTION;
                case CLOUDY_BREW ->
                        ingredient.equals(Ingredient.STARDUST) ? PotionType.WRAITH_POTION : PotionType.RUINED_POTION;
                default -> PotionType.RUINED_POTION;
            };
        }
    }

    public static void main(String[] args) {
        ThePotionMastersOfStatem potionMaker = new ThePotionMastersOfStatem();
        potionMaker.run();
    }

    private PotionType potion;
    private final Scanner input;

    public ThePotionMastersOfStatem() {
        potion = PotionType.WATER;
        input = new Scanner(System.in);
    }

    public void run() {
        boolean potionCompleted = false;
        while (!potionCompleted) {
            String potionText = potion.name().replace("_", " ").toLowerCase();
            System.out.println("Your current potion: " + potionText);
            Ingredient[] ingredients = Ingredient.values();
            for (Ingredient ingredient : ingredients) {
                System.out.println(ingredient.name().replace("_", " ").toLowerCase());
            }
            System.out.print("Please choose from the above ingredients which to add: ");
            String choice = input.nextLine().replace(" ", "_").toUpperCase();
            try {
                Ingredient ingredient = Ingredient.valueOf(choice);
                potion = potion.addIngredient(ingredient);
                System.out.println("Adding " + ingredient.name().replace("_", " ").toLowerCase()
                        + " was succesfull!");
                System.out.println("You now have: " + potion.name().replace("_", " ").toLowerCase());
            } catch (IllegalArgumentException e) {
                System.out.println("This is not a possible ingredient!");
                continue;
            }
            if (potion.equals(PotionType.RUINED_POTION)) {
                System.out.println("You ruined your potion!");
                System.out.println("Please try again.");
                potion = PotionType.WATER;
                continue;
            }
            System.out.print("Do you want to complete your potion? ");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("YES")) potionCompleted = true;
        }
    }

    //This could be done in the Enum with functions
/*    private void addIngredient(Ingredient ingredient) {
        potion = switch (potion) {
            case WATER -> ingredient.equals(Ingredient.STARDUST) ? PotionType.ELIXER : PotionType.RUINED_POTION;
            case ELIXER -> {
                if (ingredient.equals(Ingredient.SNAKE_VENOM)) yield PotionType.POISON_POTION;
                else if (ingredient.equals(Ingredient.DRAGON_BREATH)) yield PotionType.FLYING_POTION;
                else if (ingredient.equals(Ingredient.SHADOW_GLASS)) yield PotionType.INVISIBILITY_POTION;
                else if (ingredient.equals(Ingredient.EYESHINE_GEM)) yield PotionType.NIGHT_SIGHT_POTION;
                else yield PotionType.RUINED_POTION;
            }
            case INVISIBILITY_POTION ->
                    ingredient.equals(Ingredient.EYESHINE_GEM) ? PotionType.CLOUDY_BREW : PotionType.RUINED_POTION;
            case NIGHT_SIGHT_POTION ->
                    ingredient.equals(Ingredient.SHADOW_GLASS) ? PotionType.CLOUDY_BREW : PotionType.RUINED_POTION;
            case CLOUDY_BREW ->
                    ingredient.equals(Ingredient.STARDUST) ? PotionType.WRAITH_POTION : PotionType.RUINED_POTION;
            default -> PotionType.RUINED_POTION;
        };
    }
 */
}
