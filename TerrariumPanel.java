package progrLab3;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TerrariumPanel extends JPanel 
{
	private Terrarium terrarium;
	
	public TerrariumPanel(Terrarium ter){
		updateTerrariumPanel(ter);
	}
	
	public void updateTerrariumPanel(Terrarium ter){
		this.terrarium=ter;
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		terrarium.Draw(g);
	}
}
