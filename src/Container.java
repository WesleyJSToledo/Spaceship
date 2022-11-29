import javax.swing.JFrame;
import modelo.Stage;

public class Container extends JFrame{

		public Container() {
			add(new Stage());
			setTitle("Spaceship");
			setSize(1024, 576);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			this.setResizable(false);
			setVisible(true);
		}
		
		public static void main(String[] args) {
			new Container();
		}
}
