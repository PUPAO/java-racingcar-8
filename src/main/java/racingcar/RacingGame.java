package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final InputDisplay inputDisplay = new InputDisplay();
    private final OutputDisplay outputDisplay = new OutputDisplay();
    private static final int forwardThreshold = 4;
    private static final int minimumNumber = 0;
    private static final int maximumNumber = 9;

    public void run() {
        outputDisplay.askCarsName();
        Car[] playerList = inputDisplay.getRacerList();

        outputDisplay.askRoundNumber();
        int round = inputDisplay.getRound();

        // 경기 중
        playing(round, playerList);

        // 우승자 출력
        int bestRecord = findMaxRecord(playerList);
        StringBuilder winnerList = getWinnerList(playerList, bestRecord);
        outputDisplay.showWinner(winnerList);
    }

    private void playing(int round, Car[] playerList) {
        while (round-- != 0) {

            for (Car racer : playerList) {
                forwardOrNot(racer);
            }
            outputDisplay.showRoundResult(playerList);
        }
    }

    private static void forwardOrNot(Car racer) {
        int value = Randoms.pickNumberInRange(minimumNumber, maximumNumber);
        if (value >= forwardThreshold) {
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
