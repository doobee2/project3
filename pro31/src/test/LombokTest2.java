import kr.co.teaspoon.dto.Sample;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LombokTest2 {
    private static final Logger log = LoggerFactory.getLogger("LombokTest.class");
    @BeforeClass
    public static void testStart() {
        System.out.println("전체 테스트 시작!");
    }
    @AfterClass
    public static void testFinish() {
        System.out.println("테스트 클래스 종료 - 위치 상관없음");
    }
    @Before
    public void testBeforePrint() {
        System.out.println("junit 테스트 시작");
    }
    @Test
    public void testLombok(){
            Sample dto = new Sample();
            dto.setNo(1);
            dto.setName("일슬비");
            log.info(dto.toString());
            System.out.println(dto.toString());
        }
    @Test
    public void testLombok2(){
        Sample dto = new Sample();
        dto.setNo(2);
        dto.setName("이슬비");
        log.info(dto.toString());
        System.out.println(dto.toString());
    }
    @After
    public void testAfterPrint() {
        System.out.println("junit 테스트 종료");
    }
}
