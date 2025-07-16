import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

interface Register {
  public void username();
  public void age();
  public void gender();
  public void phoneNumber();
  public void emailAddress();
}

class Introduction {

  public void messageDisplay() {
    System.out.println("This is the JK Bank App! Welcome and let's get you registered!");
  }
}

abstract class RegisterAccount implements Register {

  private static final int maxAttempts = 3;

  private String username;
  private int age;
  private String gender;
  private String phoneNumber;
  private String emailAddress;

  public RegisterAccount(String username, int age, String gender, String phoneNumber, String emailAddress) {
    this.username = username;
    this.age = age;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public String getUserName() {
    return username;
  }

  public int getAge() {
    return age;
  }

  public String getGender() {
    return gender;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  private static void RemainingAttempts(int attempts, int maxAttempts) {
    System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
  }

  private LinkedHashSet<String> usernames = new LinkedHashSet<String>();
  private ArrayList<Integer> ages = new ArrayList<Integer>();
  private ArrayList<String> genders = new ArrayList<String>();
  private LinkedHashSet<String> phoneNumbers = new LinkedHashSet<String>();
  private LinkedHashSet<String> emailAddresses = new LinkedHashSet<String>();

  public void username() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String username = "";

    while (attempts < maxAttempts) {

      System.out.println("Please enter your username which can't be empty and is between 10 and 20 characters long: ");
      username = sc.nextLine();
      attempts++;

      if (username == null || username.trim().isEmpty() || (username.length() < 10 || username.length() > 20)) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }

        RemainingAttempts(attempts, maxAttempts);
        System.out.println("Sorry, either, your username is empty or is out of character length!");
        continue;
      }

      if (usernames.contains(username)) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }

        RemainingAttempts(attempts, maxAttempts);
        System.out.println("Sorry, that username is already used!");
        continue;
      }

      this.username = username;
      break;

    }
  }

  public void age() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String ageStr = "";

    while (attempts < maxAttempts) {

      try {

        System.out.println("Enter your age which can't be empty (You need to be at least 16 to create an account here: ");
        ageStr = sc.nextLine();
        attempts++;

        if (ageStr == null || ageStr.trim().isEmpty()) {
          if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
        RemainingAttempts(attempts, maxAttempts);
        System.out.println("Sorry, your age is empty!");
        continue;
        }
        age = Integer.parseInt(ageStr);

        if (age < 16 || age > 100) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          RemainingAttempts(attempts, maxAttempts);
          System.out.println("Sorry, your age is out of range!");
          continue;
        }

      } catch (NumberFormatException e) {

        if (attempts == maxAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }

           RemainingAttempts(attempts, maxAttempts);    
           System.out.println("Your age is an invalid input!");
           continue;
        }

       this.age = Integer.parseInt(ageStr);
       break;
    }
  }

  public void gender() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String gender = "";

    while (attempts < maxAttempts) {

      System.out.println("Please state your gender: Male, Female, or Rather not say!");
      gender = sc.nextLine();
      attempts++;

      if (gender == null || gender.trim().isEmpty() || (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && !gender.equalsIgnoreCase("Rather not say"))) {
        if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }

         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your gender is invalid input!");
         continue;
      }

      this.gender = gender;
      break;
    } 
  }

  public void phoneNumber() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String input = "";

    while (attempts < maxAttempts) {

        System.out.println("Please enter your phone number starting with 07 and is 11 digits long exactly which can't be empty: ");
        input = sc.nextLine();
        attempts++;

        if (input == null || input.trim().isEmpty()) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, your phone number is empty!");
          RemainingAttempts(attempts, maxAttempts);
          continue;
          }

        if (input.length() != 11 || !input.startsWith("07")) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, your phone number is invalid format!");
          RemainingAttempts(attempts, maxAttempts);
          continue;
        }

        if (!input.matches("\\d+")) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, no numbers present!");
          RemainingAttempts(attempts, maxAttempts);
          continue;    
        }

        if (phoneNumbers.contains(input)) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("Sorry, that phone number is already taken!");
          RemainingAttempts(attempts, maxAttempts);
          continue;
        }

        this.phoneNumber = input;
        break;
    }
  }

   public void emailAddress() {

     Scanner sc = new Scanner(System.in);
     int attempts = 0;
     String emailAddress = "";

     while (attempts < maxAttempts) {

       System.out.println("Please enter your email address which can't be empty and correct structure!");
       emailAddress = sc.nextLine();
       attempts++;

       if (emailAddress == null || emailAddress.trim().isEmpty()) {
         if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your email address is empty!");
         continue;
      }

       if (!emailAddress.endsWith("@gmail.com") && !emailAddress.endsWith("@yahoo.com") && !emailAddress.endsWith("@hotmail.com") && !emailAddress.endsWith("@icloud.com")) {
         if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          RemainingAttempts(attempts, maxAttempts);
          System.out.println("Sorry, your email address is an invalid format!");
          continue;
       }

       if (emailAddresses.contains(emailAddress)) {
         if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, the email address is already used. Everyone should have one unique email address!");
         continue;
       }

       this.emailAddress = emailAddress;
       break;
   }
  }

  public void addRegister(String userName, int age, String gender, String phoneNumber, String emailAddress) {

    usernames.add(username);
    ages.add(age);
    genders.add(gender);
    phoneNumbers.add(phoneNumber);
    emailAddresses.add(emailAddress);

  }

  public void confirm() {
    System.out.println("User Information so far!");
    System.out.println("----------------");
    System.out.println("Username: " + username);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Email Address: " + emailAddress);
    System.out.println("----------------");
  }

  abstract public void password();
  abstract public void confirmPassword();
  abstract public void passCode();

}

