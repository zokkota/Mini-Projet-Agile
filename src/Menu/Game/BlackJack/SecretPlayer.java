package Menu.Game.BlackJack;

public class SecretPlayer extends Player{
	
	public SecretPlayer(String name) {
		super(1000,name,10);
	}
	
	public void bourseWin(int coins) {
		this.setBourse(this.getBourse() + coins*2);
	}
	
	public void bourseLose(int coins) {
		this.setBourse((int) (this.getBourse() - coins*0.5));
	}

	
	
	
}
