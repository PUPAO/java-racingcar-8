package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputDisplay {

    Car[] getRacerList() {
        String input = Console.readLine().trim();

        if (input.isEmpty()) {
            throw new racingException("You must enter at least one name.");
        }

        String[] racerList = input.split("[,]+");

        return createCars(racerList);
    }

    private Car[] createCars(String[] racerList) {
        Car[] racer = new Car[racerList.length];
        for (int i = 0; i < racerList.length; i++) {
            racer[i] = Car.of(racerList[i]);
        }
        return racer;
    }

    public Round getRound() {
        String input = Console.readLine();
        return Round.of(input);
    }

}