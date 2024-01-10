package PlayersGuide.TheGame;

public class Character {
    private final String NAME;
    private final CharacterType TYPE;
    private final int MAX_HP;
    private final AttackAction STANDARD_ATTACK;
    private final DefensiveBuff defensiveBuff;
    private final DamageType vulnerability;
    private int currentHP;
    private Weapon weapon;

    public Character(String name, CharacterType type) {
        NAME = name;
        TYPE = type;
        MAX_HP = type.getMAX_HP();
        STANDARD_ATTACK = type.getSTANDARD_ATTACK();
        currentHP = MAX_HP;
        weapon = switch (type) {
            case TRUE_PROGRAMMER -> Weapon.SWORD;
            case VIN_FLETCHER -> Weapon.VINS_BOW;
            default -> null;
        };
        defensiveBuff = switch (type) {
            case STONE_AMAROK -> DefensiveBuff.STONE_ARMOR;
            case TRUE_PROGRAMMER -> DefensiveBuff.OBJECT_SIGHT;
            default -> null;
        };
        vulnerability = switch (type) {
            case THE_UNCODED_ONE -> DamageType.CODING;
            case VIN_FLETCHER -> DamageType.DECODING;
            default -> null;
        };
    }

    public void doNothing() {
        System.out.println(NAME + " did NOTHING.");
    }

    public void usePotion(Potion potion) {
        potion.useOn(this);
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
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

    public String attack(Character opponent, boolean withWeapon) {
        StringBuilder returnString = new StringBuilder();
        AttackAction attackAction = withWeapon ? weapon.getAttackAction() : STANDARD_ATTACK;
        if (hasAttackHit(attackAction)) {
            String attackString = withWeapon ? NAME + " attacked " + opponent.getNAME() + " with his/her " + weapon + "!"
                    : NAME + " used " + STANDARD_ATTACK + " on " + opponent.getNAME() + "!";
            returnString.append(attackString).append("\n");
            int damage = attackAction.calculateDMG();
            DamageType damageType = attackAction.getDAMAGE_TYPE();
            int finalDamage = opponent.getHit(damage, damageType);
            String damageString = NAME + "'s " + attackAction + " attack dealt " + finalDamage + " damage to " + opponent.getNAME() + "\n";
            returnString.append(damageString);
            returnString.append(opponent.tellCurrentHP());
        } else {
            returnString.append(NAME).append(" missed!\n");
        }
        return returnString.toString();
    }

    private String tellCurrentHP() {
        //"%s is now at %d/%d HP%n", NAME, currentHP, MAX_HP
        return NAME + " is now at " + currentHP + "/" + MAX_HP + "\n";
    }

    public void attack(Character opponent) {
        if (hasAttackHit(STANDARD_ATTACK)) {
            int damage = STANDARD_ATTACK.calculateDMG();
            DamageType damageType = STANDARD_ATTACK.getDAMAGE_TYPE();
            System.out.println(NAME + " used " + STANDARD_ATTACK + " on " + opponent.getNAME() + "!");
            int finalDamage = opponent.getHit(damage, damageType);
            System.out.println(STANDARD_ATTACK + " dealt " + finalDamage + " damage to " + opponent.getNAME());
            opponent.showHP();
        } else {
            System.out.println(NAME + " missed!");
        }
    }

    public void weaponAttack(Character opponent) {
        if (weapon != null) {
            AttackAction attack = weapon.getAttackAction();
            DamageType damageType = attack.getDAMAGE_TYPE();
            if (hasAttackHit(attack)) {
                int damage = attack.calculateDMG();
                System.out.println(NAME + " attacked " + opponent.getNAME() + " with his " + weapon + "!");
                int finalDamage = opponent.getHit(damage, damageType);
                System.out.println(NAME + "'s " + attack + " attack " + " dealt " + finalDamage + " damage to " + opponent.getNAME());
                opponent.showHP();
            } else {
                System.out.println(NAME + " missed!");
            }
        }
    }

    private boolean hasAttackHit(AttackAction attack) {
        return attack.attackHit();
    }

    public int getHit(int initialDamage, DamageType damageType) {
        if (initialDamage == 0) return initialDamage;
        int finalDamage = initialDamage;
        if (defensiveBuff != null) {
            if (defensiveBuff.isResistantTo(damageType)) {
                int damageReduction = defensiveBuff.getDAMAGE_REDUCTION();
                if (damageReduction > initialDamage) {
                    damageReduction = initialDamage;
                }
                finalDamage = initialDamage - damageReduction;
                System.out.println(defensiveBuff + " reduced the Damage by " + damageReduction);
            }
        }
        if (vulnerability != null) {
            if (vulnerability == damageType) {
                finalDamage++;
                System.out.println(NAME + " is vulnerable to " + damageType + " damage!");
            }
        }
        currentHP -= finalDamage;
        if (currentHP < 0) currentHP = 0;
        return finalDamage;
    }

    public void showHP() {
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

    public CharacterType getTYPE() {
        return TYPE;
    }
}

