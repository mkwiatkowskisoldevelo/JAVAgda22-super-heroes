package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Getter;

public class Team {

  @Getter
  private TeamType type;

  @Getter
  private List<AbstractHero> heroes;

  @Getter
  private AbstractHero teamLeader;

  private boolean isTeamBuffed;

  public Team(TeamType type) {
    this.type = type;
    this.heroes = new ArrayList<>();
    this.isTeamBuffed = false;
  }

  public boolean addHeroToTeam(AbstractHero hero) {
    if (this.type.equals(hero.getType())) {

      if (this.heroes.isEmpty()
          || this.teamLeader.getPower() < hero.getPower()) {
        this.teamLeader = hero;
      }

      this.heroes.add(hero);
      return true;
    }
    return false;
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

      this.heroes.stream()
          .filter(hero -> hero instanceof SuperHero)
          .forEach(hero -> hero.getStats().increaseDefense(10));

      this.heroes.stream()
          .filter(hero -> hero instanceof Villlain)
          .forEach(hero -> hero.getStats().increaseHealth(10));
    }
  }
}
