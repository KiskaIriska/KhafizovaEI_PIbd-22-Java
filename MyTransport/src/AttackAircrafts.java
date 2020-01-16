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
    private Number num;
    private IGuns guns;
    public AttackAircrafts(int maxSpeed, float weight,Number num, Color mainColor, Color dopColor, boolean turbines,
        boolean propeller, boolean flag) {
        super(maxSpeed, weight, mainColor);
        this.DopColor = dopColor;
        this.Turbines = turbines;
        this.Propeller = propeller;
        this.Flag = flag;
        this.setNumber(num);
        guns = new AircraftsGuns();
    }
    public int getX() {
		return _startPosX;		
	}
	public int getY() {
		return _startPosY;		
	}
	public Number getNumber() {
		return num;
	}
	private void setNumber(Number num) {
		this.num = num;
	}
    @Override
    public void DrawAircraft(Graphics g)
    {	
    	
        super.DrawAircraft(g);
        guns.NumberGuns(num, g, _startPosX, _startPosY);
        
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
            g.setColor(dopColor);
            g.fillRect( _startPosX + 5, _startPosY + 15, 20, 5);
            g.fillRect( _startPosX + 5, _startPosY + 40, 20, 5);
        }

        if (Flag)
        {
            g.setColor(dopColor);
            g.fillRect( _startPosX + 65, _startPosY + 10, 5, 5);
            g.fillRect( _startPosX + 65, _startPosY + 45, 5, 5);
        }
    }	
   
}
