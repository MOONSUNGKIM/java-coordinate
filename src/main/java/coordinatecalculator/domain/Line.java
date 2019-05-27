package coordinatecalculator.domain;

import coordinatecalculator.visitor.Visitor;

import java.util.*;

public class Line implements Shape {
    public static final int VERTEX_OF_LINE = 2;
    private static final int FIRST_VERTEX = 0;
    private static final int SECOND_VERTEX = 1;

    private final List<Coordinate> coordinates;

    public Line(final List<Coordinate> coordinates) {
        isValidShape(coordinates);
        this.coordinates = coordinates;
    }

    public double getLineLength() {
        return coordinates.get(FIRST_VERTEX).calculateDistance(coordinates.get(SECOND_VERTEX));
    }

    @Override
    public String separateShapeByVisitor(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public List<Coordinate> getCoordinate() {
        return Collections.unmodifiableList(coordinates);
    }

    @Override
    public void isValidShape(List<Coordinate> coordinates) {
        Set<Coordinate> overlapCoordinate = new HashSet<>(coordinates);
        if (overlapCoordinate.size() != VERTEX_OF_LINE) {
            throw new IllegalArgumentException("위치가 같은 점(point)이 존재합니다. 두 점의 위치는 달라야 합니다.");
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
