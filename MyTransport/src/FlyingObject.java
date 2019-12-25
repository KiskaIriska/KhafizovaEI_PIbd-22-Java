import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public abstract class FlyingObject implements ITransport {
	protected int _startPosX;

	protected int _startPosY;

	protected int _pictureWidth;

	protected int _pictureHeight;

	protected int maxSpeed;

	protected int weight;

	protected Color mainColor;

	protected Color dopColor;

	public int getStartPosX() {
		return _startPosX;
	}

	public int getStartPosY() {
		return _startPosY;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	protected void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getWeight() {
		return weight;
	}

	protected void setWeight(int weight) {
		this.weight = weight;
	}

	public Color getMainColor() {
		return mainColor;
	}

	protected void setMainColor(Color mainColor) {
		this.mainColor = mainColor;
	}

	public Color getDopColor() {
		return dopColor;
	}

	protected void setDopColor(Color dopColor) {
		this.dopColor = dopColor;
	}

	public void SetPosition(int x, int y, int width, int height) {
		this._startPosX = x;
		this._startPosY = y;
		this._pictureWidth = width;
		this._pictureHeight = height;
	}

	public abstract void DrawAircraft(Graphics g);

	public abstract void MoveTransport(Direction direction);

	public abstract ITransport Clone();
}
