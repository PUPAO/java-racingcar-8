package racingcar;

public class OutputDisplay {

    void askCarsName() {
        System.out.println("Enter the name of the car you want to race. (Names are separated by commas)");
    }

    void askRoundNumber() {
        System.out.println("How many times can I try?");
    }

    void showRoundResult(Car[] playerList) {
        for (Car racer : playerList) {
            System.out.println(racer.getRacer() + " : " + "-".repeat(racer.getDistance()));
        }
    }

    void showWinner(StringBuilder winnerList) {
        System.out.println("Final Winner : " + winnerList);
    }
}
