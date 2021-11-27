package epicBattle;

public class Human extends Characters {
    public Human(String alias, ClassesType classesType, Weapons weapons){
        setAlias(alias);
        setWeapons(weapons);
        setClassesType(classesType);
        setAttributes();
    }
    @Override
    public void setAttributes(){
        setLifePoints(50);
        setAttackPoints(8);
        setArmorPoints(10);
    }
}
