package com.company.automation.pages;

import com.company.automation.selenium.BasePage;
import com.company.automation.selenium.SeleniumActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchResultPage extends BasePage {

    @Autowired
    public SeleniumActions seleniumActions;

    @FindBy(xpath="//a[@class='a-link-normal s-no-outline']")
    public WebElement resultImg;

    public boolean checkSearchResult() {
        return seleniumActions.isElementVisible(resultImg);
   }
}
