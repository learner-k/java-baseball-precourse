package baseball;

import static baseball.Constants.NUMBERS_LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumberBaseballGame {
    private NumberBaseballGame() {
    }

    public static void start() {
        boolean play = true;
        while (play) {
            runGameLoop();
            printWinMessage();
            play = askForNewGame();
        }
    }

    private static void runGameLoop() {
        final Numbers defenseNumbers = RandomNumbersGenerator.generate();
        boolean win = false;
        while (!win) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            Numbers attackNumbers = new Numbers(input);
            Judgement attackResult = Referee.judge(attackNumbers, defenseNumbers);
            System.out.println(attackResult);
            win = checkToAttackerWins(attackResult);
        }
    }

    private static void printWinMessage() {
        String message = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", NUMBERS_LENGTH);
        System.out.println(message);
    }

    private static boolean checkToAttackerWins(final Judgement attackResult) {
        return attackResult.getStrike() == NUMBERS_LENGTH;
    }

    private static boolean askForNewGame() {
        printAskForNewGame();
        int input = readUserInput();
        if (input == 1) {
            return true;
        }
        if (input == 2) {
            return false;
        }
        throw new IllegalArgumentException("input number must be 1 or 2.");
    }

    private static void printAskForNewGame() {
        String askMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(askMessage);
    }

    private static int readUserInput() {
        String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
