//package BobbyBakedApp;

import java.util.Scanner;

class Main {
    static Scanner scan = new Scanner(System.in);
    static BobbyBakedApp app = new BobbyBakedApp();

    public static void main(String[] args) {
        try {
            boolean run = true;
            int chocie;
            do {
                System.out.println("************************************");
                System.out.println("enter number for task: ");
                System.out.println("Library System menu\n");
                System.out.println("1.) Find member by ID\n");
                System.out.println("2.) Find Book by ID\n");
                System.out.println("3.) Find supplier by ID\n");
                System.out.println("4.) Borrow book\n");
                System.out.println("5.) Purchase book\n");
                System.out.println("6.) show all members\n");
                System.out.println("7.) show all books\n");
                System.out.println("8.) show all suppliers\n");
                System.out.println("0.) Exit\n");
                System.out.println("************************************");

                System.out.print("choice: ");
                chocie = scan.nextInt();

                switch (chocie) {
                    case 1: {
                        // System.out.println(App.getMember());
                        break;
                    }
                    case 2: {
                        // System.out.println(App.getBook());
                        break;
                    }
                    case 3: {
                        // System.out.println(App.getSupplier());
                        break;
                    }
                    case 4: {
                        // public Borrow(int days, GregorianCalendar date, Member member, Book book)
                        // System.out.println(App.createNewBorrow());
                        break;
                    }
                    case 5: {
                        // System.out.println("5.) Purchase book\n");
                        // System.out.println(App.purchaseBook());
                        break;
                    }
                    case 6: {
                        // System.out.println("6.) show all members");
                        // App.showMembers();
                        break;
                    }
                    case 7: {
                        // App.showBooks();
                        break;
                    }
                    case 8: {
                        // App.showSuppliers();
                        break;
                    }
                    case 0: {
                        // run = false;
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