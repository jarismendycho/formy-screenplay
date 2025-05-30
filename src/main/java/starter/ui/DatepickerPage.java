package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerPage {

    public static final Target DATE_FIELD =
            Target.the("date field").located(By.id("datepicker"));

}