import java.awt.Graphics;

public interface IGuns {
	void NumberGuns(Number number, Graphics g, int x, int y);

	void DrawGuns(Graphics g, int x, int y);
 
	void DrawAeroGuns(Graphics g, int x, int y);
	
	public void setPosition(int positionX, int positionY);

	public int getPositionX();

	public int getPositionY();

}