class Password extends RegisterAccount implements Register {

  private static final int maxAttempts = 3;
  private static final String regex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";
  private static final int minimum = 15;
  private static final int maximum = 25;

  private String password;
  private String confirmPassword;
  private int passCode;

  public Password(String username, int age, String gender, String phoneNumber, String emailAddress, String password, String confirmPassword, int passCode) {

    super(username, age, gender, phoneNumber, emailAddress);
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.passCode = passCode;

  }

  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
     return confirmPassword;
  }

  public int getPassCode() {
     return passCode;
  }

  private static void RemainingAttempts(int attempts, int maxAttempts) {
    System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
  }

  private LinkedHashSet<String> passwords = new LinkedHashSet<String>();
  private LinkedHashSet<String> confirmedPasswords = new LinkedHashSet<String>();
  private ArrayList<Integer> passCodes = new ArrayList<Integer>();

  @Override
  public void password() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String password = "";

    while (attempts < maxAttempts) {

      System.out.println("Please enter your password attaining all of the requirements: non-empty, between 15 to 25 characters long, and at least 1 special character: ");
      password = sc.nextLine();
      attempts++;

      if (password == null || password.trim().isEmpty() || (password.length() < minimum || password.length() > maximum)) {
        if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
         }
           RemainingAttempts(attempts, maxAttempts);
           System.out.println("Sorry, your password is empty!");
           continue;
        }

        if (!password.matches(regex)){
          if (attempts == maxAttempts) {
              System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
              return;
            }
             RemainingAttempts(attempts, maxAttempts);
             System.out.println("Sorry, your password doesn't have a special character!");
             continue;
          }

        if (passwords.contains(password)) {
          if (attempts == maxAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
           RemainingAttempts(attempts, maxAttempts);
           System.out.println("Sorry, that password is already taken and every username should have one unique password!");
           continue;
        }

        this.password = password;
        break;   
      }
    } 

  @Override
  public void confirmPassword() {

    Scanner sc = new Scanner(System.in);
    int attempts = 0;
    String confirmPassword = "";

    while (attempts < maxAttempts) {
      System.out.println("Please confirm your password: ");
      confirmPassword = sc.nextLine();
      attempts++;

      if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your confirm password shouldn't be empty!");
         continue;
      }

      if (!confirmPassword.equals(password)) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
         RemainingAttempts(attempts, maxAttempts);
         System.out.println("Sorry, your confirm password doesn't match your password!");
         continue;
      }

      this.confirmPassword = confirmPassword;
      break;
    }
  }

  @Override
  public void passCode() {
    System.out.println("You will be given a 9 digit passcode randomly generated for you to be able to use your account!");
    Random random = new Random();
    this.passCode = random.nextInt(100000000, 1000000000);
    System.out.println("Your passcode is: " + this.passCode);
  }

  public void addRegister(String password, String confirmPassword, int passCode) {

    passwords.add(password);
    confirmedPasswords.add(confirmPassword);
    passCodes.add(passCode);

  }

  @Override
  public void confirm() {

    super.confirm();
    System.out.println("Password: " + password);
    System.out.println("Confirm Password: " + confirmPassword);
    System.out.println("Passcode: " + passCode);

  }
}

