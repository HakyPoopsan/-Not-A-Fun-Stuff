package package0;

import package2.Monster_Creeper;
import package2.Monster_Goblin;
import package2.Weapon_Knife;
import package2.Weapon_LongSword;

public class Story {
	
	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperMonster monster;
	
	int silverRing = 0;
	
    public Story(Game g, UI userInterface, VisibilityManager vManager) {
    	
    	game = g;
    	ui = userInterface;
    	vm = vManager;
    	
    }
    
    public void defaultSetup() {
    	
    	player.hp = 10;
    	player.currentWeapon = new Weapon_Knife();
    	
    	ui.weaponLabelName.setText(player.currentWeapon.name);
    	ui.hpLabelNumber.setText(""+player.hp);
    }
    
        public void selectPosition(String nextPosition){
        	
        	if (nextPosition == "talkGuard") {
        		talkGuard();
        	}
        	else if (nextPosition == "attackGuard") {
        		attackGuard();
        	}
        	else if (nextPosition == "crossRoad") {
        		crossRoad();
        	}
        	else if (nextPosition == "townGate") {
        		townGate();
        	}
        	else if (nextPosition == "north") {
        		north();
        	}
            else if (nextPosition == "east") {
        		east();
        	}
            else if (nextPosition == "west") {
	            west();
            }
            else if (nextPosition == "fight") {
	            fight();
            }
            else if (nextPosition == "run") {
	            ruin();
            }
            else if (nextPosition == "playerAttack") {
	            playerAttack();
            }
            else if (nextPosition == "monsterAttack") {
	            monsterAttack();
            }
            else if (nextPosition == "win") {
	            win();
            }
            else if (nextPosition == "lose") {
	            lose();
            }
            else if (nextPosition == "toTitle") {
	            toTitle();
            }
        	
        }
    	
    	
    	public void townGate() {
    		ui.mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \nWhat do you do?");
    		
    		ui.choice2.setVisible(true);
    		ui.choice3.setVisible(true);
    		ui.choice1.setText("Talk to the guard");
    		ui.choice2.setText("Attack the guard");
    		ui.choice3.setText("Leave");
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "talkGuard";
    		game.nextPosition2 = "attackGuard";
    		game.nextPosition3 = "crossRoad";
    		game.nextPosition4 = "";
    		
    		
    	}
    	
    	public void talkGuard() {
    		
    		if (silverRing == 0) { 
    	    ui.mainTextArea.setText("Guard: Hello, stranger. \nI have never seen you face before.\nI'm sorry, but we cannot let a stranger enter our town.");
    		
    		ui.choice1.setText(">");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		
    		game.nextPosition1 = "townGate";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    		
    		}
    		else if (silverRing == 1) {
    			 ending();
    			
    		}
    		
    		
    		
    	}
    	
    	public void attackGuard() {
    		ui.mainTextArea.setText("Guard: Hey, don't be foolish!\nThe guard fought back and hit you hard\n(You recieve 3 damage)");
    		
    		player.hp-=3;
    		ui.hpLabelNumber.setText(""+ player.hp);
    		ui.choice1.setText(">");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		
    		game.nextPosition1 = "townGate";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    		
    	}
    	
    	public void crossRoad() {
    		
    		ui.mainTextArea.setText("You are at crossroad.\nIf you go south, you will get back to the town.");
    		
    		ui.choice1.setVisible(true);
    		ui.choice2.setVisible(true);
    		ui.choice3.setVisible(true);
    		ui.choice4.setVisible(true);
    		
    		ui.choice1.setText("Go north");
    		ui.choice2.setText("Go east");
    		ui.choice3.setText("Go west");
    		ui.choice4.setText("Go south");
    		
    		game.nextPosition1 = "north";
    		game.nextPosition2 = "east";
    		game.nextPosition3 = "west";
    		game.nextPosition4 = "townGate";
    		
    		
    	}
    	
    	public void north() {
    		ui.mainTextArea.setText("There is a river.\nYou drink the water and rest at the riverside for a bit.\n(Your HP are recovered by 2)");
    		
    		player.hp+=2;
    		ui.hpLabelNumber.setText(""+ player.hp);
    		
    		ui.choice1.setText("Go south");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "crossRoad";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    		
    	}
    	
