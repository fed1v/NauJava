import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        System.out.println("Please enter task number (1-5): ");
        
        Scanner sc = new Scanner(System.in);
        int taskNumber = sc.nextInt();
        
        switch (taskNumber) {
            case 1:
                System.out.println("Please enter array length: ");
                new Task1().run();
                break;
            case 2:
                System.out.println("Please enter array length: ");
                new Task2().run();
                break;
            case 3:
                new Task3().run();
                break;
            case 4:
                new Task4().run();
                break;
            case 5:
                System.out.println("Please enter time: ");
                new Task5().run();
                break;
        }
    }
}