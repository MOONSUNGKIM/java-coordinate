package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void 선의_길이를_제대로_구하는지_테스트() {
        /* Given */
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(2, 20), new Coordinate(20, 20));

        /* Then */
        assertThat(new Line(coordinates).getLineLength()).isEqualTo(18, offset(0.00099));
    }

    @Test
    void 선이_아니라고_판단하는지_테스트() {
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(2, 20), new Coordinate(2, 20));
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(coordinates);
        });
    }
}