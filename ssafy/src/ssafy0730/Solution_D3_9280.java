package ssafy0730;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_9280 {
    static int T;
    static int n, m, Answer;
    static ParkingZone[] zoon;
    static Car[] cars;
    static LinkedList<Car> waitList;
    static LinkedList<Integer> carMove;
 
    static class Car {
        private int zone;
        private int num;
        private int weight;
        
        public Car(int num, int weight){
            this.zone = 0;
            this.num = num;
            this.weight = weight;
        }
    }
    
    static class ParkingZone {
        private int num;
        private int cost;
        private boolean chk;
        
        public ParkingZone(int num, int cost) {
            this.num = num;
            this.cost = cost;
            this.chk = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T  = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            
            zoon = new ParkingZone[n + 1];
            cars = new Car[m + 1];
            
            waitList = new LinkedList<>();
            carMove = new LinkedList<>();
            
            for (int i = 1; i <= n; i++)        // 단위무게당 요금
                zoon[i] = new ParkingZone(i, sc.nextInt());
            
            for (int i = 1; i <= m; i++)        // 차량의 무게
                cars[i] = new Car(i, sc.nextInt());
            
            for (int i = 0; i < 2 * m; i++) 
                carMove.add(sc.nextInt());
            
            Answer = 0;
            int index = 0;
            
            // in-out
            while (index < 2 * m) {
                int car = carMove.get(index++);
                // in 
                if (car > 0) {
                    int roomNum = getZoonNum();
                    if (roomNum < 0) { 
                        waitList.add(cars[car]);
                        continue;                        
                    }
                    parking(roomNum, cars[car]);
                }
                // out
                else {
                    car *= -1;
                    zoon[cars[car].zone].chk = false;
                    if(!waitList.isEmpty()) 
                        parking(getZoonNum(), waitList.removeFirst());
                }
            }
 
            System.out.println("#" + t + " " + Answer);
        }
    }
    
    static void parking(int zoonNum, Car car) {
        zoon[zoonNum].chk = true;
        car.zone = zoonNum;
        Answer += (zoon[zoonNum].cost * car.weight);
    }
    
    static int getZoonNum() {
        for (int i = 1; i <= n; i++) 
            if (!zoon[i].chk)
                return i;
        return -1;
    }
    
}
