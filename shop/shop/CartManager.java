import java.util.HashMap;

public class CartManager {

    private HashMap<Integer, CartItem> cart = new HashMap<>();

    public void addItem(CartItem item){
        CartItem existingItem = search(item.getName());
        if (existingItem == null) {
            // New item
            CartItem cartItem = new CartItem(item.getId(), item.getName(), item.getQty(), item.getPrice());
            cart.put(item.getId(), cartItem);
        } else {
            // Existing item only increment the quantity
            increment(existingItem.getId(), item.getQty());
        }
    }

    public CartItem search(String name) {
        for (CartItem item : this.cart.values()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // No item available
    }

    public Double increment(Integer id, Double qty) {
        CartItem item = cart.get(id);
        Double updatedQty = item.getQty() + qty;
        item.setQty(updatedQty);
        return updatedQty;
    }

    public Double decrement(Integer id, Double qty) {
        CartItem item = cart.get(id);
        Double updatedQty = item.getQty() - qty;
        item.setQty(updatedQty);
        return updatedQty;
    }

    public Double getTotal() {
        Double total = 0.0;
        // Total all in cart 
        for (CartItem item : this.cart.values()) {
            System.out.println(item);
            total = total + item.getTotalPrice();
        }
        return total;
    }

}