    	public void east() {
    		
    		ui.mainTextArea.setText("You walked into a dark forest and found a Long Sword.\n(You obtained a Long Sword)");
    		
    		player.currentWeapon = new Weapon_LongSword();
        	
        	ui.weaponLabelName.setText(player.currentWeapon.name);
    		
    		ui.choice1.setText("Go west");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "crossRoad";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    		
    		
    	}
    	
    	public void west() {
    		
    		int i = new java.util.Random().nextInt(100)+1;
    		
    		if (i<90) {
    			monster = new Monster_Goblin();
    		}
    		else {
    			monster = new Monster_Creeper();
    		}
    		
    		
    		
    		ui.mainTextArea.setText("You encounter a " + monster.name + "!\n");
    		
    		ui.choice1.setVisible(true);
    		ui.choice2.setVisible(true);
    		
    		ui.choice1.setText("Fight!");
    		ui.choice2.setText("Run");
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "fight";
    		game.nextPosition2 = "run";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    	}
    	
    	public void ruin() {
    		
    		ui.mainTextArea.setText("You got startled and decided to run away!\n" + monster.name + " roared at you and punched you before you managed\n to escape him.\n(You recieve 5 damage)");
    		
    		player.hp-=4;
    		ui.hpLabelNumber.setText(""+ player.hp);
    		
    		ui.choice1.setText(">");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "crossRoad";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    	}
    	
    	public void fight(){
    		
    		ui.mainTextArea.setText(monster.name + " HP: " + monster.hp + "\nWhat do you do?");
    		
    		ui.choice1.setVisible(true);
    		ui.choice2.setVisible(true);
    		
    		ui.choice1.setText("Attack");
    		ui.choice2.setText("Run");
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "playerAttack";
    		game.nextPosition2 = "run";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    		
    		
    	}
    	
    	public void playerAttack() {
    		
    		int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
    		
    		
    		ui.mainTextArea.setText("You attacked the " + monster.name + " and gave " + playerDamage + " damage!");
    		
    		monster.hp -=playerDamage;
    		
    		ui.choice1.setText(">");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		if (monster.hp > 0) {
    			game.nextPosition1 = "monsterAttack";
        		game.nextPosition2 = "";
        		game.nextPosition3 = "";
        		game.nextPosition4 = "";
    		}
    		else if (monster.hp<1) {
    			
    			game.nextPosition1 = "win";
        		game.nextPosition2 = "";
        		game.nextPosition3 = "";
        		game.nextPosition4 = "";
    			
    		}
    		
    		
    	}
    	
    	public void monsterAttack() {
    		int monsterDamage = new java.util.Random().nextInt(monster.attack);
    		
    		
    		ui.mainTextArea.setText(monster.attackMessage + " and you gain " + monsterDamage + " damage!");
    		
    		player.hp -=monsterDamage;
    		ui.hpLabelNumber.setText(""+ player.hp);
    		
    		
    		ui.choice1.setText(">");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		if (player.hp > 0) {
    			game.nextPosition1 = "fight";
        		game.nextPosition2 = "";
        		game.nextPosition3 = "";
        		game.nextPosition4 = "";
    		}
    		else if (player.hp<1) {
    			
    			game.nextPosition1 = "lose";
        		game.nextPosition2 = "";
        		game.nextPosition3 = "";
        		game.nextPosition4 = "";
    			
    		}
    		
    		
    	}
    	
    	public void lose() {
    		ui.mainTextArea.setText("You are dead.\n<GAME OVER>");
    		
    		ui.choice1.setVisible(false);
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    	}
    	
    	public void win() {
    		ui.mainTextArea.setText("You have defeated the " + monster.name + "!\nThe " + monster.name + " dropped a ring.\n(You obtained a Silver Ring)");
    		
    		silverRing = 1;
    		
    		ui.choice1.setText("Go east");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "crossRoad";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    		
    		
    	}
    	
    	public void ending() {
    		
    		ui.mainTextArea.setText("Guard: Oh, you killed the" + monster.name + "?\nThank you so much, you are true hero!\nWelcome to our town!\n<THE END>");
    		
    		ui.choice1.setText("To the title");
    		ui.choice2.setVisible(false);
    		ui.choice3.setVisible(false);
    		ui.choice4.setVisible(false);
    		
    		game.nextPosition1 = "toTitle";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "";
    		
    	}
    	
    	public void toTitle() {
    		defaultSetup();
    		vm.showTitleScreen();
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
}
