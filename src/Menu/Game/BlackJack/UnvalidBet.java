package Menu.Game.BlackJack;

public class UnvalidBet extends Exception {
    public UnvalidBet() {
        super("Veuillez miser une valeur inférieur à votre solde et supérieur à 0 ! ");
    }
}