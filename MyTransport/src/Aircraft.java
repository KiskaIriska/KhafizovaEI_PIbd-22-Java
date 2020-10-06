
import java.awt.Color;
import java.awt.Graphics;

public class Aircraft extends FlyingObject {

	protected final int carWidth = 100;
	protected final int carHeight = 60;
	private int numberOfType;
	private int number;

	public Aircraft(int maxSpeed, float weight, Color mainColor) {
		this.maxSpeed = maxSpeed;
		this.weight = (int) weight;
		this.mainColor = mainColor;
		this.number = 4 + (int) (Math.random() * 3);
		this.numberOfType = 1 + (int) (Math.random() * 3);
	}

	public void MoveTransport(Direction direction) {
		float step = maxSpeed * 100 / weight;
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
			if (_startPosY + step + 60 < 370) {
				_startPosY += step;
			}
			break;
		}
	}

	@Override
	public void DrawAircraft(Graphics g) {
		g.setColor(mainColor);
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

		g.setColor(Color.cyan);
		g.fillOval(_startPosX + 60, _startPosY + 25, 20, 10);
	}	
	
	@Override
	 public void drawBasement(Graphics g) {
		 g.setColor(mainColor);
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

			g.setColor(Color.cyan);
			g.fillOval(_startPosX + 60, _startPosY + 25, 20, 10);
	    }
}

