#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char* type;
} Product;

Product* createProduct(const char* type) {
    Product* product = (Product*)malloc(sizeof(Product));
    product->type = strdup(type);
    return product;
}

int main() {
    Product* p1 = createProduct("TypeA");
    Product* p2 = createProduct("TypeB");

    printf("Product 1 type: %s\n", p1->type);
    printf("Product 2 type: %s\n", p2->type);

    free(p1->type);
    free(p1);
    free(p2->type);
    free(p2);
    return 0;
}
