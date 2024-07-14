import java.util.ArrayList;

public abstract class Account implements Comparable<Account>{

    protected User user;

    protected AuthenticationStatus authStatus;
    protected ArrayList<Insurance> insuranceArrayList;
    public Account(User user) {
        this.user = user;
        this.authStatus = AuthenticationStatus.FAIL;
        this.insuranceArrayList = new ArrayList<>();
    }

    public final void showUserInfo(){
        System.out.println("Name: " + user.getName());
        System.out.println("Surname: " + user.getSurname());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Job: " + user.getJob());
        System.out.println("Age: " + user.getAge());
    }
    public void login(String email,String password) throws InvalidAuthenticationException{
        if(user.getEmail().equals(email) && user.getPassword().equals(password)){
           authStatus=  AuthenticationStatus.SUCCESS;
        }else{
            throw new InvalidAuthenticationException("Invalid email or password!");
        }
    }
    public void addAddress(IAddress address){
        user.addAddress(address);
    }
    public void removeAddress(IAddress address){
        user.removeAddress(address);
    }
    public AuthenticationStatus getAuthenticationStatus() {
        return authStatus;
    }
    public abstract void addInsurance(Insurance insurance);

    @Override
    public int compareTo(Account other) {
        return this.user.getEmail().compareTo(other.user.getEmail());
    }

    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return user.getEmail().equals(account.user.getEmail());
    }
}
