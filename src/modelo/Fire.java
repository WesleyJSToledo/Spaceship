package modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Fire {
	private Image image;
	private int x, y;
	private int height, width;
	private boolean isVisible;
	
	private static final int WIDTH = 938;
	private static final int VELOCITY = 2;
	
	public Fire(int x, int y) {
		this.x = x;
		this.y = y;
		isVisible = true;
		
	}
	
	public void load() {
		ImageIcon reference = new ImageIcon();
		image = reference.getImage();
		
	}
}
