package souomarcos.Modelos;

public class TvShow extends Title {
    private int myReview;

    //Constructor--------------------------------------------------------------------------------
    //Recebe um TvShowOmdb e interpreta os atributos para um TvShow
    public TvShow(TvShowOmdb myTvShowOmdb, int myReview) {
        super();
        this.setName(myTvShowOmdb.title());
        this.setYear(myTvShowOmdb.year());
        this.setReleased(myTvShowOmdb.released());
        this.setDirector(myTvShowOmdb.director());
        this.setActors(myTvShowOmdb.actors());
        this.setGenre(myTvShowOmdb.genre());
        this.setLanguage(myTvShowOmdb.language());
        this.setCountry(myTvShowOmdb.country());
        this.setPlot(myTvShowOmdb.plot());
        this.setAwards(myTvShowOmdb.awards());
        this.myReview = myReview;
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + " (" + this.getYear() + ").\n" +
                "Lançamento: " + this.getReleased() + ".\n" +
                "Diretor: " + this.getDirector() + ".\n" +
                "Genero: " + this.getGenre() + ".\n" +
                "Duração média por episódio:" + this.getRuntime() + ".\n" +
                "Atores: " + this.getActors() + ".\n" +
                "Linguagem: " + this.getLanguage() + ".\n" +
                "País: " + this.getCountry() + ".\n" +
                "Premiações: " + this.getAwards() + ".\n" +
                "Sinopse:\n" + this.getPlot() + "\n";
    }

    //Getters------------------------------------------------------------------------------------
    public int getMyReview() {
        return myReview;
    }

    //Setters------------------------------------------------------------------------------------

    public void details() {
        System.out.print(
                "Série: " + this.getName() + ".\n" +
                        "Minha avaliação: ");
        for (int i = 1; i <= getMyReview(); i++) {
            System.out.print("★");
        }
        ;
        System.out.println(".\n" +
                "Lançamento: " + this.getReleased() + ".\n" +
                "Diretor: " + this.getDirector() + ".\n" +
                "Genero: " + this.getGenre() + ".\n" +
                "Duração média por episódio: " + this.getRuntime() + ".\n" +
                "Atores: " + this.getActors() + ".\n" +
                "Linguagem: " + this.getLanguage() + ".\n" +
                "País: " + this.getCountry() + ".\n" +
                "Premiações: " + this.getAwards() + ".\n" +
                "Sinopse:\n" + this.getPlot() + "\n");
    }
}