package progrLab3;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form1 {

	private JFrame frame;
	private JTextField textField;
	 Color color;
	 Color dopColor;
	 int maxCountMouse;
	 int maxCountBirds;
	 int maxSpeed;
	 int height;
	 private Terrarium terrarium;

	 private Interface1 inter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form1 window = new Form1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Form1() {
		terrarium=new Terrarium();
		color=Color.green;
		dopColor=Color.YELLOW;
		maxSpeed=150;
		maxCountMouse=15;
		maxCountBirds=29;
		height=200;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TerrariumPanel panelBig = new TerrariumPanel(terrarium);
		panelBig.setBounds(10, 11, 460, 411);
		frame.getContentPane().add(panelBig);
		
		JButton button1 = new JButton("\u041E\u0442\u0434\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interface1 inter = new PoisonousSnake(maxSpeed, maxCountMouse,maxCountBirds, height, color, dopColor);
				int place = terrarium.putSnakeInTerrarium(inter);
				if (place > -1) {
					
					panelBig.updateTerrariumPanel(terrarium);
					JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Мест нет", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button1.setBounds(492, 11, 152, 23);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("\u041E\u0442\u0434\u0430\u0442\u044C \u043A\u043E\u0431\u0440\u0443");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface1 inter = new Kobra(maxSpeed,maxCountMouse,maxCountBirds,height,Color.BLUE,true,true,Color.red);
				int place = terrarium.putSnakeInTerrarium(inter);
				if (place > -1) {
					
					panelBig.updateTerrariumPanel(terrarium);
					JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Мест нет:", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button2.setBounds(492, 45, 152, 23);
		frame.getContentPane().add(button2);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(480, 247, 46, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(536, 244, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);		
		
		SnakePanel panelSmall = new SnakePanel();
		panelSmall.setBounds(480, 303, 164, 119);
		frame.getContentPane().add(panelSmall);
		
		JButton button3 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != "") {
					Interface1 inter = terrarium.getSnakeInTerrarium(Integer.parseInt(textField.getText()) - 1);
					if (inter != null) {
						inter.setPosition(25, 55);
						panelBig.updateTerrariumPanel(terrarium);
						panelSmall.updatePanel(inter);
					} else {
						JOptionPane.showMessageDialog(null, "На таком месте нет змеи", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		button3.setBounds(511, 272, 89, 23);
		frame.getContentPane().add(button3);
	
	}

}
