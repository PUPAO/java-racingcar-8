package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputDisplay {

    String[] getRacerList() {
        String[] racerList = Console.readLine().split(",");
        return racerList;
    }

    public int getRound() {
        int count = Integer.parseInt(Console.readLine());
        return count;
    }
}
