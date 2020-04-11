/*Фрекен Снорк кивнула. От страха у нее побелела мордочка. Они принялись что-то бормотать и выписывать круги, притоптывая ногами.
Седьмой круг был самым долгим, потому что теперь им стало по-настоящему жутко. Но если ух начал ворожить в ночь на Иванов день,
то надо продолжать, а то еще неизвестно, чем все кончится.
 */

/*Фрекен Снорк кивнула. От страха у нее побелела мордочка. Они принялись что-то бормотать и выписывать круги, притоптывая ногами.
Седьмой круг был самым долгим, потому что теперь им стало по-настоящему жутко. Но если ух начал ворожить в ночь на Иванов день,
то надо продолжать, а то еще неизвестно, чем все кончится.
 */

import classes.*;
import enums.Emotion;
import enums.TimeOfDay;
import exceptions.NoOccasionException;
import exceptions.TrollsNameException;

public class Main {
    public static void main(String[] args) {
        SpecialDate ivanov = new SpecialDate("Иванов день", TimeOfDay.NIGHT);
        MumiTroll snork = new MumiTroll("Фрекен+Снорк"){
            @Override
            public void nod(){
                System.out.println(super.getName() + " кивнула");
            }
        };
        MumiTroll notSnork = new MumiTroll("Снифф");
        snork.expressEmotion(Emotion.AFRAID);
        snork.nod();
        Ritual ritual = new Ritual(ivanov,7,snork,notSnork);
        ritual.start();
        Occasion night = new Occasion("ночь на Иванов день",TimeOfDay.NIGHT);
        End ivanovEnding = new End(ivanov, "завершилось благопалучно");
        End nightEnding = new End(night, "завершилось благопалучно");
        End ritualEnding = new End("ворожба", "завершилось неизвестно чем");
        End.printNumOfEventsAboutToEnd();
        try{
        nightEnding.changeOccasion(null);}
        catch (NoOccasionException e){
            e.printStackTrace();
        }
        ritualEnding.endEvent();
        nightEnding.endOccasion();
        ivanovEnding.endOccasion();
    }
}
