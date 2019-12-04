import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public abstract class FlyingObject implements ITransport {
	protected int _startPosX;
	protected int _startPosY;
	protected int _pictureWidth;
	protected int _pictureHeight;
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
	public void SetPosition(int x, int y, int width, int height) {
		this._startPosX = x;
		this._startPosY = y;
		this._pictureWidth = width;
		this._pictureHeight = height;
	}

	public abstract void DrawAircraft(Graphics g);

	public abstract void MoveTransport(Direction direction);
}
