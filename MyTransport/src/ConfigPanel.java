import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ConfigPanel extends JPanel {
	public ConfigPanel() {
	}
	
	private ITransport transport;

	private IGuns guns;

	public ITransport getTransport() {
		return transport;
	}

	public void setTransport(ITransport transport) {
		this.transport = transport;
	}

	public IGuns getGuns() {
		return guns;
	}

	public void setGuns(IGuns guns) {
		this.guns = guns;
	}

	public void clearGuns() {
		guns= null;
	}

	public void clear() {
		transport = null;
		guns = null;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (transport != null) {
			transport.DrawAircraft(g);
			setTransport(transport);
			if (guns != null) {
				g.setColor(Color.black);
		       guns.setPosition(transport.getStartPosX(), transport.getStartPosY());
		        guns.DrawAeroGuns(g, guns.getPositionX(), guns.getPositionY());
			} else {
				transport.DrawAircraft(g);
				setTransport(transport);
			}
		}
	}
}
