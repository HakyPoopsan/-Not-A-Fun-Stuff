
public class Function_Format {

	GUI gui;
	
	public Function_Format(GUI gui) {
		
		this.gui = gui;
		
	}
	
	public void wrap(){
		
		if (gui.wordWrapOn == false){
			
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: On");
			
			
		}
		else if (gui.wordWrapOn == false){
			
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: Off");
			
		}
	}
}
