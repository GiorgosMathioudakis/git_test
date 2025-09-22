import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.CyclicBarrier;
import static java.lang.Thread.sleep;

public class Car implements Runnable{

    private static final int RACE_DISTANCE = 500;
    private int distance_travelled = 0;
    private String name;
    private int horsepower;
    private final CyclicBarrier startBarrier;
    private static volatile AtomicInteger position = new AtomicInteger(1);
    private static final ReentrantLock printLock = new ReentrantLock();


    public Car(String name,int horsepower, CyclicBarrier startBarrier) {
        assert(horsepower <= 1000);
        this.name = name;
        this.horsepower = horsepower;
        this.startBarrier = startBarrier;

    }

    @Override
    public void run() {

        int launchTime = 1000-horsepower;

        try {

            sleep(launchTime);

            System.out.println(name + " has started the race");

            int acceleration = 100;

            while(distance_travelled < RACE_DISTANCE){

                sleep(3500-horsepower-acceleration);
                acceleration += 200;
                printLock.lock();
                distance_travelled += 100;

                System.out.println(name + " has advanced to " + distance_travelled + " meters");

                if(distance_travelled >= RACE_DISTANCE){
                    System.out.println(name + " has crossed the race line in P" + position.getAndIncrement());
                }

                printLock.unlock();

            }

        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        }


    }

}
