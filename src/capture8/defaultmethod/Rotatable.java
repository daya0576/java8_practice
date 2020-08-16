package capture8.defaultmethod;

public interface Rotatable {
    int getRotationAngle();

    void setRotationAngle(int angleInDegrees);

    default void rotateBy(int angle) {
        setRotationAngle((getRotationAngle() + angle) % 360);
    }
}
