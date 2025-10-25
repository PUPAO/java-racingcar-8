package racingcar;

public class OutputDisplay {

    void askCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    void askRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    void showRoundResult(Car[] playerList) {
        for (Car racer : playerList) {
            System.out.println(racer.getRacer() + " : " + "-".repeat(racer.getDistance()));
        }
    }

    void showWinner(StringBuilder winnerList){
        System.out.println("최종 우승자 : " + winnerList);
    }
}
