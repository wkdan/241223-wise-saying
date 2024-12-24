import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        app.run();
    }
}

class App {

    private int lastId = 0;
    private int wiseSayingSize = 0;
    private WiseSaying[] wiseSayingList = new WiseSaying[3];

    public void run() {
        Scanner scanner = new Scanner(System.in);

        // 테스트 명언 데이터1
        add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.","월트 디즈니");

        System.out.println("== 명언 앱 ==");

        while (true) {

            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                System.out.println("명언 앱을 종료합니다.");
                break;

            } else if (command.equals("등록")) {

                System.out.print("명언 : ");
                String content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                add(content,author); // 함수로 분리 -> 코드가 줄어듬 가독성 증가, 재활용 할 수 있음

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastId));

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언 /");
                System.out.println("----------------------");

                for (int i = 0; i < wiseSayingSize; i++) {
                    WiseSaying wiseSaying = wiseSayingList[i];
                    System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
                }

//                for(WiseSaying wiseSaying : wiseSayingList) {
//                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
//                }
            }
        }
    }

    //함수 이름은 동사가 좋음
    public void add(String content, String author) {

        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList[wiseSayingSize++] = wiseSaying;

    }
}

class WiseSaying {
    private int id;
    private String content;
    private String author;

    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}