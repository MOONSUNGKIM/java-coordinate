package coordinatecalculator.view;

import coordinatecalculator.domain.Coordinate;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String POINT = "*";
    private static final String BLANK = "  ";
    private static final char STRAIGHT = '─';
    private static final char PILLAR = '|';

    public static void printScore(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }

    public static void printBoardLine(List<Coordinate> coordinates) {
        printYAxis(coordinates);
        System.out.println(makeViewLine());
        System.out.println(makeXAxis());
    }

    private static void printYAxis(List<Coordinate> coordinates) {
        for (int i = 24; i > 0; i--) {
            StringBuilder axis = new StringBuilder();
            axis.append(printNumber(i))
                    .append(PILLAR);

            makeBlank(axis);

            printCoordinate(coordinates, i, axis);
            System.out.println(axis.toString());
        }
    }

    private static String makeViewLine() {
        StringBuilder viewLine = new StringBuilder("  +");
        for (int i = 1; i < 24; i++) {
            viewLine.append(STRAIGHT)
                    .append(STRAIGHT);
        }
        viewLine.append(STRAIGHT);
        return viewLine.toString();
    }

    private static String makeXAxis() {
        StringBuilder XAxis = new StringBuilder();
        for (int i = 0; i <= 24; i++) {
            XAxis.append(printNumber(i));
        }
        return XAxis.toString();
    }

    private static String printNumber(int axis) {
        return (axis % 2 == 0) ? String.format("%2d", axis) : BLANK;
    }

    private static void printCoordinate(List<Coordinate> coordinates, int axisY, StringBuilder stringBuilder) {
        coordinates.stream()
                .filter(coordinate -> coordinate.getY() == axisY)
                .collect(Collectors.toList())
                .forEach(coordinate ->
                        stringBuilder.replace(coordinate.getX() * 2 + 1, coordinate.getX() * 2 + 1, POINT));
    }

    private static void makeBlank(StringBuilder stringBuilder) {
        for (int a = 0; a < 24; a++) {
            stringBuilder.append(BLANK);
        }
    }

}
