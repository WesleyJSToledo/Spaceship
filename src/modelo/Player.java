package modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	private int x, y;
	private int dx, dy;
	private Image image;
	private int height, width;
	private List <Shot> shots;
	
	public Player() {
		this.x = 100;
		this.y = 100;
		
		shots = new ArrayList<Shot>();
	}
	
	public void load() {
		ImageIcon reference = new ImageIcon("res/spaceship.png");
		image = reference.getImage();
		this.height = image.getHeight(null);
		this.width = image.getWidth(null);
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void simpleShot() {
		this.shots.add(new Shot((x + width), (y + (height/2))));
	}
	
	public void keyPressed(KeyEvent button) {
		int code = button.getKeyCode();
		
		if(code == KeyEvent.VK_A) {
			simpleShot();
		}
		
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

	public List<Shot> getShots() {
		return shots;
	}
	
	
}
