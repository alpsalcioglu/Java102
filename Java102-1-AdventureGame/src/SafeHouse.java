public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
   public boolean onLocation(){
        System.out.println("You are now safe in the Safe House!");
        System.out.println("Your health has been renewed...");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        if (this.getPlayer().hasFood() && this.getPlayer().hasFirewood() && this.getPlayer().hasWater()) {
            System.out.println("Congratulations! You have collected all the rewards and won the game!");
            return false;
        }
        return true;

    }
}
