import java.util.HashMap;
import java.util.Set;

public class Player {

    private int limitWeight = 10;
    private int totalWeight;
    private HashMap<String, Item> itemsOfPlayer = new HashMap<>();

    public void takeItem(String name){
        itemsOfPlayer.get(name).ganhaItem();
        updateWeight(name,true);
        System.out.println(getItem(name).getAmount());
        System.out.println("TOTAL PESO: " + totalWeight);
    }

    public void dropItem(String name){
        itemsOfPlayer.get(name).perderItem();
        updateWeight(name,false);
        System.out.println("TOTAL PESO: " + totalWeight);
        if(itemsOfPlayer.get(name).getAmount() == 0){
            itemsOfPlayer.remove(name);
        }
        System.out.println(getItem(name).getAmount());
    }

    public String getItems(){
        Set<String> keys = itemsOfPlayer.keySet();
        String information = String.join(" ", keys);
        return "Items: " + information + "\n"+ "Total weight "+ totalWeight;
    }

    public Item getItem(String name){
        return itemsOfPlayer.get(name) != null ? itemsOfPlayer.get(name) : null;
    }

    private void setItem(String name, Item item) {
        itemsOfPlayer.put(name,item);
        updateWeight(name,true);
        System.out.println(itemsOfPlayer.get(name).getAmount());
        System.out.println("TOTAL PESO: " + totalWeight);
    }

    public void createItem(String description, int weight, int amount, String name) {
        Item item = new Item(description, weight, amount);
        setItem(name, item);
    }

    private void updateWeight(String name, boolean add){
        if(add){
            if(totalWeight == limitWeight){
                System.out.println("sem espaço");
            }else{
                totalWeight +=  itemsOfPlayer.get(name).getWeight();
            }

        }else{
            totalWeight -=  itemsOfPlayer.get(name).getWeight();
        }

    }
}
