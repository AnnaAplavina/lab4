package classes;

import interfaces.ITimeCirclesCalculator;

public class TimeCirclesCalculator implements ITimeCirclesCalculator {
    @Override
    public int calculateInitialTime(int fearFactor){ return fearFactor*10; }
    @Override
    public int calculateTimeStep(int fearFactor){
        class LocalCalculator{
            private int fearFactor;
            private String message;
            public LocalCalculator(int fearFactor){
                this.fearFactor = fearFactor;
            }
            private int calculateIfVeryScary(){
                return fearFactor*3;
            }
            private int calculateIfJustScary(){
                return fearFactor*2;
            }
        }
        LocalCalculator localCalculator = new LocalCalculator(fearFactor);
        return localCalculator.calculateIfJustScary();
    }
    @Override
    public int calculateCircles(int fearFactor){ return fearFactor; }
}