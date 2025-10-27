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
        int bestRecord = findMaxRecord(playerList);
        StringBuilder winnerList = getWinnerList(playerList, bestRecord);
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

    private static int findMaxRecord(Car[] playerList) {
        int max = Integer.MIN_VALUE;
        for (Car car : playerList) {
            max = Math.max(max, car.getDistance());
        }
        return max;
    }

    private static StringBuilder getWinnerList(Car[] playerList, int bestRecord) {
        StringBuilder winnerList = new StringBuilder();
        for (Car racer : playerList) {
            if (bestRecord != racer.getDistance()) {
                continue;
            }
            addWinnerList(racer, winnerList);
        }
        return winnerList;
    }

    private static void addWinnerList(Car racer, StringBuilder winnerList) {
        if (winnerList.isEmpty()) {
            winnerList.append(racer.getRacer());
        } else {
            winnerList.append(", ").append(racer.getRacer());
        }
    }
}
