package progrLab2New;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form1 {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;

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
	Color color;
	 Color dopColor;
	 int maxCountMouse;
	 int maxCountBirds;
	 int maxSpeed;
	 int height;

	 private Interface1 inter;
	// private JTextField textField;
	 
	public Form1() {
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
		frame.setBounds(100, 100, 569, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 533, 206);
		frame.getContentPane().add(panel);
		
		JLabel lblMouse = new JLabel("Mouse:");
		lblMouse.setBounds(10, 228, 46, 14);
		frame.getContentPane().add(lblMouse);
		
		JLabel lblBirds = new JLabel("Birds:");
		lblBirds.setBounds(10, 253, 46, 14);
		frame.getContentPane().add(lblBirds);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setBounds(10, 279, 46, 14);
		frame.getContentPane().add(lblSpeed);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(200, 228, 46, 14);
		frame.getContentPane().add(lblHeight);
		
		JLabel lblPoison = new JLabel("Poison:");
		lblPoison.setBounds(360, 228, 46, 14);
		frame.getContentPane().add(lblPoison);
		
		JButton button1 = new JButton("\u0417\u0430\u0434\u0430\u0442\u044C \u0437\u043C\u0435\u044E");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inter = new PoisonousSnake(maxSpeed, maxCountMouse, maxCountBirds,height, color,dopColor);
                Graphics gr = panel.getGraphics();
                gr.clearRect(0,0,panel.getWidth(),panel.getHeight());
                inter.drawAnimal(gr);
			}
		});
		button1.setBounds(10, 313, 125, 23);
		frame.getContentPane().add(button1);
		
		JButton button2 = new JButton("\u0417\u0430\u0434\u0430\u0442\u044C \u043A\u043E\u0431\u0440\u0443");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inter = new Kobra(maxSpeed, maxCountMouse, maxCountBirds,height, color,true,true,dopColor);
                Graphics gr = panel.getGraphics();
                gr.clearRect(0,0,panel.getWidth(),panel.getHeight());
                inter.drawAnimal(gr);
			}
		});
		button2.setBounds(200, 313, 125, 23);
		frame.getContentPane().add(button2);
		
		JButton button3 = new JButton("\u0414\u0432\u0438\u0436\u0435\u043D\u0438\u0435");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (inter != null)
	                {
	                    Graphics gr = panel.getGraphics();
	                    gr.clearRect(0,0,panel.getWidth(),panel.getHeight());
	                    inter.moveAnimal(gr);
	                }
			}
		});
		button3.setBounds(390, 313, 89, 23);
		frame.getContentPane().add(button3);
		
		JButton button4 = new JButton("Color1");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = button4.getBackground();
                Color newColor = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
                if (newColor == null) {
                    return;
                }
                color = newColor;
                button4.setBackground(newColor);
			}
		});
		button4.setBackground(Color.GREEN);
		button4.setBounds(220, 275, 89, 23);
		frame.getContentPane().add(button4);
		
		JButton button5 = new JButton("Color2");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color initialBackground = button5.getBackground();
                Color newColor = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
                if (newColor == null) {
                    return;
                }
                dopColor = newColor;
                button5.setBackground(newColor);
			}
		});
		button5.setBackground(Color.YELLOW);
		button5.setBounds(390, 275, 89, 23);
		frame.getContentPane().add(button5);
		
		textField1 = new JTextField();
		textField1.setBounds(77, 228, 86, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(49, 253, 86, 20);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(59, 278, 86, 20);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setBounds(239, 225, 86, 20);
		frame.getContentPane().add(textField4);
		textField4.setColumns(10);
		
		textField5 = new JTextField();
		textField5.setBounds(416, 228, 86, 20);
		frame.getContentPane().add(textField5);
		textField5.setColumns(10);
	}
}
