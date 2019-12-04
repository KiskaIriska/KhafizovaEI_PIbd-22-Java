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

	private JFrame frame;

    private  ITransport aircraft; 
	private JPanel Panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttackAircraftPanel window = new AttackAircraftPanel();
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
	public AttackAircraftPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
 
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Random rnd = new Random();
		
		JButton ButtonCreateAttackAircraft = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0448\u0442\u0443\u0440\u043C\u043E\u0432\u0438\u043A");
		ButtonCreateAttackAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft = new AttackAircrafts(rnd.nextInt(100) + 300, rnd.nextInt(1000) + 2000, Color.GRAY, Color.DARK_GRAY, true, true, true);
				aircraft.SetPosition(rnd.nextInt(100) + 300, rnd.nextInt(100) + 100, 550, 500);
				Panel = new MyPanel(aircraft);
				Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, 
						null, null, null, null));
				Panel.setBounds(30, 10, 630, 370);
				frame.getContentPane().add(Panel);
				Panel.repaint();
			}
		});
		ButtonCreateAttackAircraft.setBounds(63, 414, 163, 23); 
		frame.getContentPane().add(ButtonCreateAttackAircraft);

		JButton Button_Right = new JButton("<<");
		Button_Right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft.MoveTransport(Direction.Left);
				Panel.repaint();
			}
		});
		Button_Right.setBounds(238, 414, 57, 23);
		frame.getContentPane().add(Button_Right);

		JButton Button_Left = new JButton(">>");
		Button_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft.MoveTransport(Direction.Right);
				Panel.repaint();
			}
		});
		Button_Left.setBounds(398, 414, 57, 23);
		frame.getContentPane().add(Button_Left);

		JButton Button_Down = new JButton("v");
		Button_Down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				aircraft.MoveTransport(Direction.Down);
				Panel.repaint();
			}
		});
		Button_Down.setBounds(299, 427, 89, 23);
		frame.getContentPane().add(Button_Down);

		JButton Button_Up = new JButton("^");
		Button_Up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aircraft.MoveTransport(Direction.Up);
				Panel.repaint();
			}
		});
		Button_Up.setBounds(299, 401, 89, 23);
		frame.getContentPane().add(Button_Up);
		
		JButton ButtonCreateAircraft = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		ButtonCreateAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 aircraft = new Aircraft(rnd.nextInt(100) + 300, rnd.nextInt(1000) + 2000, Color.GRAY);
					aircraft.SetPosition(rnd.nextInt(100) + 300, rnd.nextInt(100) + 100, 550, 500);
					Panel = new MyPanel(aircraft);
					Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, 
							null, null, null, null));
					Panel.setBounds(30, 10, 630, 370);
					frame.getContentPane().add(Panel);
					Panel.repaint();
			}
		});
		ButtonCreateAircraft.setBounds(479, 414, 163, 23);
		frame.getContentPane().add(ButtonCreateAircraft);
	}
}