import java.util.ArrayList;

public class MultiLevelAerodrome {
	ArrayList<Aerodrome<ITransport, IGuns>> aerodromeStages;
	private final int countPlaces = 20;
	public MultiLevelAerodrome(int countStages, int pictureWidth, int pictureHeight) {
		aerodromeStages = new ArrayList<>();
		for (int i = 0; i < countStages; i++) {
			aerodromeStages.add(new Aerodrome<ITransport, IGuns>(countPlaces, pictureWidth, pictureHeight));
		}
	}
	
	public Aerodrome<ITransport, IGuns> getAerodrome(int index){
		if ((index > -1) && (index < aerodromeStages.size()))
		{
			return aerodromeStages.get(index);
		}
		return null;
	}

	public ITransport getAircraft(int i, int j) {
		if((i > -1) && (i < aerodromeStages.size())) {
			if((j > -1) && (j < aerodromeStages.get(i).maxCount)) {
				ITransport ship = aerodromeStages.get(i).getPlace(j);
				aerodromeStages.get(i).deleteAircraft(j);
				return ship;
			}
		}
		return null;
	}
	public IGuns getGuns(int i, int j) {
		if(i > -1 && i < aerodromeStages.size()) {
			if(j > -1 && j < aerodromeStages.get(i).maxCount) {
				IGuns guns = aerodromeStages.get(i).getPlacesGuns(j);
				aerodromeStages.get(i).deleteGuns(j);
				return guns;
			}
		}
		return null;
	}
}
