package wiseSaying;

import java.util.ArrayList;
import java.util.Scanner;


public class WiseSayingController {


    private final WiseSayingService wiseSayingService;
    private final Scanner scanner;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayingService = new WiseSayingService();
    }

    public void updateWiseSaying(int targetId) {

        WiseSaying wiseSaying = wiseSayingService.findById(targetId);

        if (wiseSaying == null) {
            System.out.println("%d 번 명언은 존재하지 않습니다.".formatted(targetId));
            return;
        }
        System.out.println("명언(기존) : %s".formatted(wiseSaying.getContent()));
        System.out.println("명언 : ");
        String newContent = scanner.nextLine();
        System.out.println("명언(작가) : %s".formatted(wiseSaying.getAuthor()));
        System.out.println("작가 : ");
        String newAuthor = scanner.nextLine();

        wiseSayingService.update(wiseSaying, newContent, newAuthor);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(wiseSaying.getId()));


    }

    public void deleteWiseSaying(int targetId) {

        WiseSaying wiseSaying = wiseSayingService.findById(targetId);

        if (wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(targetId));
            return;
        }
        wiseSayingService.remove(wiseSaying);
        System.out.println("%d번 명언이 삭제되었습니다.".formatted(targetId));
    }

    public void printWiseSayingList() {
        System.out.println("번호 / 작가 / 명언 /");// 출력은 컨트롤러 역할
        System.out.println("----------------------");

        ArrayList<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (WiseSaying wiseSaying : wiseSayings.reversed()) { // 향상된 for문
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
        }
    }

    public void writeWiseSaying() {
        System.out.print("명언 : ");
        String content = scanner.nextLine(); // 입력값 가져옴. 입력값이 없으면 대기

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = wiseSayingService.add(content, author); // 함수로 분리 -> 코드가 줄어듬 가독성 증가, 재활용 할 수 있음

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    //함수 이름은 동사가 좋음
    public void makeTestData() {
        // 테스트 명언 데이터1
        wiseSayingService.add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니");
        wiseSayingService.add("현재를 사랑하라", "작자 미상");
    }
}