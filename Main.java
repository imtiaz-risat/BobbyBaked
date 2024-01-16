//package BobbyBakedApp;

import java.util.Scanner;

class Main {
    static Scanner scan = new Scanner(System.in);
    static BobbyBakedApp app = new BobbyBakedApp();

    public static void main(String[] args) {
        try {
            boolean run = true;
            int choice;
            do {
                System.out.println("************************************");
                System.out.println("Interact as: ");
                System.out.println("1. Customer\n");
                System.out.println("2. Product Manager\n");
                System.out.println("3. Inventory Manager\n");
                System.out.println("4. Employee Manager\n");
                System.out.println("************************************");

                System.out.print("choice: ");
                choice = scan.nextInt();

                switch (choice) {
                    case 1: {
                        app.customerDashboard();
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 0: {
                        run = false;
                        break;
                    }
                    default:
                        break;
                }

            } while (run);
            System.out.println(" Thank you for visiting BobbyBakedApp!");

        } catch (

        Exception e) {
            System.out.println(e);
        } finally {
            scan.close();
        }

    }

}