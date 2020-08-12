package ssafy0810;

public class TV extends Product {
	private String displayType;

	public TV(int num, String name, int price, int cnt, String displayType) {
		super(num, name, price, cnt);
		this.displayType = displayType;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "TV " + super.toString() + " [displayType=" + displayType + "]";
	}
	
}
