package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputDisplay {

    String getRacerList() {
        String roster = Console.readLine().trim();

        if (roster.isEmpty()) {
            throw new racingException("You must enter at least one name.");
        }
        return roster;
    }

    public String getYesOrNo() {
        return Console.readLine().trim().toLowerCase();
    }

    public String getDelimiter() {
        return Console.readLine().trim();
    }

    public Round getRound() {
        String input = Console.readLine();
        return Round.of(input);
    }

}