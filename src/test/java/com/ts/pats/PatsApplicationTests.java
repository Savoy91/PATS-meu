package com.ts.pats;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PatsApplicationTests {

    WebDriver driver;
    String URL_PAGE = "http://localhost:8080/";
    String ChromeDriverPath = "C://driversWeb//chromedriver.exe";

    @BeforeMethod
    void setUp(){

        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
        try{
            if(driver == null) {
                driver = new ChromeDriver();
            }
        }catch(Exception ignored){
        }
        driver.get(URL_PAGE);
    }

    @Test
    void assertTittle() {
        String tituloPagina = "PATS";
        Assert.assertTrue(driver.getTitle().contains(tituloPagina),"Não foi possivel visualizar o titulo da página.");
    }
    @Test
    void checkPage() {
        WebElement logoPagina = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='banner']//img[2]")));
        Assert.assertTrue(logoPagina.isDisplayed(), "Não foi possível visualizar a página inicial.");
    }

    @AfterMethod
    void quit(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }

}
