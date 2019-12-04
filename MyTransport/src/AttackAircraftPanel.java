import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AttackAircraftPanel {

	private JFrame AttackAircraftFrame;
	private AttackAircrafts aircraft;
	private JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttackAircraftPanel window = new AttackAircraftPanel();
					window.AttackAircraftFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AttackAircraftPanel() {
		initialize();
	}

	
	private void initialize() {
 
		AttackAircraftFrame = new JFrame();
		AttackAircraftFrame.setBounds(100, 100, 700, 500);
		AttackAircraftFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AttackAircraftFrame.getContentPane().setLayout(null);
		
		Random rnd = new Random();
		
		JButton ButtonCreate = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C ");
		ButtonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft = new AttackAircrafts(rnd.nextInt(100) + 300, rnd.nextInt(1000) + 2000, Color.GRAY, Color.DARK_GRAY, true, true, true);
				aircraft.SetPosition(rnd.nextInt(100) + 300, rnd.nextInt(100) + 100, 550, 500);
				panel = new MyPanel();
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, 
						null, null, null, null));
				panel.setBounds(30, 10, 630, 370);
				AttackAircraftFrame.getContentPane().add(panel);
				((MyPanel) panel).drawPanel(aircraft);
				panel.repaint();
			}
		});
		ButtonCreate.setBounds(122, 414, 89, 23); 
		AttackAircraftFrame.getContentPane().add(ButtonCreate);

		JButton ButtonLeft = new JButton("<<");
		ButtonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft.MoveTransport(Direction.Left);
				panel.repaint();
			}
		});
		ButtonLeft.setBounds(269, 414, 57, 23);
		AttackAircraftFrame.getContentPane().add(ButtonLeft);

		JButton ButtonRight = new JButton(">>");
		ButtonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft.MoveTransport(Direction.Right);
				panel.repaint();
			}
		});
		ButtonRight.setBounds(435, 414, 57, 23);
		AttackAircraftFrame.getContentPane().add(ButtonRight);

		JButton ButtonDown = new JButton("v");
		ButtonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				aircraft.MoveTransport(Direction.Down);
				panel.repaint();
			}
		});
		ButtonDown.setBounds(336, 427, 89, 23);
		AttackAircraftFrame.getContentPane().add(ButtonDown);

		JButton ButtonUp = new JButton("^");
		ButtonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft.MoveTransport(Direction.Up);
				panel.repaint();
			}
		});
		ButtonUp.setBounds(336, 402, 89, 23);
		AttackAircraftFrame.getContentPane().add(ButtonUp);
	}
}
