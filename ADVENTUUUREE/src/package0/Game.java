package package0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

	UI ui = new UI();
	ChoiceHandler cHandler = new ChoiceHandler();
	VisibilityManager vm = new VisibilityManager(ui);
	Story story = new Story(this, ui, vm);
	
	String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
	
	public static void main(String[] args) {
		
		new Game();

	}

	public Game() {
		
		ui.createUI(cHandler);
		story.defaultSetup();
		vm.showTitleScreen();
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			
			String yourChoice = event.getActionCommand();
			
			if (yourChoice == "start") {
				vm.showGameScreen();
				story.townGate();
			}
			else if (yourChoice == "exit") {
				vm.showTitleScreen();
			}
			else if (yourChoice == "c1") {
				story.selectPosition(nextPosition1);
			}
			else if (yourChoice == "c2") {
				story.selectPosition(nextPosition2);
			}
			else if (yourChoice == "c3") {
				story.selectPosition(nextPosition3);
			}
			else if (yourChoice == "c4") {
				story.selectPosition(nextPosition4);
			}
		}}
}
