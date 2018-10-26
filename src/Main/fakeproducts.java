package Main;
import entities.products;

public class fakeproducts {
    public static void main(String[] args) {

        //HW while() will launch the menu after each choice
        //MENU 1. create a new product
        //2. Save product
        //3. load product
        //4. exit

        products p = new products();
        System.out.println(p);
        p.savetoFile("C:\\Users\\Mihail Olaru\\Desktop\\Javatext.txt");

    }

}
