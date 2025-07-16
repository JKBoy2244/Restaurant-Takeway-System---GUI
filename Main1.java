class Main {

  public static void main(String[] args) {

    OrderMeal order = new OrderMeal("", "", "", "", "", "", "", 0.0);
    order.firstName();
    order.lastName();
    order.emailAddress();
    order.phoneNumber();
    JOptionPane.showMessageDialog(null, "Wait for 3 seconds! ");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      JOptionPane.showMessageDialog(null, "Thread sleep was interrupted: " + e.getMessage());
    } 

    order.Food();
    order.Drink();
    order.Dessert();
    order.Cost(0.0, 0.0, 0.0);
    JOptionPane.showMessageDialog(null, "Wait for 3 seconds! ");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      JOptionPane.showMessageDialog(null, "Thread sleep was interrupted: " + e.getMessage());
    } 

    Confirmation confirm = new Confirmation();
    confirm.confirm(order);

  }
}
