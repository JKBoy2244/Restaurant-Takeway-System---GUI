import javax.swing.JOptionPane;

public class OrderMealTest {

  public static void main(String[] arg) {


    OrderMeal order = new OrderMeal("Bob", "Daniel", "bobdaniel@yahoo.com", "09876543212", "4 PC. Wings and Chips", "Coke", "Chocolate Ice Cream", 2.50);
    JOptionPane.showMessageDialog(order.getFirstName());
    JOptionPane.showMessageDialog(order.getLastName());
    JOptionPane.showMessageDialog(order.getEmailAddress());
    JOptionPane.showMessageDialog(order.getPhoneNumber());
    JOptionPane.showMessageDialog(order.getFirstName());
    JOptionPane.showMessageDialog(order.getFood());
    JOptionPane.showMessageDialog(order.getDrink());
    JOptionPane.showMessageDialog(order.getDessert());
    JOptionPane.showMessageDialog(order.getCost());
  }
  
}
