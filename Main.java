import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    static PhoneBook pb = new PhoneBook();

    public static void main(String[] args) {



        boolean running = true;
        while (running) {

            System.out.println("Телефонная книга:\n");
            System.out.println("1. Просмотреть записи");
            System.out.println("2. Добавить запись");
            System.out.println("3. Удалить запись");
            System.out.println("4. Редактировать запись");
            System.out.println("5. Выйти");
            System.out.print("\nВыберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            clearConsole();

            switch (choice) {
                case 1:
                    pb.printBook(phoneBook);
                    break;
                case 2:
                    System.out.println("Введите фамилию");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер телефона");
                    Integer num = scanner.nextInt();
                    pb.addNumber(name, num, phoneBook);
                    break;
                case 3:
                    System.out.println("Введите фамилию");
                    String txt = scanner.nextLine();
                    pb.deleteItem(phoneBook, txt);
                    break;
                case 4:
                    System.out.print("Редактирование Контакта\n\n");
                    System.out.print("Введите имя для редактирования: ");
                    String word = scanner.nextLine();
                    if (phoneBook.containsKey(word)) {
                        System.out.print("Введите новый номер телефона: ");
                        Integer newPhoneNumber = scanner.nextInt();
                        pb.editItem(phoneBook, word, newPhoneNumber);
                    } else {
                        System.out.println("Запись с таким именем не найдена.");
                    }
                    waitEnter();

                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("\nНекорректное значение! Попробуйте снова.\n");
            }
        }
        System.out.println("\nРабота приложения завершена.\n");

    }

    private static void waitEnter() {
        System.out.print("\nНажмите ENTER для продолжения...");
        scanner.nextLine();
        clearConsole();
    }

    public static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}

