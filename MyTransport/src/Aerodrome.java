import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Set;

public class Aerodrome<T extends ITransport, G extends IGuns> {
	private HashMap<Integer, T> places;
	private HashMap<Integer, G> placesGuns;
	private int pictureWidth;

	private void setPictureWidth(int pictureWidth) {
		this.pictureWidth = pictureWidth;
	}

	public int getPictureWidth() {
		return pictureWidth;
	}

	private int pictureHeight;

	private void setPictureHeight(int pictureHeight) {
		this.pictureHeight = pictureHeight;
	}

	private final int placeSizeWidth = 210;
	private final int placeSizeHeight = 80;
	public int maxCount;

	public T getPlace(int i) {
		return places.get(i);
	}

	public G getPlacesGuns(int i) {
		return placesGuns.get(i);
	}

	public Aerodrome(int sizes, int pictureWidth, int pictureHeight) {
		this.places = new HashMap<>(sizes);
		this.placesGuns = new HashMap<>(sizes);
		setPictureWidth(pictureWidth);
		setPictureHeight(pictureHeight);
		this.maxCount = sizes;
	}

	public int addAircraft(T aircraft) {
		for (int i = 0; i < maxCount; i++) {
			if (this.checkFreePlace(i)) {
				places.put(i, aircraft);
				places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15,
						this.pictureWidth, this.pictureHeight);
				return i;
			}
		}
		return -1;
	}

	public int addAircraft(T aircraft, G guns) {
		for (int i = 0; i < maxCount; i++) {
			if (this.checkFreePlace(i)) {
				places.put(i, aircraft);
				places.get(i).SetPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15,
						this.pictureWidth, this.pictureHeight);
				placesGuns.put(i, guns);
				placesGuns.get(i).setPosition(5 + i / 5 * placeSizeWidth + 5, i % 5 * placeSizeHeight + 15);
				return i;
			}
		}
		return -1;
	}

	public T deleteAircraft(int index) {
		if (index < 0 || index > maxCount) {
			return null;
		}
		if (!this.checkFreePlace(index)) {
			T aircraft = places.get(index);
			places.remove(index);
			return aircraft;
		}
		return null;
	}

	public G deleteGuns(int index) {
		if (index < 0 || index > maxCount) {
			return null;
		}
		if (placesGuns.containsKey(index)) {
			G guns = placesGuns.get(index);
			placesGuns.remove(index);
			return guns;
		}
		return null;
	}


	private boolean checkFreePlace(int index) {
		return !(places.containsKey(index));
	}

	public void draw(Graphics g) {
		DrawMarking(g);
		for (int i = 0; i < maxCount; i++) {
			if (!checkFreePlace(i)) {
				places.get(i).DrawAircraft(g);
				if (placesGuns.containsKey(i)) {
					placesGuns.get(i).DrawAeroGuns(g, placesGuns.get(i).getPositionX(),
							placesGuns.get(i).getPositionY());
				}
			}
		}
	}

	private void DrawMarking(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (maxCount / 5) * placeSizeWidth, 480);
		for (int i = 0; i < maxCount / 5; i++) {
			for (int j = 0; j < 6; ++j) {

				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 400);
		}
	}
}