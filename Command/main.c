#include <stdio.h>
#include <stdlib.h>

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
} Invoker;

void setCommand(Invoker* invoker, Command* command) {
    invoker->command = command;
}

void executeCommand(Invoker* invoker) {
    invoker->command->execute();
}

int main() {
    Invoker invoker;

    Command commandAInstance = {commandA};
    Command commandBInstance = {commandB};

    setCommand(&invoker, &commandAInstance);
    executeCommand(&invoker);

    setCommand(&invoker, &commandBInstance);
    executeCommand(&invoker);

    return 0;
}
