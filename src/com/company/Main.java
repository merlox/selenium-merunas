package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Automate auto = new Automate();
        auto.play();
    }
}

class Automate {
    String[] tweets = {
            "Try to build the best product possible, then promote it. There are hacks that actually work if you pay attention and use your creativity.",
            "Skills + creativity + willpower = MASSIVE success",
            "Why pay employees when I can automate it myself with my coding skills?\nI always try to find a way to automate it by myself and then and only then I find talent to do the required job.\nSpecially when it comes to creative writing and similar stuff."
    };

    String username = "INPUT-YOUR-USERNAME-HERE";
    String userPassword = "INPUT-YOUR-PASSWORD-HERE";

    public void play() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\merun\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://twitter.com/explore");

        Thread.sleep(3000);
        WebElement userInput = driver.findElement(By.name("session[username_or_email]"));
        userInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.name("session[password]"));
        passwordInput.sendKeys(userPassword);

        WebElement loginButton = driver.findElement(By.cssSelector("[data-testid=LoginForm_Login_Button]"));
        loginButton.click();

        Thread.sleep(3000);

        for (int i = 0; i < this.tweets.length; i++) {
            WebElement tweetInput = driver.findElement(By.cssSelector(".public-DraftStyleDefault-block"));
            tweetInput.sendKeys(this.tweets[i]);
            Thread.sleep(500);
            WebElement tweetButton = driver.findElement(By.cssSelector("[data-testid=tweetButtonInline]"));
            tweetButton.click();
            Thread.sleep(1000);
            WebElement likeButton = driver.findElement(By.cssSelector("[data-testid=like]"));
            likeButton.click();
            Thread.sleep(2000);
        }
//        driver.close();
    }
}
