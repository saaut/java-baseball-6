package baseball.View;

import baseball.Controller.CheckNumberController;
import baseball.Controller.NumberController;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    static final int NUMOFEND = 2;
    static final int NUMOFRESTART = 1;
    NumberController numbers=new NumberController();

    CheckNumberController checkNumbers= new CheckNumberController();

    Integer[] userNumbers={};
    Integer[] randomNumbers={};
    public void run(){
        //게임 전체 루프
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            randomNumbers=numbers.createRandomNumber();

            do {
                readUserNumber();
            }while(!checkUserNumber());
            if(isEnd()) return;

        }
    }
    public void readUserNumber(){

        System.out.println("숫자를 입력해주세요 :");
        String userSay = readLine();
        userNumbers=numbers.getUserNumber(userSay);

    }
    public boolean checkUserNumber(){
        //검사
        //ball의 경우
        checkNumbers.countBall(userNumbers,randomNumbers);
        //strike의 경우
        checkNumbers.countStrike(userNumbers,randomNumbers);
        if(checkNumbers.isCorrected()) return true;
        else return false;
    }
    public boolean isEnd(){
        int EndUserInput;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            EndUserInput = Integer.parseInt(readLine());

            if (EndUserInput == NUMOFRESTART) {
                System.out.println("게임을 새로 시작합니다.");
                return false;
            } else if (EndUserInput == NUMOFEND) {
                System.out.println("게임을 종료합니다.");
                return true;
            } else {
                System.out.println("1 혹은 2 중 하나를 입력해주세요.");
            }

        } while (true);
    }

}

