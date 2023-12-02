import javax.print.DocFlavor.STRING;

public class Item {
    private String description;
    private int weight;
    private int amount;
    private String name;

    public Item(String description, int weight, int amount){
        this.description = description;
        this.weight = weight;
        this.amount = amount;
    }

    public void perderItem(){
        System.out.println(amount);
        amount--;
        System.out.println(amount);
    }

    public void ganhaItem(){
        System.out.println(amount);
        amount++;
        System.out.println(amount);
    }

    public int getAmount(){
        return amount;
    }

    public String getDescription(){
        return description;
    }

    public int getWeight(){
        return weight;
    }

}
