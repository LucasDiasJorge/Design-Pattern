package Command;

// Interface Command
interface Command {
    void execute();
}

// Implementações concretas dos comandos
class CommandA implements Command {
    public void execute() {
        System.out.println("Executing Command A");
    }
}

class CommandB implements Command {
    public void execute() {
        System.out.println("Executing Command B");
    }
}

// Invocador
class Invoker {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        this.command.execute();
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        Command commandA = new CommandA();
        Command commandB = new CommandB();

        invoker.setCommand(commandA);
        invoker.executeCommand();

        invoker.setCommand(commandB);
        invoker.executeCommand();
    }
}
