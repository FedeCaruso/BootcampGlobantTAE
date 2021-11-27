package com.companyname.pages;

import com.companyname.core.MobileOperations;
import com.companyname.core.LocalDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MobileLoginPage extends MobileOperations {
    @AndroidFindBy(id="com.example.sample_login:id/username")
    MobileElement userName;
    @AndroidFindBy(id="com.example.sample_login:id/password")
    MobileElement password;
    @AndroidFindBy(id="com.example.sample_login:id/login")
    MobileElement signInRegister;
    @AndroidFindBy(xpath="/hierarchy/android.widget.Toast")
    MobileElement toast;

    public MobileLoginPage() {
        // Initialize elements using page factory
        PageFactory.initElements(new AppiumFieldDecorator(LocalDriverManager.getInstance().getDriver()), this);
    }

    public MobileLoginPage enterCredentials(String user, String pass) {
        type(userName, user);
        type(password, pass);
        tapByElement(signInRegister);
        return this;
    }

    public String getToastMessage() {
        return toast.getText();
    }
}