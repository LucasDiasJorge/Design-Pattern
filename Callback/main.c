#include <stdio.h>

// Definindo o tipo de função callback
typedef void (*Callback)(int);

// Função que aceita um callback como argumento
void process(int value, Callback callback) {
    printf("Processing value: %d\n", value);
    callback(value);
}

// Função callback
void myCallback(int result) {
    printf("Callback called with result: %d\n", result);
}

int main() {
    int value = 42;
    process(value, myCallback);
    return 0;
}
