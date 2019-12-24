import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TakePanel extends JPanel {
	public ITransport transport;
	public IGuns guns;

	public void drawAircraft(ITransport transport) {
		this.transport = transport;
	}

	public void drawAircraft(ITransport transport, IGuns guns) {
		this.transport = transport;
		this.guns = guns;
	}

	public void clear() {
		transport = null;
		guns = null;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (transport != null) {
			transport.DrawAircraft(g);
			if (guns != null) {
				guns.setPosition(transport.getStartPosX(), transport.getStartPosY());				
				guns.DrawAeroGuns(g, guns.getPositionX(), guns.getPositionY());
			}

		}
	}
}