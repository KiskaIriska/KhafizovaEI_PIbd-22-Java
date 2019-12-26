
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelAerodrome extends JPanel {

	private Aerodrome<ITransport, IGuns> aerodrome;

	public PanelAerodrome(Aerodrome<ITransport, IGuns> aerodrome) {
		this.aerodrome = aerodrome;
	}

	public void setAerodrome(Aerodrome<ITransport, IGuns> aerodrome) {
		this.aerodrome = aerodrome;
	}

	public void paint(Graphics g) {
		super.paint(g);
		aerodrome.draw(g);
	}
}