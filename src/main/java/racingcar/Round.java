package racingcar;

public class Round {

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round of(String round){
        int roundNumber = validNumber(round);
        validPositiveNumber(roundNumber);

        return new Round(roundNumber);
    }

    private static int validNumber(String round) {
        int roundNumber;
        try {
            roundNumber = Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new racingException("숫자만 입력하세요.");
        }
        return roundNumber;
    }

    private static void validPositiveNumber(int count) {
        if (count <= 0) {
            throw new racingException("양수만 입력하세요.");
        }
    }

    public int getRound() {
        return round;
    }
}
