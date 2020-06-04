package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    private int maxStation = 11;
    private int minStation = 0;
    private int minVolume = 0;
    private int maxVolume = 100;

    @Test
    void shouldSetCurrentVolume() {
        int expected = 60;
        Radio radio = new Radio();
        // Установить значение громкости
        radio.setCurrentVolume(expected);
        // Проверить, что текущая громкость соответствует ожидаемой
        assertEquals(expected, radio.getCurrentVolume());
    }

    @Test
    void shouldInvalidMaxSetCurrentVolume() {
        int expected = 10;
        Radio radio = new Radio(1, expected, maxStation, minStation, minVolume, maxVolume);
        // Установить значение громкости больше максимальной
        radio.setCurrentVolume(101);
        // Проверить, что текущая громкость не изменилась
        assertEquals(expected, radio.getCurrentVolume());
    }

    @Test
    void shouldInvalidMinSetCurrentVolume() {
        int expected = 10;
        Radio radio = new Radio(1, expected, maxStation, minStation, minVolume, maxVolume);
        // Установить значение громкости больше максимальной
        radio.setCurrentVolume(-1);
        // Проверить, что текущая громкость не изменилась
        assertEquals(expected, radio.getCurrentVolume());
    }

    @Test
    void shouldIncreaseCurrentVolume() {
        Radio radio = new Radio(1, 99, maxStation, minStation, minVolume, maxVolume);
        // Нажимать кнопку увеличения громкости 2 раза
        radio.increaseCurrentVolume();
        radio.increaseCurrentVolume();
        // Проверить, что громкость равна максимально возможной
        assertEquals(radio.getMaxVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseCurrentVolume() {
        Radio radio = new Radio(1, 1, maxStation, minStation, minVolume, maxVolume);
        // Нажимать кнопку уменьшения громкости 2 раза
        radio.decreaseCurrentVolume();
        radio.decreaseCurrentVolume();
        // Проверить, что громкость равна минимально возможной
        assertEquals(radio.getMinVolume(), radio.getCurrentVolume());
    }

    @Test
    void shouldSetCurrentStation() {
        Radio radio = new Radio();
        int expected = 5;
        // Установить станцию 5
        radio.setCurrentStation(expected);
        // Проверить, что станция 5 теперь текущая
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldInvalidMinSetCurrentStation() {
        int expected = 5;
        Radio radio = new Radio(expected, 50, maxStation, minStation, minVolume, maxVolume);
        // Установить станцию меньше минимальной
        radio.setCurrentStation(-1);
        // Проверить, что текущая станция не изменилась
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldInvalidMaxSetCurrentStation() {
        int expected = 5;
        Radio radio = new Radio(expected, 50, maxStation, minStation, minVolume, maxVolume);
        // Установить станцию больше максимальной
        radio.setCurrentStation(12);
        // Проверить, что текущая станция не изменилась
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldNextRadioStation() {
        Radio radio = new Radio(10, 50, maxStation, minStation, minVolume, maxVolume);
        // Нажать 2 раза next
        radio.nextStation();
        radio.nextStation();
        // Ожидаемый результат
        int expected = 0;
        // Проверить, что станция 0 теперь текущая
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    void shouldPrevRadioStation() {
        Radio radio = new Radio(1, 50, maxStation, minStation, minVolume, maxVolume);
        // Нажать 2 раза prev
        radio.prevStation();
        radio.prevStation();
        // Ожидаемый результат
        int expected = 11;
        // Проверить, что станция 9 теперь текущая
        assertEquals(expected, radio.getCurrentStation());
    }
}