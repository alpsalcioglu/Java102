public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Welcome to the Tool Store...");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1. Weapons\n2. Armours\n3. Exit.");
            System.out.print("Your Selection: ");
            int selectCase = Location.input.nextInt();
            while(selectCase <1 || selectCase > 3){
                System.out.println("Invalid selection, try again...");
                System.out.print("Your Selection: ");
                selectCase = Location.input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Come Again...");
                    showMenu = false;
                    break;

            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("---> Weapons: ");
        for(Weapon w : Weapon.weapons()){
            System.out.println("ID:"+w.getId() +
                    " -> "+ w.getName() +
                    "\t <Price: "+w.getPrice() +
                    ", Damage: " + w.getDamage() + ">" );
        }
        System.out.println("0: Exit.");
    }
    public void buyWeapon(){
        System.out.print("Choose a weapon, Enter its id: ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID <0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Invalid selection, try again...");
            System.out.print("Your Selection: ");
            selectWeaponID = Location.input.nextInt();
        }
        if(selectWeaponID !=0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if( selectedWeapon != null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("You do not have enough money! ");
                }else{
                    System.out.println("You have purchased the "
                            +selectedWeapon.getName()+" successfully..." );
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money: "+ this.getPlayer().getMoney());
                    // System.out.println("Your previous weapon: "+ this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    // System.out.println("Your new weapon: "+ this.getPlayer().getInventory().getWeapon().getName());


                }
            }
        }

    }
    public void printArmor(){
        System.out.println("---> Armors: ");
        for(Armor a : Armor.armors()){
            System.out.println("ID:"+a.getId() +
                    " -> "+ a.getName() +
                    "\t <Price: "+a.getPrice() +
                    ", Block: " + a.getBlock() + ">" );
        }
        System.out.println("0: Exit.");
    }
    public void buyArmor(){
        System.out.print("Choose an armor, Enter its id: ");
        int selectArmorID = input.nextInt();
        while(selectArmorID <0 || selectArmorID > Armor.armors().length){
            System.out.println("Invalid selection, try again...");
            System.out.print("Your Selection: ");
            selectArmorID = Location.input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
        if(selectArmorID!=0){
            if(selectedArmor!=null){
                if(selectedArmor.getPrice()> this.getPlayer().getMoney()){
                    System.out.println("You do not have enough money! ");
                }else {
                    System.out.println("You have purchased the "
                            + selectedArmor.getName() + " successfully...");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }



    }



}
