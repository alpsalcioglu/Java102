public class AddressManager {
   public static void addAddress(User user, IAddress address){
       user.addAddress(address);
   }
   public static void removeAddress(User user, IAddress address){
       user.removeAddress(address);
   }
}