class InitialMoneyTransfer {

  private double money = 1000.00;

  public InitialMoneyTransfer(double money) {
    this.money = money;
  }

  public double getMoney() {
    return money;
  } 

  private ArrayList<Double> moneyAccount = new ArrayList<Double>();

  public void addMoney(double money) {
    moneyAccount.add(money);
  }

  public void moneyMessage(RegisterAccount register) {

    System.out.println("Congratulations " + register.getUserName() + "! You have successfully created your JK Bank Tracker Account where you can buy or save money whereever you want.");
    System.out.println("Currently, as you created your account, you have a starting amount of £" + money + " in your account!");
    System.out.println("Thank you so much for choosing us and we wish you a very good day!");
  }
}

class Main {

  private static ArrayList<String> usernames = new ArrayList<String>();  
  private static ArrayList<Integer> ages = new ArrayList<Integer>();
  private static ArrayList<String> genders = new ArrayList<String>();
  private static ArrayList<String> phonenumbers = new ArrayList<String>();
  private static ArrayList<String> emailaddresses = new ArrayList<String>();
  private static ArrayList<String> passwords = new ArrayList<String>();  
  private static ArrayList<Integer> passcodes = new ArrayList<Integer>();
  private static ArrayList<Double> cashAmount = new ArrayList<Double>();

 public static void main(String[] args) {


  Scanner sc = new Scanner(System.in);
  String optionStr = "";
  int option = 0;

  while (true) {

    try {
      System.out.println("1). Log in, 2). Register, 3). Exit , so choose option 1 or 3:");
      optionStr = sc.nextLine();
      if (optionStr == null || optionStr.trim().isEmpty()) {
        System.out.println("Option can't be empty!");
        continue;
      }

      option = Integer.parseInt(optionStr);
      if (option < 1 || option > 3) {
        System.out.println("Sorry, option out of range!");
        continue;
      }

      switch (option) {

        case 1: 

          System.out.println("Log in!");
          login();
          break;

        case 2:
          Introduction intro = new Introduction();
          intro.messageDisplay();

          Password register = new Password("",0,"","","","","", 0);
          register.username();
          register.age();
          register.gender();
          register.phoneNumber();
          register.emailAddress();

          String username = register.getUserName();
          int age = register.getAge();
          String gender = register.getGender();
          String phoneNumber = register.getPhoneNumber();
          String emailAddress = register.getEmailAddress();

          register.addRegister(username, age, gender, phoneNumber, emailAddress);
          
          register.password();
          if (register.getPassword() != null && !register.getPassword().isEmpty()) {
            register.confirmPassword();
            if (register.getConfirmPassword() != null && !register.getConfirmPassword().isEmpty()) {
              register.passCode();
              register.addRegister(register.getPassword(), register.getConfirmPassword(), register.getPassCode());
              register.confirm();
            }
          }


          InitialMoneyTransfer money = new InitialMoneyTransfer(1000.00);
          money.addMoney(money.getMoney());
          money.moneyMessage(register);

          usernames.add(username);
          ages.add(age);
          genders.add(gender);
          phonenumbers.add(phoneNumber);
          emailaddresses.add(emailAddress);
          passwords.add(register.getPassword());
          passcodes.add(register.getPassCode());
          cashAmount.add(money.getMoney());  

          break;

        case 3:
          System.out.println("Exit!");
          System.exit(0);
      }

    } catch (NumberFormatException e) {
      System.out.println("Sorry, invalid option!");
      continue;
    }
   }
  }

