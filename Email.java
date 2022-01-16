package emailapp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int passlen = 16;
    private int sizeFirstLastName = 8;
    private String alternateEmail;
    private String resultEmail;

    // Конструктор для получения имени и фамилии
    public Email() {
        this.firstName = firstNameBuilder(sizeFirstLastName);
        this.lastName = lastNameBuilder(sizeFirstLastName);
        this.department = setDepartment();
        this.password = randPassw(passlen);
        this.alternateEmail = alternateSetEmail();
        this.resultEmail = buildEmailAdress(this.firstName, this.lastName, this.password, this.sizeFirstLastName);
        System.out.println(this.resultEmail);
        System.out.println(this.password);
    }

    private String buildEmailAdress(String firstName, String lastName, String password, int size) {
        char [] resultEmail = new char[size * 2 + 10];
        String domen = "@gmail.com";
        int i;
        int k;

        i = 0;
        k = 0;
        while (i < size) {
            resultEmail[i] = firstName.charAt(i);
            i++;
        }
        while (i < size * 2) {
            resultEmail[i] = lastName.charAt(k++);
            i++;
        }
        k = 0;
        while (i < size * 2 + 10) {
            resultEmail[i++] = domen.charAt(k++);
        }
        
        return (new String(resultEmail));
    }

    private String alternateSetEmail(){
        return (new String("rborisov989@gmail.com"));
    }
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
