package package0;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import package0.Game.ChoiceHandler;

public class UI {
	
	JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, exitButtonPanel;
    JLabel titleNameLabel, startButtonLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font fontTitle = new Font("Times New Roman", Font.PLAIN, 69);
    Font fontButton = new Font("Times New Roman", Font.PLAIN, 40);
    Font fontBasic = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4,exitButton;
    JTextArea mainTextArea;
    String playerWeapon;

	
	public void createUI(ChoiceHandler cHandler) {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		
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
		window.add(startButtonPanel);
		
		startButton = new JButton();
		startButton.setBackground(Color.black);
		startButton.setFocusPainted(false);
		startButton.setBorderPainted(true);
		startButton.setActionCommand("start");
		startButton.addActionListener(cHandler);
		startButton.add(startButtonLabel);
		
		
		startButtonPanel.add(startButton);
		titleNamePanel.add(titleNameLabel);
		window.add(titleNamePanel);
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);
		
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
		window.add(choiceButtonPanel);
		
		choice1 = new JButton();
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.WHITE);
		choice1.setFont(fontBasic);
		choice1.setFocusPainted(false);
		choice1.setActionCommand("c1");
		choice1.addActionListener(cHandler);
		
		
		
		choice2 = new JButton();
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.WHITE);
		choice2.setFont(fontBasic);
		choice2.setFocusPainted(false);
		choice2.setActionCommand("c2");
		choice2.addActionListener(cHandler);
		
		
		
		choice3 = new JButton();
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.WHITE);
		choice3.setFont(fontBasic);
		choice3.setFocusPainted(false);
		choice3.setActionCommand("c3");
		choice3.addActionListener(cHandler);
		
		
		
		choice4 = new JButton();
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.WHITE);
		choice4.setFont(fontBasic);
		choice4.setFocusPainted(false);
		choice4.setActionCommand("c4");
		choice4.addActionListener(cHandler);
		
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		window.add(playerPanel);
		
		exitButtonPanel = new JPanel();
		exitButtonPanel.setBounds(100, 400, 100, 180);
		exitButtonPanel.setBackground(Color.black);
		window.add(exitButtonPanel);
		
		exitButton = new JButton("Exit to menu");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.gray);
		exitButton.setFont(fontBasic);
		exitButton.addActionListener(cHandler);
		exitButton.setActionCommand("exit");
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
		
		
		window.setVisible(true);
	}

}
