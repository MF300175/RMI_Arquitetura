import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculator {

    public Server() {}

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("Divisor cannot be zero.");
        return a / b;
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            // Usando a porta 9400 como no exemplo original
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            registry.bind("Calculator", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
