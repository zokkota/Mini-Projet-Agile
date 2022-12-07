package Menu.Game.BlackJack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Menu.Menu;
import Menu.Game.Game;

public class RoyalCrous implements Game {

	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static String red= "\033[0;31m";
	public static String green = "\033[0;32m";

	public void start(Player player, Players players) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
		 "╔━╤━━━━━━━━━━━━━━━━━━╗\n"
		+"┃ BlackJack          ┃\n"
		+"╚═╧━━━━━━━━━━━━━━━━━═╝\n");
		

		Event event = new Event(0);

		System.out.println("\nCombien de paquet de cartes ? :");
		int nb = scanner.nextInt();

		int choix = 0;
		boolean fin = false;
		while (fin != true) {
			Packet jeu = new Packet(nb);
			System.out.println("Début du jeu ! ");
			System.out.println(ANSI_BLUE + "Tu as " + player.getBourse() + " jetons" + ANSI_RESET);
			int bet = 0;
			boolean correct = false;
			while (!correct) {
				try {
					bet = player.bet(scanner);
					correct = true;
					System.out.println(bet);
				} catch (UnvalidBet e1) {
					System.out.println(e1.getMessage());
				}
			}
			System.out.println("Tu as misé : " + bet + " jetons");
			clear();
			player.hand.clear();
			player.croupier.clear();
			player.hand.add(jeu.PickCard());
			player.hand.add(jeu.PickCard());
			player.croupier.add(jeu.PickCard());

			System.out.println("Ta main :");

			afficherMainPlayer(player);

			System.out.println("Ton total : " + player.totalOfHand() + "\n");
			System.out.println("-----------------------------------");
			System.out.println("Main du croupier : ");

			afficherMainCroupier(player);

			System.out.println("Total du croupier : " + player.totalOfCroupier() + "\n");

			if (player.totalOfHand() == 21) {
				System.out.println("BLACKJACK ! Tu remportes cette partie !");
				updateBourseWin(player, bet, players);
				event.WinTheGame(player.getBourse());
				choix = 0;
			}

			System.out.println(
			 "╔═━═╤━━━━━━━━═══━━━━╗\n"
			+"┃ 1 ┃ PIOCHER       ┃\n"
			+"╠═══╬═══════════════╣\n"
			+"┃ 2 ┃ RESTER        ┃\n"
			+"╠═══╬═══════════════╣\n"
			+"┃-1 ┃ QUITTER JEU   ┃\n"
			+"╚═══╧═══════════════╝\n"
			+"               \n"
			+"Faites un choix : ");

			choix = scanner.nextInt();
			while (choix != 0) {
				if (choix == -1) {
					try {
						Menu.LoadingMenu();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (choix == 0) {
					choix = 0;
					break;
				} else if (choix == 1 && player.totalOfHand() < 21) {
					player.hand.add(jeu.PickCard());
					System.out.println("Ta main : ");
					afficherMainPlayer(player);
					System.out.println("Total : " + player.totalOfHand());
					if (player.totalOfHand() > 21) {
						handResult(Result.LOST);
						updateBourseLost(player, bet, players);
						event.LostTheGame(player.getBourse());
						event.setTimer(event.getTimer() + 1);
						choix = 0;
						try {
							event.RandomEvent(event.getRandEvent(), player);
							event.Loyer(player);
							event.Bourses(player);
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						clear();
					} else {
						System.out.println(
			 "╔━╤━━━━━━━━═══━━━━╗\n"
			+"┃1┃ PIOCHER       ┃\n"
			+"╠═╬═══════════════╣\n"
			+"┃2┃ RESTER        ┃\n"
			+"╠═╬═══════════════╣\n"
			+"┃3┃ QUITTER JEU   ┃\n"
			+"╚═╧═══════════════╝\n"
			+"               \n"
			+"Faites un choix : ");
						choix = scanner.nextInt();
					}
				} else if (choix == 2) {
					while (player.totalOfCroupier() < 17) {
						player.croupier.add(jeu.PickCard());
						System.out.println("Main du croupier : ");
						System.out.println("----------------");
						afficherMainCroupier(player);
						System.out.println("Total du croupier : " + player.totalOfCroupier() + "\n");
					}
					if (player.totalOfCroupier() < player.totalOfHand() || player.totalOfCroupier() > 21) {
						handResult(Result.WIN);
						updateBourseWin(player, bet, players);
						event.WinTheGame(player.getBourse());
						event.setTimer(event.getTimer() + 1);
						clear();
						choix = 0;
						try {
							event.RandomEvent(event.getRandEvent(), player);
							event.Loyer(player);
							event.Bourses(player);
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (player.totalOfHand() > 21
							|| player.totalOfCroupier() > player.totalOfHand() && player.totalOfCroupier() < 21) {
						handResult(Result.LOST);
						updateBourseLost(player, bet, players);
						event.LostTheGame(player.getBourse());
						event.setTimer(event.getTimer() + 1);
						clear();
						choix = 0;
						try {
							event.RandomEvent(event.getRandEvent(), player);
							event.Loyer(player);
							event.Bourses(player);
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (player.totalOfCroupier() == player.totalOfHand()) {
						handResult(Result.DRAW);
						event.setTimer(event.getTimer() + 1);
						choix = 0;
						clear();
						try {
							event.RandomEvent(event.getRandEvent(), player);
							event.Loyer(player);
							event.Bourses(player);
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}
		}

		scanner.close();
	}

	private static void afficherMainCroupier(Player player) {
		for (Card c : player.croupier) {
			System.out.println(c.afficherNumber(c.getRank()) + c.afficherSymbole(c.getColor()));
		}
	}

	private static void afficherMainPlayer(Player player) {
		for (Card c : player.hand) {
			System.out.println(c.afficherNumber(c.getRank()) + c.afficherSymbole(c.getColor()));
		}
	}

	private static void clear() {
		for (int i = 0; i < 14; i++) {
			System.out.println("\n");
		}
	}

	private static void handResult(Result res) {
		if (res == Result.WIN) {
			System.out.println(green + "Tu as gagné" + ANSI_RESET);
		} else if (res == Result.LOST) {
			System.out.println(red +"Tu as perdu, le Croupier Gagne" + ANSI_RESET);
		} else {
			System.out.println("Egalité, tu récupères ta mise");
		}
	}

	private static void updateBourseWin(Player player, int coins, Players players) {
		System.out.println("Tu as gagné " + coins + " crédits");
		player.bourseWin(coins);
		players.majProfil(player);
		System.out.println("Il te reste " + player.getBourse() + "crédits");
	}

	private static void updateBourseLost(Player player, int coins, Players players) {
		System.out.println("Tu as perdu " + coins + " crédits");
		player.bourseLose(coins);
		players.majProfil(player);
		System.out.println("Il te reste " + player.getBourse() + "crédits");
	}

}
