package model;

import static java.util.stream.Collectors.toList;

import exceptions.InvalidHeroTeamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.ToString;
import sun.security.x509.SubjectKeyIdentifierExtension;

@ToString
public class Team {

  @Getter
  private TeamType type;

  @Getter
  private List<AbstractHero> heroes;

  @Getter
  private AbstractHero teamLeader;

  @Getter
  private Side side;

  private boolean isTeamBuffed;

  public Team(TeamType type) {
    this.type = type;
    this.heroes = new ArrayList<>();
    this.isTeamBuffed = false;
    this.side = Side.UNKNOWN;
  }

  public boolean addHeroToTeamOld(AbstractHero hero) {
    if (this.type.equals(hero.getType())) {

      if (this.heroes.isEmpty()
          || this.teamLeader.getPower() < hero.getPower()) {
        this.teamLeader = hero;
      }

      this.heroes.add(hero);

      //this.checkSide();
      this.checkSideUsingPower();

      return true;
    }
    return false;
  }

  public void addHeroToTeam(AbstractHero hero) {
    if (!this.type.equals(hero.getType())) {
      throw new InvalidHeroTeamException(this, hero);
    }

    if (this.heroes.isEmpty()
        || this.teamLeader.getPower() < hero.getPower()) {
      this.teamLeader = hero;
    }

    this.heroes.add(hero);

    this.checkSideUsingPower();
  }

  private void checkSide() {
    long superHeroesCount = getSuperHeroStream().count();

    long villainCount = this.heroes.size() - superHeroesCount;

    setTeamSide(superHeroesCount, villainCount);
  }

  private void checkSideUsingPower() {
    int superHeroesPower = getSuperHeroStream()
        .mapToInt(AbstractHero::getPower)
        .sum();

    int villainPower = this.heroes.stream()
        .filter(hero -> hero instanceof Villlain)
        .mapToInt(AbstractHero::getPower)
        .sum();

    setTeamSide(superHeroesPower, villainPower);
  }

  private void setTeamSide(long superHeroesValue, long villainValue) {
    if (superHeroesValue > villainValue) {
      this.side = Side.GOOD;
    } else if (superHeroesValue < villainValue) {
      this.side = Side.EVIL;
    } else {
      this.side = Side.UNKNOWN;
    }
  }

  public AbstractHero getTeamLeaderOld() {
    Optional<AbstractHero> foundHero = this.heroes.stream()
        .sorted((hero1, hero2) -> {
          int hero1Power = hero1.getPower();
          int hero2Power = hero2.getPower();

          if (hero1Power > hero2Power) {
            return -1;
          } else if (hero1Power < hero2Power) {
            return 1;
          }
          return 0;
        })
        .findFirst();

//    if (foundHero.isPresent()) {
//      return foundHero.get();
//    }
//    return null;

    return foundHero.orElse(null);
  }

  public int getTeamPower() {
//    int sum = 0;
//    for (AbstractHero hero : this.heroes) {
//      sum += hero.getPower();
//    }
//    return sum;

    return this.heroes.stream()
        .mapToInt(AbstractHero::getPower)
        .sum();
  }

  public void buffTeam() {
    if (!isTeamBuffed) {
      this.isTeamBuffed = true;

      getSuperHeroStream()
          .forEach(hero -> hero.getStats().increaseDefense(10));

      getVillainStream()
          .forEach(hero -> hero.getStats().increaseHealth(10));
      this.teamLeader = getTeamLeaderOld();
    }
  }

  public boolean isAnyHeroStillAlive() {
    return this.heroes.stream()
        .anyMatch(AbstractHero::isAlive);
  }

  public AbstractHero getRandomAliveHero() {
    List<AbstractHero> aliveHeroes = this.heroes.stream()
        .filter(AbstractHero::isAlive)
        .collect(toList());

    Random random = new Random();
    int randomNumber = random.nextInt(aliveHeroes.size());

    return aliveHeroes.get(randomNumber);
  }

  private Stream<AbstractHero> getSuperHeroStream() {
    return this.heroes.stream()
        .filter(hero -> hero instanceof SuperHero);
  }

  private Stream<AbstractHero> getVillainStream() {
    return this.heroes.stream()
        .filter(hero -> hero instanceof Villlain);
  }
}
