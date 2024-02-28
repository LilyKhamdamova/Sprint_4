package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuestionsAndAnswers {
    private WebDriver driver;

    public QuestionsAndAnswers(WebDriver driver) {
        this.driver = driver;
    }

    private By theMainQuestions = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]");
    private By openListToDown = By.className("accordion__item");
    private By question = By.className("accordion__heading");
    private By answer = By.className("accordion__panel");

    public void scrollToQuestions() {
        WebElement element = driver.findElement(theMainQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public String findTheQuestion(int id) {
        List<WebElement> elements = driver.findElements(openListToDown);
        elements.get(id).click();
        List<WebElement> questionList = driver.findElements(question);
        return questionList.get(id).getText();
    }

    public void checkQuestionText(String expectedQuestionText, String actualQuestionText) {
        assertEquals("Не верный текст вопроса", expectedQuestionText, actualQuestionText);

    }
    // метод находит ответ
    public String findTheAnswer(int id) {
            List<WebElement> elements = driver.findElements(openListToDown);
            elements.get(id).click();
            List<WebElement> answersList = driver.findElements(answer);
            return answersList.get(id).getText();
        }

    // метод проверяет текст ответа
    public void checkAnswerText(String expectedAnswerText, String actualAnswerText) {
        assertEquals("Не верный текст ответа", expectedAnswerText, actualAnswerText);
    }


}