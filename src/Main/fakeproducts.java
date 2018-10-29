package Main;
import entities.products;
import java.util.Scanner;


public class fakeproducts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(;;) {

            System.out.println("Please chose the action you want to perform: \n1. Create a new product\n" +
                    "2. Save the product\n3.Load the product\n4.Exit");
            int choice = in.nextInt();
            switch (choice){
                case 1:{
                    break;
                }case 2: {
                    break;
                }case 3:{
                    break;
                }case 4:{
                    System.out.println("GOOD BYE!!");
                }
            }
            if(choice==4)break;
        }

      //products p = new products();
   //     System.out.println(p);
    //    p.savetoFile("Javatext.txt");

    }

}
