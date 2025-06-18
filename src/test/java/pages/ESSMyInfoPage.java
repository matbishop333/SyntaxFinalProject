package pages;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ESSMyInfoPage extends CommonMethods {
    public ESSMyInfoPage() {
        PageFactory.initElements(driver, this);
    }


}
