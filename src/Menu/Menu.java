package Menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Menu.Game.BlackJack.Player;
import Menu.Game.BlackJack.Players;
import Menu.Game.BlackJack.RoyalCrous;
import Menu.Game.BlackJack.SecretPlayer;
import Menu.Game.BlackJack.UnvalidBet;
import Menu.Game.Roulette.Roulette;





public class Menu {
	private static Players players= new Players();
	private static Player p1;
	private static List<String> secretPlayer= new ArrayList<String>();

	//Couleurs
	public static final String ANSI_RESET = "\u001B[0m";
	//public static final String ANSI_BLACK_BG = "\u001B[40m";
	public static final String ANSI_BLACK_BG = "\033[47m"; // WHITE (pour black)
	public static final String ANSI_RED_BG = "\u001B[41m";
	public static final String ANSI_GREEN_BG = "\033[42m";



	private static Scanner userInput = new Scanner(System.in);




	public static void main(String[] args) throws IOException, InterruptedException{
		titleMenu();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		players.loadPlayers();
		boolean exit = false;
		String input;
		while(!exit) {
			clear();
			mainMenu();
			input = userInput.nextLine();
			clear();
			switch (input) {
			case "1": {
				try {
					playMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}	
			
			case "2":{
				exitMenu();
				exit = true;
				break;
			}
			default:
				break;
			}
		}
		userInput.close();
	}



	public static void exitMenu() {
		System.out.println("Merci d'avoir joué !");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void LoadingMenu() throws InterruptedException, IOException {
		System.out.println("Loading game...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		boolean exit = false;
		String input;
		while(!exit) {
			clear();

			String [] best=new String [5];
			for (int i = 0; i < best.length; i++) {
				best[i]="n°"+Integer.sum(i, 1)+" no one";
			}
			Collections.sort(players.getPlayers());
			for (int i = 0; i < players.getPlayers().size(); i++) {
				best[i]="n°"+Integer.sum(i, 1)+" "+players.getPlayers().get(i).toString();
				if(i==4)break;
			}


			System.out.print("╔━╤━━━━━━━━━━━━╗\n"
					+"┃1┃ BlackJack  ┃\n"
					+"╠═╬════════════╣\n"
					+"┃2┃ Roulette   ┃\n"
					+"╠═╬════════════╣\n"
					+"┃3┃ Back       ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Faites un choix : ");
			
			input = userInput.nextLine();
			if(Integer.valueOf(input) == 3 ) {
				playMenu();
			}
			play(input);
			exit=true;


		}
	}

	private static void titleMenu() throws InterruptedException {
		
		System.out.println(
		 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
		+"┃ Tu es un jeune bachelier, le jour de ta rentrée tu n'as pas reçu ta bourse     								   			    ┃\n"
		+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━═╝\n");
		TimeUnit.SECONDS.sleep(3);

		System.out.println(
		 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
		+"┃ Malheuresement cette argent devait servir a soigner ton perroquet              								   		        ┃\n"
		+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━═╝\n");
		TimeUnit.SECONDS.sleep(3);

		System.out.println(
		 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
		+"┃ A cause de ce retard, PIOU-PIOU est mort                                      								   			    ┃\n"
		+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━═╝\n");
		TimeUnit.SECONDS.sleep(3);

		System.out.println(
		 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
		+"┃ Tu n'as qu'une idée en tête, te venger de cette organisation maléfique       											    ┃\n"
		+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━═╝\n");
		TimeUnit.SECONDS.sleep(3);

		System.out.println(
		 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
		+"┃ Ton plan est d'aller au casino avec l'argent du Crous (reçu en retard) pour acheter un BAZOOKA et détruire les méchants     ┃\n"
		+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━═╝\n");
		TimeUnit.SECONDS.sleep(3);

		System.out.println(
		 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
		+"┃ L'armurier de Los Santos t'a dit que le BAZZOKA valait 8000 jetons !                                                        ┃\n"
		+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━═╝\n");
		TimeUnit.SECONDS.sleep(5);
		
		System.out.println(Roulette.ANSI_RED_BG+"░░▒▒▒▒▓▓▒▒▒▒▒▒▒▒░░░░▒▒▓▓██▓▓░░▒▒░░░░▒▒░░░░▓▓░░░░▒▒▒▒▓▓▒▒▒▒▒▒░░░░░░▒▒░░▒▒░░▒▒░░▒▒░░░░▒▒  ▒▒▒▒░░░░▒▒▒▒▒▒░░░░    ▒▒▒▒▒▒  ░░▒▒░░▓▓▓▓▒▒▒▒░░▒▒▒▒░░▒▒██▓▓▓▓▒▒░░░░░░░░▓▓▓▓▓▓▓▓▓▓░░  ▒▒▓▓▓▓░░░░\n" + 
				"▒▒▒▒▓▓▓▓░░░░░░▒▒▒▒▓▓░░  ▓▓▒▒▒▒░░    ▒▒▒▒▒▒▒▒▒▒░░▒▒░░▒▒▓▓░░▒▒░░░░░░░░▒▒  ▒▒▒▒░░░░░░░░▒▒░░░░░░░░░░            ░░  ▓▓▒▒  ░░▒▒░░▒▒▓▓▒▒  ▒▒▒▒░░░░▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓██░░  ▒▒▒▒▒▒▒▒  ░░▒▒\n" + 
				"▒▒▓▓▓▓▒▒░░░░░░░░░░▓▓▓▓▓▓░░░░░░░░    ░░▒▒▒▒▒▒▒▒▒▒░░░░▓▓▓▓▓▓▒▒░░░░░░░░░░░░▒▒▒▒░░░░░░▒▒▒▒▒▒  ▒▒░░░░            ░░░░▒▒▒▒░░▒▒░░▓▓▓▓▓▓  ▒▒▒▒░░░░░░░░▒▒▓▓▓▓██▓▓▒▒▒▒▒▒▒▒░░  ░░▓▓▓▓░░░░▒▒▒▒░░░░\n" + 
				"▒▒▓▓▓▓░░▒▒▒▒░░░░▒▒▒▒░░▒▒▓▓▓▓░░  ░░░░  ░░░░░░▒▒▒▒▒▒░░▓▓▓▓▓▓▒▒░░░░░░░░░░░░▒▒░░▒▒░░░░▒▒▒▒▒▒  ▒▒░░  ░░  ▒▒▒▒▓▓  ░░░░  ▒▒▒▒░░▒▒▓▓██░░░░▒▒░░░░░░░░░░░░▒▒▓▓▓▓▓▓▓▓░░░░  ░░░░░░░░░░░░░░░░░░░░  \n" + 
				"▓▓▓▓▒▒░░▒▒▒▒▒▒▓▓▒▒▒▒░░░░░░▒▒▓▓▓▓░░░░▒▒▒▒░░░░▒▒░░▒▒▒▒  ▓▓██▒▒░░░░░░░░░░▓▓▒▒▒▒░░░░░░░░▒▒▒▒  ▒▒▒▒  ░░  ▒▒▓▓▒▒▒▒░░░░░░▒▒▒▒░░▒▒▓▓▒▒░░▒▒    ░░░░  ░░░░░░▒▒▓▓▓▓░░  ▒▒▒▒░░░░░░  ▒▒░░▒▒▒▒      \n" + 
				"▓▓▒▒▒▒░░░░░░▓▓▓▓▒▒▒▒░░▒▒░░░░░░▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒  ▓▓▒▒░░░░▒▒░░  ▓▓▒▒▒▒░░░░░░░░░░░░  ▒▒▒▒  ░░  ▒▒▓▓▒▒▒▒░░░░░░▒▒▓▓  ██▒▒░░▒▒▒▒░░░░░░░░▒▒░░░░░░░░░░  ▒▒▒▒▒▒▒▒░░  ░░░░░░▓▓░░░░░░    \n" + 
				"▓▓▒▒▒▒▒▒░░▓▓▒▒▓▓▒▒▒▒░░░░░░▒▒░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒░░▒▒▒▒  ▒▒░░░░▒▒▒▒░░▒▒░░▒▒░░░░░░░░░░░░░░░░▒▒░░░░    ▒▒░░  ░░░░  ▒▒▒▒  ▓▓░░▒▒▒▒░░░░░░░░▒▒▓▓▒▒░░    ▒▒▒▒▒▒░░▒▒▓▓▒▒░░  ▒▒▒▒▓▓▓▓░░░░    \n" + 
				"░░▒▒▒▒░░▒▒▓▓▓▓▓▓▒▒▒▒░░  ░░░░░░▒▒▒▒░░░░▒▒▒▒▒▒░░  ░░░░  ▓▓░░▒▒▒▒▒▒▒▒░░▒▒▒▒░░▒▒  ░░░░░░░░  ░░░░░░░░░░  ░░            ░░▒▒  ▒▒░░░░░░░░░░░░░░▒▒▓▓░░  ▒▒░░▒▒░░░░  ░░▓▓▓▓░░▒▒▓▓░░▒▒▒▒▓▓░░░░  \n" + 
				"░░░░▒▒░░▒▒▓▓██▓▓▒▒░░░░░░▒▒░░  ▒▒░░▒▒░░░░░░▒▒░░▓▓░░  ░░░░▒▒▓▓▒▒░░░░░░▓▓▓▓░░░░░░  ░░░░░░      ░░░░░░  ░░      ░░░░▒▒▒▒░░  ░░▓▓▒▒░░░░░░░░  ░░  ▒▒░░▒▒░░░░  ░░  ░░▓▓▓▓▒▒░░░░░░▓▓▒▒▓▓▓▓▒▒  \n" + 
				"▒▒░░▓▓██▓▓██▓▓▒▒░░░░░░░░░░▒▒▒▒░░  ░░▒▒░░▒▒░░░░░░░░░░      ░░░░      ░░░░░░▒▒░░░░░░  ░░░░░░  ▒▒░░░░░░░░░░      ░░        ░░░░  ░░░░▒▒░░  ▓▓▒▒▒▒░░░░  ░░░░    ░░▓▓▓▓▒▒░░░░░░▒▒▓▓▓▓▓▓▒▒  \n" + 
				"▒▒░░▒▒▓▓▓▓██▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒░░    ░░░░░░░░  ░░  ░░                    ░░  ░░░░░░░░░░░░  ▒▒░░    ░░▒▒░░                      ░░  ▒▒  ▒▒░░░░░░░░░░        ▒▒▓▓▒▒▓▓░░░░░░░░░░████▒▒  \n" + 
				"▒▒▒▒▒▒▓▓▓▓▒▒░░░░░░▒▒░░░░▒▒▒▒▒▒▒▒  ░░░░░░░░░░░░▒▒  ░░                          ░░░░░░░░▒▒░░▒▒▒▒░░▒▒▓▓▒▒                              ░░▒▒    ░░      ░░░░    ░░▒▒▒▒▓▓▒▒░░▒▒▒▒▓▓██▒▒▒▒░░\n" + 
				"▒▒░░▒▒▒▒▒▒▓▓░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░                                  ░░▒▒░░░░░░  ▒▒░░▓▓▒▒                                      ▒▒░░░░  ▒▒▒▒▒▒▒▒    ▒▒▒▒▓▓▓▓░░░░▓▓██▓▓██▓▓▒▒\n" + 
				"░░░░░░░░▒▒▓▓▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░                                      ▓▓▒▒▒▒░░░░▒▒▒▒                                        ░░      ▒▒▓▓▒▒▒▒    ░░▒▒▓▓▓▓░░░░░░░░▒▒░░░░░░\n" + 
				"░░▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒░░                                        ░░▓▓░░░░▒▒▒▒                                            ▒▒    ▒▒▒▒▒▒░░  ░░  ░░▒▒▒▒▒▒░░░░░░▒▒░░  ▓▓\n" + 
				"▒▒░░██▓▓▓▓▒▒░░░░▒▒▒▒▒▒▒▒░░▒▒▒▒░░░░░░░░░░░░░░                                          ░░░░▒▒▒▒                                              ░░          ░░░░░░  ▒▒  ▒▒▒▒▒▒▓▓░░░░░░░░▒▒\n" + 
				"░░▒▒▓▓██▓▓▒▒  ░░░░░░▒▒▒▒▒▒▒▒░░▒▒▒▒░░░░▒▒░░                                              ░░▓▓  ░░                                              ▒▒    ░░░░░░░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒\n" + 
				"▒▒▒▒████▒▒░░░░░░  ░░░░░░▒▒▒▒▒▒▒▒░░▒▒░░░░░░                                                  ░░                                                ░░  ░░░░░░░░░░▒▒▒▒▓▓▒▒░░░░▓▓░░░░░░░░▒▒▓▓\n" + 
				"██████▓▓▒▒░░░░░░░░░░▒▒▒▒░░░░▒▒▒▒▒▒▒▒▓▓░░                                                                                                        ▒▒    ░░▒▒▒▒▓▓▒▒░░░░▒▒▓▓▓▓░░▒▒▓▓░░▓▓▓▓\n" + 
				"░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░  $$$$$$$$                            $$$        $$$$$$\\                                               ░░░░▒▒▒▒▒▒▒▒    ░░░░▒▒▓▓▒▒▒▒░░░░░░▒▒▓▓\n" + 
				"▒▒░░▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒░░  $$  __$$$                           $$ |      $$  __$$\\                                                ▒▒▒▒▒▒  ░░░░  ░░░░  ░░░░░░░░░░░░░░░░\n" + 
				"░░░░▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒░░░░░░░░░░  ▒▒    $$ |  $$ |$$$$$$$ $$$   $$$ $$$$$$$ $$ |      $$ l  l__|$$$$$$$  $$$$$$$ $$$   $$$ $$$$$$$$             ░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓▓▓\n" + 
				"░░░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░  ▒▒    $$$$$$$  $$  __$$$$$ |  $$ |$____$$$$$ |      $$ |     $$  __$$l$$  __$$l$$ |  $$ $$  _____|          ░░  ▒▒██▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒\n" + 
				"░░░░▓▓▒▒▒▒  ░░░░░░░░░░░░░░░░░░      ▒▒    $$  __$$<$$ $  $$ $$ |  $$ |$$$$$$$ $$ |      $$ |     $$ |  l__$$ /  $$ $$ |  $$ l$$$$$$l            ░░░░░░░░░░  ░░░░░░░░░░▒▒▓▓▒▒░░░░░░░░▒▒\n" + 
				"▒▒▓▓▓▓▒▒▒▒░░  ░░░░░░▒▒▒▒░░          ▒▒    $$ |  $$ $$ |  $$ $$ |  $$ $$  __$$ $$ |      $$ |  $$l$$ |     $$ |  $$ $$ |  $$ |l____$$l           ░░░░░░░░░░░░░░░░░░░░▒▒▒▒▓▓▒▒░░░░░░░░▓▓\n" + 
				"░░▒▒▓▓▒▒▒▒░░░░░░░░▓▓▒▒▒▒▒▒      ░░  ░░░░  $$ |  $$ l$$$$$$  l$$$$$$$ l$$$$$$$ $$ |      l$$$$$$  $$ |     l$$$$$$  l$$$$$$  $$$$$$$  |          ░░  ░░    ░░░░░░░░░░▒▒▓▓▓▓▒▒░░▓▓▒▒▓▓██\n" + 
				"▒▒██▒▒██░░░░░░  ░░▓▓▒▒▒▒▒▒░░  ░░░░▒▒░░░░  l$$|  %__|l______% l____$$ |l_______l__|       l______%l__|      l______% l______%l_______%           ░░░░    ▒▒▒▒▓▓  ░░░░▒▒▓▓▒▒▒▒░░▒▒░░▓▓██\n" + 
				"░░▓▓▓▓██▒▒░░░░  ▒▒░░▓▓▒▒░░  ░░▒▒▒▒▓▓▓▓░░                    $$l   $$ |                                                                          ░░░░░░░░▒▒██▒▒░░░░░░▒▒▒▒██▒▒░░░░▒▒▓▓▓▓\n" + 
				"░░▒▒▓▓▓▓▒▒    ░░░░░░  ░░▒▒▒▒▒▒▒▒░░░░░░░░                    l$$$$$$  |                                                                            ░░░░░░▒▒▒▒▓▓░░  ░░▓▓▓▓▓▓▒▒░░░░░░▓▓▓▓\n" + 
				"▓▓▓▓▓▓▓▓▒▒░░      ░░▒▒▒▒▒▒░░░░░░░░  ░░▒▒                     l______l                                                                          ░░░░░    ░░▒▒░░░░  ░░▓▓▓▓▓▓▒▒▒▒░░░░▓▓▓▓\n" + 
				"██▓▓▒▒▒▒░░░░░░▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒  ░░  ░░                                                                                                      ░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓░░▒▒▒▒▒▒▓▓▓▓\n" + 
				"▒▒▓▓▒▒  ░░▓▓▓▓▓▓▒▒░░▒▒░░▒▒░░▒▒░░░░░░░░░░░░                                                                                                  ▒▒  ░░░░░░░░░░░░░░░░  ░░▒▒▓▓▓▓░░░░▓▓██▓▓▓▓\n" + 
				"░░░░▒▒▓▓▒▒▓▓░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░                                                                                              ░░░░░░░░░░▒▒░░▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒░░░░▓▓▓▓▓▓\n" + 
				"▒▒▒▒░░░░▒▒▒▒░░▒▒▒▒▒▒░░  ▒▒▒▒░░░░░░░░░░░░░░▓▓░░                                                                                            ▒▒░░░░░░▒▒▓▓▒▒▓▓▒▒▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" + 
				"▒▒░░░░▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒░░▒▒                                                                                      ░░░░░░░░  ░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒░░▒▒▒▒░░▒▒▒▒░░\n" + 
				"░░░░░░░░▓▓▒▒▒▒▒▒░░░░░░▒▒▒▒▒▒▓▓░░░░░░  ▒▒▒▒░░    ▒▒░░                                                                                ▒▒░░▒▒░░░░░░░░▒▒▒▒░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒\n" + 
				"░░░░░░░░▓▓▓▓▒▒▒▒░░░░░░▒▒▒▒▒▒░░░░░░░░▒▒▓▓░░░░░░░░░░▒▒░░                                                                          ░░▒▒  ░░░░  ▒▒░░░░░░    ░░░░▒▒▓▓▓▓▓▓▒▒░░░░▒▒░░▒▒▒▒▒▒▓▓\n" + 
				"░░▒▒▒▒░░▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░  ▒▒▒▒░░░░░░░░  ░░░░░░░░░░                                                                    ▒▒░░    ▓▓▒▒▓▓░░░░▒▒░░░░░░░░▒▒▒▒▓▓██▒▒░░▓▓▓▓░░░░▒▒▒▒░░░░\n" + 
				"▓▓░░░░░░▒▒▒▒██▓▓▒▒░░░░░░░░░░  ░░▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░                                                              ░░▒▒    ░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▓▓▓▓▒▒▒▒░░░░░░▓▓██▒▒▒▒░░░░\n" + 
				"▓▓░░░░░░░░▓▓▓▓▓▓▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒░░░░  ░░░░░░  ░░░░▒▒░░                                                          ▒▒░░░░░░  ░░▒▒▒▒  ░░▒▒▒▒▓▓▒▒░░░░░░▓▓▓▓▓▓▒▒▒▒░░▒▒░░▒▒██▒▒▒▒  ░░\n" + 
				"▓▓▒▒░░▒▒░░▒▒██▓▓▒▒░░░░▒▒░░░░░░▓▓▒▒░░▒▒▒▒░░░░░░░░░░░░  ░░▒▒░░▒▒  ░░                                                ░░▓▓  ▒▒░░░░░░░░▓▓▓▓██▒▒░░  ░░▒▒▓▓▒▒░░░░▓▓▓▓░░▒▒▒▒░░░░▓▓▒▒▓▓▒▒▒▒░░░░\n" + 
				"▓▓▒▒▒▒▒▒░░▒▒████▒▒░░░░▓▓▒▒░░▓▓▒▒░░░░░░░░▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▓▓░░░░▒▒                                            ░░▒▒▒▒▒▒  ▒▒░░░░░░▓▓▒▒░░░░▒▒░░░░  ▒▒▓▓▓▓▒▒▒▒▒▒░░▒▒▒▒░░▒▒▓▓██▓▓░░░░░░░░\n" + 
				"▓▓▒▒▒▒▒▒▓▓██▓▓▒▒▒▒▓▓▒▒▒▒  ▓▓▓▓░░▒▒░░░░▒▒▒▒▒▒▓▓░░░░░░▒▒▒▒▒▒▒▒░░░░░░  ░░░░                                      ░░░░  ░░░░▒▒░░░░▒▒░░  ▒▒  ▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▒▒░░░░▓▓▓▓▓▓████▒▒▒▒░░░░░░\n" + 
				"▓▓▓▓░░░░░░▒▒▓▓▓▓▒▒▓▓▒▒░░▓▓▓▓  ▒▒░░░░▒▒░░▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒░░        ░░▒▒░░                                ▒▒  ░░░░  ░░░░░░░░░░░░▒▒░░░░  ▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒░░▓▓▓▓▓▓▓▓▒▒▒▒░░░░░░░░\n" + 
				"▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓░░  ░░▒▒▓▓░░░░░░░░░░░░░░░░▒▒░░░░░░░░░░▒▒▓▓░░    ░░    ▒▒░░▓▓▒▒░░                          ▒▒    ░░░░░░░░  ░░░░░░░░░░    ░░  ▒▒▒▒▒▒░░░░░░  ░░░░▒▒▒▒▒▒██▒▒▒▒▒▒░░░░░░░░░░\n" + 
				"░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▓▓▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▓▓░░▒▒  ░░░░  ░░▒▒▒▒▓▓░░░░                        ▒▒    ░░    ░░░░░░▒▒▒▒░░░░  ░░░░▓▓▒▒  ▒▒▒▒▒▒░░    ░░▒▒░░░░▓▓░░▓▓░░░░░░░░░░░░░░\n" + 
				"▓▓▓▓▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░  ░░░░▒▒░░▒▒▓▓  ▒▒▒▒▒▒░░░░░░▒▒░░▒▒░░░░  ░░                  ░░░░      ▒▒▓▓▒▒  ░░░░░░▒▒▒▒░░▒▒░░▓▓▓▓▓▓▓▓░░▒▒▓▓░░░░  ▒▒▓▓▓▓▓▓░░░░▓▓▒▒▒▒░░▒▒░░░░░░\n" + 
				"▒▒░░░░▒▒▓▓▒▒░░░░░░▒▒▒▒░░░░▒▒▓▓▒▒▒▒▒▒░░░░░░░░░░░░▒▒▓▓░░░░▒▒▒▒░░░░░░▒▒░░▒▒▓▓░░      ░░              ░░░░  ░░░░  ▒▒▓▓▓▓░░  ░░░░░░▒▒▒▒░░▒▒▓▓▓▓▓▓▒▒░░░░▒▒▒▒░░░░▓▓▓▓▓▓▒▒░░░░  ▒▒▓▓▒▒▒▒░░░░░░\n" + 
				"░░░░░░▓▓▓▓▓▓▒▒  ▒▒▒▒░░░░░░▒▒▓▓▓▓▓▓▓▓▒▒░░░░░░░░▒▒▒▒░░▒▒▒▒▒▒▓▓░░░░░░▒▒▒▒▓▓░░░░        ░░          ▒▒▒▒░░  ░░░░  ▒▒▒▒▒▒  ░░  ░░░░░░▒▒▒▒  ▓▓▒▒▒▒▒▒░░  ░░▒▒░░▒▒▓▓▓▓░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒  \n" + 
				"    ░░▒▒▓▓▓▓  ▓▓▒▒░░░░░░▓▓░░▒▒▓▓▓▓██▓▓▒▒░░░░▒▒▒▒▒▒░░  ░░░░░░░░░░░░░░▒▒▒▒░░        ░░  ░░        ░░▒▒▓▓▒▒░░░░░░░░▒▒░░    ░░░░▒▒▒▒▒▒▒▒▒▒    ▒▒▒▒░░░░  ▒▒▒▒▒▒▒▒░░░░▒▒░░░░░░░░▓▓▒▒░░▓▓▒▒▒▒\n"+
				"▒▒    ░░▒▒░░▒▒▓▓▒▒▓▓░░░░▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒░░░░▒▒▒▒░░  ░░  ░░░░░░░░░░▒▒▒▒░░░░  ░░  ░░░░  ▒▒▒▒    ▒▒▒▒░░▒▒▓▓▒▒░░░░░░    ░░░░▒▒▒▒▒▒▓▓▓▓▒▒▒▒░░  ▒▒░░░░░░▒▒  ▒▒▒▒▒▒░░▒▒░░░░░░▓▓▒▒▓▓▒▒▒▒░░░░▓▓\n" + 
				"▓▓      ░░▒▒▓▓░░▒▒▓▓▓▓▒▒░░░░░░▒▒▒▒▓▓▓▓▒▒▒▒▒▒▓▓░░▒▒░░    ░░░░░░░░▒▒▓▓░░▒▒  ░░  ░░░░░░▒▒▒▒▒▒░░░░  ░░▒▒░░▒▒▓▓░░░░      ░░▒▒▓▓▓▓▓▓▓▓▒▒░░░░▒▒░░░░▒▒▒▒▓▓▒▒▓▓  ▒▒░░░░▒▒▓▓░░▓▓▓▓▓▓▒▒░░▒▒  ░░  \n" + 
				"▒▒  ░░  ░░▒▒░░  ▒▒▓▓▓▓▓▓▒▒▒▒▒▒░░░░▓▓▓▓██▓▓▓▓░░▒▒▒▒▒▒░░    ░░░░░░░░▒▒░░▒▒░░░░░░  ▒▒▒▒▒▒  ░░░░  ░░░░░░░░░░▓▓▒▒░░  ░░░░▒▒▓▓▒▒██▓▓▒▒░░░░░░░░░░░░▒▒▓▓▓▓██▓▓░░  ▒▒░░▒▒██▓▓▓▓▓▓██░░░░░░  ░░░░\n" + 
				"░░░░░░░░▒▒░░░░░░▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒░░▒▒██▓▓▒▒░░░░░░░░░░▒▒▓▓░░░░░░░░    ▒▒▒▒░░░░▒▒░░  ▒▒  ░░░░░░░░▒▒▒▒▒▒▒▒  ▒▒▓▓▓▓██▓▓▒▒░░▒▒░░░░░░░░▓▓░░▓▓██▓▓▒▒▒▒░░░░▒▒▒▒▓▓▓▓██▓▓░░▒▒░░      ░░\n" + 
				"  ░░░░▒▒▒▒░░░░░░░░▒▒▓▓▓▓██▓▓▒▒░░░░░░░░▒▒▒▒░░▒▒▒▒▓▓██▓▓▒▒░░░░▒▒▓▓░░░░░░░░  ░░▒▒▒▒░░░░░░        ░░  ░░░░░░░░▒▒▓▓░░░░▓▓▓▓▓▓▓▓▒▒░░░░▓▓▒▒░░░░░░▓▓▓▓░░▒▒▒▒░░  ░░  ░░░░██▒▒▒▒▒▒░░        ░░  \n" + 
				"  ░░▒▒▒▒░░░░░░  ░░░░▒▒▓▓▓▓▓▓▓▓░░░░░░▒▒▒▒▒▒▓▓░░▓▓▓▓▓▓██▓▓▒▒░░▒▒▒▒░░      ▓▓▒▒▒▒▒▒▒▒░░▒▒        ░░░░  ░░░░    ▒▒▒▒▒▒▒▒▓▓░░▒▒░░░░░░░░▒▒▒▒▓▓▒▒░░▓▓▓▓  ░░░░░░    ░░░░▒▒▒▒░░          ░░░░▒▒\n" + 
				"  ▒▒▒▒░░░░▒▒░░░░░░░░░░▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▓▓▓▓▒▒▒▒▓▓░░    ░░▓▓▓▓░░░░▒▒░░░░    ░░      ▒▒░░    ░░    ▒▒▒▒▒▒▒▒░░▒▒░░▒▒▒▒▒▒▒▒▓▓▒▒▒▒░░░░▓▓▓▓  ░░    ▒▒░░░░▒▒░░░░  ░░░░░░░░░░▒▒▒▒\n" + 
				"▒▒▒▒▒▒  ░░  ░░▓▓▒▒░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░▓▓░░░░░░▒▒░░░░██▓▓▓▓░░░░░░  ▓▓▓▓▒▒░░░░▒▒░░░░░░░░░░          ░░░░      ▒▒░░▓▓▒▒▒▒░░▓▓░░▒▒▓▓▒▒▓▓▒▒▒▒▒▒░░░░░░▓▓▒▒  ░░░░▒▒░░▒▒  ▒▒░░░░░░  ░░░░▒▒▒▒░░\n" + 
				"▒▒▒▒░░░░    ▒▒▓▓▒▒░░  ░░░░░░  ▒▒▓▓  ▓▓▒▒▓▓░░▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒░░░░▓▓▓▓░░▒▒▒▒░░░░░░▒▒▒▒▒▒░░          ░░░░  ░░░░░░▒▒░░▒▒▒▒░░▓▓▓▓▒▒▓▓██▓▓░░▒▒░░░░▒▒░░░░▓▓▒▒░░  ▒▒▒▒▒▒▒▒  ▒▒▒▒░░░░░░░░  ▒▒░░\n" + 
				"░░▒▒░░░░░░  ▓▓▓▓▒▒░░░░░░░░░░▓▓▓▓░░▒▒░░▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░▒▒░░▒▒▓▓▓▓░░░░▒▒░░░░░░░░░░▒▒▒▒░░░░░░  ░░▒▒░░▓▓  ░░▒▒▓▓▓▓░░░░▒▒░░▓▓▓▓▓▓██▓▓▒▒▒▒░░░░  ░░▒▒▒▒▒▒▒▒░░░░░░▓▓▒▒▒▒░░  ▓▓▒▒░░░░  ░░  ░░\n" + 
				"░░  ▒▒░░░░  ▒▒▒▒▓▓░░░░░░░░▓▓▓▓░░░░░░░░▓▓▒▒▓▓▓▓░░░░░░▒▒░░░░░░░░░░▒▒▒▒░░░░    ░░▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒░░▒▒▒▒░░▓▓▒▒▓▓░░░░░░▓▓▓▓▓▓██▓▓░░▒▒░░░░  ░░  ░░░░░░▒▒▒▒  ░░░░▒▒      ░░▒▒▓▓      ░░  \n" + 
				""+Roulette.ANSI_RESET);
		System.out.println();
	}

	private static void playMenu() throws IOException, InterruptedException{
		initSecretPlayer();
		boolean exit = false;
		String input;
		while(!exit) {
			clear();
			System.out.print("╔━╤━━━━━━━━━━━━╗\n"
					+"┃1┃ Newplayer  ┃\n"
					+"╠━╫━━━━━━━━━━━━╣\n"
					+"┃2┃ LoadPlayers┃\n"
					+"╠═╬════════════╣\n"
					+"┃3┃ Ranking    ┃\n"
					+"╠═╬════════════╣\n"
					+"┃4┃ Back       ┃\n"
					+"╚═╧════════════╝\n"
					+"               \n"
					+"Faites un choix : ");
			input = userInput.nextLine();
			clear();

			switch (input) {
			case "1":

				
				//System.out.println("Bienvenue dans Royal Crous \n"+ "Quelle est ton prénom ?  ");

				System.out.println(
				 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
				+"┃ Bienvenue dans Royal Crous  ┃\n"
				+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━═╝\n");

				System.out.println("\n");

				System.out.println( 
				 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
				+"┃ Quel est ton prénom ?       ┃\n"
				+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━═╝\n");

				String nom= userInput.nextLine();

				while(players.existingName(nom)) {
					System.out.println(ANSI_RED_BG + "Ton prénom est déjà pris, choisis en un autre !" + ANSI_RESET);
					nom= userInput.nextLine();
				}
				
				if(secretPlayer.contains(nom)) {
					p1 = new SecretPlayer(nom);
					System.out.println(
					 "╔━╤━━━━━━━━━━━━━━━━━━━━━━━━━━━╗\n"
					+"┃ JackPot                     ┃\n"
					+"╚═╧═══━━━━━━━━━━━━━━━━━━━━━━━═╝\n");
					System.out.println("\nLe crous t'a attribué l'échelon exceptionnel ! Votre échelon est : " + p1.getEchelon() + " \nTa bourse s'élève à " + p1.getBourse());  
				}else {
					p1=new Player(100,nom,1);
					init(p1);
				}
				
				while(!players.addPlayer(p1)) {
					nom= userInput.nextLine();
				}

				play();
				exit = false;
				break;
			case "2":
				System.err.println(" Mais qui revoila ici dans le meilleur jeu ,\n"
						+ "euh rappel moi ton nom de joueur : ");
				String nomLoad= userInput.nextLine();


				try {
					if(players.existingName(nomLoad)) {
						System.out.println("cool de te revoir "+nomLoad);
						p1=players.loadPlayer(nomLoad);
					}
					else { System.out.println("mais je ne t'ai jamais vu ici "+nomLoad+"  !");
					try {
						Thread.sleep(3000);
						playMenu();
					} catch (Exception e) {
						}
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				play();

				exit = true;
				break;

			case "3":

				rankingMenu();
				break;

			case "4":

				exit = true;
				break;
			default:
				break;
			}
		}
	}





	private static void mainMenu() {
		System.out.print("    ╔━╤━━━━━━━━━━━╗\n"
				+"    ┃1┃ Play      ┃\n"
				+"    ╠━╫━━━━━━━━━━━╣\n"
				+"    ┃2┃ Exit      ┃\n"
				+"    ╚═╧═══════════╝\n"
				+"                   \n"
				+"Make your choice : ");
	}

	private static void clear(){
		for (int i = 0; i < 10; i++) {
			System.out.println("\n");
		}
	}



	private static void play( ) throws InterruptedException, IOException {
		LoadingMenu();
		
	}
	
	private static void play(String choix ) throws InterruptedException, IOException {
		switch (choix) {
		case "1":
			clear();
			RoyalCrous blackJack = new RoyalCrous();
			blackJack.start(p1, players);
			players.updateTxt();
			LoadingMenu();
			break;
		case "2":
			clear();
			Roulette roulette = new Roulette();
				try {
					roulette.start(p1,players);
				} catch (UnvalidBet e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			LoadingMenu();
			break;
		default:
			break;
		}
	}


	private static void rankingMenu() {
		String [] best=new String [5];
		for (int i = 0; i < best.length; i++) {
			best[i]="n°"+Integer.sum(i, 1)+" no one";
		}
		Collections.sort(players.getPlayers());
		for (int i = 0; i < players.getPlayers().size(); i++) {
			best[i]="n°"+Integer.sum(i, 1)+" "+players.getPlayers().get(i).toString();
			if(i==4)break;
		}
		System.out.println(best[0]
				+"\n"+best[1]
						+"\n"+best[2]
								+"\n"+best[3]
										+"\n"+best[4]);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void init(Player player){
		Map<Integer,Integer> solde = new HashMap<>();
		solde.put(1, 100);
		solde.put(2, 200);
		solde.put(3, 300);
		solde.put(4, 400);
		solde.put(5, 500);
		solde.put(6, 600);

		Random random = new Random();
		int echelon = random.nextInt(6) + 1;
		int bourse = solde.get(echelon);

		p1.setEchelon(echelon);
		p1.setBourse(bourse);
		
		System.out.println("\nLe crous t'a attribué l'échelon " + echelon + " \nTa bourse s'élève à " + bourse);  
	}

	private static void initSecretPlayer(){
		List<String> list = new ArrayList<String>();
		list.add("Titouan");
		list.add("Law");
		list.add("Jessy");
		list.add("Mounir");
		list.add("Théo");
		list.add("Hocine");
		list.add("Marine");
		list.add("Renan");
		secretPlayer = list;
	}

	
}
