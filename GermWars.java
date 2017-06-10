package germwars;

import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

@SuppressWarnings("serial")
public class GermWars extends PApplet {
	public static Random random = new Random();
	PImage background;
	PImage paddleImage;
	public Paddle player;
	PImage soapImage;
	public Ball bubble;
	PImage[] germImages = new PImage[5];
	static boolean soapMove = false;
	public Germ germBlue;
	public Germ germRed;
	public Germ germYellow;
	public Germ germGreen;
	public Germ germOrange;
	public String score2;
	public int score = 0;

	public void setup() {
		size(800, 600);
		background = loadImage("background.png");
		paddleImage = loadImage("paddle.png");

		germImages[0] = loadImage("germ_blue.png");
		germImages[1] = loadImage("germ_yellow.png");
		germImages[2] = loadImage("germ_orange.png");
		germImages[3] = loadImage("germ_green.png");
		germImages[4] = loadImage("germ_red.png");

		player = new Paddle(paddleImage, width / 2, height * 4 / 5);
		// System.out.println(playerImage.height);
		soapImage = loadImage("soapbubble.png");
		bubble = new Ball(soapImage, 0, height / 2);

		germBlue = new Germ(germImages[0], width / 2, 30);
		germBlue.xSpeed = 4;
		germBlue.ySpeed = -2;
		germYellow = new Germ(germImages[1], width / 2, 30);
		germYellow.xSpeed = 4;
		germYellow.ySpeed = -2;
		germOrange = new Germ(germImages[2], width / 2, 30);
		germOrange.xSpeed = 4;
		germOrange.ySpeed = -2;
		germGreen = new Germ(germImages[3], width / 2, 30);
		germGreen.xSpeed = 4;
		germGreen.ySpeed = -2;
		germRed = new Germ(germImages[4], width / 2, 30);
		germRed.xSpeed = 4;
		germRed.ySpeed = -2;

	}

	public void draw() {
		player.update();
		bubble.update();

		germBlue.update();
		germRed.update();
		germYellow.update();
		germGreen.update();
		germOrange.update();

		background(background);
		player.drawPaddle();
		bubble.drawBall();

		germBlue.drawGerm();
		germRed.drawGerm();
		germYellow.drawGerm();
		germGreen.drawGerm();
		germOrange.drawGerm();
		// if (objectCollision(germBlue)) {
		// germBlue.alive = false;
		// germImages[0] = null;
		// bubble.xSpeed = -bubble.xSpeed;
		// bubble.ySpeed = -bubble.ySpeed;
		// score += 5;
		// }
		// if (objectCollision(germOrange)) {
		// germOrange.alive = false;
		// germImages[1] = null;
		// bubble.xSpeed = -bubble.xSpeed;
		// bubble.ySpeed = -bubble.ySpeed;
		// score += 5;
		// }
		// if (objectCollision(germGreen)) {
		// germGreen.alive = false;
		// germImages[2] = null;
		// bubble.xSpeed = -bubble.xSpeed;
		// bubble.ySpeed = -bubble.ySpeed;
		// score += 5;
		// }
		// if (objectCollision(germYellow)) {
		// germYellow.alive = false;
		// germImages[3] = null;
		// bubble.xSpeed = -bubble.xSpeed;
		// bubble.ySpeed = -bubble.ySpeed;
		// score += 5;
		// }
		// if (objectCollision(germRed)) {
		// germRed.alive = false;
		// germImages[4] = null;
		// bubble.xSpeed = -bubble.xSpeed;
		// bubble.ySpeed = -bubble.ySpeed;
		// score += 5;
		// }
		
	}

	public void keyPressed() {
		if (key == 'd') {
			player.moveRight = true;
		} else if (key == 'a') {
			player.moveLeft = true;
		} else if (key == ' ') {
			if (soapMove == false) {
				soapMove = true;
			} else {
				soapMove = false;
			}

		}
	}

	public void keyReleased() {
		if (key == 'd') {
			player.moveRight = false;
		} else if (key == 'a') {
			player.moveLeft = false;
		} else if (key == ' ') {
			if (soapMove == true)
				soapMove = true;
		}
	}

	public boolean objectCollision(Germ germ) {
		if (bubble.xPos > germ.xPos && bubble.xPos < germ.xPos + germ.sprite.width && bubble.yPos > germ.yPos
				&& bubble.yPos < germ.yPos + germ.sprite.height) {
		
			return true;

		} else
			return false;
	}

	public class Paddle {
		int speed = 10;
		public boolean moveRight = false;
		public boolean moveLeft = false;
		PImage sprite;
		float xPos;
		float yPos;

		public void checkBounds() {
			if (this.xPos < 0) {
				this.xPos = 0;
				moveLeft = false;
			}
			if (this.xPos + this.sprite.width > width) {
				this.xPos = width - this.sprite.width;
				moveRight = false;
			}

		}

		public Paddle(PImage paddleSprite, float startX, float startY) {
			sprite = paddleSprite;
			xPos = startX;
			yPos = startY;
		}// Paddle public

		public void drawPaddle() {
			image(sprite, xPos, yPos);
		}

		public void update() {
			if (this.moveRight) {
				this.xPos += this.speed;
			}
			if (this.moveLeft) {
				this.xPos -= this.speed;
			}
			checkBounds();
		}
	}// Paddle class

