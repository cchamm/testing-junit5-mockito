package guru.springframework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

public class AnnotationMocksTest {
@BeforeEach
void setUp() {
    MockitoAnnotations.initMocks(this);
}
    @Mock
    Map<String, Object> mapMock;


    @Test
    void testMock() {
        mapMock.put("keyvalue", "foo");
    }
}
