package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar extends AbstractComponent {

    By FlightsLink = By.cssSelector("[title='Flights']");
    By Links = By.tagName("a");

    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void GetFlightAttribute() {

        System.out.println(findElement(FlightsLink).getAttribute("class"));

    }

    public void getNumberOfLinks() {

        int links = findElements(Links).size();
        System.out.println("Number of links > TopNav: " + links);

    }

}
