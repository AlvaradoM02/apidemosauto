import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CP01_AperturaAppTest.class,
        CP02_AccessibilityTest.class,
        CP03_AnimationTest.class,
        CP04_AlarmControllerTest.class,
        CP05_GraphicsTest.class
})
public class SuiteApiDemos {
}