package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    // private int mailboxCapacity;
    private int passlen = 16;
    private int sizeFirstLastName = 8;
    private String alternateEmail;

    // Конструктор для получения имени и фамилии
    public Email() {
        this.firstName = firstNameBuilder(sizeFirstLastName);
        this.lastName = lastNameBuilder(sizeFirstLastName);
        System.out.println("NEW EMAIL:" + this.firstName + " " + this.lastName);
        // Вызов метода, который будет запрашивать информациб о отделе
        this.department = setDepartment();
        System.out.println("Department:" + this.department);
        // Получение или генерация пароля для пользователя
        this.password = randPassw(passlen);
        this.alternateEmail = alternateSetEmail();
        System.out.println(this.password);
        
    }

    private String alternateSetEmail(){
        return (new String("rborisov989@gmail.com"));
    }
    // генератор имени
    private String firstNameBuilder(int leng){
        String validCharacters = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ";
        char [] firstName = new char[leng];
        int i;

        i = 0;
        while (i < leng){
            int rand = (int)(Math.random() * (validCharacters.length() - 1));
            firstName[i] = validCharacters.charAt(rand);
            i++;
        }
        return (new String(firstName));
    }

    private String lastNameBuilder(int leng) {
            String validCharacters = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ";
            char [] lastName = new char[leng];
            int i;
    
            i = 0;
            while (i < leng){
                int rand = (int)(Math.random() * (validCharacters.length() - 1));
                lastName[i] = validCharacters.charAt(rand);
                i++;
            }
            return (new String(lastName));
    }

    // Получение информации о отделе
    private String setDepartment() {
        int depChoice;
        System.out.println("Enter the department: \npress 1 if email needed for Department of sales \npress 2 if email needed for Department of Developing \npress 3 if email needed for Department of Accounting \npress 0 if email needed for other Departments");
        // Scanner number = new Scanner(System.in);
        // depChoice = number.nextInt();
        while (true) {
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
        // return ("fail");
    }
    // generating random password
    private String randPassw(int len) {
        String validCharacters = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char [] password = new char[len];
        int i;
        int checkValidityPass = 0;
        while (checkValidityPass == 0) {
            i = 0;
            while (i < len){
                int rand = (int)(Math.random() * (validCharacters.length() - 1));
                password[i] = validCharacters.charAt(rand);
                i++;
            }
            checkValidityPass = checkPass(password, len);
        }
        return (new String(password));
    }
    // validation email password
    private int checkPass(char [] password, int passSize){
        int i;
        int flagUpCase = 0;
        int flagLowCase = 0;
        // int palindrom; // check later
        int specialSymb = 0;
        int flagNumb = 0;

        i = 0;
        while (i < passSize){
            if (password[i] >= 'A' && password[i] <= 'Z')
                flagUpCase = 1;
            else if (password[i] >= 'a' && password[i] <= 'z')
                flagLowCase = 1;
            else if (password[i] == '!' || password[i] == '@' || password[i] == '#' || password[i] == '$' || password[i] == '%')
                specialSymb = 1;
            else if (password[i] <= '9' && password[i] >= '0')
                flagNumb = 1;
            i++;
        }
        if (flagLowCase == 1 && flagNumb == 1 && flagUpCase == 1 && specialSymb == 1)
            return (1);
        return (0);
    }
}
