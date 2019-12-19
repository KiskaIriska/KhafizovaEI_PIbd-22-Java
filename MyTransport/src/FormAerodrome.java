
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FormAerodrome {
	private JFrame frame;
	private final int panelPierWidth = 870;
	private final int panelPierHeight = 460;
	private Aerodrome<ITransport> aerodrome;
	private ITransport transport;
	private TakePanel panelTake;
	private PanelAerodrome panelAerodrome;
	private JTextField textFieldIndex;
	static int choiceOperator = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAerodrome window = new FormAerodrome();
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
	public FormAerodrome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1331, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		aerodrome = new Aerodrome<ITransport>(20, panelPierWidth, panelPierWidth);

		JButton btnAircraft = new JButton("Aircraft");
		btnAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color newColor = JColorChooser.showDialog(frame, null, Color.blue);
				if (newColor != null) {
					transport = new Aircraft(100, 1000, newColor);
					int place = aerodrome.addAircraft(transport);
					panelAerodrome.repaint();
				}
			}
		});
		btnAircraft.setBounds(877, 11, 148, 25);
		frame.getContentPane().add(btnAircraft);

		JButton btnAttackAircraft = new JButton("AttackAircraft");
		btnAttackAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, null, Color.blue);
				if (mainColor != null) {
					Color dopColor = JColorChooser.showDialog(frame, null, Color.blue);
					if (dopColor != null) {
						transport = new AttackAircrafts(100, 1000, mainColor, dopColor, true, true, true);
					}
					int place = aerodrome.addAircraft(transport);
					panelAerodrome.repaint();
				}
			}
		});
		btnAttackAircraft.setBounds(877, 46, 148, 25);
		frame.getContentPane().add(btnAttackAircraft);
		JLabel label = new JLabel(
				"\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0435\u0442:");
		label.setBounds(915, 199, 122, 14);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label_1.setBounds(912, 224, 48, 14);
		frame.getContentPane().add(label_1);

		textFieldIndex = new JTextField();
		textFieldIndex.setBounds(972, 226, 51, 22);
		frame.getContentPane().add(textFieldIndex);
		textFieldIndex.setColumns(10);

		JButton btnTake = new JButton("Take");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldIndex.getText() != "") {
					transport = aerodrome.deleteAircraft(Integer.parseInt(textFieldIndex.getText()));
					if (transport != null) {
						panelTake.clear();
						panelTake.drawAircraft(transport);
						panelTake.transport.SetPosition(30, 100, panelPierWidth, panelPierHeight);
						panelAerodrome.repaint();
						panelTake.repaint();
					}
				}
			}
		});
		btnTake.setBounds(1047, 225, 170, 25);
		frame.getContentPane().add(btnTake);

		panelTake = new TakePanel();
		panelTake.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTake.setBounds(891, 286, 410, 186);
		frame.getContentPane().add(panelTake);

		panelAerodrome = new PanelAerodrome(aerodrome);
		panelAerodrome.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAerodrome.setBounds(10, 12, 833, 460);
		frame.getContentPane().add(panelAerodrome);

		JButton btnAddSeveralAircraft = new JButton("Add Several Aircraft");
		btnAddSeveralAircraft.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int count = 4;
				ITransport aircraft;
				aircraft = new Aircraft((int) (Math.random() * 200) + 100, (int) (Math.random() * 1000) + 1000,
						Color.green);
				panelAerodrome.AddSeveral(aircraft, count);
				panelAerodrome.repaint();
			}

		});
		btnAddSeveralAircraft.setBounds(1061, 12, 182, 35);
		frame.getContentPane().add(btnAddSeveralAircraft);

		JButton btnDeleteSeveral = new JButton("Delete Several");
		btnDeleteSeveral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldIndex.getText() != "") {
					int index = Integer.parseInt(textFieldIndex.getText());
					for (int j = index; j < 20; j++) {
						transport = aerodrome.deleteAircraft(j);
						if (transport != null) {
							panelTake.clear();
							panelTake.drawAircraft(transport);
							panelTake.transport.SetPosition(30, 100, panelPierWidth, panelPierHeight);
							panelAerodrome.repaint();
							panelTake.repaint();
						}
					}
				}
			}
		});
		btnDeleteSeveral.setBounds(1047, 192, 170, 29);
		frame.getContentPane().add(btnDeleteSeveral);

		JButton btnAddSeveralAttackAircraft = new JButton("Add Several AttackAircraft");
		btnAddSeveralAttackAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 4;
				ITransport aircraft;
				aircraft = new AttackAircrafts((int) (Math.random() * 200) + 100, (int) (Math.random() * 1000) + 1000,
						Color.green, Color.BLUE, true, true, true);
				panelAerodrome.AddSeveral(aircraft, count);
				panelAerodrome.repaint();
			}
		});
		btnAddSeveralAttackAircraft.setBounds(1061, 57, 182, 35);
		frame.getContentPane().add(btnAddSeveralAttackAircraft);

	}
}