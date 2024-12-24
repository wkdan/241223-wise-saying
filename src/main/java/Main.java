import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        app.run();
    }
}

class App {

    public void run() {
        Map<Integer, String[]> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");
        int lastNo = 1;

        while (true) {

            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                String wise = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                map.put(lastNo, new String[]{author, wise});

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo++));


            } else if (command.equals("목록")) {
                System.out.println("번호 / "+"작가 / "+"명언 / ");
                System.out.println("----------------------");

                for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
                    int no = entry.getKey();
                    String[] data = entry.getValue();

                    String author = data[0];
                    String wise = data[1];

                    System.out.println(no+" / "+author+" / "+wise);
                }
            }

        }
    }
}