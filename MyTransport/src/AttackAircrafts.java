import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Set;

public class AttackAircrafts {

	public AttackAircrafts(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean turbines,
			boolean propeller, boolean flag) {
		MaxSpeed = maxSpeed;
		Weight = weight;
		MainColor = mainColor;
		DopColor = dopColor;
		Turbines = turbines;
		Propeller = propeller;
		Flag = flag;
	}
	static int _startPosX;
	static int _startPosY;
	private int _pictureWidth;
	private int _pictureHeight;
	private final int AttackAircraftWidth = 100;
	private final int AttackAircraftHeight = 60;
	
	public int MaxSpeed;
	{
		Set get;
	}

	public float Weight;
	{
		Set get;
	}

	public static Color MainColor;
	{
		Set get;
	}

	public static Color DopColor;
	{
		Set get;
	}
	
	private static boolean Turbines;
	{
		Set get;
	}
	
	private static boolean Propeller;
	{
		Set get;
	}

	private static boolean Flag;
	{
		Set get;
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public void MoveTransport(Direction direction) {
		float step = MaxSpeed * 100 / Weight;
		switch (direction) {
		case Right:
			if (_startPosX + 100 + step < 630) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0)

			{
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step + 60 < 380) {
				_startPosY += step;
			}
			break;
		}
	}

	final Random random = new Random();
	int number = 4 + (int) (Math.random() * 3);

	public void DrawAttackAircraft(Graphics g) {

		switch (number) {
		case 4:
			new AircraftsGuns().NumberGuns(Number.Four, g, AttackAircrafts._startPosX, AttackAircrafts._startPosY);
			break;
		case 5:
			new AircraftsGuns().NumberGuns(Number.Five, g, AttackAircrafts._startPosX, AttackAircrafts._startPosY);
			break;
		case 6:
			new AircraftsGuns().NumberGuns(Number.Six, g, AttackAircrafts._startPosX, AttackAircrafts._startPosY);
			break;
		}

		if (Propeller) {
			g.setColor(DopColor);
			g.fillOval(_startPosX + 93, _startPosY + 13, 5, 18);
			g.fillOval(_startPosX + 93, _startPosY + 31, 5, 18);
			g.setColor(Color.BLACK);
			g.fillOval(_startPosX + 90, _startPosY + 27, 10, 5);
		}

		if (Turbines) {
			g.setColor(Color.darkGray);
			g.fillRect(_startPosX + 5, _startPosY + 15, 20, 5);
			g.fillRect(_startPosX + 5, _startPosY + 40, 20, 5);
		}

		g.setColor(MainColor);
		g.fillRect(_startPosX + 5, _startPosY + 25, 85, 10);
		g.fillOval(_startPosX, _startPosY + 25, 10, 10);
		g.fillOval(_startPosX + 85, _startPosY + 25, 10, 10);

		g.fillRect(_startPosX + 10, _startPosY + 15, 10, 30);
		g.fillOval(_startPosX + 10, _startPosY + 10, 10, 10);
		g.fillOval(_startPosX + 10, _startPosY + 40, 10, 10);

		g.fillRect(_startPosX + 60, _startPosY + 5, 15, 50);
		g.fillOval(_startPosX + 60, _startPosY, 15, 10);
		g.fillOval(_startPosX + 60, _startPosY + 50, 15, 10);

		g.fillRect(_startPosX + 50, _startPosY + 20, 25, 20);
		g.fillOval(_startPosX + 65, _startPosY + 20, 20, 20);
		g.fillOval(_startPosX + 40, _startPosY + 20, 20, 20);

		g.setColor(DopColor);
		g.fillOval(_startPosX + 60, _startPosY + 25, 20, 10);

		if (Flag) {
			g.setColor(Color.RED);
			g.fillOval(_startPosX + 65, _startPosY + 10, 5, 5);
			g.fillOval(_startPosX + 65, _startPosY + 45, 5, 5);
		}

	}
}
