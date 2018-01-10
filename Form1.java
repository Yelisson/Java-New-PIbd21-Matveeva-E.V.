package progrLab6_new;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		frame.setBounds(100, 100, 703, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelBig = new TerrariumPanel(terrarium);
		panelBig.setBounds(10, 11, 485, 417);
		frame.getContentPane().add(panelBig);
		
		SnakePanel panelSmall = new SnakePanel();
		panelSmall.setBounds(505, 236, 172, 143);
		frame.getContentPane().add(panelSmall);
		
		listLevels = new JList(elements);
		listLevels.setBounds(504, 3, 153, 89);
		frame.getContentPane().add(listLevels);
		
		JList list = new JList();
		list.setBounds(519, 100, 158, -88);
		frame.getContentPane().add(list);
		
		JButton buttonDown = new JButton("<<");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				terrarium.levelDown();
				listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
				panelBig.repaint();
			}
		});
		buttonDown.setBounds(507, 100, 89, 23);
		frame.getContentPane().add(buttonDown);
		
		JButton buttonUp = new JButton(">>");
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terrarium.levelUp();
				listLevels.setSelectedIndex(terrarium.GetCurrentLevel());
				panelBig.repaint();
			}
		});
		buttonUp.setBounds(598, 100, 89, 23);
		frame.getContentPane().add(buttonUp);
		
		JButton button1 = new JButton("\u0412\u044B\u0431\u0440\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				getSnake();
			}
		});
		button1.setBounds(505, 134, 172, 23);
		frame.getContentPane().add(button1);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(505, 166, 46, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(557, 163, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
		button2.setBounds(505, 202, 172, 23);
		frame.getContentPane().add(button2);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuBar.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuBar.add(menuSave);

		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser filesave = new JFileChooser();

				if (filesave.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
					try {
						if (terrarium.save(filesave.getSelectedFile().getPath()))
							if (filesave.getSelectedFile().getPath() != null)
								System.out.println("Good");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		menuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileopen = new JFileChooser();
				if (fileopen.showDialog(null, "Open") == JFileChooser.APPROVE_OPTION) {
					if (terrarium.load(fileopen.getSelectedFile().getPath()))
						if (fileopen.getSelectedFile().getPath() != null)
							System.out.println("Good");
				}
				panelBig.repaint();
			}
		});

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
