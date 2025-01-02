import wiseSaying.WiseSaying;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("Hello");
        strings.add("World");
        strings.add("Java");

        //index로 지우는 방법
        strings.remove(1);
        for (String s : strings) {
            System.out.println(s);
        }

        strings.remove("Java");

        //값으로 지우는 방법
        for (String s : strings) {
            System.out.println(s);
        }

        WiseSaying w1 = new WiseSaying(1,"ㅂㅈㄷ", "ㅂㅈㄷ");
        WiseSaying w2 = new WiseSaying(2,"123","123");

        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
        wiseSayings.add(w1);
        wiseSayings.add(w2);

        wiseSayings.remove(w2);

        for (WiseSaying w : wiseSayings) {
            System.out.println(w.getContent());
            System.out.println(w.getAuthor());
        }
    }
}
