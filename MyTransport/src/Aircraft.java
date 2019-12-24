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
		/*switch (numberOfType) {
		case 1: {
			switch (number) {
			case 4:
				new AircraftsGuns().NumberGuns(Number.Four, g, _startPosX, _startPosY);
				break;
			case 5:
				new AircraftsGuns().NumberGuns(Number.Five, g, _startPosX, _startPosY);
				break;
			case 6:
				new AircraftsGuns().NumberGuns(Number.Six, g, _startPosX, _startPosY);
				break;
			}
		}
			break;
		case 2: {
			switch (number) {
			case 4:
				new AircraftsMegaGuns().NumberGuns(Number.Four, g, _startPosX, _startPosY);
				break;
			case 5:
				new AircraftsMegaGuns().NumberGuns(Number.Five, g, _startPosX, _startPosY);
				break;
			case 6:
				new AircraftsMegaGuns().NumberGuns(Number.Six, g, _startPosX, _startPosY);
				break;
			}
		}

			break;
		case 3: {
			switch (number) {
			case 4:
				new AircraftsSuperGuns().NumberGuns(Number.Four, g, _startPosX, _startPosY);
				break;
			case 5:
				new AircraftsSuperGuns().NumberGuns(Number.Five, g, _startPosX, _startPosY);
				break;
			case 6:
				new AircraftsSuperGuns().NumberGuns(Number.Six, g, _startPosX, _startPosY);
				break;
			}

		}
			break;
		}
*/
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
	
	public ITransport Clone() {
		ITransport air = new Aircraft(this.maxSpeed, this.weight, this.mainColor);
		return air;
	}

	

}
