package epicBattle;

public abstract class Characters {
    private String alias;
    private double lifePoints;
    private double attackPoints;
    private double armorPoints;
    private Weapons weapons;
    private ClassesType classesType;

    public abstract void setAttributes();

    public void calculateFinalValues(){
        setAttackPoints(getAttackPoints()+getAttackPoints()*(getClassesType().getAttackModiffier()+getWeapons().getModifier()));
        setArmorPoints(getArmorPoints()+getArmorPoints()*getClassesType().getDefenseModiffier());
    }

    public void attack(Characters characters){
        double damage = getAttackPoints() - characters.getArmorPoints();
        if(getAttackPoints() >= characters.getArmorPoints()){
            characters.setArmorPoints(0);
            characters.setLifePoints(characters.getLifePoints()-damage);
        }
        else{
            characters.setArmorPoints(-damage);
        }
    }

    @Override
    public String toString() {
        return "Characters{" +
                "alias='" + alias + '\'' +
                ", lifePoints=" + lifePoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints +
                ", weapons=" + weapons +
                ", classesType=" + classesType +
                '}';
    }

    //getters y setters
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }

    public double getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public double getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(double armorPoints) {
        this.armorPoints = armorPoints;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public ClassesType getClassesType() {
        return classesType;
    }

    public void setClassesType(ClassesType classesType) {
        this.classesType = classesType;
    }
}