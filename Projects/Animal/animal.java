public class animal {
    public int age;
    public String gender; 

    public void isMammal() {
        System.out.println("Method from Animal class");
    }

    public void mate() {
        System.out.println("Method from Animal class");
    }

    public static void main(String[] args) {
        animal myAnimal = new animal();
        Fish myFish = new Fish();
        Zebra myZebra = new Zebra();

        myAnimal.isMammal();
        myAnimal.mate();
        myZebra.run();
    }
}

class Fish extends animal {
    private double sizeInFeet;

    public void canEat() {
        System.out.println("Method from Fish class");
    }
}

class Zebra extends animal {
    public boolean isWild; 

    public void run() {
        System.out.println("Method from Zebra class");
    }
}
