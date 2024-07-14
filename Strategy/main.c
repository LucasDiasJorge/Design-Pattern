#include <stdio.h>
#include <stdlib.h>

typedef struct {
    void (*execute)(void);
} Strategy;

void strategyA() {
    printf("Executing strategy A\n");
}

void strategyB() {
    printf("Executing strategy B\n");
}

typedef struct {
    Strategy* strategy;
} Context;

void setStrategy(Context* context, Strategy* strategy) {
    context->strategy = strategy;
}

void executeStrategy(Context* context) {
    context->strategy->execute();
}

int main() {
    Context context;

    Strategy strategyAInstance = {strategyA};
    Strategy strategyBInstance = {strategyB};

    setStrategy(&context, &strategyAInstance);
    executeStrategy(&context);

    setStrategy(&context, &strategyBInstance);
    executeStrategy(&context);

    return 0;
}
