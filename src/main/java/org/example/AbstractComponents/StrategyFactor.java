package org.example.AbstractComponents;

import org.example.PageComponents.MultiTrips;
import org.example.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {

    WebDriver driver;
    By SectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver= driver;
    }

    public SearchFlightAvail CreateStrategy(String strategyType) {

        if (strategyType.equalsIgnoreCase("RoundTrip")) {
            return new RoundTrip(driver, SectionElement);
        }
        else if (strategyType.equalsIgnoreCase("MultiTrips")) {
            return new MultiTrips(driver, SectionElement);
        }
        return null;
    }

}
