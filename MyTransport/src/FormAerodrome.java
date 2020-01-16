
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FormAerodrome {
	private JFrame frame;
	private final int panelPierWidth = 870;
	private final int panelPierHeight = 460;
	private final int countLevels = 5;

	private MultiLevelAerodrome aerodrome;

	private Hashtable<Integer, ITransport> storageTransport;

	private Hashtable<Integer, IGuns> storageGuns;

	private ITransport transport;
	private IGuns guns;
	private TakePanel panelTake;
	private PanelAerodrome panelAerodrome;
	private JTextField textFieldIndex;
	private int storageIndex = 0;
	private JList<String> list;

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
		aerodrome = new MultiLevelAerodrome(countLevels, panelPierWidth, panelPierHeight);
		storageTransport = new Hashtable<>();
		storageGuns = new Hashtable<>();

		String[] levels = new String[countLevels];
		for (int i = 0; i < countLevels; i++) {
			levels[i] = "Уровень" + (i + 1);
		}
		list = new JList(levels);
		list.setSelectedIndex(0);
		list.setBounds(890, 11, 161, 164);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int index = list.getSelectedIndex();
				panelAerodrome.setAerodrome(aerodrome.getAerodrome(index));
				panelAerodrome.repaint();

			}

		});

		frame.getContentPane().add(list);

		JButton btnAircraft = new JButton("Aircraft");
		btnAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color newColor = JColorChooser.showDialog(frame, null, Color.blue);
				if (newColor != null) {
					transport = new Aircraft(100, 1000, newColor);
					int place = aerodrome.getAerodrome(list.getSelectedIndex()).addAircraft(transport);
					panelAerodrome.repaint();
				}
			}
		});
		btnAircraft.setBounds(1124, 103, 148, 25);
		frame.getContentPane().add(btnAircraft);

		JButton btnAttackAircraft = new JButton("AttackAircraft");
		btnAttackAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(frame, null, Color.blue);
				if (mainColor != null) {
					Color dopColor = JColorChooser.showDialog(frame, null, Color.blue);
					if (dopColor != null) {
						transport = new AttackAircrafts(100, 1000, mainColor, dopColor, true, true, true);
						Random rnd = new Random();
						switch (rnd.nextInt(3)) {
						case 0:
							guns = new AircraftsGuns();
							break;
						case 1:
							guns = new AircraftsSuperGuns();
							break;
						case 2:
							guns = new AircraftsMegaGuns();
							break;

						}
					}
					int place = aerodrome.getAerodrome(list.getSelectedIndex()).addAircraft(transport, guns);
					panelAerodrome.repaint();
				}
			}
		});
		btnAttackAircraft.setBounds(1124, 139, 148, 25);
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
					transport = aerodrome.getAircraft(list.getSelectedIndex(),
							Integer.parseInt(textFieldIndex.getText()));
					if (transport != null) {
						panelTake.clear();
						guns = aerodrome.getGuns(list.getSelectedIndex(), Integer.parseInt(textFieldIndex.getText()));
						if (guns != null) {
							panelTake.drawAircraft(transport, guns);
							storageGuns.put(storageIndex, guns);
						} else {
							panelTake.drawAircraft(transport);
						}
						panelTake.transport.SetPosition(100, 100, panelPierWidth, panelPierHeight);
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

		panelAerodrome = new PanelAerodrome(aerodrome.getAerodrome(0));
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
		btnAddSeveralAircraft.setBounds(1119, 11, 182, 35);
		frame.getContentPane().add(btnAddSeveralAircraft);

		JButton btnAddSeveralAttackAircraft = new JButton("Add Several AttackAircraft");
		btnAddSeveralAttackAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 4;
				ITransport aircraft;
				aircraft = new AttackAircrafts((int) (Math.random() * 200) + 100, (int) (Math.random() * 1000) + 1000,
						Color.green, Color.BLUE, true, true, true);
				Random rnd = new Random();
				switch (rnd.nextInt(3)) {
				case 0:
					guns = new AircraftsGuns();
					break;
				case 1:
					guns = new AircraftsSuperGuns();
					break;
				case 2:
					guns = new AircraftsMegaGuns();
					break;

				}
				panelAerodrome.AddSeveralAircraft(aircraft, guns, count);
				panelAerodrome.repaint();
			}
		});
		btnAddSeveralAttackAircraft.setBounds(1119, 57, 182, 35);
		frame.getContentPane().add(btnAddSeveralAttackAircraft);
	}
}