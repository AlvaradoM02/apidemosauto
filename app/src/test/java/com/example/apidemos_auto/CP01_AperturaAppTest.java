import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class CP01_AperturaAppTest extends BaseTest {

    @Test
    public void verificarAperturaDeLaApp() {
        // Si la app no abre bien, el setUp() de BaseTest ya habría fallado antes de llegar acá
        assertNotNull(driver);
        assertNotNull(driver.getPageSource());
    }
}
