package Factory;

// Interface Product
interface Product {
    void use();
}

// Implementações concretas dos produtos
class ProductA implements Product {
    public void use() {
        System.out.println("Using Product A");
    }
}

class ProductB implements Product {
    public void use() {
        System.out.println("Using Product B");
    }
}

// Fábrica
class ProductFactory {
    static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        }
        throw new IllegalArgumentException("Unknown product type");
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        Product productB = ProductFactory.createProduct("B");

        productA.use();
        productB.use();
    }
}
