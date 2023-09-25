package souomarcos.Modelos;

public class Title {
    private String name;
    private String year;
    private String released;
    private String director;
    private String actors;
    private String genra;
    private String language;
    private String country;
    private String plot;
    private String awards;

    private String runtime;

    public Title() {
    }

    public String getName() {
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    public String getReleased() {
        return this.released;
    }

    public String getDirector() {
        return this.director;
    }

    public String getActors() {
        return this.actors;
    }

    public String getGenre() {
        return this.genra;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPlot() {
        return this.plot;
    }

    public String getRuntime() {
        return this.runtime;
    }

    public String getAwards() {
        return this.awards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setGenre(String genre) {
        this.genra = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
}