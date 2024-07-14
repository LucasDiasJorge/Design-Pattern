#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int value;
} Singleton;

Singleton* instance = NULL;

Singleton* getInstance() {
    if (instance == NULL) {
        instance = (Singleton*)malloc(sizeof(Singleton));
        instance->value = 0; // Inicialização do valor
    }
    return instance;
}

int main() {
    Singleton* s1 = getInstance();
    Singleton* s2 = getInstance();
    
    s1->value = 42;

    printf("s1 value: %d\n", s1->value);
    printf("s2 value: %d\n", s2->value);

    free(instance);
    return 0;
}
