package Callback;

// Definição da interface Callback
interface Callback {
    void call(int result);
}

// Classe que usa o callback
class Processor {
    void process(int value, Callback callback) {
        System.out.println("Processing value: " + value);
        callback.call(value);
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.process(42, result -> 
        System.out.println("Callback called with result: " + result));
    }
}
