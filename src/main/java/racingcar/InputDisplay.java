package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputDisplay {

    int limitNameLength = 5;

    String[] getRacerList() {
        String[] racerList = Console.readLine().split(",");
        validNamesLength(racerList);
        return racerList;
    }

    private void validNamesLength(String[] racerList) {
        for(String str : racerList){
            if(str.length() > limitNameLength)
                throw new racingException("이름이 너무 길어요. "+limitNameLength+"글자를 넘지 않게 주의하세요.");
        }
    }

    public int getRound() {
        int count = Integer.parseInt(Console.readLine());
        return count;
    }
}
