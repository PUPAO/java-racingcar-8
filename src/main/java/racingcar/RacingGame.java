package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final InputDisplay inputDisplay = new InputDisplay();
    private final OutputDisplay outputDisplay = new OutputDisplay();
    private static final int FORWARD_THRESHOLD = 4;
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    public void run() {
        outputDisplay.askCarsName();
        Car[] playerList = inputDisplay.getRacerList();

        outputDisplay.askRoundNumber();
        Round round = inputDisplay.getRound();

        // 경기 중
        playing(round, playerList);

        // 우승자 출력
        Winner winner = new Winner();
        StringBuilder winnerList = winner.calculateWinners(playerList);
        outputDisplay.showWinner(winnerList);
    }

    private void playing(Round round, Car[] playerList) {
        for(int i = 0 ; i < round.getRound(); i++) {
            for (Car racer : playerList) {
                forwardOrNot(racer);
            }
            outputDisplay.showRoundResult(playerList);
        }
    }

    private static void forwardOrNot(Car racer) {
        int value = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        if (value >= FORWARD_THRESHOLD) {
            racer.goForward();
        }
    }
}
