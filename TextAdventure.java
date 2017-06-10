
import java.util.Random;

import java.util.Scanner;

public class TextAdventure {
	static String x = "Hello";// classes in upper case
	static String y = "\nWelcome!";// variables in lower case
	static Scanner scan = new Scanner(System.in);
	static String name = " ";
	static String chooseClass;
	static String u = " ";
	static boolean i = true;
	static boolean h = true;
	static int sum;
	static int type;
	static int num2;
	static boolean m = true;
	static boolean jo = true;
	// static int health = 100;
	// static int damage = 0;
	static Character player;
	static int enemyHealth = 60;
	static Character enemy;
	static int[] cards = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
	static int r;
	static int dealer;

	public static void blackJack() {
		Random random = new Random();
		Random bfdf = new Random();
		// int a = random.nextInt(12);
		// int b = bfdf.nextInt(12);
		System.out.println("Joe: " + name + " the warrior, please help me! Fight the monster with your magical"
				+ " strength and strategy.");
		System.out.println(
				"You: Leave my friend alone!\n" + "Monster: You must play this game of black Jack with me in order for "
						+ "you to save you and your friend. The rules for this version of Black Jack is "
						+ "that you get two random cards, " + "and you only get 5 turns until the sum of them is 21.");
		System.out.println("Ok, deal!\n");
		System.out.println("*Mini-Game: Black Jack*\n" + "GOOD LUCK!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		int sum;
		sum = cards[random.nextInt(13)] + cards[random.nextInt(13)];
		int e = 0;
		while (m && e < 6) {
			if (sum == 21) {
				System.out.println("Your sum is 21!");
				System.out.print(" You win!");
				break;
			}
			System.out.println(
					"The sum of the " + "cards you got, " + sum + " is not 21. Would you like to draw another card?");
			u = scan.nextLine();
			if (u.equalsIgnoreCase("y") || u.equalsIgnoreCase("yes")) {
				sum += cards[random.nextInt(13)];
				if (sum > 21) {
					System.out.println("Try again! Your sum is greater than 21. You lose :(");
					sum = cards[random.nextInt(13)] + cards[random.nextInt(13)];
					e++;
				}

			} else if (u.equalsIgnoreCase("n") || u.equalsIgnoreCase("no")) {
				System.out.println("Now your card will be compared with the dealer.");
				dealer = random.nextInt(6) + 15;
				System.out.println("The dealer has " + dealer + " and you have " + sum + "\n");
				if ((sum > dealer) && sum < 21) {

					System.out.println("You win!");
					break;

				} else {
					System.out.println("Try again!");
					e++;
					sum = cards[random.nextInt(13)] + cards[random.nextInt(13)];
				}

			}

		}

	} // while

	public static void dice() {
		System.out.println("Joe: " + name + " the warrior, please help me! Fight the monster with your magical"
				+ " strength and strategy.");
		System.out.println(
				"You: Leave my friend alone!\n" + "Monster: You must play this game of black Jack with me in order for "
						+ "you to save you and your friend. \nThe rules for this version of this dice game is "
						+ "that you roll two dice, " + "and you calculate the sum of the two di.\n"
						+ " If it is 7 or 11 you win or if it is 2,3, or 12, you lose. \nIf you roll 4,5,6,8,9,10"
						+ " you get a point then roll again. If you get a point, then you have to try to get another point, but if "
						+ " you get a sum of 7 after the first time, you lose.");
		System.out.println("Ok, deal!\n" + "*Mini-Game: Dice*\n" + "GOOD LUCK!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Random random = new Random();
		Random bfdf = new Random();
		int one = random.nextInt(5) + 1;
		int two = bfdf.nextInt(5) + 1;
		while (jo) {
			if (one + two == 7 || one + two == 11) {
				System.out
						.println("The numbers you rolled were " + one + " and " + two + ". Your sum is " + (one + two));
				System.out.println("YOU WIN!! CONGRATULATIONS!!");

				jo = false;
				System.out.println("Press enter to continue...");
				scan.nextLine();
			} else if (one + two == 2 || one + two == 3 || one + two == 12) {
				System.out
						.println("The numbers you rolled were " + one + " and " + two + ". Your sum is " + (one + two));
				System.out.println("You lose. Sorry :(");
				player.death();
			} else {
				System.out
						.println("The numbers you rolled were " + one + " and " + two + ". Your sum is " + (one + two));
				System.out.println("You got a point, try to get another one");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				int three = random.nextInt(5) + 1;
				int four = bfdf.nextInt(5) + 1;
				if (three + four == 7) {
					System.out.println("The numbers you rolled were " + three + " and " + four + ". Your sum is "
							+ (three + four));
					System.out.println("You lose. Sorry :(");
					player.death();
				} else {
					System.out.println("The numbers you rolled were " + three + " and " + four + ". Your sum is "
							+ (three + four));
					System.out.println("YOU WIN!! CONGRATULATIONS!!");
					jo = false;
				}

			} // else big
		} // while

	}

	public static void boss() {
		enemy = new BossEnemy("Cyclops");
		System.out.println("Joe: We are almost here " + name + ". Good luck I hope that you will"
				+ " survive. Here is a sword that gives the ability to use your special attack.");
		System.out.println("*The Cyclops approaches you*");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("Cyclops: Who are you and what are you doing here?");
		System.out.println("You: I am " + name + " and I am here to destroy you!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println(
				"Cyclops: Ha ha ha! You all will be destroyed and doomed " + "because of your irrational thinking!");
		System.out.println("Joe: Attack!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("*You ram into the cyclops and it is hurt.*");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		damageDealt(player.damage);
		System.out.println("Cyclops: NOW I WILL BREAK YOU!!");
		player.damageTaken(enemy.damage);
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("You: NOOOOOO!!!\n**The Cyclops used his powerful attack.**");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("You: Ouch! AH that hurts!\nCyclops: I told you not to mess with me!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		player.damageTaken(enemy.bossAttack);

	}

	public static void conclusion() {
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("*You turn around and see that Joe is running away" + " with a bucket of treasure.*");
		System.out.println("You: JOE, YOU TRAITOR!\nJoe: Sayonara my friend! HA HA HA!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("**Before he could run off with the treasure, " + "he tripped and broke his other foot.**");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		while (h) {
			System.out.println("Will you choose to forgive him or not? Enter y for yes and n for no.");
			u = scan.nextLine();
			if (u.equalsIgnoreCase("yes") || u.equalsIgnoreCase("y")) {
				System.out.println("You have passed the test. Congratulations your highness " + name + ". You "
						+ "have been chosen to be the one to rule the kingdom of Yachland, for your forgiving spirit.");
				h = false;
			} else if (u.equalsIgnoreCase("no") || u.equalsIgnoreCase("n")) {
				System.out.println(
						"What a savage! You punish Joe for what he did " + "and go on to become one of the greatest"
								+ " despots ever. Rich, infamous, and unforgiving.");
				h = false;
			} else {
				System.out.println("Not a valid choice.");
			}

		} // while
		System.out.println("*********THE END*********");
		System.exit(0);
	}

	public static void avalanche() {
		System.out.println("Joe: Thank you my dear friend you have " + "helped me greatly. I owe so much to you.");
		System.out.println("We will walk up and defeat the cyclops.");
		System.out.println(
				"You: Why me Joe? Why must I be the one who kills the" + " cyclops? I am so dearly afraid friend.");
		System.out.println("Joe: " + name + " you are the chosen one, that is why. Your name, " + name + ", is"
				+ " written in the scrolls of the ancient prophets.");
		System.out.println("You: I don't know if I am ready.");
		System.out.println("Joe: " + name + ", you were born ready.");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("**You both approach the dangerous mountains of the Himalayas."
				+ " There is an avalanche approaching. Watch out!**");
		System.out.println("Joe: Run! There is a cave over there, go go go!!!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("*A large icicle falls on your head. Everything goes dark*");
		player.damageTaken(20);
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("Joe: You got hurt pretty bad. I gave you some of my health potion."
				+ "\nI carried you in this cave. " + "We must get going if we want to get to the cyclops.");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
		
		healthPotion(10);
	}

	public static void highLow() {
		System.out.println("Joe: " + name + " the unicorn, please help me! Fight the monster with your magical"
				+ " mind-reading powers.");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println(
				"You: Leave my friend alone!\n" + "Monster: You must guess the number I am thinking of from 1-10\n"
						+ "I will tell you if its too high or too low, and every time you get it wrong\n"
						+ "I will throw a rock at you. You only get 5 tries.");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("Ok, deal!\n" + "*Mini-Game: Guess the number the giant is thinking of.\n"
				+ "You will be hurt every time you guess wrong. GOOD LUCK!");
		Random randomGenerator = new Random();
		int num = randomGenerator.nextInt(11);
		for (int i = 0; i < 6; i++) {
			System.out.print("Guess " + (i + 1) + ":");
			num2 = scan.nextInt();
			if (num2 == num) {
				System.out.println("Congratulations! You have defeated the giant!!:)");
				break;
			} else if (num > num2) {
				System.out.println("Your number is too low.");
				player.damageTaken(5);
			} else if (num2 > num) {
				System.out.println("Your number is too high.");
				player.damageTaken(5);
			} else {
				System.out.println("Not a valid choice.");
			}
			int tries = i;
			if (tries > 5) {
				player.death();
			}
		} // for loop
	}

	public static void healthPotion(int potion) {
		player.health += potion;
		System.out.println("Your health is now " + player.health);
	}

	public static void damageDealt(int damageDealt) {
		enemy.health -= damageDealt;
		if (enemy.health > 0) {
			System.out.println("The enemy health remaining is " + enemyHealth + ".");
		} else {
			System.out.println("You have defeated the enemy!");

		}
	}

	public static void chooseClass() {
		while (i) {
			// System.out.println("\n");
			System.out.println("The different classes of this journey include unicorns,\n "
					+ "warriors, and giants. \nIf you would like to be a unicorn type one, "
					+ "if you would like to be a warrior type two,\n and "
					+ "if you would like to be a giant type three.");
			chooseClass = scan.nextLine();
			if (chooseClass.equalsIgnoreCase("unicorn") || chooseClass.equalsIgnoreCase("one")
					|| chooseClass.equalsIgnoreCase("1")) {
				System.out.println("You have chosen the unicorn.");
				player = new Unicorn(name);
				i = false;
				type = 1;

			} else if (chooseClass.equalsIgnoreCase("warrior") || chooseClass.equalsIgnoreCase("two")
					|| chooseClass.equalsIgnoreCase("2")) {
				System.out.println("You have chosen the warrior.");
				chooseClass = "warrior";
				player = new Warrior(name);
				i = false;
				type = 2;
			} else if (chooseClass.equalsIgnoreCase("giant") || chooseClass.equalsIgnoreCase("three")
					|| chooseClass.equalsIgnoreCase("3")) {
				System.out.println("You have chosen the giant.");
				chooseClass = "giant";
				player = new Giant(name);
				i = false;
				type = 3;
			} else {
				System.out.println("Not a valid choice.");
			} // else

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		x += y;
		System.out.println(x);
		System.out.println("What is your name? ");
		name = scan.nextLine();
		System.out.println("Hello " + name);
		chooseClass();
		System.out.println(
				"Hello I am Joe, your companion. Comrade, this will be a difficult journey, regardless of your\n"
						+ "nervousness, there is no going back now. Get rest for we will begin tomorrow.");
		System.out.println("***A good night's rest later***");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		System.out.println("Good morning " + name + ". Today will be a long day, get your belongings\n"
				+ "together and follow me, we are going to the Langley Cove.");

		System.out.println("*A dirt monster arises outside of the ground and lunges at Joe. " + "his leg is broken.");
		switch (type) {
		case 1:
			highLow();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			avalanche();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			boss();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			System.out.println("NO YOU CANNOT STOP ME!!! RaInBoW ATTACK!!!");
			damageDealt(player.specialAttack);
			System.out.println("Press enter to continue...");
			scan.nextLine();
			conclusion();
			break;
		case 2:
			blackJack();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			avalanche();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			boss();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			System.out.println("NO you cannot stop me! Sword SHOWER!!");
			damageDealt(player.specialAttack);
			conclusion();
			break;
		case 3:
			dice();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			avalanche();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			boss();
			System.out.println("Press enter to continue...");
			scan.nextLine();
			System.out.println("NO you cannot stop me! CLUB SMASHDOWN!!");
			damageDealt(player.specialAttack);
			System.out.println("Press enter to continue...");
			scan.nextLine();
			conclusion();

		}// switch

	}// main

	private static void System(String string) {
		// TODO Auto-generated method stub

	}

	private static void Sleep(int j) {
		// TODO Auto-generated method stub

	}

}// public class
