import io.appium.java_client.AppiumBy;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CP05_GraphicsTest extends BaseTest {

    @Test
    public void verificarElRenderizadoDelPrimerDemo() throws InterruptedException {
        // 1. Tocar 'Graphics'
        driver.findElement(AppiumBy.accessibilityId("Graphics")).click();

        // 2. Tocar el primer elemento de la lista
        driver.findElement(AppiumBy.accessibilityId("AlphaBitmap")).click();

        // 3. Observar el renderizado durante unos segundos
        Thread.sleep(5000);

        // Verificar que la app sigue viva y respondiendo (sin caídas)
        boolean appSigueViva = driver.findElements(
                AppiumBy.className("android.widget.TextView")).size() > 0;

        assertTrue(appSigueViva);
    }
}