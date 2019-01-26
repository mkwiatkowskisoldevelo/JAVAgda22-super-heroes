import factory.HeroCreator;
import factory.SuperHeroCreator;
import factory.VillainCreator;
import model.AbstractHero;
import model.HeroStatistics;
import model.TeamType;
import util.PropertiesUtils;

public class Application {

  public static void main(String... args) {
    PropertiesUtils.getInstance().loadProperties();

    HeroCreator creatorA = new SuperHeroCreator();
    HeroCreator creatorB = new VillainCreator();

    generateHero(creatorA);
    generateHero(creatorB);

    generateDefaultHero(creatorA);
    generateDefaultHero(creatorB);
  }

  public static void generateHero(HeroCreator creator) {
    AbstractHero hero = creator
        .createHero("Zenek", new HeroStatistics(10, 5, 15), TeamType.RED);
    System.out.println(hero);
  }

  public static void generateDefaultHero(HeroCreator creator) {
    AbstractHero hero = creator.createHeroWithDefaultStats("Bartek", TeamType.BLUE);
    System.out.println(hero);
  }

  public static void incrementExample() {
    int i = 1;
    int j = 2;
    int sum = i++ + j;

    System.out.println("post increment " + sum);
    System.out.println("i: " + i);

    i = 1;
    sum = ++i + j;

    System.out.println("pre increment " + sum);
    System.out.println("i: " + i);
  }
}
