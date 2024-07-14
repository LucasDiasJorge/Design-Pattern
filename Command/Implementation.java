public class Implementation {
    // Interface para os comandos
    interface Command {
        void execute();
    }

    // Implementação concreta do comando A
    static class CommandA implements Command {
        public void execute() {
            System.out.println("Executing Command A");
        }
    }

    // Implementação concreta do comando B
    static class CommandB implements Command {
        public void execute() {
            System.out.println("Executing Command B");
        }
    }

    // Invocador
    static class Invoker {
        private Command command;
        private boolean state; // Variável de estado para alternar entre os comandos A e B

        void setCommand(Command command) {
            this.command = command;
        }

        void executeCommand() {
            command.execute();
        }

        void toggleState() {
            state = !state;
        }

        boolean getState() {
            return state;
        }

        void setState(boolean state) {
            this.state = state;
        }
    }

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setState(true); // Inicializa o estado para 'true'

        Command commandA = new CommandA();
        Command commandB = new CommandB();

        while (true) {
            if (invoker.getState()) {
                invoker.setCommand(commandA);
            } else {
                invoker.setCommand(commandB);
            }

            invoker.executeCommand();

            // Alterna o estado
            invoker.toggleState();

            // Condição para sair do loop (apenas para exemplo, mude conforme necessário)
            if (!invoker.getState()) {
                break;
            }
        }
    }
}
