
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelAerodrome extends JPanel {

	private Aerodrome<ITransport> aerodrome;

	public PanelAerodrome(Aerodrome<ITransport> aerodrome) {
		this.aerodrome = aerodrome;
	}

	public ITransport Delete(int index) {
		return aerodrome.deleteAircraft(index);
	}

	public int AddSeveral(ITransport airplane, int count) {
		return aerodrome.AddSeveral(airplane, count);
	}

	public void paint(Graphics g) {
		super.paint(g);
		aerodrome.draw(g);
	}
}