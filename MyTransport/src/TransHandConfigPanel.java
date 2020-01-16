import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

@SuppressWarnings("serial")
public class TransHandConfigPanel extends TransferHandler {
	private ITransport transport;
	public Transferable createTransferable(JComponent c) {
		JTextField textField = (JTextField)c;
	    return new StringSelection(textField.getText());
	}
	public int getSourceActions(JComponent c) {
	    return COPY_OR_MOVE;
	}
	public boolean canImport(TransferSupport supp) {
		return supp.isDataFlavorSupported(DataFlavor.stringFlavor);
	}
	
	public ITransport getTrancport() {
		return transport;
	}

	public boolean importData(TransferSupport supp) {
		if(!supp.isDrop()) {
		return false;
		}	
		
		ConfigPanel panelAircraft = (ConfigPanel)supp.getComponent();
		String data;
		try {
			data = (String)supp.getTransferable().getTransferData(
				DataFlavor.stringFlavor);
			switch(data) {
				case "Простые":
				if(transport instanceof AttackAircrafts) {
					panelAircraft.clearGuns();
					panelAircraft.setGuns(new AircraftsGuns());
					}
					break;
				case "Супер":
					if(transport instanceof AttackAircrafts) {
						panelAircraft.clearGuns();
						panelAircraft.setGuns(new AircraftsSuperGuns());
					}
					break;
				case "Мега":
					if(transport instanceof AttackAircrafts) {
						panelAircraft.clearGuns();
						panelAircraft.setGuns(new AircraftsMegaGuns());
					}
					break;
				case "Самолет":
					panelAircraft.clear();
					transport = new Aircraft(50, 200, Color.gray);
					transport.SetPosition(panelAircraft.getX() - 50, panelAircraft.getY() + 20,
							panelAircraft.getWidth(), panelAircraft.getHeight());
					panelAircraft.setTransport(transport);
					break;
				case "Штурмовик":
					panelAircraft.clear();
					transport = new AttackAircrafts(50, 200, Number.Four, Color.gray, 
							Color.blue, true, true, true);
					transport.SetPosition(panelAircraft.getX() - 50, panelAircraft.getY() + 20, 
							panelAircraft.getWidth(), panelAircraft.getHeight());
					panelAircraft.setTransport(transport);
					break;
			}
		}catch(Exception e) {
			return false;
		}
		panelAircraft.repaint();
		return true;
	}
}
