
package progrLab5;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form1 {

	private JFrame frame;
	private JTextField textField;
	Terrarium terrarium;
	private String[] elements = new String[6];
	JList listLevels;
	TerrariumPanel panelBig;
	SelectSnake select;
	Color color;
	Color dopColor;
	int maxCountMouse;
	int maxCountBirds;
	int maxSpeed;
	int height;

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
			elements[i] = "Уровень " + (i + 1);
		}

		listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 754, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelBig = new TerrariumPanel(terrarium);
		panelBig.setBounds(10, 11, 507, 343);
		frame.getContentPane().add(panelBig);

		listLevels = new JList(elements);
		listLevels.setBounds(544, 23, 153, 89);
		frame.getContentPane().add(listLevels);

		JList list = new JList();
		list.setBounds(527, 11, 187, 101);
		frame.getContentPane().add(list);

		JButton button1 = new JButton("\u0412\u044B\u0431\u0440\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				getSnake();
			}
		});
		button1.setBounds(552, 150, 114, 23);
		frame.getContentPane().add(button1);

		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(527, 184, 46, 14);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(583, 181, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		SnakePanel panelSmall = new SnakePanel();
		panelSmall.setBounds(527, 243, 187, 111);
		frame.getContentPane().add(panelSmall);

		JButton button2 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkPlace(textField.getText())) {
					Interface1 inter = terrarium.getSnakeInTerrarium(Integer.parseInt(textField.getText()) - 1);
					if (inter != null) {
						inter.setPosition(25, 55);
						panelBig.updateTerrariumPanel(terrarium);
						panelSmall.updatePanel(inter);
					} else {
						JOptionPane.showMessageDialog(null, "На таком месте нет змеи", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		button2.setBounds(555, 209, 114, 23);
		frame.getContentPane().add(button2);

		JButton button3 = new JButton("<<");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terrarium.levelDown();
				listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
				panelBig.repaint();
			}
		});
		button3.setBounds(537, 116, 89, 23);
		frame.getContentPane().add(button3);

		JButton button4 = new JButton(">>");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terrarium.levelUp();
				listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
				panelBig.repaint();
			}
		});
		button4.setBounds(636, 116, 89, 23);
		frame.getContentPane().add(button4);
	}

	public void getSnake() {
		select = new SelectSnake(frame);
		if (select.res()) {
			Interface1 inter = select.getSnake();
			int place = terrarium.putSnakeInTerrarium(inter);
			if (place > -1) {
				panelBig.updateTerrariumPanel(terrarium);
				JOptionPane.showMessageDialog(null, "Ваше место: " + (place + 1), "", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Мест нет", "", JOptionPane.INFORMATION_MESSAGE);
			}
		}
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
