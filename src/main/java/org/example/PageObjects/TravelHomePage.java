package org.example.PageObjects;

import org.example.AbstractComponents.SearchFlightAvail;
import org.example.AbstractComponents.StrategyFactor;
import org.example.PageComponents.FooterNav;
import org.example.PageComponents.NavigationBar;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {

    By HeaderSection = By.className("search-buttons-heading");
    By FooterSection = By.id("traveller-home");
    WebDriver driver;

    SearchFlightAvail SearchFlightAvail;

    public TravelHomePage(WebDriver driver) {

        this.driver= driver;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        
        return new NavigationBar(driver, HeaderSection);
    }

    public FooterNav getFooterNav() {

        return new FooterNav(driver, FooterSection );
    }

    /*public void setBookingStrategy(SearchFlightAvail SearchFlightAvail)
    {
        this.SearchFlightAvail = SearchFlightAvail;
    }*/

    public void setBookingStrategy(String StrategyType)
    {
        StrategyFactor StrategyFactor = new StrategyFactor(driver);
        SearchFlightAvail =  StrategyFactor.CreateStrategy(StrategyType);
        this.SearchFlightAvail = SearchFlightAvail;
    }

    public void checkAvail(HashMap<String, String> ReservationDetails)
    {

        SearchFlightAvail.CheckAvail(ReservationDetails);
    }

    public String gettitle()
    {
        return driver.getTitle();
    }
}
