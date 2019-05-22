package coordinatecalculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Line implements Shape {
    private static final int VERTEX_OF_LINE = 2;

    private final List<Coordinate> coordinates;

    public Line(final List<Coordinate> coordinates) {
        isValidShape(coordinates);
        this.coordinates = coordinates;
    }

    public double getLineLength() {
        return coordinates.get(0).calculate(coordinates.get(1));
    }

    @Override
    public double getScore() {
        return getLineLength();
    }

    @Override
    public void isValidShape(List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_LINE) {
            throw new IllegalArgumentException("선이 될 수 없어요");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Line line = (Line) o;
        return Objects.equals(coordinates, line.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}