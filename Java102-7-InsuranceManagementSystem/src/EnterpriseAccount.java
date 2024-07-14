public class EnterpriseAccount extends Account{


    public EnterpriseAccount(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insuranceArrayList.add(insurance);
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
