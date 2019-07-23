package ru.eltex;

public enum WorkDay {
    MONDAY ("Понедельник"),
    TUESDAY ("Вторник"),
    WEDNESDAY ("Среда"),
    THURSDAY ("Четверг"),
    FRIDAY ("Пятница"),
    SATURDAY ("Суббота"),
    SUNDAY ("Воскресенье");

    private String title;

    WorkDay(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}