package epicBattle;

public class Orcs extends Characters {
    public Orcs (String alias, ClassesType classesType, Weapons weapons){
        setAlias(alias);
        setWeapons(weapons);
        setClassesType(classesType);
        setAttributes();
    }
    @Override
    public void setAttributes(){
        setLifePoints(80);
        setAttackPoints(3);
        setArmorPoints(15);
    }

}
