import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<IAddress> IAddressArrayList;
    private String lastLoginDate;

    public User(String name, String surname, String email, String password, String job, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.IAddressArrayList = new ArrayList<>();
    }
    public void addAddress(IAddress address){
        IAddressArrayList.add(address);
    }
    public void removeAddress(IAddress address){
        IAddressArrayList.remove(address);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<IAddress> getIAddressArrayList() {
        return IAddressArrayList;
    }

    public void setIAddressArrayList(ArrayList<IAddress> IAddressArrayList) {
        this.IAddressArrayList = IAddressArrayList;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
