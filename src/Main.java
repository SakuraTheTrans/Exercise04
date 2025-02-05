import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> cities = new ArrayList<>();
    static ArrayList<Double> temps = new ArrayList<>();
    static Map<String, ArrayList<Double>> cityNTemp = new HashMap<>();
    static ArrayList<Double> point(ArrayList<Double> val){
        return val;
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
                System.out.println("cityNTemp : " + cityNTemp);
                System.out.println("Please input the temp for " + day + " in " + city);
                temps.add(input.nextDouble());
            }
            System.out.println("cityNTemp : " + cityNTemp);

            cityNTemp.put(city, temps);

            System.out.println("temps : " + temps);
            System.out.println("cityNTemp : " + cityNTemp);
        }
        System.out.println("cityNTemp : " + cityNTemp);
    }

    public static void main(String[] args) {
        getCities();
        getTemps();

    }
}