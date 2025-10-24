package racingcar;

public class RacingGame {
    private final InputDisplay inputDisplay = new InputDisplay();
    private final OutputDisplay outputDisplay = new OutputDisplay();

    public void run(){
        outputDisplay.askCarsName();
        String[] racerList = inputDisplay.getRacerList();

        outputDisplay.askRoundNumber();
        int round = inputDisplay.getRound();

        String[] winnerList = racerList;
        for(String i : winnerList)
            System.out.println("최종 우승자 : " + i);
    }
}
