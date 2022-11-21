//trying to protect the bank customer name and phonenumber
public class EncapsulationBankCustomer {
    public static void main(String[] args) {
        Onecustomer customer = new Onecustomer();
       //Set the values to the vars
        customer.setName("Ashis Adhikary");
        customer.setMobile(9841836);
        //Now get these values
        System.out.println(customer.getName());
        System.out.println(customer.getMobile());
    }

}

class Onecustomer{
    private String name;
    private int mobile;
    //As they are private now we use getter and setter. Setters always sets the data (constant) and getters return them
    public void setName(String name) {
        this.name = name;
    }
    public void setMobile(int Mobile){
        this.mobile = mobile;
    }
    public String getName(){
        return name;
    }
   public int getMobile(){
      return mobile;
   }
}