import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> cities = new ArrayList<>();
    static ArrayList<Double> temps = new ArrayList<>();
    static Map<String, String> cityNTemp = new HashMap<>();

    // Credit to stack overflow for this one
    static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    static void getCities(){
        String userInput = "";
        while (!userInput.equals("END")){
            System.out.println("Please input a city name, OR input 'END' to continue :");
            userInput = input.nextLine();
            if(!userInput.equals("END")) {
                cities.add(userInput);
            }
        }
    }

    static void getTemps(){
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String city : cities) {
            temps.clear();
            for (String day : days) {
                System.out.println("Please input the temp for " + day + " in " + city);
                temps.add(input.nextDouble());
            }
            final Object[] falseStrArray = temps.toArray();
            cityNTemp.put(city, Arrays.toString(falseStrArray));
        }
    }

    static void getAvg() {
        for (String value : cityNTemp.values()) {
            String cityKey = getKeyByValue(cityNTemp, value);
            value = value.substring(1, value.length() - 1);
            double avg = 0;
            String[] tempSet = value.split(", ");
            for (String s : tempSet) {
                avg = avg + Double.parseDouble(s);
            }
            avg = avg / 5;

            cityNTemp.replace(cityKey, Double.toString(avg));
            System.out.println(cityKey + " has an average temp of " + cityNTemp.get(cityKey));
        }
    }

    public static void main(String[] args) {
        getCities();
        getTemps();
        getAvg();

    }
}