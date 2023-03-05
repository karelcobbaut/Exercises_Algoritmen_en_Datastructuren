package week7parking;

import java.util.*;



class myComp implements Comparator<Event> {

    public int compare(Event a, Event b)
    {
        if(a.timestamp()!=b.timestamp()) return a.timestamp()-b.timestamp();
        else return a.duration()-b.duration();

    }
}
public class QueueParkingSimulator implements ParkingSimulator {
    @Override
    public int simulate(int capacity, int returnTime, Collection<Event> arrivalEvents) {
        int time=0;
        PriorityQueue<Event> myQueue = new PriorityQueue<>(new myComp());

        myQueue.addAll(arrivalEvents);
        if(myQueue.size()==0) return 0;

        PriorityQueue<Event> parking = new PriorityQueue<>(capacity,new myComp());
        Event e = myQueue.poll();
        while(true){
            if((capacity>parking.size()||e.timestamp()>=parking.peek().timestamp()+parking.peek().duration())){
                if(parking.size()==capacity){
                    Event e1 = parking.poll();
                    if(e1.duration()+e1.timestamp()>time) time = e1.timestamp()+e1.duration();
                }
                parking.add(e);


            }
            else if(e.timestamp()<parking.peek().timestamp()+parking.peek().duration()) {
                Event eNew = new Event(e.timestamp()+returnTime,true,e.duration());
                myQueue.add(eNew);

                //e = myQueue.poll();
            }
            if(myQueue.size()==0) break;
            e=myQueue.poll();


        }


        while(parking.size()>0){
            Event e1 = parking.poll();
            if(e1.duration()+e1.timestamp()>time) time = e1.timestamp()+e1.duration();
            //e1 = parking.poll();


        }

        return time;
    }
}
