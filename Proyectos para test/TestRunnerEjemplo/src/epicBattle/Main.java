package epicBattle;

import java.sql.SQLOutput;

public class Main {
    public static void main(String [] args){
        Characters flor = new Human("Flor", ClassesType.MAGICIAN, Weapons.DAGGER);
        Characters juan = new Elves("Juan", ClassesType.ROGUE, Weapons.SWORD);

        System.out.println("Characters before the battle");
        System.out.println(flor);
        System.out.println(juan);

        Battle battle1 = new Battle();
        battle1.startBattle(flor, juan);

        System.out.println("Characters after the battle");
        System.out.println(flor);
        System.out.println(juan);
    }
}
