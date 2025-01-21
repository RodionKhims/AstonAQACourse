package khims.rodion;

import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<String> words = List.of(
                "word1", "word2", "word1", "word3", "word1", "word2", "word4", "word1", "word5", "word1"
                , "word7", "word10", "word6", "word9", "word1", "word3", "word1", "word1", "word2", "word5"
        );
        List<String> uniqueWords = words.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique words: " + uniqueWords);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "+79111111111");
        phoneBook.add("Ivanov", "+79222222222");
        phoneBook.add("Ivanov", "+79333333333");
        phoneBook.add("Petrov", "+79444444444");
        phoneBook.add("Petrov", "+79555555555");
        phoneBook.add("Sidorov", "+79666666666");
        System.out.println(phoneBook.getPhones("Ivanov"));
        System.out.println(phoneBook.getPhones("Petrov"));
        System.out.println(phoneBook.getPhones("Sidorov"));
    }
}
