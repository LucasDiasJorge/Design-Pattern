package Observer;

import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void update();
}

// Classe Subject
class Subject {
    private List<Observer> observers = new ArrayList<>();

    void attach(Observer observer) {
        observers.add(observer);
    }

    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Implementações concretas dos observadores
class ObserverA implements Observer {
    public void update() {
        System.out.println("Observer A notified");
    }
}

class ObserverB implements Observer {
    public void update() {
        System.out.println("Observer B notified");
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();

        subject.attach(observerA);
        subject.attach(observerB);

        subject.notifyObservers();
    }
}
