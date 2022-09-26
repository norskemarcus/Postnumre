package main;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

  private ArrayList<Postinfo> listOfPostinfo = new ArrayList<>();


  public ArrayList<Postinfo> registerNatives(){

    try{
      Scanner scanner = new Scanner(new File("postnumre_csv.CSV"), "Windows-1252");


      while (scanner.hasNextLine()){
        String lineInput = scanner.nextLine();
        Scanner lineScanner = new Scanner(lineInput).useDelimiter(";").useLocale(Locale.ENGLISH);

        if (lineScanner.hasNextInt()){

          int postNumber = lineScanner.nextInt();
          String cityName = lineScanner.next();

          Postinfo numberAndCity = new Postinfo(postNumber, cityName);
          listOfPostinfo.add(numberAndCity);
        }


      }
    } catch (FileNotFoundException fnfe){
      System.err.println(fnfe.getMessage());
    }
    return listOfPostinfo;
  }




  public String findCityByPostNumber(int postnummer){

    // gennemløb alle postnummer i listen for at finde den by der høre til det postnummer der er
    for (int i = 0; i < listOfPostinfo.size()-1; i++) {

      if (listOfPostinfo.get(i).getPostnummer() == (postnummer)){
        return ("Fundet info --> " + listOfPostinfo.get(i));
      }
    }
    return "By ikke fundet";
  }




  public static void main(String[] args) {

    Main main = new Main();
    main.registerNatives();

    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;

    while(isRunning){

      System.out.print("Skriv ind postnummeret til den by du vil søge op: ");
      int keyboard_input = scanner.nextInt();

      System.out.println(main.findCityByPostNumber(keyboard_input));

    }
  }
}
