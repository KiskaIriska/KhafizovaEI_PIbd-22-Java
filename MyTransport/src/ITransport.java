import java.awt.Color;
import java.awt.Graphics;

public interface ITransport {
	void SetPosition(int x, int y, int width, int height);

	void MoveTransport(Direction direction);

	void DrawAircraft(Graphics g);

	void drawBasement(Graphics g);

	void setMainColor(Color color);

	void setDopColor(Color color);

	Color getMainColor();

	Color getDopColor();

	int getStartPosX();

	int getStartPosY();

}
