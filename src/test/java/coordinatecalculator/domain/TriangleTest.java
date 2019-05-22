package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void 삼각형이_아니라고_판단() {
        List<Coordinate> coordinate = Arrays.asList(new Coordinate(0, 2),
                new Coordinate(0, 6), new Coordinate(0, 24));
        List<Coordinate> coordinate2 = Arrays.asList(new Coordinate(24, 0),
                new Coordinate(24, 10), new Coordinate(24, 23));

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(coordinate);
            new Triangle(coordinate2);
        });
    }

    @Test
    void 삼각형의_넓이를_제대로_구하는지_테스트() {
        /* Given */
        List<Coordinate> coordinate = Arrays.asList(new Coordinate(1, 1),
                new Coordinate(5, 1), new Coordinate(1, 5));
        /* Then */
        assertThat(new Triangle(coordinate).area()).isEqualTo(8, offset(0.00099));
    }
}