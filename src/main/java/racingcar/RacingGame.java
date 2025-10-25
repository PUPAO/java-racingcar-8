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
        int max = Integer.MIN_VALUE;
        StringBuilder winnerList = new StringBuilder();

        for (Car car : playerList) {
            max = Math.max(max, car.getDistance());
        }

        for (Car car : playerList) {
            if (max == car.getDistance()) {
                if (winnerList.isEmpty()) {
                    winnerList.append(car.getRacer());
                } else {
                    winnerList.append(", ").append(car.getRacer());
                }
            }
        }

        System.out.println("최종 우승자 : " + winnerList);
    }


    private static void forwardOrNot(Car racer) {
        int dice = Randoms.pickNumberInRange(0, 9);
        if (dice >= 4) {
            racer.goForward();
        }
    }

    private static Car[] createCars(String[] racerList) {
        Car[] racer = new Car[racerList.length];
        for (int i = 0; i < racerList.length; i++) {
            racer[i] = Car.of(racerList[i]);
        }
        return racer;
    }
}
