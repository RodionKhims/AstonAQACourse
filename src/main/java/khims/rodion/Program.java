package khims.rodion;

import khims.rodion.task1.Animal;
import khims.rodion.task1.Cat;
import khims.rodion.task1.Dish;
import khims.rodion.task1.Dog;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Cat> cats = List.of(
                new Cat("Murizk"),
                new Cat("Vasya")
        );
        System.out.println("Cat count = " + cats.size());

        List<Dog> dogs = List.of(
                new Dog("Bobik"),
                new Dog("Tuzik"),
                new Dog("Sharik")
        );
        System.out.println("Dog count = " + dogs.size());

        List<Animal> animals = new ArrayList<>();
        animals.addAll(cats);
        animals.addAll(dogs);
        System.out.println("Animal count = " + animals.size());

        Dish dish = new Dish(75);
        animals.forEach(animal -> {
            animal.eat(dish, 20);
            System.out.println(animal.getName() + " satiety = " + animal.isSatiety());
            dish.increase(5);
        });
    }
}
