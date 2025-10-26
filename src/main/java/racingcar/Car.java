package racingcar;

public class Car {

    private final String racer;
    private int distance;

    private Car(String racer) {
        this.racer = racer;
        this.distance = 0;
    }

    public static Car of(String racer) {
        // 빈 문자열 예외 처리
        return new Car(racer);
    }

    public int getDistance() {
        return distance;
    }

    public String getRacer() {
        return racer;
    }

    public void goForward() {
        distance++;
    }
}
