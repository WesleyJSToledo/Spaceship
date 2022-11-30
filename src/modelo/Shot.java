package modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Shot {
	
	private Image image;
	private int x, y;
	private int height, width;
	private boolean isVisible;
	
	private static final int WIDTH = 938;
	private static int VELOCITY = 2;
	
	public Shot(int x, int y) {
		this.x = x;
		this.y = y;
		isVisible = true;
		
	}
	
	public Image getImage() {
		return image;
	}

	public void load() {
		ImageIcon reference = new ImageIcon("res/playershot.png");
		image = reference.getImage();
		
		this.height = image.getHeight(null);
		this.width = image.getWidth(null);
	}
	
	public void update() {
		this.x += VELOCITY;
		if(this.x > WIDTH) {
			isVisible = false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public static int getVELOCITY() {
		return VELOCITY;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public static void setVELOCITY(int vELOCITY) {
		VELOCITY = vELOCITY;
	}
	
}
