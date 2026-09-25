import io.appium.java_client.AppiumBy;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CP03_AnimationTest extends BaseTest {

    @Test
    public void verificarQueLaAnimacionSeReproduce() throws InterruptedException {
        // 1. Tocar 'Animation'
        driver.findElement(AppiumBy.accessibilityId("Animation")).click();

        // 2. Entrar a 'Cloning'
        driver.findElement(AppiumBy.accessibilityId("Cloning")).click();

        // 3. Tocar 'Run'
        driver.findElement(AppiumBy.accessibilityId("Run")).click();

        // 4. Observar la demo durante unos 10 segundos
        Thread.sleep(10000);

        // Verificar que la app sigue viva y respondiendo (no se cerró ni trabó)
        boolean appSigueViva = driver.findElements(
                AppiumBy.className("android.widget.TextView")).size() > 0;

        assertTrue(appSigueViva);
    }
}