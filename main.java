import java.time.LocalDate;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

public class main {

    public static void main(String[] args) throws InterruptedException {

        int carCount = 3;

        CyclicBarrier barrier = new CyclicBarrier(
                carCount
        );


        Car car1 = new Car("ferrari 812" ,  820 , barrier);
        Thread ferrari = new Thread(car1);

        Car car2 = new Car("lamborghini SVJ" ,  730 , barrier);
        Thread lambo = new Thread(car2);

        Car car3 = new Car("golf R" ,  330 , barrier);
        Thread golf = new Thread(car3);


        System.out.println("The race will begin in...");

        for(int i=3;i>0;i--){
            sleep(1000);
            System.out.println(i + "...");
        }

        golf.start();
        lambo.start();
        ferrari.start();

    }

}
