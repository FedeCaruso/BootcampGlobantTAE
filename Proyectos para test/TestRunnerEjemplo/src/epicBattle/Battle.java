package epicBattle;

public class Battle {
    public void chooseCharacters (Characters character1, Characters character2){
        character1.calculateFinalValues();
        character2.calculateFinalValues();
    }
    public void startBattle(Characters character1, Characters character2){
        character1.attack(character2);
        character2.attack(character1);


    }
}
