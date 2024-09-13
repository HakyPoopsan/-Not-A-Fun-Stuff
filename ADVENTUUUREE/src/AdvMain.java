
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
   

public class AdvMain {
	JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, exitButtonPanel;
    JLabel titleNameLabel, startButtonLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font fontTitle = new Font("Times New Roman", Font.PLAIN, 69);
    Font fontButton = new Font("Times New Roman", Font.PLAIN, 40);
    Font fontBasic = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4,exitButton;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String playerWeapon, position;
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    MenuHandler menuHandler = new MenuHandler();
    ChoiceHandler cHandler = new ChoiceHandler();
	
	public static void main(String[] args) {
		new AdvMain();

	}
	
	public AdvMain(){
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		
		
		
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600, 150);
		titleNamePanel.setBackground(Color.black);
		
		
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(fontTitle);
		
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(250, 350, 300, 75);
		startButtonPanel.setBackground(Color.black);
		startButtonLabel = new JLabel("Start");
		startButtonLabel.setFont(fontButton);
		startButtonLabel.setForeground(Color.lightGray);
		con.add(startButtonPanel);
		
		startButton = new JButton();
		startButton.setBackground(Color.black);
		startButton.setFocusPainted(false);
		startButton.setBorderPainted(true);
		startButton.add(startButtonLabel);
		
