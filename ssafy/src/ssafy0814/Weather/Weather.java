package ssafy0814.Weather;

public class Weather {
	private int hour;
	private double temp;
	private String wfKor;
	private int reh;
	
	public Weather() {}

	public Weather(int hour, double temp, String wfKor, int reh) {
		super();
		this.hour = hour;
		this.temp = temp;
		this.wfKor = wfKor;
		this.reh = reh;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public int getReh() {
		return reh;
	}

	public void setReh(int reh) {
		this.reh = reh;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("hour : " + hour + "\t");
		sb.append("temp : " + temp + "\t");
		sb.append("wfKor : " + wfKor + "\t");
		sb.append("reh : " + reh + "\t");
		return sb.toString();
	}
	
}
