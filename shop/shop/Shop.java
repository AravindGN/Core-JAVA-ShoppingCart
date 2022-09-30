import java.util.Scanner;

public class Shop {

    private ItemManager itemManager = new ItemManager();
    private CartManager cartManager = new CartManager();

    public Shop() {
        this.sampleStock();
        this.menu();
    }

    private void menu() {
        while (true) {
            System.out.println("**************************");
            System.out.println("1. Add Stock");
            System.out.println("2. Sell");
            System.out.println("3. Print Bill");
            System.out.println("4. Print Stock");
            System.out.println("5. Exit");
            System.out.println("--------------------------");
            System.out.println("Choice? ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            System.out.println("**************************");

            switch (choice) {
                case 1:
                    Item item = getItem();
                    itemManager.addItem(item);
                    break;
                case 2:
                    itemManager.printAll();
                    CartItem cartItem = getCartItem();
                    cartManager.addItem(cartItem);
                    itemManager.decrement(cartItem.getId(), cartItem.getQty());
                    break;
                case 3:
                    System.out.println("ABC Company");
                    System.out.println("Nitravalai");
                    System.out.println("-------------------------------");
                    Double total = cartManager.getTotal();
                    System.out.println("-------------------------------");
                    System.out.println("Amount to be paid: " + total);
                    System.out.println("Welcome again, Thank you.");
                    System.out.println("-------------------------------");
                    break;
                case 4:
                    itemManager.printAll();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private Item getItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name ? ");
        String name = scanner.next();
        System.out.println("Qty ? ");
        Double qty = scanner.nextDouble();
        System.out.println("Price ? ");
        Double price = scanner.nextDouble();

        return new Item(name, qty, price);
    }

    private CartItem getCartItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id please ? ");
        Integer id = scanner.nextInt();
        Item item = itemManager.searchById(id);
        if (item == null) {
            System.out.println("Required item is not available");
        } else {
            System.out.println("Qty ? ");
            Double qty = scanner.nextDouble();
            CartItem cartItem = new CartItem(id, item.getName(), qty, item.getPrice());
            return cartItem;
        }
        return null;
    }

    public void sampleStock() {
        Item item1 = new Item("Sugar", 100.00, 50.00);
        itemManager.addItem(item1);

        Item item2 = new Item("Rava", 150.00, 30.00);
        itemManager.addItem(item2);

        Item item3 = new Item("Noodles", 50.00, 30.00);
        itemManager.addItem(item3);

        Item item4 = new Item("Mida", 75.00, 25.00);
        itemManager.addItem(item4);
    }

    public static void main(String args[]) {
        new Shop();
    }

}
