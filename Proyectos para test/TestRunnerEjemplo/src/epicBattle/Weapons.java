package epicBattle;

public enum Weapons {
    SCREPTER(0.015),
    SWORD(0.02),
    DAGGER(0.012);

    private final double modifier;

    Weapons(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier(){
        return modifier;
    }
}
