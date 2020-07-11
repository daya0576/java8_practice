package capture2.predict.impl;

import capture2.Apple;
import capture2.predict.ApplePredict;

public class HeavyApplePredict implements ApplePredict {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 1;
    }
}
