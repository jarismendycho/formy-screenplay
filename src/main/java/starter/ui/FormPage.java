package starter.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormPage {
    public static final Target FIRST_NAME     = Target.the("first name field").located(By.id("first-name"));
    public static final Target LAST_NAME      = Target.the("last name field").located(By.id("last-name"));
    public static final Target JOB_TITLE      = Target.the("job title field").located(By.id("job-title"));
    public static final Target EDUCATION      = Target.the("college radio button").located(By.id("radio-button-2"));
    public static final Target GENDER         = Target.the("male checkbox").located(By.id("checkbox-1"));
    public static final Target EXPERIENCE     = Target.the("experience dropdown").located(By.id("select-menu"));
    public static final Target DATE           = Target.the("date field").located(By.id("datepicker"));
    public static final Target SUBMIT_BUTTON  = Target.the("submit button").located(By.cssSelector(".btn.btn-lg.btn-primary"));
    public static final Target ALERT_SUCCESS  = Target.the("success alert").located(By.className("alert"));
}