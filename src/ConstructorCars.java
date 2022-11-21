public class ConstructorCars {
    String name1;
    int model1;
    //create a constructor
    ConstructorCars(String name, int model)
    {
        this.name1 = name;
        this.model1 = model;
    }
    public void printInfo(){
        System.out.println(name1);
        System.out.println(model1);
    }
}

class cars {
    public static void main(String[] args) {
        //calling constructor
        ConstructorCars Nissan = new ConstructorCars("Sedan", 2005);
        Nissan.printInfo();
    }
}