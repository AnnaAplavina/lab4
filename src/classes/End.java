package classes;
import exceptions.NoOccasionException;

import java.util.*;
public class End {
    private static int numberOfEventsAboutToEnd = 0;
    NewEnding ending;
    private String whatEnded;
    private Occasion occasion;
    public End(String whatEnded, String howEnded){
        this.whatEnded = whatEnded;
        ending = new NewEnding(howEnded);
        EventsToEndCounter.addEvent(whatEnded);
    }
    public End (Occasion occasion, String howEnded){
        this.occasion = occasion;
        ending = new NewEnding(howEnded);
        EventsToEndCounter.addEvent(occasion.getName());
    }
    public void changeOccasion(Occasion occ){
        try{
            if(occ == null){
                throw new NoOccasionException("Попытка изменить событие на несуществующее");
            }
            occasion = occ;
        }
        catch (NoOccasionException e){
            System.out.println("Нельзя изменить событие на несуществующее");
            e.printStackTrace();
        }
    }
    public static void printNumOfEventsAboutToEnd(){
        System.out.println(numberOfEventsAboutToEnd + " - число действий/событий, которые могут завершиться");
    }
    public void endEvent(){
        System.out.print("Действие ");
        ending.end();
    }
    public void endOccasion(){
        System.out.print("Событие ");
        ending.end();
    }
    class NewEnding{
    String howEnded;
    public NewEnding(String howEnded){
        this.howEnded = howEnded;
    }
    private void end(){
        if(!(whatEnded == null)) {
            System.out.println(whatEnded + ", " + howEnded);
        }
        else{
            System.out.println(occasion.getName() + ", " + howEnded);
        }
        EventsToEndCounter.deleteEvent(whatEnded);
        }
    }

    private static class EventsToEndCounter{
        private static ArrayList<String> ends = new ArrayList<String>();
        private static void addEvent(String end) {
            ends.add(end);
            numberOfEventsAboutToEnd = ends.size();
        }
        private static void deleteEvent(String end){
            ends.remove(end);
            numberOfEventsAboutToEnd = ends.size();
        }
    }
}
