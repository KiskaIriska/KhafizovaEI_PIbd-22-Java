import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel {	
	ITransport transport;
	
	public MyPanel(ITransport transport ) {
		this.transport = transport;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		transport.DrawAircraft(g);	
	}
	
}
