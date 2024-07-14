package Singleton;

// Classe Singleton
class Singleton {
    private static Singleton instance;
    private int value;

    private Singleton() {
        this.value = 0;
    }

    static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        s1.setValue(42);

        System.out.println("s1 value: " + s1.getValue());
        System.out.println("s2 value: " + s2.getValue());
    }
}
