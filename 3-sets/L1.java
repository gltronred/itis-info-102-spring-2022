import java.util.*;

class Person {
    private int height;
    private int weight;
    private int age;

    public Person(int h, int m, int y) {
        height = h;
        weight = m;
        age = y;
    }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public int getAge() { return age; }
}

class BMIComparator implements Comparator<Person> {
    static double bmi(Person p) {
        double h = p.getHeight() / 100.0;
        return (double)p.getWeight() / (h*h);
    }
    public int compare(Person p1, Person p2) {
        if (bmi(p1) < bmi(p2))
            return -1;
        else if (bmi(p1) > bmi(p2))
            return 1;
        else
            return 0;
    }
}

public class L1 {
    public static void main(String[] args) {
        System.out.println(BMIComparator.bmi(new Person(170, 77, 25)));
    }
}
