
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelAerodrome extends JPanel {

	private Aerodrome<ITransport, IGuns> aerodrome;
	public PanelAerodrome(Aerodrome<ITransport, IGuns> aerodrome) {
		this.aerodrome = aerodrome;
	}
	public int AddSeveral(ITransport airplane, int count) {
		return aerodrome.AddSeveral(airplane, count);
	}
	public int AddSeveralAircraft(ITransport airplane,IGuns guns, int count) {
		return aerodrome.AddSeveralAircraft(airplane, guns, count);
	}
	public void paint(Graphics g) {
		super.paint(g);
		aerodrome.draw(g);
	}
}
