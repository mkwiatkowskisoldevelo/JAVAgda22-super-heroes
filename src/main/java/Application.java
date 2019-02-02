import factory.HeroCreator;
import factory.SuperHeroCreator;
import factory.VillainCreator;
import model.AbstractHero;
import model.HeroStatistics;
import model.SuperHero;
import model.Team;
import model.TeamType;
import util.AbstractHeroUtils;
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

    Team teamDC = new Team(TeamType.RED);
    teamDC.addHeroToTeam(new SuperHero(
        "Superman",
        new HeroStatistics(20, 20, 20),
        TeamType.RED));
    teamDC.addHeroToTeam(new SuperHero(
        "Batman",
        new HeroStatistics(10, 10, 10),
        TeamType.RED));
    teamDC.addHeroToTeam(new SuperHero(
        "Aquaman",
        new HeroStatistics(15, 20, 10),
        TeamType.RED));

    Team teamMarvel = new Team(TeamType.BLUE);
    teamMarvel.addHeroToTeam(new SuperHero(
        "Iron Man",
        new HeroStatistics(10, 10, 20),
        TeamType.BLUE));
    teamMarvel.addHeroToTeam(new SuperHero(
        "Thor",
        new HeroStatistics(30, 10, 20),
        TeamType.BLUE));
    teamMarvel.addHeroToTeam(new SuperHero(
        "Hulk",
        new HeroStatistics(15, 30, 30),
        TeamType.BLUE));

    War war = new War(teamDC, teamMarvel);
    System.out.println(war.startWar());

    AbstractHeroUtils.saveHeroesToFile(teamMarvel.getHeroes(), "./MarvelHeroes");
    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
    System.out.println(AbstractHeroUtils.readHeroesFromFile("./MarvelHeroes"));
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
