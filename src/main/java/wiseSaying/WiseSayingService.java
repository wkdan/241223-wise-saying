package wiseSaying;

import java.util.ArrayList;

public class WiseSayingService {
    private final ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying findById(int targetId) {
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == targetId) {
                return wiseSaying;
            }
        }
        return null; // 자바에서 null은 객체가 비어있음을 의미
    }

    public void update(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);
    }

    //뭔가를 저장하는 함수(메서드) 저장된 것을 다시 리턴하는 것이 관례
    public WiseSaying add(String content, String author) {
        int id = lastId;
        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }

    public ArrayList<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }
}
