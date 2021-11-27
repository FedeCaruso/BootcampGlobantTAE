package epicBattle;

public enum ClassesType {
    MAGICIAN(0.2, -0.1),
    WARRIOR(0.1, 0.2),
    ROGUE(0.3, 0);

    private final double attackModiffier, defenseModiffier;

    ClassesType(double attackModiffier, double defenseModiffier) {
        this.attackModiffier = attackModiffier;
        this.defenseModiffier = defenseModiffier;
    }
    public double getAttackModiffier(){
        return attackModiffier;
    }
    public double getDefenseModiffier(){
        return defenseModiffier;
    }
}
