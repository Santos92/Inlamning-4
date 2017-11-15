package ClientSide.GUI;

import java.awt.Color;


public class ColorThemes {

    private Color startGameBG; // green
	private Color topBG;
	private Color BG;
	private Color txFdBG;
	private Color buttonBG;
	private Color text;
	
	public ColorThemes(Color startGameBG, Color topBG, Color BG, Color txFdBG, Color buttonBG, Color text){
		this.startGameBG = startGameBG;
		this.topBG = topBG;
		this.BG = BG;
		this.txFdBG = txFdBG;
		this.buttonBG = buttonBG;
		this.text = text;
	}

	public Color getStartGameBG() {
		return startGameBG;
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
