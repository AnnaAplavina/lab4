package classes;

import enums.Emotion;
import exceptions.TrollsNameException;
import interfaces.ITroll;

public abstract class Troll implements ITroll {
    private String name;
    abstract void expressEmotion(Emotion emotion);
    @Override
    public String getName(){
        return name;
    }
    public Troll (String name){
            try{
            setName(name);}
            catch (TrollsNameException e){
                e.printStackTrace();
                this.name = "NameException";
            }
        }
        public void setName(String name) throws TrollsNameException{
            String checkName = name.toLowerCase();
            char[] arr = checkName.toCharArray();
            for (char i : arr) {
                if (!(Character.isLetter(i) || i == ' ')) {
                    throw new TrollsNameException("Некоррктное имя тролля");
                }
                this.name = name;
            }
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    public boolean equals(Object o){
        return super.equals(o);
    }
}
