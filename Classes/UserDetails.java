abstract class UserDetails implements UserInterface {

  protected String firstName;
  protected String lastName;
  protected String emailAddress;
  protected String phoneNumber;

  public UserDetails(String firstName, String lastName, String emailAddress, String phoneNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.phoneNumber = phoneNumber;

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setFirstName(String firstName) {

    if (firstName == null || firstName.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "First name cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    if (firstName.length() < 3 || firstName.length() > 13) {
      JOptionPane.showMessageDialog(null, "First name isn't 3 to 13 characters long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    this.firstName = firstName.trim();
  }

  public void setLastName(String lastName) {

    if (lastName == null || lastName.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Last name cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    if (lastName.length() < 3 || lastName.length() > 13) {
      JOptionPane.showMessageDialog(null, "Last name isn't 3 to 13 characters long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    this.lastName = lastName.trim();
  }

  public void setEmailAddress(String emailAddress) {

     if (emailAddress == null || emailAddress.trim().isEmpty()) {
       JOptionPane.showMessageDialog(null, "Email address cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
     }

     if (!emailAddress.endsWith("@yahoo.com") && !emailAddress.endsWith("@gmail.com") && !emailAddress.endsWith("@hotmail.com")) {
       JOptionPane.showMessageDialog(null, "Email address doesn't end with @yahoo.com, @gmail.com, or @hotmail.com!", "Input Error", JOptionPane.ERROR_MESSAGE);
     }

    if (emailAddress.length() < 17 || emailAddress.length() > 25) {
      JOptionPane.showMessageDialog(null, "Email address isn't 17 to 25 characters long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    int Position = emailAddress.indexOf('@');

     if (Position <= 0) {
        JOptionPane.showMessageDialog(null, "Email address must contain a username before the @ symbol!", "Input Error", JOptionPane.ERROR_MESSAGE);
      }

       String localPart = emailAddress.substring(0, Position);

       for (int i = 0; i < localPart.length(); i++) {
         char c = localPart.charAt(i);
         if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
           JOptionPane.showMessageDialog(null, "Email address is in the incorrect format unfortunately!", "Input Error", JOptionPane.ERROR_MESSAGE);
         }
       }

    this.emailAddress = emailAddress.trim();
  }

  public void setPhoneNumber(String phoneNumber) {

    if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
       JOptionPane.showMessageDialog(null, "Phone number cannot be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
     }

    if (phoneNumber.length() != 11) {
      JOptionPane.showMessageDialog(null, "Phone number isn't 11 digits long!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    for (int i = 0; i < phoneNumber.length(); i++) {
      if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.charAt(0) != '0') {
        JOptionPane.showMessageDialog(null, "Phone number isn't in valid format!", "Input Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    this.phoneNumber = phoneNumber.trim();
  }

  public void firstName() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {

      JOptionPane.showMessageDialog(null, "Enter your first name between 3 and 13 characters: ");
      firstName = JOptionPane.showInputDialog(null, "Enter your first name between 3 and 13 characters: ");
      attempts++;

      if (firstName == null || firstName.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid first name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;

      }

      if (firstName.length() < 3 || firstName.length() > 13) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid first name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "Sorry, your first name's length isn't between 3 and 13 characters. Please try again: ");
        continue;
      }

      setFirstName(firstName);
      break;
     } catch (Exception e) {
       if (attempts == maxAttempts) {
         JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid first name. Try again later: ");
         return;
       }
       JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
       attempts++;
     }
    }
  } 

  public void lastName() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

      JOptionPane.showMessageDialog(null, "Enter your last name between 3 and 13 characters: ");
      lastName = JOptionPane.showInputDialog(null, "Enter your last name between 3 and 13 characters: ");
      attempts++;

      if (lastName == null || lastName.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid last name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;

      }

      if (lastName.length() < 3 || lastName.length() > 13) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid last name. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "Sorry, your last name's length isn't between 3 and 13 characters. Please try again: ");
        continue;
      }

      setLastName(lastName);
      break;
    } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid last name. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
  }

  public void emailAddress() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {
       
      JOptionPane.showMessageDialog(null, "Enter your email address in either @yahoo.com, @gmail.com or @hotmail.com. We don't accept any other forms of email address: ");
      emailAddress = JOptionPane.showInputDialog(null, "Enter your email address in either @yahoo.com, @gmail.com or @hotmail.com. We don't accept any other forms of email address: ");
      attempts++;

      if (emailAddress == null || emailAddress.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;
      }

      if (!emailAddress.endsWith("@yahoo.com") && !emailAddress.endsWith("@gmail.com") && !emailAddress.endsWith("@hotmail.com")) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "Sorry, that's the wrong format. Please try again: ");
          continue;
        }

     if (emailAddress.length() < 17 || emailAddress.length() > 25) {
       if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address between 17 and 25 characters long. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
         JOptionPane.showMessageDialog(null, "Sorry, that's the wrong format. Please try again: ");
         continue;
       }

      int Position = emailAddress.indexOf('@');
       if (Position > 0) {
           String localPart = emailAddress.substring(0, Position);
           boolean containsInvalidChar = false;

           for (int i = 0; i < localPart.length(); i++) {
               char c = localPart.charAt(i);
               if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
                   containsInvalidChar = true;
                   break;
               }
           }

           if (containsInvalidChar) {
               if (attempts == maxAttempts) {
                 JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address between 17 and 25 characters long. Try again later: ");
                   return;
               }
               JOptionPane.showMessageDialog(null, "You have " + attempts + " chances left to enter a valid email address!");
               JOptionPane.showMessageDialog(null, "Sorry, email address can only contain letters, numbers, dots, underscores, or hyphens before the @ symbol. Please enter a valid email address:");
               emailAddress = JOptionPane.showInputDialog(null, "Enter your email address: ");
               continue;
           }
       }

      setEmailAddress(emailAddress);
      break;
     } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid email address. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
  }

  public void phoneNumber() {

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {
       
      JOptionPane.showMessageDialog(null, "Enter your phone number (11 digits long starting with 0): ");
      phoneNumber = JOptionPane.showInputDialog(null, "Enter your phone number (11 digits long starting with 0): ");
      attempts++;

      if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
        continue;
      }

      if (phoneNumber.length() != 11) {
        if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
          return;
        }
        JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
        JOptionPane.showMessageDialog(null, "Sorry, this phone number is not 11 digits long. Please try again: ");
        continue;
      }

      for (int i = 0; i < phoneNumber.length(); i++) {
        if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.charAt(0) != '0') {
          if (attempts == maxAttempts) {
          JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "Sorry, this phone number either doesn't start with 0 or has strings inside it which isnt valid. Please try again: ");
          continue;
        }
      }

       setPhoneNumber(phoneNumber);
       break;
      } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid phone number. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     } 
    }

  abstract public void Food();
  abstract public void Drink();
  abstract public void Dessert();
  abstract public void Cost(double foodCost, double drinkCost, double dessertCost);

}
