package playersguide.coloreditems;

import playersguide.ansicolors.AnsiColors;

public class ColoredItem<T> {
    private final T item;
    private final String color;

    public ColoredItem(T item, String color) {
        this.item = item;
        this.color = switch (color.toLowerCase()) {
            case "blue" -> AnsiColors.ANSI_BLUE;
            case "red" -> AnsiColors.ANSI_RED;
            case "green" -> AnsiColors.ANSI_GREEN;
            default -> AnsiColors.ANSI_WHITE;
        };
    }

    public void display() {
        System.out.print(color + item + AnsiColors.ANSI_RESET);
    }
}