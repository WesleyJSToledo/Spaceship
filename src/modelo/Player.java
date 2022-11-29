package modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	private int x, y;
	private int dx, dy;
	private Image image;
	private int height, width;
	
	public Player() {
		this.x = 100;
		this.y = 100;
	}
	
	public void load() {
		ImageIcon reference = new ImageIcon("res/spaceship.png");
		image = reference.getImage();
		height = image.getHeight(null);
		width = image.getWidth(null);
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void keyPressed(KeyEvent button) {
		int code = button.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			dy = -3;
		} 
		
		if(code == KeyEvent.VK_DOWN) {
			dy = 3;
		} 
		
		if(code == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		
		if(code == KeyEvent.VK_RIGHT) {
			dx = 3;
		} 
	}
	
	public void keyRelease(KeyEvent button) {
		int code = button.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			dy = 0;
		} 
		
		if(code == KeyEvent.VK_DOWN) {
			dy = 0;
		} 
		
		if(code == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		
		if(code == KeyEvent.VK_RIGHT) {
			dx = 0;
		} 
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}
	
	
}
