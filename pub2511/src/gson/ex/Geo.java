package gson.ex;

import java.io.Serializable;

public class Geo implements Serializable {
	
	private static final long serialVersionUID = 93247983284923L;
	
	private String lat;
	private String lng;
	
	public Geo() {
	}

	public Geo(String lat, String lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Geo [lat=" + lat + ", lng=" + lng + "]";
	}
	
}
