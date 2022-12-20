package com.company.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SearchResultPage extends BasePage {

    @FindBy(xpath="//a[@class='a-link-normal s-no-outlineX']")
    public WebElement resultImg;

    public boolean checkSearchResult() {
        return resultImg.isDisplayed();
   }
}
