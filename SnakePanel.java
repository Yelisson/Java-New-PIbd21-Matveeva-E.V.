package progrLab6_new;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SnakePanel extends JPanel {

	private Interface1 inter;

	public void updatePanel(Interface1 inter) {
		this.inter = inter;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (inter != null) {
			inter.drawAnimal(g);
		}
	}
}
