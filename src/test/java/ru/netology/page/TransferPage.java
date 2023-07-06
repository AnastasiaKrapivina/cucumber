package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

   private SelenideElement transferHead = $(byText("Пополнение карты"));
    private SelenideElement transferAmount = $("[data-test-id='amount'] input");
    private SelenideElement transferFrom = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public TransferPage() {

        transferHead.shouldBe(visible, Duration.ofSeconds(15));
    }
    public DashboardPage validTransfer(String amount) {
        transferAmount.setValue(amount);
        transferFrom.setValue(DataHelper.getSecondCardInfo().getNumber());
        transferButton.click();
        return new DashboardPage();
    }
}
