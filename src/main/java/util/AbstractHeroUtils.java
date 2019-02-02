package util;

import com.sun.org.apache.xml.internal.serialize.Printer;
import exceptions.InvalidHeroDataException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.AbstractHero;
import model.HeroStatistics;
import model.SuperHero;
import model.TeamType;
import model.Villlain;

public class AbstractHeroUtils {

  public static AbstractHero createHeroFromString(String heroString) {
    String[] heroParts = heroString.split(";");
    
    if (heroParts.length != 6) {
      throw new InvalidHeroDataException("Wrong numer of fields, expeted 6"
      + " but was: " + heroParts.length);
    }

    String name = heroParts[1];
    int health, defense, strength;
    
    try {
      health = Integer.valueOf(heroParts[2]);
      defense = Integer.valueOf(heroParts[3]);
      strength = Integer.valueOf(heroParts[4]);
    } catch (NumberFormatException ex) {
      throw new InvalidHeroDataException(
          "One of hero statistics has wrong format", ex);
    }
    TeamType type = TeamType.valueOf(heroParts[5]);

    AbstractHero hero;
    if ("SuperHero".equals(heroParts[0])) {
      hero = new SuperHero();
      hero.setName(name);
      hero.setStats(new HeroStatistics(health, defense, strength));
      hero.setType(type);
    } else {
      hero = new Villlain();
      hero.setName(name);
      hero.setStats(new HeroStatistics(health, defense, strength));
      hero.setType(type);
    }
    return hero;
  }

  public static void saveHeroesToFile(List<AbstractHero> heroes, String fileName) {
    try (FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
      heroes.forEach(hero -> printWriter.write(hero.parseToString() + "\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }

//    finally {
//      if (null != printWriter) {
//        printWriter.close();
//      }
//      if (null != bufferedWriter) {
//        bufferedWriter.close();
//      }
//      if (null != fileWriter) {
//        fileWriter.close();
//      }
//    }
  }

  public static List<AbstractHero> readHeroesFromFile(String fileName) {
    List<AbstractHero> heroes = new ArrayList<>();
    try (FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      String line = bufferedReader.readLine();
      while (line != null) {
        heroes.add(createHeroFromString(line));
        line = bufferedReader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return heroes;
  }
}
