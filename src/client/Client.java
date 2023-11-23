import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            Calculator stub = (Calculator) registry.lookup("Calculator");

            // Exemplo de operações
            System.out.println("3 + 2 = " + stub.add(3, 2));
            System.out.println("3 - 2 = " + stub.subtract(3, 2));
            System.out.println("3 * 2 = " + stub.multiply(3, 2));
            System.out.println("3 / 2 = " + stub.divide(3, 2));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
