import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private boolean hasFood;
    private boolean hasFirewood;
    private boolean hasWater;
    private boolean foodCollected;
    private boolean firewoodCollected;
    private boolean waterCollected;
    private ArrayList<String> inventoryList;


    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
        this.hasFood = false;
        this.hasFirewood = false;
        this.hasWater = false;
        this.foodCollected = false;
        this.firewoodCollected = false;
        this.waterCollected = false;
    }

    public void addInventory(String item) {
        this.inventoryList.add(item);
    }
    public ArrayList<String> getInventoryList() {
        return inventoryList;
    }
    public void selectChar(){
        System.out.println("-----------------------------" +
                "----------------------------------------");
        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};

        for(GameChar gameChar : charList){


            System.out.println("ID: "+gameChar.getId()+"-> Character: "+gameChar.getName()+
                    " \t Damage: "+gameChar.getDamage() +
                    " \t Health: " + gameChar.getHealth() +
                    " \t Money: "+ gameChar.getMoney());
        }
        System.out.print("--------------------------------" +
                "-------------------------------------" +
                "\nPlease select your character!\nEnter the id: ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai()) ;
        }
     /*   System.out.println("--------------------------------" +
                "-------------------------------------");
        System.out.println("Selected Character -> "+this.getCharName()+
                ":\tDamage: "+this.getDamage() +
                ", Health: " + this.getHealth() +
                ", Money: "+ this.getMoney());
        System.out.println("--------------------------------" +
                "-------------------------------------");*/
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setCharName(gameChar.getName());
        this.setMoney(gameChar.getMoney());

    }
    public void printInfo(){
        System.out.println("----------\nWeapon: "+ this.getInventory().getWeapon().getName() +
                ", Armor: "+this.getInventory().getArmor().getName() +", Damage: "+this.getTotalDamage() +
                ", Block:"+this.getInventory().getArmor().getBlock()+
                ", Health: " + this.getHealth() +
                ", Money: "+ this.getMoney());

    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    /*public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }*/

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
    public boolean hasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean hasFirewood() {
        return hasFirewood;
    }

    public void setHasFirewood(boolean hasFirewood) {
        this.hasFirewood = hasFirewood;
    }

    public boolean hasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }
    public boolean isFoodCollected() {
        return foodCollected;
    }

    public void setFoodCollected(boolean foodCollected) {
        this.foodCollected = foodCollected;
    }

    public boolean isFirewoodCollected() {
        return firewoodCollected;
    }

    public void setFirewoodCollected(boolean firewoodCollected) {
        this.firewoodCollected = firewoodCollected;
    }

    public boolean isWaterCollected() {
        return waterCollected;
    }

    public void setWaterCollected(boolean waterCollected) {
        this.waterCollected = waterCollected;
    }

}
