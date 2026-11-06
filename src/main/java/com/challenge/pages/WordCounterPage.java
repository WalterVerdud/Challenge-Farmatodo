package com.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WordCounterPage {

    private final WebDriver driver;

    public WordCounterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By textArea = By.id("box");

    private final By topCounter =
            By.cssSelector("#top_counter span.counted");

    public void openPage() {

        driver.get("https://wordcounter.net/");
    }

    public void writeText(String text) {

        WebElement editor =
                driver.findElement(textArea);

        editor.click();

        editor.sendKeys(text);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTextAreaContent() {

        return driver.findElement(textArea)
                .getAttribute("value");
    }

    private void waitForCalculation() {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        wait.until(d ->
                d.findElement(topCounter)
                        .getText()
                        .contains("words")
        );
    }

    public String getCounterText() {

        return driver.findElement(topCounter)
                .getText();
    }

    public int getWordCount() {

        String text = getCounterText();

        String[] parts = text.split(" ");

        return Integer.parseInt(parts[0]);
    }

    public int getCharacterCount() {

        String text = getCounterText();

        String[] parts = text.split(" ");

        return Integer.parseInt(parts[2]);
    }

    public String getKeyword(int position) {

        List<WebElement> words =
                driver.findElements(
                        By.cssSelector(
                                "#kwd-accordion span.word"
                        )
                );

        return words.get(position - 1)
                .getText()
                .trim();
    }

    public int getKeywordCount(int position) {

        List<WebElement> counts =
                driver.findElements(
                        By.cssSelector(
                                "#kwd-accordion span.badge"
                        )
                );

        String text =
                counts.get(position - 1)
                        .getText();

        return Integer.parseInt(
                text.split(" ")[0]
        );
    }
}