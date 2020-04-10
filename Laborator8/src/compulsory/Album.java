package compulsory;

public class Album {
    private int id;
    private String name;
    private int artist_id;
    private int release_year;

    public Album(int id, String name, int artist_id, int release_year) {
        this.id = id;
        this.name = name;
        this.release_year = release_year;
        this.artist_id = artist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist_id=" + artist_id +
                ", release_year=" + release_year +
                '}';
    }
}
