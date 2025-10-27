package racingcar;

public class Car {

    private final String racer;
    private int distance;

    private static final int limitNameLength = 5;

    private Car(String racer) {
        this.racer = racer;
        this.distance = 0;
    }

    public static Car of(String racerName) {

        if (racerName.length() > limitNameLength) {
            throw new racingException("이름이 너무 길어요. " + limitNameLength + "글자를 넘지 않게 주의하세요.");
        } else if (racerName.isEmpty()) {
            throw new racingException("이름이 없어요. 이름을 생성해주세요");
        }

        return new Car(racerName);
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
