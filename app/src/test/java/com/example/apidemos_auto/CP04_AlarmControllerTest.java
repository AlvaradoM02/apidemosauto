import io.appium.java_client.AppiumBy;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CP04_AlarmControllerTest extends BaseTest {

    @Test
    public void programarUnaAlarmaDePrueba() throws InterruptedException {
        // 1. Tocar 'App'
        driver.findElement(AppiumBy.accessibilityId("App")).click();

        // 2. Tocar 'Alarm'
        driver.findElement(AppiumBy.accessibilityId("Alarm")).click();

        // 3. Tocar 'Alarm Controller'
        driver.findElement(AppiumBy.accessibilityId("Alarm Controller")).click();

        // 4. Presionar el botón para programar una alarma de una sola vez
        driver.findElement(AppiumBy.accessibilityId("One Shot Alarm")).click();

        // Verificar que no hubo errores y la app sigue respondiendo
        boolean appSigueViva = driver.findElements(
                AppiumBy.className("android.widget.TextView")).size() > 0;

        assertTrue(appSigueViva);

        // Pausa de 40 segundos al final
        Thread.sleep(40000);
    }
}