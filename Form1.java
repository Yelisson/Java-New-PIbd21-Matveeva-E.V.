package progrLab4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form1 {

	private JFrame frame;
	private JTextField textField;
	Terrarium terrarium;
	private String[] elements = new String[6];
	JList listLevels;
	
	 Color color;
	 Color dopColor;
	 int maxCountMouse;
	 int maxCountBirds;
	 int maxSpeed;
	 int height;

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
		terrarium = new Terrarium(5);

		initialize();
		for (int i = 0; i < 5; i++) {
			elements[i] = "Уровень " + (i+1);
		}

		listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TerrariumPanel panelBig = new TerrariumPanel(terrarium);
		panelBig.setBounds(10, 11, 489, 400);
		frame.getContentPane().add(panelBig);
		
		JLabel label = new JLabel("\u0423\u0440\u043E\u0432\u043D\u0438:");
		label.setBounds(576, 11, 46, 14);
		frame.getContentPane().add(label);
		
		JList list = new JList();
		list.setBounds(447, 116, 175, -70);
		frame.getContentPane().add(list);
		
		JButton button1 = new JButton("\u041E\u0442\u0434\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color colorDialog = JColorChooser.showDialog(null, "JColorChooser Sample", null);
				if (colorDialog != null) {
					Interface1 inter = new PoisonousSnake(maxSpeed, maxCountMouse,maxCountBirds, height, colorDialog, dopColor);
					int place = terrarium.putSnakeInTerrarium(inter);
					if (place > -1) {
						
						panelBig.updateTerrariumPanel(terrarium);
						JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Мест нет", "", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		button1.setBounds(537, 168, 112, 23);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("\u041E\u0442\u0434\u0430\u0442\u044C \u043A\u043E\u0431\u0440\u0443");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color colorDialog1 = JColorChooser.showDialog(null, "JColorChooser Sample", null);
				if (colorDialog1 != null) {
					Color colorDialog = JColorChooser.showDialog(null, "JColorChooser Sample", null);
					if (colorDialog != null) {

						Interface1 inter = new Kobra(maxSpeed,maxCountMouse,maxCountBirds,height,colorDialog,true,true,colorDialog1);
						int place = terrarium.putSnakeInTerrarium(inter);
						if (place > -1) {
							
							panelBig.updateTerrariumPanel(terrarium);
							JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Мест нет:", "", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		button2.setBounds(535, 199, 114, 23);
		frame.getContentPane().add(button2);
		
		JLabel label_1 = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label_1.setBounds(534, 236, 46, 14);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(590, 233, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		SnakePanel panelSmall = new SnakePanel();
		panelSmall.setBounds(501, 291, 175, 120);
		frame.getContentPane().add(panelSmall);
		
		JButton button3 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkPlace(textField.getText())) {
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
		button3.setBounds(537, 257, 112, 23);
		frame.getContentPane().add(button3);
		
		listLevels = new JList(elements);
		listLevels.setBounds(518, 11, 153, 111);
		frame.getContentPane().add(listLevels);
		
		JButton buttonUp = new JButton(">>");
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terrarium.levelUp();
				listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
				panelBig.repaint();
			}
		});
		buttonUp.setBounds(604, 139, 67, 23);
		frame.getContentPane().add(buttonUp);
		
		JButton buttonDown = new JButton("<<");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terrarium.levelDown();
				listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
				panelBig.repaint();
			}
		});
		buttonDown.setBounds(527, 139, 67, 23);
		frame.getContentPane().add(buttonDown);
	}
	private boolean checkPlace(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}

		if (Integer.parseInt(str) > 20)
			return false;
		return true;
	}
}
