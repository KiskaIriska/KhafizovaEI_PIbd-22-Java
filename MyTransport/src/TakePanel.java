import java.awt.Graphics;

import javax.swing.JPanel;

public class TakePanel extends JPanel {
	public ITransport transport;

	public void drawAircraft(ITransport transport) {
		this.transport = transport;
	}

	public void clear() {
		transport = null;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (transport != null) {
			transport.DrawAircraft(g);

		}
	}
}