import java.awt.Color;
import java.awt.Graphics;

public class AircraftsGuns_2 implements IGuns {

	public  void NumberGuns(Number number, Graphics g, int x, int y) 
	{
		g.setColor(Color.BLACK);
		g.fillRect(x + 50, y + 5, 5, 15);
		g.fillRect(x + 50, y + 40, 5, 15);
		 
		DrawGuns(g, x + 45, y + 5);
		DrawGuns(g, x + 45, y + 15);
		DrawGuns(g, x + 45, y + 40);
		DrawGuns(g, x + 45, y + 50);
		if (number == Number.Six || number == Number.Five) 
		{
			g.setColor(Color.RED);
			DrawGuns(g, x + 45, y + 10);
		}
		if (number == Number.Six)
		{
			g.setColor(Color.RED);
			DrawGuns(g, x + 45, y + 45);
		}
		g.setColor(Color.BLACK);
		g.fillRect(x + 80, y + 5, 5, 15);
		g.fillRect(x + 80, y + 40, 5, 15);

	}

	public  void DrawGuns(Graphics g, int x, int y) {
		
		g.fillRect(x, y + 1, 45, 3);

	}
}
