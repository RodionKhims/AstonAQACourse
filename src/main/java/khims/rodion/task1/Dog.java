package khims.rodion.task1;

public class Dog extends Animal {
    private static final int RUNNING_DISTANCE_LIMIT = 500;
    private static final int SWIMMING_DISTANCE_LIMIT = 10;

    public Dog(String name) {
        super(RUNNING_DISTANCE_LIMIT
                ,SWIMMING_DISTANCE_LIMIT
                ,(distance) -> System.out.println("Dog " + name + " runs " + distance + " m")
                ,(distance) -> System.out.println("Dog " + name + " swims " + distance + " m")
                ,name);
    }
}
