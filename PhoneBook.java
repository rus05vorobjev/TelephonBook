import java.util.*;


public class PhoneBook  {
    public static void printBook(Map<String, ArrayList<Integer>> map) {
        if (map.isEmpty()) {
            System.out.println("\nТелефонная книга пуста.\n");
        } else {
            List<Map.Entry<String, ArrayList<Integer>>> sortedEntries = new ArrayList<>(map.entrySet());
            sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
            for (Map.Entry<String, ArrayList<Integer>> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    public static void deleteItem(Map<String, ArrayList<Integer>> map, String name){
        if (map.containsKey(name)) {
            ArrayList<Integer> phoneNumbers = map.remove(name);
            System.out.println("Запись удалена: " + name + ": " + phoneNumbers);
        } else {
            System.out.println("Запись с таким именем не найдена.");
        }

    }
    public static void editItem(Map<String, ArrayList<Integer>> map, String name, Integer newPhoneNumber) {
        map.get(name).add(newPhoneNumber);
        System.out.println("Запись отредактирована: " + name + ": " + map.get(name));
    }


}



