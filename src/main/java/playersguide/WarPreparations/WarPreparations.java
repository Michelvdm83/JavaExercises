package playersguide.WarPreparations;

public class WarPreparations {
    public static void main(String[] args) {
        Sword basicSword = new Sword(Material.iron, Gemstone.none, 60, 15);
        Sword swordMaterialUpgrade = basicSword.withMaterial(Material.binarium);
        Sword basicSwordWithGemstone = basicSword.withGemstone(Gemstone.sapphire);
        System.out.println(basicSword);
        System.out.println(swordMaterialUpgrade);
        System.out.println(basicSwordWithGemstone);
    }
}
