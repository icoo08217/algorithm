package programmers;

import java.util.ArrayList;
import java.util.List;

public class 캐시1 {
    public static void main(String[] args) {
//        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int cacheSize = 3;
        Solution_캐시1 solution_캐시1 = new Solution_캐시1();
        System.out.println(solution_캐시1.solution(cacheSize , cities));
    }
}

class Solution_캐시1 {
    public int solution(int cacheSize, String[] cities) {

        int time = 0;
        int cacheHit = 1;
        int cacheMiss = 5;
        List<String> cityList = new ArrayList<>();

        if (cacheSize == 0) {
            return cacheMiss * cities.length;
        }

        for (String city : cities) {
            city = city.toUpperCase();

            if (cityList.contains(city)) { // cacheHit
                cityList.remove(city);
                cityList.add(city);
                time += cacheHit;
            } else { // cacheMiss
                if (cityList.size() == cacheSize) {
                    cityList.remove(0);
                    cityList.add(city);
                } else {
                    cityList.add(city);
                }
                time += cacheMiss;
            }
        }
        return time;
    }
}