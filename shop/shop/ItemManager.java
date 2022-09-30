import java.util.HashMap;

public class ItemManager {

    private HashMap<Integer, Item> stock = new HashMap<>();

    public void addItem(Item item) {

        Item existingItem = search(item.getName());
        if (existingItem == null) {
            // New item
            Integer id = generateId();
            item.setId(id);
            stock.put(id, item);
        } else {
            // Existing item only increment the quantity
            increment(existingItem.getId(), item.getQty());
        }
    }

    private Integer generateId() {
        Integer id = stock.size() + 1; // Total Item count + 1
        return id;
    }

    public Item search(String name) {
        for (Item item : this.stock.values()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // No item available
    }

    public Item searchById(Integer id) {
        for (Item item : this.stock.values()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // No item available
    }

    public Double increment(Integer id, Double qty) {
        Item item = stock.get(id);
        Double updatedQty = item.getQty() + qty;
        item.setQty(updatedQty);
        return updatedQty;
    }

    public Double decrement(Integer id, Double qty) {
        Item item = stock.get(id);
        Double updatedQty = item.getQty() - qty;
        item.setQty(updatedQty);
        return updatedQty;
    }

    public void printAll() {
        for (Item item : this.stock.values()) {
            System.out.println(item);
        }
    }

    // For testing
    // public static void main(String args[]) {

    // ItemManager itemManager = new ItemManager();
    // Item item1 = new Item("Sugar", 100.00, 50.00);
    // itemManager.addItem(item1);

    // Item item2 = new Item("Rava", 150.00, 30.00);
    // itemManager.addItem(item2);

    // Item item3 = new Item("Rava", 50.00, 30.00);
    // itemManager.addItem(item3);

    // Item item4 = new Item("Mida", 75.00, 25.00);
    // itemManager.addItem(item4);

    // itemManager.printAll();
    // }
}
