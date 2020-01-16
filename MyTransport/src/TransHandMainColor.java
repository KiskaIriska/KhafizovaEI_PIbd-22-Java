import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
@SuppressWarnings("serial")
public class TransHandMainColor extends TransferHandler {
	private ConfigPanel panel;
	public int getSourceActions(JComponent c) {
	    return COPY_OR_MOVE;
	}
	public Transferable createTransferable(JComponent c) {
		JTextField textField = (JTextField)c;
	    return new StringSelection(textField.getText());
	}
	public boolean canImport(TransferSupport supp) {
		return supp.isDataFlavorSupported(DataFlavor.stringFlavor);
	}
	public void setPanel(ConfigPanel panel) {
		this.panel = panel;
	}
	public boolean importData(TransferSupport supp) {
		if(!supp.isDrop())
			return false;
		ITransport transport = panel.getTransport();
		String data;
		if(transport != null) {
			try {
				data = (String)supp.getTransferable().getTransferData(DataFlavor.stringFlavor);
				switch(data) {
					case "Красный":
						transport.setMainColor(Color.red);
						break;
					case "Желтый":
						transport.setMainColor(Color.yellow);
						break;
					case "Зеленый":
						transport.setMainColor(Color.green);
						break;
					case "Синий":
						transport.setMainColor(Color.blue);
						break;
					case "Белый":
						transport.setMainColor(Color.white);
						break;
					case "Черный":
						transport.setMainColor(Color.black);
						break;
				}
			}catch(Exception e) {
				return false;
			}
		}
		panel.repaint();
		return true;
	}	
}