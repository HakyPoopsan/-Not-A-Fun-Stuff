
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import javax.swing.JPanel;



public class CookieMain {

	JPanel cookiePanel;
	JLabel counterLabel, perSecLabel;
	int cookieCounter, timerSpeed, cursorNumber, cursorPrice, grandpaNumber, grandpaPrice, bakeryNumber, bakeryPrice, factoryNumber, factoryPrice, totalCookieCounter;
	double perSecond;
	boolean timerOn, grandpaUnlocked, bakeryUnlocked, factoryUnlocked;
	Font font1, font2, font3;
	CookieHandler cHandler = new CookieHandler();
	JButton button1, button2, button3, button4;
	Timer timer;
	JTextArea messageText;
	MouseHandler mHandler = new MouseHandler();
	
	
	public static void main(String[] args) {
		new CookieMain();

	}
	public CookieMain(){
		timerOn = false;
		perSecond = 0;
		cookieCounter = 0;
		cursorNumber = 0;
		cursorPrice = 10;
		grandpaNumber = 0;
		grandpaPrice = 60;
		grandpaUnlocked = false;
		bakeryNumber = 0;
		bakeryPrice = 800;
		bakeryUnlocked = false;
		factoryNumber = 0;
		factoryPrice = 10000;
		factoryUnlocked = false;
		createFont();
		createUI();
	
	}
	public void createFont(){
		font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
		font2 = new Font("Comic Sans MS", Font.PLAIN, 15);
		
	}
	public void createUI(){
		JFrame window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		cookiePanel = new JPanel();
		cookiePanel.setBounds(100, 220, 260, 260);
		cookiePanel.setBackground(Color.black);
		
		window.add(cookiePanel);
		
		ImageIcon cookie = new ImageIcon(getClass().getClassLoader().getResource("CookiePNG.png"));
		JButton cookieButton = new JButton();
		cookieButton.setBackground(Color.black);
		cookieButton.setFocusPainted(false);
		cookieButton.setBorder(null);
		cookieButton.setIcon(cookie);
		cookieButton.addActionListener(cHandler);
		cookieButton.setActionCommand("cookie");
		cookiePanel.add(cookieButton);
		
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100, 100, 200, 100);
		counterPanel.setBackground(Color.black);
		counterPanel.setLayout(new GridLayout(2,1));
		window.add(counterPanel);
		