		startButton.addActionListener(tsHandler);
		startButtonPanel.add(startButton);
		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);
		
		
		
		
		
		
		
		window.setVisible(true);
	}
	
	public void createGameScreen(){
		
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("Totally not an actual game, you see, see, don't have to worry that much, it's just some pranking boiss");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.WHITE);
		mainTextArea.setFont(fontBasic);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.WHITE);
		choice1.setFont(fontBasic);
		choice1.setFocusPainted(false);
		choice1.setActionCommand("c1");
		choice1.addActionListener(cHandler);
		
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.WHITE);
		choice2.setFont(fontBasic);
		choice2.setFocusPainted(false);
		choice2.setActionCommand("c2");
		choice2.addActionListener(cHandler);
		
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.WHITE);
		choice3.setFont(fontBasic);
		choice3.setFocusPainted(false);
		choice3.setActionCommand("c3");
		choice3.addActionListener(cHandler);
		
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.WHITE);
		choice4.setFont(fontBasic);
		choice4.setFocusPainted(false);
		choice4.setActionCommand("c4");
		choice4.addActionListener(cHandler);
		
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		exitButtonPanel = new JPanel();
		exitButtonPanel.setBounds(100, 400, 100, 180);
		exitButtonPanel.setBackground(Color.black);
		con.add(exitButtonPanel);
		
		exitButton = new JButton("Exit to menu");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.gray);
		exitButton.setFont(fontBasic);
		exitButton.addActionListener(menuHandler);
		exitButtonPanel.add(exitButton);
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(fontBasic);
		hpLabel.setForeground(Color.WHITE);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(fontBasic);
		hpLabelNumber.setForeground(Color.lightGray);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(fontBasic);
		weaponLabel.setForeground(Color.WHITE);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(fontBasic);
		weaponLabelName.setForeground(Color.lightGray);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
			
	}
	
	public void playerSetup(){
		
		playerHP = 15;
		monsterHP = 20;
		playerWeapon = "Knife";
		weaponLabelName.setText(playerWeapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
		
	}
	
	public void townGate() {
		mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \nWhat do you do?");
		
		position = "townGate";
		
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setVisible(false);
		
		
	}
	
	public void talkGuard() {
		
		position = "talkGuard";
		
		mainTextArea.setText("Guard: Hello, stranger. \nI have never seen you face before.\nI'm sorry, but we cannot let a stranger enter our town.");
		choice1.setText(">");
		choice2.setVisible(false);
		choice3.setVisible(false);
		
	}
	
	public void attackGuard() {
		
        position = "attackGuard";
		
		mainTextArea.setText("Guard: Hey, don't be foolish!\nThe guard fought back and hit you hard\n(You recieve 3 damage)");
		
		playerHP-=3;
		hpLabelNumber.setText(""+ playerHP);
		choice1.setText(">");
		choice2.setVisible(false);
		choice3.setVisible(false);
		
	}
	
	public void crossRoad() {
		
		position = "crossRoad";
		
		mainTextArea.setText("You are at crossroad.\nIf you go south, you will get back to the town.");
		
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
		
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go west");
		choice4.setText("Go south");
		
		
	}
	
	public void north() {
		
		position = "north";
		
		mainTextArea.setText("There is a river.\nYou drink the water and rest at the riverside for a bit.\n(Your HP are recovered by 2)");
		
		playerHP+=2;
		hpLabelNumber.setText(""+ playerHP);
		
		choice1.setText("Go south");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void east() {
		
		position = "east";
		
		mainTextArea.setText("You walked into a dark forest and found a Long Sword.\n(You obtained a Long Sword)");
		
		playerWeapon = "Long Sword";
		weaponLabelName.setText(playerWeapon);
		
		
		choice1.setText("Go west");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
		
	}
	
	public void west() {
		
		position = "west";
		
		mainTextArea.setText("You encounter a goblin!\n");
		
		choice1.setVisible(true);
		choice2.setVisible(true);
		
		choice1.setText("Fight!");
		choice2.setText("Run");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void ruin() {
		
        position = "run";
		
		mainTextArea.setText("You got startled and decided to run away!\nThe goblin roared at you and punched you before you managed\n to escape him.\n(You recieve 5 damage)");
		
		playerHP-=4;
		hpLabelNumber.setText(""+ playerHP);
		
		choice1.setText(">");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void fight(){
		
        position = "fight";
		
		mainTextArea.setText("Monster HP: " + monsterHP + "\nWhat do you do?");
		
		choice1.setVisible(true);
		choice2.setVisible(true);
		
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setVisible(false);
		choice4.setVisible(false);
		
	}
	
	public void playerAttack() {
		
		position = "playerAttack";
		
		int playerDamage = 0;
		if (playerWeapon == "Knife") {
		playerDamage = new java.util.Random().nextInt(3);
		}
		else if(playerWeapon == "Long Sword") {
		playerDamage = new java.util.Random().nextInt(8);
		}
		
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		
		monsterHP -=playerDamage;
		
		choice1.setText(">");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
		
	}
	
	public void monsterAttack() {
		
        position = "monsterAttack";
		
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(4);
		
		
		mainTextArea.setText("The goblin fought back and you gain " + monsterDamage + " damage!");
		
		playerHP -=monsterDamage;
		hpLabelNumber.setText(""+ playerHP);
		
		
		choice1.setText(">");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
		
	}
	
	public void lose() {
		position = "lose";
		
		mainTextArea.setText("You are dead.\n<GAME OVER>");
		
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void win() {
		position = "win";
		
		mainTextArea.setText("You have defeated the monster!\nThe monster dropped a ring.\n(You obtained a Silver Ring)");
		
		silverRing = 1;
		
		choice1.setText("Go east");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
		
	}
	
	public void ending() {
		
		position = "ending";
		
		mainTextArea.setText("Guard: Oh, you killed that goblin?\nThank you so much, you are true hero!\nWelcome to our town!\n<THE END>");
		
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
			
		}
	}
public class MenuHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			titleNamePanel.setVisible(true);
			startButtonPanel.setVisible(true);
			
			choiceButtonPanel.setVisible(false);
			playerPanel.setVisible(false);
			mainTextPanel.setVisible(false);
			exitButtonPanel.setVisible(false);
			
		}
	}

public class ChoiceHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event) {
		
		String yourChoice = event.getActionCommand();
		
		if(playerHP<1) {
			lose();
		}
		
		if(position=="townGate") {
			if (yourChoice == "c1"){
				if (silverRing == 1){
					ending();
				}
				else {
				talkGuard();}
			}
			else if (yourChoice == "c2") {
				attackGuard();
			}
			else if (yourChoice == "c3"){
				crossRoad();
			}
		}
		else if (position=="talkGuard") {
			
			if(yourChoice == "c1") {
				townGate();
			}
			
		}
		else if (position == "attackGuard") {
			if (yourChoice == "c1") {
				townGate();
			}
		}
		else if (position == "crossRoad") {
			if (yourChoice == "c1"){
				north();
			}
			else if (yourChoice == "c2") {
				east();
			}
			else if (yourChoice == "c3"){
				west();
			}
			else if (yourChoice == "c4") {
				townGate();
			}
		}
		else if (position == "north") {
			if (yourChoice == "c1") {
				crossRoad();
			}
		}
		else if (position == "east") {
			if (yourChoice == "c1") {
				crossRoad();
			}
		}
		else if (position == "west") {
			if (yourChoice == "c1") {
				fight();
			}
			else if (yourChoice == "c2") {
				ruin();
			}
		}
		else if (position == "run") {
			if (yourChoice == "c1") {
				crossRoad();
			}
		}
		else if (position == "fight") {
			if (yourChoice == "c1") {
				playerAttack();
			}
			else if (yourChoice == "c2") {
				ruin();
			}
		}
		else if (position == "monsterAttack") {
			if (yourChoice == "c1") {
				
				fight();
			}
		}
		else if (position == "playerAttack") {
			if (yourChoice == "c1") {
				if (monsterHP<1) {
					win();
				}
				else {
				  monsterAttack();}
			}
		}
		else if (position == "win") {
			if (yourChoice == "c1") {
				crossRoad();
			}
		}
		
}

}
}

