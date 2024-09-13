package package0;

public class VisibilityManager {
	
	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		ui = userInterface;
		
	}
	
	public void showTitleScreen() {
		
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.exitButtonPanel.setVisible(false);
		
	}
	
	public void showGameScreen() {
		
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
		ui.mainTextPanel.setVisible(true);
		ui.exitButtonPanel.setVisible(true);
		
	}

}