		counterLabel = new JLabel(cookieCounter + " cookies");
		counterLabel.setForeground(Color.white);
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.white);
		perSecLabel.setFont(font2);
		counterPanel.add(perSecLabel);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(450, 200, 300, 300);
		itemPanel.setBackground(Color.black);
		itemPanel.setLayout(new GridLayout(4,1));
		window.add(itemPanel);
		
		button1 = new JButton();
		button1.setFont(font1);
		button1.setFocusPainted(false);
		button1.addActionListener(cHandler);
		button1.setActionCommand("Cursor");
		button1.addMouseListener(mHandler);
		button1.setText("Cursor");
		itemPanel.add(button1);
		
		button2 = new JButton();
		button2.setFont(font1);
		button2.setFocusPainted(false);
		button2.addActionListener(cHandler);
		button2.setActionCommand("Grandpa");
		button2.addMouseListener(mHandler);
		button2.setText("[Locked]");
		itemPanel.add(button2);
		
		button3 = new JButton();
		button3.setFont(font1);
		button3.setFocusPainted(false);
		button3.addActionListener(cHandler);
		button3.setActionCommand("Bakery");
		button3.addMouseListener(mHandler);
		button3.setText("[Locked]");
		itemPanel.add(button3);
		
		button4 = new JButton();
		button4.setFont(font1);
		button4.setFocusPainted(false);
		button4.addActionListener(cHandler);
		button4.setActionCommand("Factory");
		button4.addMouseListener(mHandler);
		button4.setText("[Locked]");
		itemPanel.add(button4);
		
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(450, 100, 300, 200);
		messagePanel.setBackground(Color.black);
		window.add(messagePanel);
		
		messageText = new JTextArea();
		messageText.setBounds(450, 100, 300, 200);
		messageText.setForeground(Color.white);
		messageText.setBackground(Color.black);
		messageText.setFont(font2);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setEditable(false);
		messagePanel.add(messageText);
		
		
		
		window.setVisible(true);
	}
	
	public void setTimer(){
		
		timer = new Timer(timerSpeed, new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				cookieCounter++;
				counterLabel.setText(cookieCounter + " cookies");
				totalCookieCounter +=cookieCounter;
				
				if(grandpaUnlocked==false){
					if(cookieCounter>=100) {
						grandpaUnlocked = true;
						button2.setText("Grandpa" + "(" + grandpaNumber + ")");
					}
				}
				if (bakeryUnlocked == false) {
					if (cookieCounter >=2000) {
						bakeryUnlocked = true;
						button3.setText("Bakery" + "(" + bakeryNumber + ")");
					}
				}
				if (factoryUnlocked == false) {
					if (cookieCounter >=15000) {
						factoryUnlocked = true;
						button4.setText("Factory" + "(" + factoryNumber + ")");
					}
				}
				
				}
		});
	}
		
	public void timerUpdate(){
			if (timerOn == false) {
				timerOn = true;
			}
			else if (timerOn == true) {
				timer.stop();
			}
			double speed = 1/perSecond*1000;
			timerSpeed = (int)Math.round(speed);
			
			String s = String.format("%.1f", perSecond);
			perSecLabel.setText("per second: " + s);
			
			
			setTimer();
			timer.start();
	}
	
	
	public class CookieHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String action = event.getActionCommand();
			System.out.println(totalCookieCounter);
			
			if (action == "cookie"){
				cookieCounter++;
				counterLabel.setText(cookieCounter + " cookies");
				
				}
			if (action == "Cursor") {
				if (cookieCounter>= cursorPrice) {
				  
				  cookieCounter -= cursorPrice;
				  cursorPrice += cursorPrice * 0.1;
				  counterLabel.setText(cookieCounter + " cookies");
				  
				  cursorNumber++;
				  button1.setText("Cursor" + "(" + cursorNumber + ")");
				  messageText.setText("Cursor\n[price: " + cursorPrice + "]\nEach cursor autoclicks once every 10 seconds.");
				  
				  perSecond += 0.1;
				  timerUpdate();
				  }
				else {
					messageText.setText("You need more cookies!");
				}}
			 if (action == "Grandpa") {
				 if (cookieCounter>= grandpaPrice) {
					  
					  cookieCounter -= grandpaPrice;
					  grandpaPrice += grandpaPrice * 0.1;
					  counterLabel.setText(cookieCounter + " cookies");
					  
					  grandpaNumber++;
					  button2.setText("Grandpa" + "(" + grandpaNumber + ")");
					  messageText.setText("Grandpa\n[price: " + grandpaPrice + "]\nEach grandpa produces 3 cookies per second.");
					  
					  perSecond += 3;
					  timerUpdate();
					  }
					else {
						messageText.setText("You need more cookies!");
					} 
			 }
			 if (action == "Bakery") {
				 if (cookieCounter>= bakeryPrice) {
					  
					  cookieCounter -= bakeryPrice;
					  bakeryPrice += bakeryPrice * 0.1;
					  counterLabel.setText(cookieCounter + " cookies");
					  
					  bakeryNumber++;
					  button3.setText("Bakery" + "(" + bakeryNumber + ")");
					  messageText.setText("Bakery\n[price: " + bakeryPrice + "]\nEvery bakery produces 24 cookies per second.");
					  
					  perSecond += 24;
					  timerUpdate();
					  }
					else {
						messageText.setText("You need more cookies!");
					} 
			 }
			 if (action == "Factory") {
				 if (cookieCounter>= factoryPrice) {
					  
					  cookieCounter -= factoryPrice;
					  factoryPrice += factoryPrice * 0.1;
					  counterLabel.setText(cookieCounter + " cookies");
					  
					  factoryNumber++;
					  button4.setText("Factory" + "(" + factoryNumber + ")");
					  messageText.setText("Factory\n[price: " + factoryPrice + "]\nEvery factory produces 100 cookies per second.");
					  
					  perSecond += 100;
					  timerUpdate();
					  }
					else {
						messageText.setText("You need more cookies!");
					} 
			 }
			
		}
		
	}
	public class MouseHandler implements MouseListener{
		
		public void mouseClicked(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
					public void mouseEntered(MouseEvent e) {
						JButton button = (JButton)e.getSource();
						
						if (button == button1) {
							messageText.setText("Cursor\n[price: " + cursorPrice + "]\n Each cursor autoclicks once every 10 seconds.");
						}
						else if (button == button2) {
							if (grandpaUnlocked == false) {
							messageText.setText("This item is currently locked!\nCollect 100 cookies to unlock this item!\n[" + cookieCounter + "/100]");}
							else {
								messageText.setText("Grandpa\n[price: " + grandpaPrice + "]\nEach grandpa produces 3 cookies per second.");
							}
						}
						else if (button == button3) {
							if (bakeryUnlocked == false) {
								messageText.setText("This item is currently locked!\nCollect 2000 cookies to unlock this item!\n[" + cookieCounter + "/2000]");}
								else {
									messageText.setText("Bakery\n[price: " + bakeryPrice + "]\nEvery bakery produces 24 cookies per second.");
								}
						}
						else if (button == button4) {
							if (factoryUnlocked == false) {
								messageText.setText("This item is currently locked!\nCollect 15000 cookies to unlock this item!\n[" + cookieCounter + "/15000]");}
								else {
									messageText.setText("Factory\n[price: " + factoryPrice + "]\nEvery factory produces 100 cookies per second.");
								}
						}}
						public void mouseExited(MouseEvent e) {
							JButton button = (JButton)e.getSource();
							
							if (button == button1) {
								messageText.setText(null);
							}
							else if (button == button2) {
								messageText.setText(null);
							}
							else if (button == button3) {
								messageText.setText(null);
							}
							else if (button == button4) {
								messageText.setText(null);
							}
						}}
					
				
			
		
	}


