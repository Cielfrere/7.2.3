import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }

    @Test
    public void wildberriesScript() {
        open("https://www.wildberries.ru/");

        SelenideElement searchField = $("#searchInput");
        searchField.shouldBe(Condition.visible).setValue("Pencil").pressEnter();

        SelenideElement firstProduct = $$(".product-card-list article").first();
        firstProduct.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();

        SelenideElement addToCartButton = $$(".product-page__order-buttons .order__button.btn-main").first();
        addToCartButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();

        SelenideElement cartLink = $("a[data-wba-header-name='Cart']");
        cartLink.shouldBe(Condition.visible).click();

        SelenideElement addedItem = $(".list-item__good");
        addedItem.shouldBe(Condition.visible);
    }
}