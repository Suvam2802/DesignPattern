package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {

    WebDriver driver;
    By FlightsLink = By.cssSelector("[title='Flights']");
    By Links = By.tagName("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        // when we extend a class, we need to call the parent class constructor (Parent "AbstractComponents")
    }

    public void selectFlight() {

        findElement(FlightsLink).click();
    }

    public void GetFlightAttribute() {

        System.out.println(findElement(FlightsLink).getAttribute("class"));

    }

    public void getNumberOfLinks() {

        int links = findElements(Links).size();
        System.out.println("Number of links > Footer: " + links);

    }
}
