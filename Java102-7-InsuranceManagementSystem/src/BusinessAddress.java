public class BusinessAddress implements IAddress{
    private String address;

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
    this.address = address;
    }
}
