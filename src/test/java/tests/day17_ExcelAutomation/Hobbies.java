package tests.day17_ExcelAutomation;


import java.util.*;

public class Hobbies {
    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }
    public List<String> findAllHobbyists(String hobby) {

        List<String> hobbyistList = new ArrayList<>();

        for (Map.Entry<String, String[]> w : hobbies.entrySet()) {

            if (Arrays.stream(w.getValue()).anyMatch(t-> t.equals(hobby))) {

                hobbyistList.add(w.getKey());
            }
        }
        return hobbyistList;
    }

    public static void main (String[]args){
        Hobbies hobbies = new Hobbies();
        hobbies.add("Steve", "Fashion", "Piano", "Reading");
        hobbies.add("Patty", "Drama", "Magic", "Pets");
        hobbies.add("Chad", "Puzzles", "Pets", "Yoga");
        System.out.println(Arrays.toString(hobbies.findAllHobbyists("Yoga").toArray()));
    }
}
