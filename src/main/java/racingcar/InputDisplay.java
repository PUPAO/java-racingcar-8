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
        for (String str : racerList) {
            if (str.length() > limitNameLength) {
                throw new racingException("이름이 너무 길어요. " + limitNameLength + "글자를 넘지 않게 주의하세요.");
            } else if (str.isEmpty()) {
                throw new racingException("이름이 없어요. 이름을 생성해주세요");
            }
        }
    }

    public int getRound() {
        int count;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new racingException("숫자만 입력하세요.");
        }

        positiveNumber(count);

        return count;
    }

    private static void positiveNumber(int count) {
        if (count <= 0) {
            throw new racingException("양수만 입력하세요.");
        }
    }

}