package testingutils;

import java.util.ArrayList;
import java.util.List;
import model.AbstractHero;
import model.Team;
import model.TeamType;

public class TeamDataBuilder {

  private TeamType type;
  private List<AbstractHero> heroes;

  public TeamDataBuilder() {
    this.type = TeamType.BLUE;
    this.heroes = new ArrayList<>();
  }

  public TeamDataBuilder withHero(AbstractHero hero) {
    heroes.add(hero);
    return this;
  }

  public TeamDataBuilder withType(TeamType type) {
    this.type = type;
    return this;
  }

  public Team build() {
    Team team = new Team(type);
    heroes.stream()
        .forEach(team::addHeroToTeam);
    return team;
  }

  public TeamDataBuilder withWeakHeroes() {
    return this
        .withHero(new AbstractHeroDataBuilder()
          .withWeakStatistics()
          .withType(this.type)
          .buildSuperHero());
  }

  public Team buildPowerfulTeam() {
    return this
        .withHero(new AbstractHeroDataBuilder()
            .withPowerfulStatistics()
            .withType(this.type)
            .buildSuperHero())
        .build();
  }
}
