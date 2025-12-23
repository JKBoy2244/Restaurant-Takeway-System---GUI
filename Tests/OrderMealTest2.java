import javax.swing.JOptionPane;

public class OrderMealTest2 {

  public static void main(String[] args) {


    OrderMeal order = new OrderMeal("", "", "", "", "", "", "", 0.00);
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
