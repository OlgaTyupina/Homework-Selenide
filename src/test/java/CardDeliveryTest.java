import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {
    @Test
    void shouldFormSubmission() {
        open("http://localhost:9999");
        SelenideElement form = $ ("form.form");
        //$$(".tab-item").find(exactText("По номеру счёта")).click();
        form.$("[data-test-id=city] input").setValue("Москва");
        form.$("[data-test-id=date] input").setValue("20.12.2019");
        form.$("[data-test-id=name] input").setValue("Иван Иванов");
        form.$("[data-test-id=phone] input").setValue("+79108747630");
        form.$("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id=notification]").waitUntil(visible, 15000);

    }


}
