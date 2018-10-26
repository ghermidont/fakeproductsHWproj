package entities;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class products {
    String category;
    String name;
    float price;
    String manufacturer;
    Date expires;
    // generate with Faker

    public products(){
        Faker f = new Faker(new Locale("ru"));
        this.category = f.lorem().word();
        this.name = f.commerce().productName();
        this.price = Float.valueOf(f.commerce().price(100, 1000));
        this.manufacturer = f.chuckNorris().fact();
        this.expires = f.date().future(1000, TimeUnit.DAYS);
    }

    public products( String category, String name, float price, String manufacturer, Date expires){
        this.category = category;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "products{\n" +
                "category='" + category + '\'' + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", price=" + price + "\n" +
                ", manufacturer='" + manufacturer + '\'' + "\n" +
                ", expires=" + expires +
                '}';
    }
//HW create another constructor that receives the info from the created file
    // public Product(String file_name){
    //
    //       1. open file an -> intodice this.category = in.next() etc etc all the detail.
    //  }

    /*Scanner in =new Scanner( new File("myfolder/data.txt"));
      String name = in.next();
      Sysout(name);*/

    public void savetoFile(String file_name){

            try {
                FileWriter fw = new FileWriter(new File(file_name));
                fw.write(this.toString());
                fw.close();
            } catch (IOException e) {
                System.err.println("CANNOT SAVE");
            }

    }
}
