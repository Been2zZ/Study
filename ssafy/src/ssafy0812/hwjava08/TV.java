package ssafy0812.hwjava08;

public class TV extends Product {
    private String displayType;
    private int inch;

    public TV(int num, String name, int price, int cnt, String displayType, int inch) {
        super(num, name, price, cnt);
        this.displayType = displayType;
        this.inch = inch;
    }

    public String getDisplayType() {
        return displayType;
    }
    public int getInch() {
        return inch;
    }
    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }
    public void setInch(int inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return "TV " + super.toString() + " [displayType=" + displayType + ", inch=" + inch + "]";
    }

}
