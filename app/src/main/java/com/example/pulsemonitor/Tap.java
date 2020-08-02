package com.example.pulsemonitor;

import java.util.Date;

/**
 * Нажатие на кнопку
 */
public class Tap {
    /** Дата нажатия */
    private Date clickDate;

    /** Миллисекунда нажатия */
    private Long clickTimeMills;

    /**
     * Нажатие на кнопку
     */
    public Tap() {
        clickDate = new Date();
        clickTimeMills = clickDate.getTime();
    }

    /**
     * Получить миллисекунду нажатия
     * @return миллисекунда нажатия
     */
    public Long getClickTimeMills() {
        return clickTimeMills;
    }
}
