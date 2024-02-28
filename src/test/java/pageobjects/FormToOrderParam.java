package pageobjects;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FormToOrderParam {
    private final String name;
    private final String familyName;
    private final String adreess;// напиши поля класса
    private final String phoneNumber;

    public FormToOrderParam(String name, String familyName, String adreess, String phoneNumber) {
        this.name = name;
        this.familyName = familyName;
        this.adreess = adreess;
        this.phoneNumber = phoneNumber;
    }
}
