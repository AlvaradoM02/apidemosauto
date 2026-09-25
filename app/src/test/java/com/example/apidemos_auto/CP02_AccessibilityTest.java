import io.appium.java_client.AppiumBy;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CP02_AccessibilityTest extends BaseTest {

    @Test
    public void abrirPrimerDemoDeAccessibility() {
        // 1. Tocar 'Accessibility'
        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();

        // 2. Verificar que navegó a la pantalla del demo (sin cerrarse ni error)
        boolean hayContenido = driver.findElements(
                AppiumBy.className("android.widget.TextView")).size() > 0;

        assertTrue(hayContenido);
    }
}
