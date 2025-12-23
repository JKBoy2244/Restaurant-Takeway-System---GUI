import javax.swing.JOptionPane;

public class OrderMealTest4 {

  public static void main(String[] args) {


    OrderMeal order = new OrderMeal("B", "Danielyyyyyyyyyyyyyyyyyyyyyy", "bobdaniel.com", "0987654321343343''@2", "100 Burgers", "Cake", "Chocolate Ice Cream---//@", 2.50);
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
