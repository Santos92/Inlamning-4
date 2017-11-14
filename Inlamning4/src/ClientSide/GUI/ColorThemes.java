package ClientSide.GUI;

import java.awt.Color;
import java.awt.Font;


public class ColorThemes {

	private Color topBG;
	private Color BG;
	private Color txFdBG;
	private Color buttonBG;
	private Color text;
	private Font headingFont, btnFont;
	
	public ColorThemes(Color topBG, Color BG, Color txFdBG, Color buttonBG, Color text){
		this.topBG = topBG;
		this.BG = BG;
		this.txFdBG = txFdBG;
		this.buttonBG = buttonBG;
		this.text = text;
	}

	public Color getTopBG() {
		return topBG;
	}
	
	public Color getBG() {
		return BG;
	}
	
	public Color getTxFdBG() {
		return txFdBG;
	}

	public Color getButtonBG() {
		return buttonBG;
	}

	public Color getText() {
		return text;
	}
	
	
	

	 
	
}
