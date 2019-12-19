import java.awt.Color;
import java.awt.Graphics;


public class AircraftsGuns implements IGuns{
	
	public void NumberGuns(Number number, Graphics g,  int x ,int y)
	{
		DrawGuns(g,x + 55,y + 5);
		DrawGuns(g,x + 55,y + 15);
		DrawGuns(g,x + 55,y + 40);
		DrawGuns(g,x + 55,y + 50);
		if(number == Number.Six || number == Number.Five)
			DrawGuns(g,x + 55,y + 10);	
		if( number == Number.Six)
			DrawGuns(g,x + 55,y + 45); 
	}
	
	public void DrawGuns(Graphics g, int x,int y) {	
		g.setColor(Color.BLACK);
		g.fillRect( x , y + 1, 25, 3);
		
	}
}
