package modelo;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Stage extends JPanel implements ActionListener{

	private Image background;
	private Player player;
	private Timer timer;
	 
	public Stage() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon reference = new ImageIcon("res/background1.jpg");
		background = reference.getImage();
		
		
		player = new Player();
		player.load();
		
		addKeyListener(new keyAdapter());
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.drawImage(background, 0, 0, null);
		graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		repaint();
	}
	
	
	private class keyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent k) {
			player.keyPressed(k);
		}
		@Override 
		public void keyReleased(KeyEvent k) {
			player.keyRelease(k);
		}
	}
}
