package modelo;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Stage extends JPanel implements ActionListener {

	private Image background;
	private Player player;
	private Timer timer;

	public Stage() {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon reference = new ImageIcon("res/background.jpg");
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

		List<Shot> shots = player.getShots();
		for (int i = 0; i < shots.size(); i++) {
			Shot m = shots.get(i);
			m.load();
			graphics.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();

		List<Shot> shots = player.getShots();
		for (int i = 0; i < shots.size(); i++) {
			Shot m = shots.get(i);
			if (isVisible()) {
				m.update();
			} else {
				shots.remove(i);
			}
		}

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
