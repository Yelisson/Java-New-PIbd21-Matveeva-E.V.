package progrLab6_new;

import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SelectSnake extends JDialog {

	Interface1 inter = null;
	SnakePanel panelSmall;
	boolean r;

	Color color;
	Color dopColor;
	int maxCountMouse=20;
	int maxCountBirds=30;
	int maxSpeed=150;
	int height=15;

	public SelectSnake(JFrame parent) {
		super(parent, true);
		setSize(450, 300);
		setLocationRelativeTo(parent);
		initialize();
	}

	public boolean res() {
		setVisible(true);
		return r;
	}

	private void initialize() {
		getContentPane().setLayout(null);

		SnakePanel panel = new SnakePanel();
		panel.setBounds(124, 11, 164, 113);
		getContentPane().add(panel);

		JLabel label1 = new JLabel("Snake");
		label1.setBounds(45, 59, 46, 14);
		getContentPane().add(label1);

		JLabel label2 = new JLabel("Kobra");
		label2.setBounds(45, 86, 46, 14);
		getContentPane().add(label2);

		MouseListener mouseL = new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JComponent jc = (JComponent) e.getSource();
				TransferHandler th = jc.getTransferHandler();
				th.exportAsDrag(jc, e, TransferHandler.COPY);
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		};

		label1.addMouseListener(mouseL);
		label2.addMouseListener(mouseL);
		label1.setTransferHandler(new TransferHandler("text"));
		label2.setTransferHandler(new TransferHandler("text"));

		panel.setDropTarget(new DropTarget() {

			public void drop(DropTargetDropEvent e) {

				try {

					for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
						if (e.getTransferable().getTransferData(df) == "Snake") {
							inter = new PoisonousSnake(maxSpeed, maxCountMouse, maxCountBirds, height, Color.GREEN,
									Color.YELLOW);
						} else if (e.getTransferable().getTransferData(df) == "Kobra") {
							inter = new Kobra(maxSpeed, maxCountMouse, maxCountBirds, height, Color.BLUE, true, true,
									Color.RED);
						}

						if (inter != null) {
							inter.setPosition(25, 55);
							panel.updatePanel(inter);
						}
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel label3 = new JLabel("\u041E\u0441\u043D\u043E\u0432\u043D\u043E\u0439 \u0446\u0432\u0435\u0442");
		label3.setBounds(156, 135, 109, 14);
		getContentPane().add(label3);

		JLabel label4 = new JLabel(
				"\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0446\u0432\u0435\u0442");
		label4.setBounds(126, 169, 162, 14);
		getContentPane().add(label4);

		label3.setDropTarget(new DropTarget() {

			public void drop(DropTargetDropEvent e) {
				if (inter != null) {
					try {
						for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
							inter.setMainColor((selectColor(e.getTransferable().getTransferData(df).toString())));

							if (inter != null) {
								inter.setPosition(25, 55);
								panel.updatePanel(inter);
							}
						}
					} catch (Exception ex) {
						System.out.println(ex + "FF");
					}
				}
			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		label4.setDropTarget(new DropTarget() {

			public void drop(DropTargetDropEvent e) {
				if (inter != null) {
					try {

						for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
							inter.setDopColor((selectColor(e.getTransferable().getTransferData(df).toString())));
							if (inter != null) {
								inter.setPosition(25, 55);
								panel.updatePanel(inter);
							}
						}
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JButton button1 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r = true;
				dispose();
			}
		});
		button1.setBounds(27, 131, 89, 23);
		getContentPane().add(button1);

		JButton button2 = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r = false;
				dispose();
			}
		});
		button2.setBounds(27, 165, 89, 23);
		getContentPane().add(button2);

		JPanel panelYellow = new JPanel();
		panelYellow.setName("yellow");
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(298, 11, 40, 38);
		getContentPane().add(panelYellow);

		JPanel panelGreen = new JPanel();
		panelGreen.setName("green");
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBounds(354, 11, 40, 38);
		getContentPane().add(panelGreen);

		JPanel panelMagenta = new JPanel();
		panelMagenta.setName("magenta");
		panelMagenta.setBackground(Color.MAGENTA);
		panelMagenta.setBounds(298, 59, 40, 38);
		getContentPane().add(panelMagenta);

		JPanel panelCyan = new JPanel();
		panelCyan.setName("cyan");
		panelCyan.setBackground(Color.CYAN);
		panelCyan.setBounds(354, 59, 40, 38);
		getContentPane().add(panelCyan);

		JPanel panelBlue = new JPanel();
		panelBlue.setName("blue");
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBounds(298, 114, 40, 40);
		getContentPane().add(panelBlue);

		JPanel panelPink = new JPanel();
		panelPink.setName("pink");
		panelPink.setBackground(Color.PINK);
		panelPink.setBounds(354, 114, 40, 40);
		getContentPane().add(panelPink);

		JPanel panelOrange = new JPanel();
		panelOrange.setName("orange");
		panelOrange.setBackground(Color.ORANGE);
		panelOrange.setBounds(298, 165, 40, 38);
		getContentPane().add(panelOrange);

		JPanel panelRed = new JPanel();
		panelRed.setName("orange");
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(354, 165, 40, 38);
		getContentPane().add(panelRed);

		panelYellow.addMouseListener(mouseL);
		panelYellow.setTransferHandler(new TransferHandler("name"));

		panelBlue.addMouseListener(mouseL);
		panelBlue.setTransferHandler(new TransferHandler("name"));

		panelRed.addMouseListener(mouseL);
		panelRed.setTransferHandler(new TransferHandler("name"));

		panelGreen.addMouseListener(mouseL);
		panelGreen.setTransferHandler(new TransferHandler("name"));

		panelOrange.addMouseListener(mouseL);
		panelOrange.setTransferHandler(new TransferHandler("name"));

		panelPink.addMouseListener(mouseL);
		panelPink.setTransferHandler(new TransferHandler("name"));

		panelMagenta.addMouseListener(mouseL);
		panelMagenta.setTransferHandler(new TransferHandler("name"));

		panelCyan.addMouseListener(mouseL);
		panelCyan.setTransferHandler(new TransferHandler("name"));
	}

	public Interface1 getSnake() {
		return inter;
	}

	public Color selectColor(String s) {
		switch (s) {
		case "yellow":
			return Color.yellow;
		case "blue":
			return Color.blue;
		case "red":
			return Color.red;
		case "green":
			return Color.green;
		case "black":
			return Color.black;
		case "pink":
			return Color.pink;
		case "magenta":
			return Color.magenta;
		case "cyan":
			return Color.cyan;
		}

		return null;
	}

}
