package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputDisplay {

    Car[] getRacerList() {
        String input = Console.readLine().trim();

        if (input.isEmpty()) {
            throw new racingException("You must enter at least one name.");
        }

        String[] racerList = input.split("[,]+");

        validateDuplicate(racerList);

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

    private void validateDuplicate(String[] names) {
        Set<String> unique = new HashSet<>();
        for (String name : names) {
            if (!unique.add(name)) {
                throw new racingException("Duplicate racer name: " + name);
            }
        }
    }

}