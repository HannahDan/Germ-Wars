
public class Character {
	int health = 0;
	int damage = 0;
	String name = " ";
	int bossAttack = 0;
	int specialAttack = 0;

	public Character() {

	}

	public void damageTaken(int damageTaken) {
		health -= damageTaken;
		if (health > 0) {
			System.out.println("Your remaining health is " + health + ".");
		} else {
			death();
		}
	}

	public void death() {
		System.out.println("Sorry you died :(");
		System.exit(0);
	}

}
