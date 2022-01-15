package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    // Конструктор для получения имени и фамилии
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("NEW EMAIL:" + this.firstName + " " + this.lastName);
        // Вызов метода, который будет запрашивать информациб о отделе
        this.department = setDepartment();
        System.out.println("Department:" + this.department);
        // Получение или генерация пароля для пользователя
        
        
    }
    // Получение информации о отделе
    private String setDepartment() {
        int depChoice;
        boolean input;
        input = false;
        while (input != true){
            System.out.println("Enter the department: \npress 1 if email needed for Department of sales \npress 2 if email needed for Department of Developing \npress 3 if email needed for Department of Accounting \npress 0 if email needed for other Departments");
            Scanner number = new Scanner(System.in);
            depChoice = number.nextInt();
            if (depChoice == 1){
                return ("sales");
            }
            else if (depChoice == 2){
                return ("developing");
            }
            else if (depChoice == 3){
                return ("accounting");
            }
            else if (depChoice == 0){
                return ("other departments");
            }
        }
        return ("fail");
    }

    // Генератор случайного пароля

    // Установка вместимости почтового ящика

    // Установка альтернативного почтового адреса

    // Изменение пароля
}
