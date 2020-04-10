package compulsory;

public class Main {
    public static void main(String[] args) {
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();

        //artistController.create("Michael Jackson","SUA");
        artistController.create("Adam Gontier","Canada");
        System.out.println(artistController.findByName("Adam Gontier"));

        //albumController.create("Dangerous",1,1991);
        //albumController.create("Thriller",1,1982);
        //albumController.create("Transit Of Venus",2,2012);
        System.out.println(albumController.findByArtist(1));
    }
}
