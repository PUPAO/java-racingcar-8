package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final InputDisplay inputDisplay = new InputDisplay();
    private final OutputDisplay outputDisplay = new OutputDisplay();

    public void run() {
        outputDisplay.askCarsName();
        String[] racerList = inputDisplay.getRacerList();

        outputDisplay.askRoundNumber();
        int round = inputDisplay.getRound();

        Car[] playerList = createCars(racerList);

        // 경기 중
        while (round-- != 0) {

            for (Car racer : playerList) {
                forwardOrNot(racer);
            }
            outputDisplay.showRoundResult(playerList);
        }

        // 우승자 출력
        int bestRecord = findMaxRecord(playerList);
        StringBuilder winnerList = getWinnerList(playerList, bestRecord);
        outputDisplay.showWinner(winnerList);
    }


    private static Car[] createCars(String[] racerList) {
        Car[] racer = new Car[racerList.length];
        for (int i = 0; i < racerList.length; i++) {
            racer[i] = Car.of(racerList[i]);
        }
        return racer;
    }

    private static void forwardOrNot(Car racer) {
        int value = Randoms.pickNumberInRange(0, 9);
        if (value >= 4) {
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
