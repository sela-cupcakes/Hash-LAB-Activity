import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HashTableApp {

    public static void main(String[] args) {
        HashMap<String, Integer> hashTable = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Hash Table Application");
        System.out.println("Commands: add, get, remove, list, exit");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    addKeyValue(scanner, hashTable);
                    break;
                case "get":
                    getKeyValue(scanner, hashTable);
                    break;
                case "remove":
                    removeKeyValue(scanner, hashTable);
                    break;
                case "list":
                    listHashTable(hashTable);
                    break;
                case "exit":
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command.  Try again.");
            }
        }
    }


    static void addKeyValue(Scanner scanner, HashMap<String, Integer> table) {
        System.out.print("Enter key (String): ");
        String key = scanner.nextLine();
        System.out.print("Enter value (Integer): ");
        try {
            int value = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            table.put(key, value);
            System.out.println("Key-value pair added.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer value.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    static void getKeyValue(Scanner scanner, HashMap<String, Integer> table) {
        System.out.print("Enter key to retrieve: ");
        String key = scanner.nextLine();
        if (table.containsKey(key)) {
            System.out.println("Value: " + table.get(key));
        } else {
            System.out.println("Key not found.");
        }
    }

    static void removeKeyValue(Scanner scanner, HashMap<String, Integer> table) {
        System.out.print("Enter key to remove: ");
        String key = scanner.nextLine();
        if (table.containsKey(key)) {
            table.remove(key);
            System.out.println("Key-value pair removed.");
        } else {
            System.out.println("Key not found.");
        }
    }

    static void listHashTable(HashMap<String, Integer> table) {
        if (table.isEmpty()) {
            System.out.println("Hash table is empty.");
        } else {
            System.out.println("Hash Table Contents:");
            for (HashMap.Entry<String, Integer> entry : table.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}