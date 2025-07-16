class OrderMeal extends UserDetails implements UserInterface {

  private String food;
  private String drink;
  private String dessert;
  private double cost;

  public OrderMeal(String firstName, String lastName, String emailAddress, String phoneNumber, String food, String drink, String dessert, double cost) {

    super(firstName, lastName, emailAddress, phoneNumber);
    this.food = food;
    this.drink = drink;
    this.dessert = dessert;
    this.cost = cost;

  }

  public String getFood() {
    return food;
  }

  public String getDrink() {
    return drink;
  }

  public String getDessert() {
    return dessert;
  }

  public double getCost() {
    return cost;
  }

  public void setFood(String food) {

    if (food == null || food.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Food can't be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    String[] foodOptions = {"4 PC. Wings and Chips", "3 PC. Wings and Chips", "2 PC. Wings and Chips", "Cheese Burger and Chips","Beef Burger and Chips", "4 Nuggets and Chips", "6 Nuggets and Chips", "4 Nuggets and cheese burger", "4 Nuggets and beef burger", "1 PC. Chicken and Chips", "foodVoid"};
    boolean validFoodOption = false;
    for (int i = 0; i < foodOptions.length; i++) {
      if (food.equalsIgnoreCase(foodOptions[i])) {
        validFoodOption = true;
        break;
      }
    }

    if (!validFoodOption) {
      JOptionPane.showMessageDialog(null, "Invalid food option selected!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.food = food.trim();
  }

  public void setDrink(String drink) {

    if (drink == null || drink.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Drink can't be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    String[] drinkOptions = {"Water", "Coke", "Sprites", "Fanta", "Lemonade", "Orange Juice", "drinkVoid"};

    boolean validDrinkOption = false;
    for (int i = 0; i < drinkOptions.length; i++) {
      if (drink.equalsIgnoreCase(drinkOptions[i])) {
        validDrinkOption = true;
        break;
      }
    }

    if (!validDrinkOption) {
      JOptionPane.showMessageDialog(null, "Invalid drink option selected!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.drink = drink.trim();
  }

  public void setDessert(String dessert) {

    if (dessert == null || dessert.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Dessert can't be empty or null!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    String[] dessertOptions = {"Vanilla Ice Cream", "Chocolate Ice Cream", "Strawberry Ice Cream", "Chocolate Cake", "Vanilla Cake", "dessertVoid"};

    boolean validDessertOption = false;
    for (int i = 0; i < dessertOptions.length; i++) {
      if (dessert.equalsIgnoreCase(dessertOptions[i])) {
        validDessertOption = true;
        break;
      }
    }

    if (!validDessertOption) {
      JOptionPane.showMessageDialog(null, "Invalid drink option selected!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.dessert = dessert.trim();
  }

  public void setCost(double cost) {

    if (cost < 0) {
      JOptionPane.showMessageDialog(null, "Cost can't be negative!", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    this.cost = cost;
  }

  @Override
  public void Food() {

    String[] foodOptions = {"4 PC. Wings and Chips", "3 PC. Wings and Chips", "2 PC. Wings and Chips", "Cheese Burger and Chips","Beef Burger and Chips", "4 Nuggets and Chips", "6 Nuggets and Chips", "4 Nuggets and cheese burger", "4 Nuggets and beef burger", "1 PC. Chicken and Chips", "foodVoid"};
  double[] foodPrices = {6.10, 5.20, 4.30, 4.50, 4.10, 5.30, 6.70, 4.80, 5.10, 5.60, 0.00};

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

      try {

      JOptionPane.showMessageDialog(null, "Enter the food you want to order from the above array list or foodVoid if you don't want to order food: ");
      food = JOptionPane.showInputDialog(null, "Enter the food you want to order from the above array list or foodVoid if you don't want to order food: ");
      attempts++;

      if (food == null || food.trim().isEmpty()) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid food option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        boolean foodValid = false;
        for (int i = 0; i < foodOptions.length; i++) {
          if (food.equalsIgnoreCase(foodOptions[i])) {
            foodValid = true;
            break;
          }
        }

        if (!foodValid) {
          if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid food option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

      double foodCost = 0.00;
      for (int i = 0; i < foodOptions.length; i++) {
         if (food.equalsIgnoreCase(foodOptions[i])) {
           foodCost = foodPrices[i];
           setFood(food);
           break;
         }
       }

         this.cost += foodCost;
         break;
        } catch (Exception e) {
           if (attempts == maxAttempts) {
             JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid food option. Try again later: ");
             return;
           }
           JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
           attempts++;
         }
       }
      }

  @Override
  public void Drink() {

    String[] drinkOptions = {"Water", "Coke", "Sprites", "Fanta", "Lemonade", "Orange Juice", "drinkVoid"};
    double[] drinkPrices = {1.10, 0.90, 0.85, 0.95, 1.25, 1.00, 0.00};

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {

      JOptionPane.showMessageDialog(null, "Enter the drink you want to order from the above array list or drinkVoid if you don't want to order drink: ");
      drink = JOptionPane.showInputDialog(null, "Enter the drink you want to order from the above array list or drinkVoid if you don't want to order drink: ");
      attempts++;

      if (drink == null || drink.trim().isEmpty()) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid drink option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        boolean drinkValid = false;
        for (int i = 0; i < drinkOptions.length; i++) {
          if (drink.equalsIgnoreCase(drinkOptions[i])) {
            drinkValid = true;
            break;
          }
        }

        if (!drinkValid) {
          if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid drink option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        double drinkCost = 0.00;
        for (int i = 0; i < drinkOptions.length; i++) {
           if (drink.equalsIgnoreCase(drinkOptions[i])) {
             drinkCost = drinkPrices[i];
             setDrink(drink);
             break;
           }
         }

         this.cost += drinkCost;
         break;
        } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid drink option. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
   }


  @Override
  public void Dessert() {

    String[] dessertOptions = {"Vanilla Ice Cream", "Chocolate Ice Cream", "Strawberry Ice Cream", "Chocolate Cake", "Vanilla Cake", "dessertVoid"};
    double[] dessertPrices = {0.45, 0.55, 0.50, 0.80, 0.75, 0.00};

    final int maxAttempts = 3;
    int attempts = 0;

    while (attempts < maxAttempts) {

     try {
       
      JOptionPane.showMessageDialog(null, "Enter the dessert you want to order from the above array list or dessertVoid if you don't want to order food: ");
      dessert = JOptionPane.showInputDialog(null, "Enter the dessert you want to order from the above array list or dessertVoid if you don't want to order food: ");
      attempts++;

      if (dessert == null || dessert.trim().isEmpty()) {
        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid dessert option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

        boolean dessertValid = false;
        for (int i = 0; i < dessertOptions.length; i++) {
          if (dessert.equalsIgnoreCase(dessertOptions[i])) {
            dessertValid = true;
            break;
          }
        }

        if (!dessertValid) {
          if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid dessert option. Try again later: ");
            return;
          }
          JOptionPane.showMessageDialog(null, "You have " + (maxAttempts - attempts) + " chances left!");
          JOptionPane.showMessageDialog(null, "No empty inputs allowed. Please try again: ");
          continue;
        }

         double dessertCost = 0.00;
         for (int i = 0; i < dessertOptions.length; i++) {
           if (dessert.equalsIgnoreCase(dessertOptions[i])) {
             dessertCost = dessertPrices[i];
             setDessert(dessert);
             break;
           }
         }

         this.cost += dessertCost;
         break;
        } catch (Exception e) {
         if (attempts == maxAttempts) {
           JOptionPane.showMessageDialog(null, "You exceeded the number of attempts to enter a valid dessert option. Try again later: ");
           return;
         }
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
         attempts++;
       }
     }
   }

 @Override
  public void Cost(double foodCost, double drinkCost, double dessertCost) {

    double cost = foodCost + drinkCost + dessertCost;
    setCost(cost);
    JOptionPane.showMessageDialog(null, "The total cost of your order is: £ " + this.cost);

  }
}
