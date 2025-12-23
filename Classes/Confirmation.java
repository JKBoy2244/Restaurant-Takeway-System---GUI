import javax.swing.JOptionPane;

class Confirmation implements ConfirmInterface {
    @Override
    public void confirm(UserDetails User) {
        JOptionPane.showMessageDialog(null, "Thank you for ordering from our restaurant, " + User.getFirstName() + " " + User.getLastName() + ". Your order has been confirmed and it will be delivered to you shortly. Have a great day!");
    }
}
