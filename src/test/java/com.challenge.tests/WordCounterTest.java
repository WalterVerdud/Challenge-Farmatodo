package com.challenge.tests;

import com.challenge.pages.WordCounterPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest extends BaseTest {

    @Test
    public void validateWordCount() {

        WordCounterPage page = new WordCounterPage(driver);

        page.openPage();
        page.writeText("hola mundo");
        System.out.println("TEXTAREA = " + page.getTextAreaContent());

        System.out.println("COUNTER = " + page.getCounterText());
        Assertions.assertEquals(2, page.getWordCount());
    }

    @Test
    public void validateCharacterCount() {

        WordCounterPage page = new WordCounterPage(driver);

        page.openPage();

        page.writeText("hola mundo");

        System.out.println(page.getCounterText());

        Assertions.assertEquals(10, page.getCharacterCount());
    }

    @Test
    public void validateTopThreeKeywords() {

        WordCounterPage page = new WordCounterPage(driver);
        page.openPage();
        page.writeText("java java java selenium selenium test");

        Assertions.assertEquals("java", page.getKeyword(1));

        Assertions.assertEquals(3, page.getKeywordCount(1));

        Assertions.assertEquals("selenium", page.getKeyword(2));

        Assertions.assertEquals(2, page.getKeywordCount(2));

        Assertions.assertEquals("test", page.getKeyword(3));

        Assertions.assertEquals(1, page.getKeywordCount(3));
    }

    @Test
    public void validateEmptyText() {

        WordCounterPage page = new WordCounterPage(driver);
        page.openPage();
        page.writeText("");
        Assertions.assertEquals(0, page.getWordCount());
    }
}