	public class Ball {
		PImage sprite;
		float xPos;
		float yPos;
		int xSpeed = 8;
		int ySpeed = 8;

		public Ball(PImage ballSprite, float startX, float startY) {
			sprite = ballSprite;
			xPos = startX;
			yPos = startY;

		}

		public void drawBall() {
			image(sprite, xPos, yPos);
		}

		public void update() {
			if (soapMove == true) {
				this.xPos += this.xSpeed;
				this.yPos += this.ySpeed;
				checkBounds();
				checkCollision();
			} else if (soapMove == false) {
				this.xPos = player.xPos + (player.sprite.width / 2);
				this.yPos = player.yPos - sprite.width;
				// checkCollision();
			}
			// checkCollision();

		}

		public void checkBounds() {
			if (this.yPos < 0) {
				this.ySpeed = -this.ySpeed;
			}
			if (this.xPos < 0) {
				this.xSpeed = -this.xSpeed;
				this.xPos = 0;
			}
			if (this.xPos + this.sprite.width > width) {
				this.xSpeed = -this.xSpeed;
				this.xPos = width - this.sprite.width;
			}
			if (this.yPos > height) {
				this.xPos = player.xPos;
				this.yPos = player.yPos - this.sprite.height;
				this.ySpeed = -this.ySpeed;
				soapMove = false;
			}

		}

		public void checkCollision() {
			if (this.xPos + this.sprite.width > player.xPos && this.xPos < player.xPos + player.sprite.width) {
				if (this.yPos > player.yPos - player.sprite.height) {
					this.ySpeed = -this.ySpeed;
					this.yPos = player.yPos - this.sprite.height;
					// this.yPos = player.yPos - sprite.width;
				}
			}
		}
	}

	public class Germ {
		PImage sprite;
		float xPos;
		float yPos;
		int xSpeed = 8;
		int ySpeed = 8;

		boolean alive = true;

		public Germ(PImage ballSprite, float startX, float startY) {
			sprite = ballSprite;
			xPos = startX;
			yPos = startY;
		}

		public void drawGerm() {
			if (this.alive)
				image(sprite, xPos, yPos);
			if (objectCollision(germBlue)) {
				germBlue.alive = false;
				germImages[0] = null;
//				bubble.xSpeed = -bubble.xSpeed;
//				bubble.ySpeed = -bubble.ySpeed;
				//score+=5;
				System.out.println("Score: "+ score);
			}
			if (objectCollision(germOrange)) {
				germOrange.alive = false;
				germImages[1] = null;
//				bubble.xSpeed = -bubble.xSpeed;
//				bubble.ySpeed = -bubble.ySpeed;
				System.out.println("Score: "+ score);
			}
			if (objectCollision(germGreen)) {
				germGreen.alive = false;
				germImages[2] = null;
//				bubble.xSpeed = -bubble.xSpeed;
//				bubble.ySpeed = -bubble.ySpeed;
				//score += 5;
				System.out.println("Score: "+ score);
			}
			if (objectCollision(germYellow)) {
				germYellow.alive = false;
				germImages[3] = null;
//				bubble.xSpeed = -bubble.xSpeed;
//				bubble.ySpeed = -bubble.ySpeed;
				//score += 5;
				System.out.println("Score: "+ score);
			}
			if (objectCollision(germRed)) {
				germRed.alive = false;
				germImages[4] = null;
//				bubble.xSpeed = -bubble.xSpeed;
//				bubble.ySpeed = -bubble.ySpeed;
				//score += 5;
				System.out.println("Score: "+ score);
			}
		}

		public void update() {
			if (this.alive) {
				this.xPos += this.xSpeed;
				this.yPos += this.ySpeed;
				checkBounds();
				checkCollision();
			} else {
				this.xPos = 2000;
				;
			}

		}

		public void checkBounds() {
			if (this.yPos < 0) {
				this.ySpeed = -this.ySpeed;
				this.ySpeed += random.nextInt(5) - 2;
			}
			if (this.xPos < 0) {
				this.xSpeed = -this.xSpeed;
				this.xPos = 0;
				this.ySpeed += random.nextInt(5) - 2;
			}
			if (this.xPos + this.sprite.width > width) {
				this.xSpeed = -this.xSpeed;
				this.xPos = width - this.sprite.width;
				this.ySpeed += random.nextInt(5) - 2;
			}
			
			if (this.yPos > height / 2) {
				this.ySpeed = -this.ySpeed;
				this.ySpeed += random.nextInt(5) - 2;
			}

		}

		public void checkCollision() {
			if (this.xPos + this.sprite.width > bubble.xPos && this.xPos < bubble.xPos + bubble.sprite.width) {
				if (this.yPos + this.sprite.height > bubble.yPos && this.yPos < bubble.yPos + bubble.sprite.height) {
					this.alive = false;
					
					score+=5;
					score2 = ((Integer) score).toString();
					text("Score: " + score2, 10, 10, 150, 100);
					textSize(38);
					fill(255, 255, 255);
					bubble.xSpeed = -bubble.xSpeed;
					bubble.ySpeed = -bubble.ySpeed;
				} // if
			} // bigger if
		}// checkCollision

	} // germ end
		// class

	public static void main(String _args[]) {
		PApplet.main(new String[] { germwars.GermWars.class.getName() });
	}
}// germ wars class