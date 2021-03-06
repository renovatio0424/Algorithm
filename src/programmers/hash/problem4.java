package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class problem4 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] results = solution(genres, plays);

        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int[] solution(String[] genres, int[] plays) {
        // 장르에 음악이 1개 인 경우
        // 같은 장르에 재생 횟수가 같은 경우
        HashMap<String, MusicList> musicMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (musicMap.containsKey(genres[i])) {
                musicMap.get(genres[i]).add(new Music(i, genres[i], plays[i]));
            } else {
                MusicList musicList = new MusicList();
                musicList.add(new Music(i, genres[i], plays[i]));
                musicMap.put(genres[i], musicList);
            }
        }

        ArrayList<MusicList> musicListByGenre = new ArrayList<>();
        for (String key : musicMap.keySet()) {
            musicListByGenre.add(musicMap.get(key));
        }

        Collections.sort(musicListByGenre);

        int[] answer = new int[musicListByGenre.size() * 2];

        for (int i = 0; i < musicListByGenre.size(); i++) {
            MusicList musicList = musicListByGenre.get(i);
            ArrayList<Music> musicArrayList = musicList.getMusicList();
            Collections.sort(musicArrayList);
        }

        for (int i = 0; i < musicListByGenre.size(); i++) {
            MusicList musicList = musicListByGenre.get(i);
            ArrayList<Music> musicArrayList = musicList.getMusicList();
            answer[2 * i] = musicArrayList.get(0).getId();
            answer[2 * i  + 1] = musicArrayList.get(1).getId();
        }

        return answer;
    }

    public static class MusicList implements Comparable<MusicList> {
        private int total = 0;
        private ArrayList<Music> musicList;

        public MusicList() {
            musicList = new ArrayList<>();
        }

        public void add(Music music) {
            total += music.getPlay();
            musicList.add(music);
        }

        public ArrayList<Music> getMusicList() {
            return musicList;
        }

        @Override
        public int compareTo(MusicList o) {
            if (this.total > o.total)
                return -1;
            else
                return 1;
        }
    }

    public static class Music implements Comparable<Music> {
        private final int id;
        private final String genre;
        private final int play;

        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        public int getId() {
            return id;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        @Override
        public int compareTo(Music music) {
            // 내림 차
            if (this.play > music.play)
                return -1;
            else if (this.play == music.play)
                if (this.id > music.id)
                    return 1;
                else
                    return 0;
            else
                return 1;
        }
    }

}
