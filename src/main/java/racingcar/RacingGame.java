package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final InputDisplay inputDisplay = new InputDisplay();
    private final OutputDisplay outputDisplay = new OutputDisplay();

    public void run(){
        outputDisplay.askCarsName();
        String[] racerList = inputDisplay.getRacerList();

        outputDisplay.askRoundNumber();
        int round = inputDisplay.getRound();

        int[] distance = new int[racerList.length];

        // 경기 중
        while (round-- != 0) {
            // 주사위
            for (int i = 0; i < racerList.length; i++) {
                int dice = Randoms.pickNumberInRange(0, 9);
                if (dice >= 4) {
                    distance[i]++;
                }
            }
            // 경기 중 출력
            for (int i = 0; i < racerList.length; i++) {
                String dist = "";
                if (distance[i] != 0) {
                    dist = "-".repeat(distance[i]);
                }

                System.out.println(racerList[i] + " : " + dist);
            }
        }
        String[] winnerList = racerList;
        for(String i : winnerList)
            System.out.println("최종 우승자 : " + i);
    }
}
