import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        if (isAwardCollected()) {
            System.out.println("You have already collected the reward from this location!");
            return true;
        }
        int obsNumber = this.randomObstacleNumber();

        System.out.println("You are here now: " + this.getName());
        System.out.print("Be careful, there are " + obsNumber + " " + this.getObstacle().getName());
        if (obsNumber != 1) {
            System.out.println("s here!");
        } else {
            System.out.println(" here!");
        }
        System.out.print("(Press)-> <F>ight or <R>un? : ");
        String selectCase = input.next();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")) {
            System.out.println("You chose to fight! Good luck!");
            if (combat(obsNumber)) {
                System.out.println("You have won the fight in the " + this.getName() + ".");
                System.out.println("You have earned the award: " + this.getAward());
                giveAward();
                return true;
            }

        } else {
            System.out.println("You ran like a coward i see...");
            return false;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You died!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats();
            while ((this.getPlayer().getHealth() > 0) && (this.getObstacle().getHealth() > 0)) {
                System.out.println("(Press)-> <H>it or <R>un? : ");
                String selectCombat = input.next().toUpperCase();

                if (selectCombat.equals("H")) {
                    System.out.println("You hit!");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Obstacle hit you!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }

            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You have won against the enemy!");
                System.out.println("You earned: " + this.getObstacle().getAward() + " money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your money: " + this.getPlayer().getMoney());
                System.out.println("");
            }
        }

        return false;
    }

    public void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println("Obstacle's Health: " + this.getObstacle().getHealth());
        System.out.println("-----------------------");
    }

    public void playerStats() {
        System.out.println("-----------------------");
        System.out.println("Gamer Status: ");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("-----------------------");
    }

    public void obstacleStats() {
        System.out.println("Obstacle Status: ");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Block: " + this.getObstacle().getDamage());
        System.out.println("Prize: " + this.getObstacle().getAward());
        System.out.println("-----------------------");
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public void giveAward() {
        switch (this.award) {
            case "Food":
                this.getPlayer().setHasFood(true);
                this.getPlayer().setFoodCollected(true);
                break;
            case "Firewood":
                this.getPlayer().setHasFirewood(true);
                this.getPlayer().setFirewoodCollected(true);
                break;
            case "Water":
                this.getPlayer().setHasWater(true);
                this.getPlayer().setWaterCollected(true);
                break;
        }
    }

    public boolean isAwardCollected() {
        switch (this.award) {
            case "Food":
                return this.getPlayer().isFoodCollected();
            case "Firewood":
                return this.getPlayer().isFirewoodCollected();
            case "Water":
                return this.getPlayer().isWaterCollected();
            default:
                return false;
        }
    }
}
