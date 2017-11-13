package ClientSide.GUI;

import java.awt.Color;

public class ColorThemes {

	private Color topBG;
	private Color BG;
	private Color buttonBG;
	private Color text;
	
	public ColorThemes(Color topBG, Color BG, Color buttonBG, Color text){
		this.topBG = topBG;
		this.BG = BG;
		this.buttonBG = buttonBG;
		this.text = text;
	}

	public Color getTopBG() {
		return topBG;
	}
	
	public Color getBG() {
		return BG;
	}

	public Color getButtonBG() {
		return buttonBG;
	}

	public Color getText() {
		return text;
	}
	
	
	

	 
	
}
