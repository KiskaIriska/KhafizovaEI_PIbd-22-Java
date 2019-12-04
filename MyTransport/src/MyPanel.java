import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	AttackAircrafts aircraft;

	public void drawPanel(AttackAircrafts aircraft) {
		this.aircraft = aircraft;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		aircraft.DrawAttackAircraft(g);
	}

}
