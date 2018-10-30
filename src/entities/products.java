package entities;

import com.github.javafaker.Faker;
import java.io.*;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class products {

    private String category;
    private String name;
    private float price;
    private String manufacturer;
    private Date expires;
    private int ordNumber = 0;

    private void request_products(){

        Faker f = new Faker( new Locale("en" ) );
        //products INPUT

        Scanner prodIN = new Scanner( System.in );

            System.out.println("*******************************************************************\n* The program has no input data type checker.                     *\n* Thus, please input the data in the format indicated in the \"()\" *\n*******************************************************************\n" );
            System.out.println("Please input the category of the new product (String):");
            this.category = prodIN.next();

            System.out.println("\nPlease input the name of the product (String):");
            this.name = prodIN.next();

            System.out.println("\nPlease input the price of the product (float data type format):");
            this.price = prodIN.nextFloat();

            System.out.println("\nPlease input the manufacturer of the product (String):");
            this.manufacturer = prodIN.next();

            System.out.println("\n");
            this.expires = f.date().future(1000, TimeUnit.DAYS);

    }

    @Override
    public String toString() {
           return "\n" + "Product nr: " + ordNumber + "\n" +
                "Category: '" + category + '\'' + "\n" +
                "Name: '" + name + '\'' + "\n" +
                "Price: " + price + " $\n" +
                "Manufacturer: '" + manufacturer + '\'' + "\n" +
                "Expiry date: " + expires +
                "\n#################################\n";

    }

    private void readFromFile( String file_name ){

       String line;

       try {
           BufferedReader in = new BufferedReader( new FileReader( file_name ) );

           if ( in.readLine() == null ) {
               System.out.println("\n!!! There are NO products in the DB... !!!\n");
               start();
           }else {
              while( ( line = in.readLine() ) != null ){ System.out.println( line );}
           }

          in.close();

       } catch ( IOException e ){
          e.printStackTrace();
       }

    }

    private void writeToDB( String file_name ){

            try {

                FileWriter fw = new FileWriter( file_name, true );
                fw.write( this.toString() );
                fw.close();

            } catch ( IOException e ) {

                System.err.println( "CANNOT SAVE" );

            }

    }

    private void deleteAllProducts( String file_name ){
        FileWriter fw = null;
        try {
            fw = new FileWriter( file_name );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write( "" );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        for (;;) {

            System.out.println("\nPlease chose the action you want to perform: \n1. View existing products \n" +
                    "2. Create a new product\n3. Delete all the products\n4. EXIT");

            int choice = in.nextInt();

            switch (choice) {

                case 1: {
                    readFromFile("Javatext.txt");
                    break;
                }
                case 2: {
                    request_products();
                    ++ordNumber;
                    writeToDB("Javatext.txt");
                    break;
                }
                case 3: {
                    deleteAllProducts("Javatext.txt");
                    System.out.println("\nAll the products have been deleted from the DB.");
                    break;
                }
                case 4: {
                    System.out.println("GOOD BYE!!");
                }
                default:{
                    System.out.println("Please input a valid option.");
                }

            }

           if (choice == 4) break;

        }
    }

}
