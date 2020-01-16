import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

public class Aerodrome<T extends ITransport, G extends IGuns> {
	private T[] places;
	private G[] placesGuns;
	private int pictureWidth;
	private void setPictureWidth(int pictureWidth)
	{
		this.pictureWidth = pictureWidth;
	}
	
	public int getPictureWidth() {

		return pictureWidth;

	}
	private int pictureHeight;
	private void setPictureHeight(int pictureHeight)
	{
		this.pictureHeight = pictureHeight;
	}
	private final int placeSizeWidth = 210;
	private final int placeSizeHeight = 80;

	@SuppressWarnings("unchecked")
	public Aerodrome(int sizes, int pictureWidth, int pictureHeight) {
		this.places = (T[]) new ITransport[sizes];
		this.placesGuns = (G[]) new IGuns[sizes];
		setPictureWidth(pictureWidth);
		setPictureHeight(pictureHeight);
		for (int i = 0; i < places.length; i++) {
			places[i] = null;
			placesGuns[i] = null;		
		}
	}

	public int addAircraft(T aircraft) {
		for (int i = 0; i < places.length; i++) {
			if (this.checkFreePlace(i)) {
				places[i] = aircraft;
				places[i].SetPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, this.pictureWidth,
						this.pictureHeight);
				return i;
			}
		}
		return -1;
	}
	
	public int addAircraft(T aircraft, G guns) {
		for (int i = 0; i < places.length; i++) {
			if (this.checkFreePlace(i)) {
				places[i] = aircraft;
				places[i].SetPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15, this.pictureWidth,
						this.pictureHeight);
				placesGuns[i] = guns;
				placesGuns[i].setPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15);
				return i;
			}
		}
		return -1;
	}

	public T deleteAircraft(int index) {
		if (index < 0 || index > places.length) {
			return null;
		}
		if (!this.checkFreePlace(index)) {
			T aircraft = places[index];
			places[index] = null;
			return aircraft;
		}
		return null;
	}
	
	public G deleteGuns(int index)
	{
		if (index < 0 || index > places.length) {
			return null;
		}
		if (!this.checkFreePlace(index)) {
			G guns = placesGuns[index];
			placesGuns[index] = null;
			return guns;
		}
		return null;
	}

	public int AddSeveral(T aircarft, int count) {
		for (int i = 0; i < count; i++) {
			ITransport air = aircarft.Clone();
			addAircraft((T) air);
		}
		return count;
	}

	private boolean checkFreePlace(int index) {
		return (places[index] == null);
	}

	public void draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < places.length; i++) {
			if (!this.checkFreePlace(i)) {
				places[i].DrawAircraft(g);
				 if (placesGuns[i] != null) {
	                	placesGuns[i].DrawAeroGuns(g, placesGuns[i].getPositionX(),
	                			placesGuns[i].getPositionY());
	               		 }
			}
		}
	}	
	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (places.length / 5) * placeSizeWidth, 480);
		for (int i = 0; i < places.length / 5; i++) {
			for (int j = 0; j < 6; ++j) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
		}
	}
	public int AddSeveralAircraft(ITransport aircraft, IGuns guns, int count) {
		for (int i = 0; i < count; i++) {
			ITransport air = aircraft.Clone();
			IGuns gun = guns.Clone();
			addAircraft((T) air, (G) gun);
		}
		return count;
	}
}
