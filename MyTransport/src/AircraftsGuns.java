import java.awt.Color;
import java.awt.Graphics;

public class AircraftsGuns implements IGuns {
	private int positionX;

	private int positionY;

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	@Override
	public void setPosition(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	@Override
	public void NumberGuns(Number number, Graphics g, int x, int y) {
		DrawGuns(g, x + 55, y + 5);
		DrawGuns(g, x + 55, y + 15);
		DrawGuns(g, x + 55, y + 40);
		DrawGuns(g, x + 55, y + 50);
		if (number == Number.Six || number == Number.Five)
			DrawGuns(g, x + 55, y + 10);
		if (number == Number.Six)
			DrawGuns(g, x + 55, y + 45);
	}
	@Override
	public void DrawGuns(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y + 1, 25, 3);
	}
	@Override
	public  void DrawAeroGuns(Graphics g, int x, int y) 
	{
		DrawGuns(g, x + 55, y + 5);
		DrawGuns(g, x + 55, y + 15);
		DrawGuns(g, x + 55, y + 40);
		DrawGuns(g, x + 55, y + 50);
		DrawGuns(g, x + 55, y + 10);
		DrawGuns(g, x + 55, y + 45);
	}
	
}
