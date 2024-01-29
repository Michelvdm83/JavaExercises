package playersguide.WarPreparations;

enum Material {
    wood,
    bronze,
    iron,
    steel,
    binarium
}

enum Gemstone {
    emerald,
    amber,
    sapphire,
    diamond,
    bitstone,
    none
}

record Sword(Material material, Gemstone gemstone, int length, int crossguardWidth) {
    public Sword withMaterial(Material material) {
        return new Sword(material, gemstone, length, crossguardWidth);
    }

    public Sword withGemstone(Gemstone gemstone) {
        return new Sword(material, gemstone, length, crossguardWidth);
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder(switch (material) {
            case iron -> "an iron";
            case wood -> "a wooden";
            default -> "a " + material;
        });
        returnString.append(" sword of ").append(length).append("cm long");
        returnString.append(", a crossguard width of ").append(crossguardWidth).append("cm");
        if (!gemstone.equals(Gemstone.none)) {
            returnString.append(", with an embedded ").append(gemstone);
        }
        return returnString.toString();
    }
}
/*
Objectives:

Swords can be made out of any of the following materials: wood, bronze, iron, steel, and the rare
binarium. Create an enumeration to represent the material type.
Gemstones can be attached to a sword, which gives them strange powers through Cygnus and Lyra’s
touch. Gemstone types include emerald, amber, sapphire, diamond, and the rare bitstone. Or no
gemstone at all. Create an enumeration to represent a gemstone type.
Create a Sword record with a material, gemstone, length, and crossguard width.
In your main program, create a basic Sword instance made out of iron and with no gemstone. Then
create two variations on the basic sword, defining methods in Sword that produce a modified copy, like Sword withMaterial(Material material).
Give sword a toString method that produces output like “a steel sword of 85 centimetres long, a crossguard width of 19 cm, and an embedded ruby” or “a plain binarium sword of 55 centimetres long and a crossguard width of 15 cm”
Display all three sword instances with code like System.out.println(original);.
 */