package Table;

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("Bob");
        Person p2 = new Person("Bob");
        if (p1.equals(p2)) System.out.println("true");
        else System.out.println("false");

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
