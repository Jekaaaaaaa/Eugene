package semester1.practice09;

public class Practice09_20 {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Вечірній плейлист", 4);
        playlist.addTrack(new AudioTrack("Трек 1", "Гурт А", 185));
        playlist.addTrack(new AudioTrack("Трек 2", "Гурт Б", 222));
        System.out.println(playlist);
    }

    static class AudioTrack {
        private final String title;
        private final String artist;
        private final int durationSeconds;

        public AudioTrack(String title, String artist, int durationSeconds) {
            this.title = title;
            this.artist = artist;
            this.durationSeconds = durationSeconds;
        }

        public int getDurationSeconds() {
            return durationSeconds;
        }

        public String formatDuration() {
            return String.format("%02d:%02d", durationSeconds / 60, durationSeconds % 60);
        }

        @Override
        public String toString() {
            return artist + " — " + title + " (" + formatDuration() + ")";
        }
    }

    static class Playlist {
        private String name;
        private final AudioTrack[] tracks;
        private int trackCount;

        public Playlist(String name, int capacity) {
            this.name = name;
            this.tracks = new AudioTrack[capacity];
        }

        public void addTrack(AudioTrack track) {
            if (track != null && trackCount < tracks.length) {
                tracks[trackCount++] = track;
            }
        }

        public int getTotalDurationSeconds() {
            int total = 0;
            for (int i = 0; i < trackCount; i++) {
                total += tracks[i].getDurationSeconds();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder list = new StringBuilder(name);
            for (int i = 0; i < trackCount; i++) {
                list.append(System.lineSeparator()).append(i + 1).append(". ").append(tracks[i]);
            }
            int total = getTotalDurationSeconds();
            return list.append(String.format("%nЗагалом: %d хв %d сек", total / 60, total % 60)).toString();
        }
    }
}
