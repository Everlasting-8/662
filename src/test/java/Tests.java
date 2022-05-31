import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Tests {

    static {
        System.setProperty("webdriver.chrome.driver", "C:/Users/user123/Desktop/ITMO/Software testing/lab3/drivers/chromedriver.exe");
    }
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    {
        driver.manage().window().maximize();
    }
    
    /**
     * Login test
     */
    @Test
    public void testLogin() {
        driver.get("https://kinozal.tv/");
        // click on the register button
        wait.until(visibilityOfElementLocated(By.cssSelector("#header-authorization > div > div > svg"))).click();
        // find the login button and click on it
        driver.findElement(By.cssSelector("span[class='registration__footer-link'][role='button']")).click();

        // enter email and password -> click login
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[2]/div/input"))).sendKeys("sepeve6207@procowork.com");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[3]/div[2]/input"))).sendKeys("Bebra1488");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/button"))).click();
        String str0 = wait.until(visibilityOfElementLocated(By.cssSelector("div[class='MuiBox-root jss11 jss7']"))).getText();
        Assertions.assertEquals("No transactions yet", str0);
        driver.quit();
    }

    /**
     * Logout test
     */
    @Test
    public void testLogout() {
        driver.get("https://kinozal.tv/");
        // click on the register button
        wait.until(visibilityOfElementLocated(By.cssSelector("#header-authorization > div > div > svg"))).click();
        // find the login button and click on it
        driver.findElement(By.cssSelector("span[class='registration__footer-link'][role='button']")).click();

        // enter email and password -> click login
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[2]/div/input"))).sendKeys("sepeve6207@procowork.com");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[3]/div[2]/input"))).sendKeys("Bebra1488");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/button"))).click();

        wait.until(visibilityOfElementLocated(By.cssSelector("svg[width='17'][height='17']"))).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("span[class='authorization-menu__link'][role='button']"))).click();
        String str1 = wait.until(visibilityOfElementLocated(By.cssSelector("h1[class='main-screen-premium__title']"))).getText();
        Assertions.assertEquals("Любовь, смерть и роботы", str1);
        driver.quit();
    }

    /**
     * Support window test
     */
    @Test
    public void openGroup() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.cssSelector("svg[width='9'][height='7']"))).click();
        driver.quit();
    }

    /**
     * select coin Cardano test
     */
    @Test
    public void selectCinema() {
        driver.get("https://kinozal.tv");
        js.executeScript("document.getElementsByClassName('top-menu--language-tooltip top-menu-dropdown-list')[0].style.display='block';");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/div[1]/div[1]/ul/li[4]/a"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/div[2]/div[1]/div[1]/div/h1"))).getText();
        Assertions.assertEquals("О фильме: Михаил Жебрак приглашает", str);
        driver.quit();
    }

    /**
     * open list of exchanges
     */
    @Test
    public void openListOfFormula() {
        driver.get("https://kinozal.tv");
        js.executeScript("document.getElementsByClassName('top-menu--language-tooltip top-menu-dropdown-list')[0].style.display='block';");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/div[1]/div[1]/ul/li[13]/a"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/div/div/h1"))).getText();
        Assertions.assertEquals("Currencies available for exchange on ChangeNOW", str);
        driver.quit();
    }

    /**
     * select Russian language test
     */
    @Test
    public void selectRussianLanguage() {
        driver.get("https://kinozal.tv");
        js.executeScript("document.getElementById('language-list').style.display='block';");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/div[4]/div[1]/ul/li[6]/a"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/a[1]"))).getText();
        Assertions.assertEquals("Русский (AC3, 2 ch, 192 Кбит/с)", str);
        driver.quit();
    }

    /**
     * open list of languages
     */

    @Test
    public void openListOfLanguage() {
        driver.get("https://kinozal.tv");
        js.executeScript("document.getElementById('language-list').style.display='block';");
        String str = wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"language-list\"]/ul/li[6]/a"))).getText();
        Assertions.assertEquals("Русский", str);
        driver.quit();
    }

    /**
     * Open settings from login page
     */
    @Test
    public void openSettings() {
        driver.get("https://kinozal.tv/");
        // click on the register button
        wait.until(visibilityOfElementLocated(By.cssSelector("#header-authorization > div > div > svg"))).click();
        // find the login button and click on it
        driver.findElement(By.cssSelector("span[class='registration__footer-link'][role='button']")).click();

        // enter email and password -> click login
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[2]/div/input"))).sendKeys("sepeve6207@procowork.com");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[3]/div[2]/input"))).sendKeys("Bebra1488");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/button"))).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("svg[width='17'][height='17'][viewBox='0 0 17 17']"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/div[2]/ul/li[5]/a"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div/div/div[1]/div/div/div[1]"))).getText();
        Assertions.assertEquals("Русские, английские, украинские", str);
        driver.quit();
    }

    /**
     * Open benefits from login page
     */
    @Test
    public void openBenefits() {
        driver.get("https://kinozal.tv/");
        // click on the register button
        wait.until(visibilityOfElementLocated(By.cssSelector("#header-authorization > div > div > svg"))).click();
        // find the login button and click on it
        driver.findElement(By.cssSelector("span[class='registration__footer-link'][role='button']")).click();

        // enter email and password -> click login
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[2]/div/input"))).sendKeys("sepeve6207@procowork.com");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/div[3]/div[2]/input"))).sendKeys("Bebra1488");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div/div/div/div[2]/form/button"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div/div[3]/div/div/ul/li[3]/span"))).getText();
        Assertions.assertEquals("День рождения", str);
        driver.quit();
    }

    /**
     * Open blog and news page and then open some news
     */
    @Test
    public void openBlogAndNewsThenMarketAndNews() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/a[3]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div/div[2]/nav/ul/li[2]/a"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[2]/div/div[1]/article[1]/div/a[1]"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"app-blog\"]/div[2]/div[2]/div/h1"))).getText();
        Assertions.assertEquals("Переходящие кубки", str);
        driver.quit();
    }

    /**
     * Open news by search Test
     */
    @Test
    public void searchNews() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/a[3]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div/div[2]/div/input"))).sendKeys("BEP-2 NOW Token Available");
        wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"app-blog\"]/div[2]/div[1]/div/div[2]/div/button"))).click();
        String str = wait.until(visibilityOfElementLocated(By.cssSelector("p[class=blog-description-section__text]"))).getText();
        Assertions.assertEquals("Latest crypto-related news and long reads on blockchain tech, DeFi industry, crypto markets, and renowned coins.", str);
        driver.quit();
    }

    /**
     * Open AssertListing
     */
    @Test
    public void openAssertListing() {
        driver.get("https://kinozal.tv");
        js.executeScript("document.getElementsByClassName('top-menu--language-tooltip top-menu-dropdown-list')[1].style.display='block';");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/div[2]/div[1]/ul/li[2]/a"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/div[2]/div[1]/ul/li[1]/a"))).getText();
        Assertions.assertEquals("Crypto Loan", str);
        driver.quit();
    }

    /**
     * Open Recommendations
     */
    @Test
    public void openRecommendation() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[1]/div/div/a"))).click();
        driver.quit();
    }

    /**
     * Open Partners page
     */
    @Test
    public void openForPartners() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/a[1]"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/h1"))).getText();
        Assertions.assertEquals("Cryptocurrency Exchange, Processing and ", str);
        driver.quit();
    }

    /**
     * Open Monetization traffic from Partners page
     */
    @Test
    public void openMonetizationTraffic() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/a[1]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div/div[1]/div/div/a[3]"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/h1"))).getText();
        Assertions.assertEquals("Exchange Widget", str);
        driver.quit();
    }

    /**
     * Open  and see documentation
     */
    @Test
    public void openAndSeeDocumentation() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/a[1]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div/div[1]/div/div/a[4]"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div/div[3]/div/div/ul/li[1]/span"))).getText();
        Assertions.assertEquals("Access more than 200 crypto assets", str);
        driver.quit();
    }

    /**
     * openTransparency and check healthy
     */
    @Test
    public void openTransparency() {
        driver.get("https://kinozal.tv");
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/nav/a[1]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div/div[1]/div/div/a[4]"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div/div[3]/div/aside/div/div[2]/ul/li[5]/a"))).click();
        String str = wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div/h1"))).getText();
        Assertions.assertEquals("Статистика трекера", str);
        wait.until(visibilityOfElementLocated(By.xpath("/html/body/main/div/div[3]/div/div/div/a"))).click();
        driver.quit();
    }

    @Test
    public void exchangeCoin() throws InterruptedException {
        driver.get("https://kinozal.tv");
        Thread.sleep(10000);
        String equ = wait.until(visibilityOfElementLocated(By.xpath("//*[@id=\"exchange-form\"]/form/div/div[1]/button[1]/span"))).getText();
        Assertions.assertEquals("Темы форума", equ);
        driver.quit();
    }


}
