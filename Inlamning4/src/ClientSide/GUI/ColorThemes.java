package ClientSide.GUI;

import java.awt.Color;


public class ColorThemes {

    private Color startGameBG; // green
	private Color topBG;
	private Color BG;
	private Color txFdBG;
	private Color buttonBG;
	private Color buttonChangeCategory1;
	private Color buttonChangeCategory2;
	private Color buttonChangeCategory3;
	private Color text;
	
	public ColorThemes(Color startGameBG, Color topBG, Color BG, Color txFdBG, 
			Color buttonBG,Color buttonChangeCategory1,Color buttonChangeCategory2,
			Color buttonChangeCategory3, Color text){
		this.startGameBG = startGameBG;
		this.topBG = topBG;
		this.BG = BG;
		this.txFdBG = txFdBG;
		this.buttonBG = buttonBG;
		this.buttonChangeCategory1 = buttonChangeCategory1;
		this.buttonChangeCategory2 = buttonChangeCategory2;
		this.buttonChangeCategory3 = buttonChangeCategory3;
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

	public Color getChangeCate1() {
		return buttonChangeCategory1;
	}
	
	public Color getChangeCate2() {
		return buttonChangeCategory2;
	}
	
	public Color getChangeCate3() {
		return buttonChangeCategory3;
	}
	
	public Color getText() {
		return text;
	}
}
