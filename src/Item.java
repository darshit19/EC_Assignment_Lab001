public class Item {
    private int item_code,qty_in_stock,min_qty_in_stock;
    private double cost;
    private String description;
    //Constructors
    Item(int code,String description,int qty,int min_qty,double cost){
        this.item_code=code;
        this.description=description;
        this.qty_in_stock=qty;
        this.min_qty_in_stock=min_qty;
        this.cost=cost;
    }

    Item(int code, String description, double cost){
        this.item_code=code;
        this.description=description;
        this.cost=cost;
        this.qty_in_stock=0;
        this.min_qty_in_stock=0;
    }

//Methods
    int getItemCode(){
        return this.item_code;
    }
    String getItemDescription(){
        return this.description;
    }
    double getCost(){
        return this.cost;
    }
    void setCost(double cost){
        this.cost=cost;
    }
    int getStock() //gets Quantity
    {
        return this.qty_in_stock;
    }
    int getMinQty() //gets min quantity
    {
        return this.min_qty_in_stock;
    }
    void addStock(int qty)
    //increases the stock by given qty
    {
        this.qty_in_stock=this.qty_in_stock+qty;
    }
    void withdrawStock(int qty) throws InSufficientStock
    //decreases the stock by given qty
    {
        if(qty<=this.qty_in_stock){
            this.qty_in_stock=this.qty_in_stock-qty;
        }else{
            throw new InSufficientStock("Not enough quantity in stock");
        }
    }
    boolean isUnderStock()
//returns true if item is under stock, i.e. qty < min_qty otherwise false
    {
        return this.qty_in_stock>=this.min_qty_in_stock;
    }

}
