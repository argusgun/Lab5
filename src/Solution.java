import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<Movie> movieList = new ArrayList<>();
    static File file;
    static BufferedReader consoleReader  = new BufferedReader(new InputStreamReader(System.in));


    static void addMovie() throws IOException {
        String name, producer;
        Integer year=null, price=null;
        System.out.println("Введите название фильма:");
        name=consoleReader.readLine();
        System.out.println("Введите режиссера фильма:");
        producer=consoleReader.readLine();
        while (year==null){
            System.out.println("Введите год выпуска:");
            try {
                year = Integer.parseInt(consoleReader.readLine());
                if (year < 1884 && year > 2018) throw new NegativeArraySizeException("Вы ввели ошибочный год!");
            }
            catch (NegativeArraySizeException e){
                System.out.println(e.getMessage());
                year=null;
            }
            catch (NumberFormatException ee) { System.out.println("Вы ввели не число!");}
        }
        while (price==null){
            System.out.println("Введите стоимость фильма:");
            try {
                price = Integer.parseInt(consoleReader.readLine());
                if (price < 0) throw new NegativeArraySizeException("Вы ввели ошибочный год!");
            }
            catch (NegativeArraySizeException e){
                System.out.println(e.getMessage());
                price=null;
            }
            catch (NumberFormatException ee) { System.out.println("Вы ввели не число!");}
        }
        movieList.add(new Movie(name,producer,year,price));
        saveMovieList(movieList);
    }

    static void addMovie(int n) throws IOException {
        String name, producer;
        Integer year, price;
        for(int i=0;i<n;i++){
            year=null;
            price=null;
            System.out.println("Введите название фильма:");
            name=consoleReader.readLine();
            System.out.println("Введите режиссера фильма:");
            producer=consoleReader.readLine();
            while (year==null){
                System.out.println("Введите год выпуска:");
                try {
                    year = Integer.parseInt(consoleReader.readLine());
                    if (year < 1884 && year > 2018) throw new NegativeArraySizeException("Вы ввели ошибочный год!");
                }
                catch (NegativeArraySizeException e){
                    System.out.println(e.getMessage());
                    year=null;
                }
                catch (NumberFormatException ee) { System.out.println("Вы ввели не число!");}
            }
            while (price==null){
                System.out.println("Введите стоимость фильма:");
                try {
                    price = Integer.parseInt(consoleReader.readLine());
                    if (price < 0) throw new NegativeArraySizeException("Вы ввели ошибочный год!");
                }
                catch (NegativeArraySizeException e){
                    System.out.println(e.getMessage());
                    price=null;
                }
                catch (NumberFormatException ee) { System.out.println("Вы ввели не число!");}
            }
            movieList.add(i,new Movie(name,producer,year,price));
        }
        saveMovieList(movieList);

    }

    static void userAction(){
        System.out.println("Выбирите действие:");
        System.out.println("0 - Добавить фильм");
        System.out.println("1 - Добавить фильмы в начало списка");
        System.out.println("2 - Удалить фильмы ниже стоимости:");
        System.out.println("3 - Сохранить в файл данные");
        System.out.println("4 - Загрузить данные из файла");
        System.out.println("5 - Открыть файл с данными");
        System.out.println("6 - Выйти");
    }

    static void saveMovieList(List<Movie> list) throws IOException {
        FileWriter fileWriter1=new FileWriter(file);
        fileWriter1.write("");
        fileWriter1.close();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file,true));
        for (Movie m:movieList){
            fileWriter.write(m.getName());
            fileWriter.newLine();
            fileWriter.write(m.getProducer());
            fileWriter.newLine();
            fileWriter.write(m.getReleaseYear()+"");
            fileWriter.newLine();
            fileWriter.write(m.getPrice()+"");
            fileWriter.newLine();
            fileWriter.flush();
        }
        System.out.println("Saving is complete!");
    }

    static void loadMovieList() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        movieList=new ArrayList<>();
        while (fileReader.ready()){
            Movie movie = new Movie(fileReader.readLine());
            movie.setProducer(fileReader.readLine());
            movie.setReleaseYear(Integer.parseInt(fileReader.readLine()));
            movie.setPrice(Integer.parseInt(fileReader.readLine()));
            movieList.add(movie);
        }
        System.out.println("Loading is complete!");
        fileReader.close();
    }

    static void deleteMovieLowerPrice(int n) throws IOException {
        List<Movie> list = movieList;
        for (int i=list.size()-1;i>=0;i--){
            if(list.get(i).getPrice()<n) movieList.remove(i);
        }
        saveMovieList(movieList);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Введите имя файла для хранения фильмов: ");
        String fileName =  consoleReader.readLine();



        file = new File(fileName+".txt");

            if(file.createNewFile()){
                System.out.println(fileName+".txt файл создан в корневой директории проекта");
            }else System.out.println(fileName+".txt файл уже существует в корневой директории проекта");

        while (true){
            userAction();
            String action = consoleReader.readLine();

            if(action.equals("6")) break;
            switch (action){
                case "0":
                        addMovie();
                    break;
                case "1":
                    Integer k=null;
                    while (k==null){
                        System.out.println("Введите количество фильмов которые хотите добавить:");
                        try {
                            k = Integer.parseInt(consoleReader.readLine());
                            if (k < 0) throw new NegativeArraySizeException("Вы ввели ошибочное количество!");
                        }
                        catch (NegativeArraySizeException e){
                            System.out.println(e.getMessage());
                            k=null;
                        }
                        catch (NumberFormatException ee) { System.out.println("Вы ввели не число!");}
                    }
                        addMovie(k);
                    break;
                case "2":
                    Integer a=null;
                    while (a==null){
                        System.out.println("Введите количество фильмов которые хотите добавить:");
                        try {
                            a = Integer.parseInt(consoleReader.readLine());
                            if (a < 0) throw new NegativeArraySizeException("Вы ввели ошибочное стоимость!");
                        }
                        catch (NegativeArraySizeException e){
                            System.out.println(e.getMessage());
                            a=null;
                        }
                        catch (NumberFormatException ee) { System.out.println("Вы ввели не число!");}
                    }
                    deleteMovieLowerPrice(a);
                    break;
                case "3":
                    saveMovieList(movieList);
                    break;
                case "4":
                    loadMovieList();
                    break;
                case "5":
                    java.awt.Desktop.getDesktop().open(file);
                    for (Movie m:movieList) System.out.println(m.getName()+" "+m.getProducer()+" "+m.getReleaseYear());
                    break;
                default:
                    System.out.println("Вы ввели неправильную команду!");
            }

        }
        consoleReader.close();
    }
}
