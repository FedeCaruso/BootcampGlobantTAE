package epicBattle;

public class Elves extends Characters {
    public Elves(String alias, ClassesType classesType, Weapons weapons) {
        setAlias(alias);
        setWeapons(weapons);
        setClassesType(classesType);
        setAttributes();
    }

    public void setAttributes(){
        setLifePoints(70);
        setAttackPoints(8);
        setArmorPoints(8);
    }
}

