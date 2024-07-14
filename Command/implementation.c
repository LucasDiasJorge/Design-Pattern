#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Tipo de função para os comandos
typedef void (*CommandFunc)(void);

// Estrutura para os comandos
typedef struct {
    CommandFunc execute;
} Command;

void commandA() {
    printf("Executing Command A\n");
}

void commandB() {
    printf("Executing Command B\n");
}

// Invocador
typedef struct {
    Command* command;
    bool state; // Variável de estado para alternar entre os comandos A e B
} Invoker;

void setCommand(Invoker* invoker, Command* command) {
    invoker->command = command;
}

void executeCommand(Invoker* invoker) {
    invoker->command->execute();
}

int main() {
    Invoker invoker;
    invoker.state = true; // Inicializa o estado para 'true'

    Command commandAInstance = {commandA};
    Command commandBInstance = {commandB};

    while (true) {
        if (invoker.state) {
            setCommand(&invoker, &commandAInstance);
        } else {
            setCommand(&invoker, &commandBInstance);
        }
        
        executeCommand(&invoker);

        // Alterna o estado
        invoker.state = !invoker.state;
        
        // Condição para sair do loop (apenas para exemplo, mude conforme necessário)
        if (!invoker.state) {
            // break;
        }
    }

    return 0;
}
