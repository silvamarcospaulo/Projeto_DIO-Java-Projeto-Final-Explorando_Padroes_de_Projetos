package souomarcos.Modelos;

public record MovieOmdb(String title, String year, String released, String director, String actors, String genre,
                        String language, String country, String plot, String awards, String runtime, String type) {
    public void details() {
        System.out.println(
                "Filme: " + this.title + ".\n" +
                        "Lançamento: " + this.released + ".\n" +
                        "Diretor: " + this.director + ".\n" +
                        "Genero: " + this.genre + ".\n" +
                        "Duração: " + this.runtime + ".\n" +
                        "Atores: " + this.actors + ".\n" +
                        "Linguagem: " + this.language + ".\n" +
                        "País: " + this.country + ".\n" +
                        "Premiações: " + this.awards + ".\n" +
                        "Sinopse:\n" + this.plot + "\n");
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}