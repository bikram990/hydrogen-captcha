package com.hyd.captcha;

import java.awt.Color;
import java.security.SecureRandom;
import java.util.Random;

public class DefaultCharPropertyFactory implements CharPropertyFactory {

    private static final Random RANDOM = new SecureRandom();

    private static double random(double min, double max) {
        return RANDOM.nextDouble() * (max - min) + min;
    }

    private static int random(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    @Override
    public CharProperty getCharProperty(char ch) {
        CharProperty charProperty = new CharProperty();
        charProperty.setFillPaint(null);
        charProperty.setStrikePaint(new Color(random(0, 255), random(0, 255), random(0, 255)));
        charProperty.setFillPaint(new Color(random(0, 150), random(0, 150), random(0, 150)));
        charProperty.setRotate(random(-Math.PI / 6, Math.PI / 6));
        charProperty.setShear(new double[]{0, random(-0.25, 0.25)});
        charProperty.setFont(FontRepository.pickRandomFont());
        return charProperty;
    }
}
