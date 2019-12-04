import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public class AttackAircrafts extends Aircraft{
	
    public Color DopColor; { 
    	Set get; 
    	}
    public boolean Turbines; { 
    	Set get; 
    	}
    public boolean Propeller; { 
    	Set get; 
    	}
    public boolean Flag; { 
    	Set get; 
    	}

    public AttackAircrafts(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean turbines,
        boolean propeller, boolean flag) {
        super(maxSpeed, weight, mainColor);
        this.DopColor = dopColor;
        this.Turbines = turbines;
        this.Propeller = propeller;
        this.Flag = flag;
    }
    public int getX() {
		return _startPosX;		
	}
	public int getY() {
		return _startPosY;		
	}
	
    @Override
    public void DrawAircraft(Graphics g)
    {	
        super.DrawAircraft(g);
        if (Propeller)
        {
            g.setColor(DopColor); 
            g.fillOval( _startPosX + 93, _startPosY + 13, 5, 18);
            g.fillOval(_startPosX + 93, _startPosY + 31, 5, 18);
            g.setColor(Color.black);
            g.fillOval(_startPosX + 90, _startPosY + 27, 10, 5);
        }

        if (Turbines)
        {
            g.setColor(Color.darkGray);
            g.fillRect( _startPosX + 5, _startPosY + 15, 20, 5);
            g.fillRect( _startPosX + 5, _startPosY + 40, 20, 5);
        }

        if (Flag)
        {
            g.setColor(Color.red);
            g.fillRect( _startPosX + 65, _startPosY + 10, 5, 5);
            g.fillRect( _startPosX + 65, _startPosY + 45, 5, 5);
        }
    }	
}
