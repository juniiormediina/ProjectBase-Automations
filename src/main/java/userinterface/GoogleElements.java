package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleElements extends PageObject {

    public static final Target GOOGLE_INPUT = Target.the("Google Input")
            .located(By.id("input"));

    public static final Target FIRST_RESULT = Target.the("First result")
            .located(By.className("LC20lb DKV0Md"));

    public static final Target VERIFY_VIDEO = Target.the("Verify video")
            .located(By.id("firstHeading"));
}
