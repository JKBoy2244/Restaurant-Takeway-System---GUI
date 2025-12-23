import javax.swing.JOptionPane;

public class OrderMealTest {

  public static void main(String[] args) {


    OrderMeal order = new OrderMeal("Bob", "Daniel", "bobdaniel@yahoo.com", "09876543212", "4 PC. Wings and Chips", "Coke", "Chocolate Ice Cream", 2.50);
    JOptionPane.showMessageDialog(null, order.getFirstName());
    JOptionPane.showMessageDialog(null, order.getLastName());
    JOptionPane.showMessageDialog(null, order.getEmailAddress());
    JOptionPane.showMessageDialog(null, order.getPhoneNumber());
    JOptionPane.showMessageDialog(null, order.getFirstName());
    JOptionPane.showMessageDialog(null, order.getFood());
    JOptionPane.showMessageDialog(null, order.getDrink());
    JOptionPane.showMessageDialog(null, order.getDessert());
    JOptionPane.showMessageDialog(null, order.getCost());
  }
  
}
