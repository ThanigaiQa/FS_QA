public class Integercaching {

    public static void main(String arg[]){
        //Integer caching
        //If we compare two integers using == that would work for certain range of integer values
        // (Integer from -128 to 127) due to the JVM's internal optimisation.


        int n1 = 100;
        int n2 = 100;
        if (n1== n2) {
            System.out.println("both are equal");
        } else{
            System.out.println("both are not equal");


        }
    }
}
