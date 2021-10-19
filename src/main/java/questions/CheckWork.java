package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static userinterface.GoogleElements.VERIFY_VIDEO;

public class CheckWork implements Question<Boolean> {

    public static CheckWork inTheScreen(){
        return new CheckWork();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(VERIFY_VIDEO).viewedBy(actor).asBoolean();
    }
}
