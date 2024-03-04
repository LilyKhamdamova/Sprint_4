import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static pageobjects.FormToOrder.SCOOTER_PRAKTIKUM_SERVICES_RU;
import org.openqa.selenium.WebDriver;
import pageobjects.QuestionsAndAnswers;


@RunWith(Parameterized.class)
public class QuestionsAndAnswersTest extends BeforeAfterAnnotations {
    private WebDriver driver;
    private String expectedDropdownQuestion;
    private String expectedDropdownAnswer;
    private int id; // Added id variable
    public QuestionsAndAnswersTest (String expectedDropdownQuestion, String expectedDropdownAnswer, int id) {
        this.expectedDropdownQuestion = expectedDropdownQuestion;
        this.expectedDropdownAnswer = expectedDropdownAnswer;
        this.id = id; // Initialized id
    }

    @Parameterized.Parameters
    public static Object[][] checkTheDrop() {
        return new Object[][] {
                { "Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                { "Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                { "Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",5},
                {"Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области.",7}
        };

    }

    @Override
    public void setUp() {
        driver = new ChromeDriver();
        long time = 10;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void tearDown() {
        driver.quit();
    }


    @Test
    public void dropdownTest() {
        driver.get(SCOOTER_PRAKTIKUM_SERVICES_RU);
        QuestionsAndAnswers objQuestionsAndAnswers = new QuestionsAndAnswers(driver);
        objQuestionsAndAnswers.scrollToQuestions();
        String actualQuestionText = objQuestionsAndAnswers.findTheQuestion(id);
        String actualAnswerText = objQuestionsAndAnswers.findTheAnswer(id);
        objQuestionsAndAnswers.checkQuestionText(expectedDropdownQuestion, actualQuestionText);
        System.out.println("ОР " + expectedDropdownQuestion + " ФР " + actualQuestionText);
        objQuestionsAndAnswers.checkAnswerText(expectedDropdownAnswer, actualAnswerText);
        System.out.println("ОР " + expectedDropdownAnswer + " ФР " + actualAnswerText);
    }
}
