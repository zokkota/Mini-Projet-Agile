package Menu.Game;

import Menu.Game.BlackJack.Player;
import Menu.Game.BlackJack.Players;
import Menu.Game.BlackJack.UnvalidBet;

public interface Game {
    public void start(Player player , Players players) throws UnvalidBet;
}