  public static void login() {

    Scanner sc = new Scanner(System.in);
    String userName = "";
    String passWord = "";
    String passCodeStr = "";
    int passCode = 0;
    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {
        System.out.println("Please enter your username: ");
        userName = sc.nextLine();
        System.out.println("Please enter your password: ");
        passWord = sc.nextLine();
        System.out.println("Please enter your allocated passcode: ");
        passCodeStr = sc.nextLine();
        attempts++;

       if ((userName == null || userName.trim().isEmpty()) || (passWord == null || passWord.trim().isEmpty()) || (passCodeStr == null || passCodeStr.trim().isEmpty())) {
         if (attempts == maxAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
          System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
          System.out.println("Sorry, one of your inputs is empty which shouldn't be allowed!");
          continue;
       }

       passCode = Integer.parseInt(passCodeStr);

       int userIndex = usernames.indexOf(userName);     

      if (userIndex == -1 || !passwords.get(userIndex).equals(passWord) || !passcodes.get(userIndex).equals(passCode)){
            if (attempts == maxAttempts) {
                System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
                return;
            }
            System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
            System.out.println("Sorry, one of your information is incorrect!");
            continue;
    } 
      } catch (NumberFormatException e) {
        if (attempts == maxAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
        System.out.println("You have " + (maxAttempts - attempts) + " attempts left!");
        System.out.println("Sorry, one of your information is incorrect!");
        continue;

    }
  }

  optionsMenu(userName, passWord, passCode);

 }

  public static void optionsMenu(String userName, String passWord, int passCode) {

    Scanner sc = new Scanner(System.in);
    String optionStrr = "";
    int optionn = 0;
    final int maxOptionAttempts = 3;
    int optionAttempts = 0;

    while (optionAttempts < maxOptionAttempts) {

      try {

        System.out.println("1). Withdraw cash, 2). Deposit cash, 3). Transfer cash, 4). Check balance");
        System.out.println("Please choose options 1-4: ");
        optionStrr = sc.nextLine();
        optionAttempts++;

        if ((optionStrr == null || optionStrr.trim().isEmpty())) {
           if (optionAttempts == maxOptionAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
            System.out.println("You have " + (maxOptionAttempts - optionAttempts) + " attempts left!");
            System.out.println("Sorry, one of your inputs is empty which shouldn't be allowed!");
            continue;
         }

        optionn = Integer.parseInt(optionStrr);

        if (optionn < 1 || optionn > 4) {
          if (optionAttempts == maxOptionAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
          System.out.println("Sorry, option out of range!");
          continue;
        }

        switch (optionn) {

          case 1:
            withDraw(userName, cashAmount);
            break;

          case 2:
            deposit(userName, cashAmount);
            break;

          case 3:
            transfer(userName, usernames, cashAmount);
            break;

          case 4:
            balanceCheck(userName, cashAmount);
            break;
        }

      } catch (NumberFormatException e) {
        if (optionAttempts == maxOptionAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
        System.out.println("You have " + (maxOptionAttempts - optionAttempts) + " attempts left!");
        System.out.println("Sorry, that's an invalid input!");
        continue;
      }
    }
  }

  public static void withDraw(String userName, ArrayList<Double> cashAmount) {

    Scanner sc = new Scanner(System.in);
    String withdrawStr = "";
    double withdraw = 0.00;
    final int maxWithdrawAttempts = 3;
    int withdrawAttempts = 0;

    while (withdrawAttempts < maxWithdrawAttempts) {

      try {

        System.out.println("Enter the cash amount you can withdraw. Maximum you can withdraw is £80.00: ");
        withdrawStr = sc.nextLine();
        withdrawAttempts++;

        if ((withdrawStr == null || withdrawStr.trim().isEmpty())) {
          if (withdrawAttempts == maxWithdrawAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
          System.out.println("Sorry, your input is empty which isn't allowed!");
          continue;
        }

        withdraw = Double.parseDouble(withdrawStr);
        withdraw = Double.parseDouble(String.format("%.2f", withdraw));

        if (withdraw < 0.00 || withdraw > 80.00) {
          if (withdrawAttempts == maxWithdrawAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
          System.out.println("Sorry, your withdraw input is either negative or higher than 80.00!");
          continue;
        }

        int userWithdrawIndex = usernames.indexOf(userName);
        if (cashAmount.get(userWithdrawIndex) < withdraw) {
          if (withdrawAttempts == maxWithdrawAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
          System.out.println("Sorry, you don't have enough money to withdraw that amount!");
          continue;
        }

        cashAmount.set(userWithdrawIndex, cashAmount.get(userWithdrawIndex) - withdraw);
        System.out.println("£ " + withdraw + " has successfully been withdrawn from your account!");
        System.out.println("Current balance: " + cashAmount.get(userWithdrawIndex));

      } catch (NumberFormatException e) {
        if (withdrawAttempts == maxWithdrawAttempts) {
          System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
          return;
        }
        System.out.println("You have " + (maxWithdrawAttempts - withdrawAttempts) + " attempts left!");
        System.out.println("Sorry, invalid input!");
        continue;

      }
    }  
  }

  public static void deposit(String userName, ArrayList<Double> cashAmount) {

    Scanner sc = new Scanner(System.in);
    String depositStr = "";
    double deposit = 0;
    final int maxDepositAttempts = 3;
    int depositAttempts = 0;

    while (depositAttempts < maxDepositAttempts) {

      try {

        System.out.println("Enter the cash amount you want to deposit. Maximum cash you can deposit is £150.00: ");
        depositStr = sc.nextLine();
        depositAttempts++;

        if (depositStr == null || depositStr.trim().isEmpty()) {
          if (depositAttempts == maxDepositAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxDepositAttempts - depositAttempts) + " attempts left!");
          System.out.println("Sorry, invalid input!");
          continue;
          }

        deposit = Double.parseDouble(depositStr);
        deposit = Double.parseDouble(String.format("%.2f", deposit));

        if (deposit < 0.00 || deposit > 150.00) {
          if (depositAttempts == maxDepositAttempts) {
            System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
            return;
          }
          System.out.println("You have " + (maxDepositAttempts - depositAttempts) + " attempts left!");
          System.out.println("Sorry, your input is out of range!");
          continue;
        }

        int userDepositIndex = usernames.indexOf(userName);
        cashAmount.set(userDepositIndex, cashAmount.get(userDepositIndex) + deposit);
        System.out.println("£ " + deposit + " has successfully been deposited to your account!");
        System.out.println("Current balance: " + cashAmount.get(userDepositIndex));


      } catch (NumberFormatException e) {
         if (depositAttempts == maxDepositAttempts) {
           System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
           return;
         }
         System.out.println("You have " + (maxDepositAttempts - depositAttempts) + " attempts left!");
         System.out.println("Sorry, invalid input!");
         continue;
      }
    }
   }

  public static void transfer(String userName, ArrayList<String> usernames, ArrayList<Double> cashAmount) {

    Scanner sc = new Scanner(System.in);
    final int maxTransferAttempts = 3;
    int transferAttempts = 0;
    String transferUser = "";
    String transferStr = "";
    double transfer = 0.00;

    while (transferAttempts < maxTransferAttempts) {

      try {

        System.out.println("Enter the username you want to transfer cash too: ");
        transferUser = sc.nextLine();
        transferAttempts++;

        if (transferUser == null || transferUser.trim().isEmpty()) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, empty input isn't allowed!");
           continue;
        }

        if (!usernames.contains(transferUser)) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, that username isn't available!");
           continue;
        }

        System.out.println("Enter the cash amount you want to transfer. Maximum cash you can transfer is £150.00: ");
        transferStr = sc.nextLine();

        if (transferStr == null || transferStr.trim().isEmpty()) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, empty input is not allowed!");
           continue;
        }

        transfer = Double.parseDouble(transferStr);
        transfer = Double.parseDouble(String.format("%.2f", transfer));

        if (transfer < 0.00 || transfer > 150.00) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, that input is out of range!");
           continue;
        }

        int giveUserIndex = usernames.indexOf(userName);

        if (cashAmount.get(giveUserIndex) < transfer) {
          if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, you don't have enough money to transfer that amount!");
           continue;
        }

        int takeUserIndex = usernames.indexOf(transferUser);
        cashAmount.set(giveUserIndex, cashAmount.get(giveUserIndex) - transfer);
        cashAmount.set(takeUserIndex, cashAmount.get(takeUserIndex) + transfer);

        System.out.println("£ " + transfer + "has successfully been transferred from " + userName + "'s account to " + transferUser + " 's account");
        System.out.println("Current balance: £ " + cashAmount.get(giveUserIndex));
        System.out.println("Current balance: £ " + cashAmount.get(takeUserIndex));


      } catch (NumberFormatException e) {
        if (transferAttempts == maxTransferAttempts) {
             System.out.println("3 attempts already used up! Sorry, but the process is restarting unfortunately!");
             return;
           }
           System.out.println("You have " + (maxTransferAttempts - transferAttempts) + " attempts left!");
           System.out.println("Sorry, invalid input!");
           continue;
        }
      }
    }

  public static void balanceCheck(String userName, ArrayList<Double> cashAmount) {

    int userNameIndex = usernames.indexOf(userName);
    System.out.println("Current balance: £ " + cashAmount.get(userNameIndex));
  }
 }
