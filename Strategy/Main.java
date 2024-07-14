package Strategy;

// Interface Strategy
interface Strategy {
    void execute();
}

// Implementações concretas das estratégias
class StrategyA implements Strategy {
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

class StrategyB implements Strategy {
    public void execute() {
        System.out.println("Executing strategy B");
    }
}

// Contexto que usa a estratégia
class Context {
    private Strategy strategy;

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void executeStrategy() {
        this.strategy.execute();
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        Strategy strategyA = new StrategyA();
        Strategy strategyB = new StrategyB();

        context.setStrategy(strategyA);
        context.executeStrategy();

        context.setStrategy(strategyB);
        context.executeStrategy();
    }
}
