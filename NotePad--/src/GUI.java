

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JFrame;




public class GUI implements ActionListener {

	JFrame window;
	TextArea textArea;
	ScrollPane scrollPane;
	boolean wordWrapOn = false;
	MenuBar menuBar;
	Menu menuFile, menuEdit, menuFormat, menuColor;
	MenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	MenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12,iFontSize16, iFontSize20, iFontSize24 , iFontSize28;
	Menu menuFont, menuFontSize;
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);
	
	
	
	public static void main(String[] args) {
		
		new GUI();

	}
	public GUI(){
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		
		
		window.setVisible(true);
		
		
	}
	public void createWindow(){
		
		window = new JFrame("Notepad--");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public void createTextArea() {
		
		textArea = new TextArea();
		scrollPane = new ScrollPane( ScrollPane.SCROLLBARS_AS_NEEDED);
		
		scrollPane.add(textArea);
		window.add(scrollPane);
		
	}
	
	public void createMenuBar() {
		
		menuBar = new MenuBar();
		window.setMenuBar(menuBar);
		
		menuFile = new Menu("File");
		menuBar.add(menuFile);
		
		menuEdit = new Menu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new Menu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new Menu("Color");
		menuBar.add(menuColor);
		
		
		
		
	}
	
	public void createFileMenu() {
		
		iNew = new MenuItem("New");
		iNew.setActionCommand("New");
		iNew.addActionListener(this);
		menuFile.add(iNew);
		
		iOpen = new MenuItem("Open");
		iOpen.setActionCommand("Open");
		iOpen.addActionListener(this);
		menuFile.add(iOpen);
		
		iSave = new MenuItem("Save");
		iSave.setActionCommand("save");
		iSave.addActionListener(this);
		menuFile.add(iSave);
		
		iSaveAs = new MenuItem("Save As");
		iSaveAs.setActionCommand("SaveAs");
		iSaveAs.addActionListener(this);
		menuFile.add(iSaveAs);
		
		iExit = new MenuItem("Exit");
		iExit.setActionCommand("exit");
		iExit.addActionListener(this);
		menuFile.add(iExit);
		
	}
	
	public void createFormatMenu(){
		
		iWrap = new MenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		menuFont = new Menu("Font");
		menuFormat.add(menuFont);
		

		iFontArial = new MenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new MenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new MenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		menuFontSize = new Menu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new MenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new MenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new MenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new MenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new MenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28 = new MenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontSize.add(iFontSize28);
		
		
		
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if (command == "New") {
			file.newFile();
		}
		else if (command == "Open") {
			file.open();
		}
		else if (command == "SaveAs") {
			file.saveAs();
		}
		else if (command == "save") {
			file.save();
		}
		else if (command == "exit") {
			file.exit();
		}
		else if (command == "Word Wrap"){
			format.wrap();
		}
		
	}
	
	

}
