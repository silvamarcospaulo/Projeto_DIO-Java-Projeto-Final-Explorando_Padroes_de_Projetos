package souomarcos.Modelos;

public class Movie extends Title {
    private int myReview;

    //Constructor--------------------------------------------------------------------------------
    //Recebe um MovieOmdb e interpreta os atributos para um Movie
    public Movie(MovieOmdb myMovieOmdb, int myReview) {
        super();
        this.setName(myMovieOmdb.title());
        this.setYear(myMovieOmdb.year());
        this.setReleased(myMovieOmdb.released());
        this.setDirector(myMovieOmdb.director());
        this.setActors(myMovieOmdb.actors());
        this.setGenre(myMovieOmdb.genre());
        this.setLanguage(myMovieOmdb.language());
        this.setCountry(myMovieOmdb.country());
        this.setPlot(myMovieOmdb.plot());
        this.setAwards(myMovieOmdb.awards());
        this.setRuntime(myMovieOmdb.runtime());
        this.myReview = myReview;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.getName() + " (" + this.getYear() + ").\n" +
                "Lançamento: " + this.getReleased() + ".\n" +
                "Diretor: " + this.getDirector() + ".\n" +
                "Genero: " + this.getGenre() + ".\n" +
                "Duração: " + this.getRuntime() + ".\n" +
                "Atores: " + this.getActors() + ".\n" +
                "Linguagem: " + this.getLanguage() + ".\n" +
                "País: " + this.getCountry() + ".\n" +
                "Premiações: " + this.getAwards() + ".\n" +
                "Sinopse:\n" + this.getPlot() + "\n";
    }

    //Getters
    public int getMyReview() {
        return myReview;
    }

    //Setters
    public void setMyReview(int myReview) {
        this.myReview = myReview;
    }

    //Métodos
    public void details() {
        System.out.print(
                "Filme: " + this.getName() + ".\n" +
                        "Minha avaliação: ");
        for (int i = 1; i <= getMyReview(); i++) {
            System.out.print("★");
        }
        ;
        System.out.println(".\n" +
                "Lançamento: " + this.getReleased() + ".\n" +
                "Diretor: " + this.getDirector() + ".\n" +
                "Genero: " + this.getGenre() + ".\n" +
                "Duração: " + this.getRuntime() + ".\n" +
                "Atores: " + this.getActors() + ".\n" +
                "Linguagem: " + this.getLanguage() + ".\n" +
                "País: " + this.getCountry() + ".\n" +
                "Premiações: " + this.getAwards() + ".\n" +
                "Sinopse:\n" + this.getPlot() + "\n");
    }
}