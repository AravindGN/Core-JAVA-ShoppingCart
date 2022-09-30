public class Item {

    private Integer id;
    private String name;
    private Double qty;
    private Double price;

    // Constructor
    public Item(String name, Double qty, Double price) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQty() {
        return this.qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // 1: Sugar: 100.00: 50.00
    public String toString(){
        return this.id+": "+this.name+": "+this.qty+ ": "+ this.price;
    }

    // For testing
    // public static void main(String args[]){
    //     Item item = new Item(1, "Sugar", 100.00, 50.00);
    //     System.out.println(item);
    // }

}