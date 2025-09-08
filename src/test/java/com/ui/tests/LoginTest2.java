package com.ui.tests;

import com.ui.pages.HomePage;
import static com.constants.Browsers.*;

public class LoginTest2 {

    public static void main(String[] args) {
        HomePage homePage=new HomePage(CHROME);
        String userName=homePage.goToLoginPage().doLoginWith("moseleg148@certve.com","Password").getUsername();
        System.out.println(userName);
    }
}
