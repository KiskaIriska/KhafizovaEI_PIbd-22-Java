import java.awt.Color;
import java.awt.Graphics;

public class AircraftsGuns_3 implements IGuns {

	public void NumberGuns(Number number, Graphics g, int x, int y) {
		DrawGuns(g, x + 55, y + 5);
		DrawGuns(g, x + 55, y + 15);
		DrawGuns(g, x + 55, y + 40);
		DrawGuns(g, x + 55, y + 50);
		if (number == Number.Six || number == Number.Five)
			DrawGuns(g, x + 55, y + 10);
		if (number == Number.Six)
			DrawGuns(g, x + 55, y + 45);
		g.setColor(Color.BLACK);
		g.fillRect(x + 80, y + 5, 5, 15);
		g.fillRect(x + 80, y + 40, 5, 15);
	}

	public void DrawGuns(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y + 1, 35, 3);

	}
}
