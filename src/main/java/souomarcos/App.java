package souomarcos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import souomarcos.Modelos.Movie;
import souomarcos.Modelos.MovieOmdb;
import souomarcos.Modelos.TvShow;
import souomarcos.Modelos.TvShowOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner read = new Scanner(System.in);
        Scanner readTitle = new Scanner(System.in);

        boolean continueProgram = true;
        int menuOption = 0;

        ArrayList<Movie> watchedMovies = new ArrayList<>();
        ArrayList<TvShow> watchedTvShow = new ArrayList<>();

        System.out.println("Bem vindo ao MovieBox\n\n");

        do {

            System.out.println("\nEscolha uma opção:\n\n" +
                    "1- Filmes;\n" +
                    "2- Séries;\n" +
                    "3- Minha lista;\n" +
                    "4- Encerrar.\n"
            );
            menuOption = read.nextInt();

            String search = " ";
            String apiAddress = " ";

            switch (menuOption) {
                case 1://Buscar um filme
                    System.out.println("\nDigite um filme para buscar:\n");
                    search = readTitle.nextLine();
                    apiAddress = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=2fab2033";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(apiAddress))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                .create();

                        MovieOmdb myMovieOmdb = gson.fromJson(json, MovieOmdb.class);

                        if ((myMovieOmdb.getTitle() == null) || (myMovieOmdb.getType().equalsIgnoreCase("series"))) {
                            System.out.println("\nBusca não encontrada!\n");
                        } else {
                            myMovieOmdb.details();

                            System.out.println("\nMarcar como assistido?\n" +
                                    "1- Sim;\n" +
                                    "2- Não.\n");
                            int watched = read.nextInt();
                            if (watched == 1) {
                                try {
                                    boolean valid = true;
                                    do {

                                        System.out.println("Dê uma nota de 1 até 5 para o filme!\n" +
                                                "(1 'Não gostei' e 5 'Amei, recomendo'!)\n");
                                        int review = read.nextInt();
                                        if (review < 1 || review > 5) {
                                            System.out.println("Opção inválida!");
                                            valid = false;
                                        } else {
                                            Movie myMovie = new Movie(myMovieOmdb, review);
                                            //Movie myMovie = new Movie(myMovieOmdb, review);
                                            watchedMovies.add(myMovie);
                                            System.out.println("\nFilme adicionado a sua lista!\n");
                                            valid = true;
                                        }
                                    } while (!valid);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("\nErro ao adicionar o titulo à lista!\n");
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nAconteceu um erro!\n");
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nBusca inválida!\n");
                    }
                    break;

                case 2://Buscar uma série
                    System.out.println("\nDigite uma série para buscar:\n");
                    search = readTitle.nextLine();
                    apiAddress = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=2fab2033";

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(apiAddress))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                                .create();

                        TvShowOmdb myTvShowOmdb = gson.fromJson(json, TvShowOmdb.class);

                        if ((myTvShowOmdb.title() == null) || (myTvShowOmdb.getType().equalsIgnoreCase("movie"))) {
                            System.out.println("\nBusca não encontrada!\n");
                        } else {
                            myTvShowOmdb.details();

                            System.out.println("\nMarcar como assistido?\n" +
                                    "1- Sim;\n" +
                                    "2- Não.\n");
                            int watched = read.nextInt();
                            if (watched == 1) {
                                try {
                                    boolean valid = true;
                                    do {
                                        System.out.println("\nDê uma nota de 1 até 5 para a série!\n" +
                                                "(1 'Não gostei' e 5 'Amei, recomendo'!)\n");
                                        int review = read.nextInt();
                                        if (review < 1 || review > 5) {
                                            System.out.println("Opção inválida!");
                                            valid = false;
                                        } else {
                                            TvShow myTvShow = new TvShow(myTvShowOmdb, review);
                                            watchedTvShow.add(myTvShow);
                                            System.out.println("\nSérie adicionado a sua lista!\n");
                                        }
                                    } while (!valid);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("\nErro ao adicionar o titulo à lista!\n");
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nAconteceu um erro!\n");
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nBusca inválida!\n");
                    } catch (NullPointerException e) {
                        System.out.println("\nBusca não encontrada!\n");
                    }
                    break;
                case 3://Visualizar minha lista
                    for (Movie item : watchedMovies) {
                        item.details();
                    }

                    for (TvShow item : watchedTvShow) {
                        item.details();
                    }
                    break;

                case 4://Encerrar o programa
                    System.out.println("\nObrigado por utilizar o MovieBox!\n");
                    continueProgram = false;
                    break;

                default:
                    System.out.println("\nO número escolhido é inválido!\n" +
                            "Digite um número entre 1 a 3.\n");
                    break;
            }
        } while (continueProgram);
    }
}