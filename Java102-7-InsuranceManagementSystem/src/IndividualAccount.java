public class IndividualAccount extends Account{

    public IndividualAccount(User user) {
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
