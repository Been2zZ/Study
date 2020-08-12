package ssafy0811;

public class Refrigerator extends Product {
    private int volume;

    public Refrigerator(int num, String name, int price, int cnt, int volume) {
        super(num, name, price, cnt);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Refrigerator " + super.toString() + " [volume=" + volume + "]";
    }


}

