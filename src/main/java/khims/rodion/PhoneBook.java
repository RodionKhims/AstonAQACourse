package khims.rodion;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> phoneMap = new HashMap<>();

    public void add(String name, String phone) {
        phoneMap.putIfAbsent(name, new ArrayList<>());
        phoneMap.get(name).add(phone);
    }

    public List<String> getPhones(String name) {
        return phoneMap.getOrDefault(name, List.of());
    }
}
