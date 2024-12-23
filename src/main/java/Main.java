import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        app.run();
    }
}

class App {

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기

                System.out.print("작가 : ");
                scanner.nextLine();

                System.out.println("1번 명언이 등록되었습니다.");
            }
        }
    }
}