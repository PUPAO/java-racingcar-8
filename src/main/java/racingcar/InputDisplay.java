package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputDisplay {

    Car[] getRacerList() {
        String[] racerList = Console.readLine().split(",");
        return createCars(racerList);
    }

    private Car[] createCars(String[] racerList) {
        Car[] racer = new Car[racerList.length];
        for (int i = 0; i < racerList.length; i++) {
            racer[i] = Car.of(racerList[i]);
        }
        return racer;
    }


    public int getRound() {
        int count;

        try {
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new racingException("숫자만 입력하세요.");
        }

        positiveNumber(count);

        return count;
    }

    private static void positiveNumber(int count) {
        if (count <= 0) {
            throw new racingException("양수만 입력하세요.");
        }
    }

}