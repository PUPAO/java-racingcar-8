package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String namesInput = Console.readLine();
        String countInput = Console.readLine();
        String winnerList = namesInput;
        System.out.println("최종 우승자 : " + winnerList);
    }
}
