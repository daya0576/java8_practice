package capture2.predict.impl;

import capture2.Apple;
import capture2.predict.ApplePredict;

public class ColorApplePredict implements ApplePredict {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
