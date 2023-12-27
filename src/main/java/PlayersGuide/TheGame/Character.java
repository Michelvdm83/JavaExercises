package PlayersGuide.TheGame;

public class Character {
    private final String NAME;
    private final CharacterType TYPE;
    private final int MAX_HP;
    private final AttackAction STANDARD_ATTACK;
    private int currentHP;
    private Weapon weapon = null;

    public Character(String name, CharacterType type) {
        NAME = name;
        TYPE = type;
        MAX_HP = type.getMAX_HP();
        STANDARD_ATTACK = type.getSTANDARD_ATTACK();
        currentHP = MAX_HP;
        if (type == CharacterType.TRUE_PROGRAMMER) weapon = Weapon.SWORD;
    }

    public static Character createSkeleton(int numberInName) {
        String newName = "SKELETON".concat(" " + numberInName);
        return new Character(newName, CharacterType.SKELETON);
    }

    public void doNothing() {
        System.out.println(NAME + " did NOTHING.");
    }

    public void useItem(Potion item) {
        item.useOn(this);
    }

    public Weapon equipWeapon(Weapon weapon) {
        Weapon returnWeapon = this.weapon;
        this.weapon = weapon;
        return returnWeapon;
    }

    public void getHealed(int healingAmount) {
        currentHP += healingAmount;
        if (currentHP > MAX_HP) {
            currentHP = MAX_HP;
        }
    }

    public AttackAction getAttackType() {
        return STANDARD_ATTACK;
    }

    public void attack(Character opponent) {
        int damage = STANDARD_ATTACK.calculateDMG();
        System.out.println(NAME + " used " + STANDARD_ATTACK + " on " + opponent.getNAME() + "!");
        System.out.println(STANDARD_ATTACK + " dealt " + damage + " damage to " + opponent.getNAME());
        opponent.getHit(damage);
    }

    public void weaponAttack(Character opponent) {
        if (weapon != null) {
            int damage = weapon.getAttackAction().calculateDMG();
            System.out.println(NAME + " attacked " + opponent.getNAME() + " with his " + weapon + "!");
            System.out.println("His " + weapon.getAttackAction() + " attack " + " dealt " + damage + " damage to " + opponent.getNAME());
            opponent.getHit(damage);
        }
    }

    public void getHit(int damage) {
        currentHP -= damage;
        if (currentHP < 0) currentHP = 0;
        System.out.printf("%s is now at %d/%d HP%n", NAME, currentHP, MAX_HP);
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public String getNAME() {
        return NAME;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}

class TrueProgrammer extends Character {
    public TrueProgrammer(String name) {
        super(name, CharacterType.TRUE_PROGRAMMER);
    }
}