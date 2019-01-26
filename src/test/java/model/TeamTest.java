package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TeamTest {

  @Test
  public void shouldReturnTrueIfHeroHasTheSameTypeAsTeam() {
    // incjacja danych testowcyh
    SuperHero hero = new SuperHero(
        "hero",
        new HeroStatistics(1, 1, 1),
        TeamType.BLUE);
    Team team = new Team(TeamType.BLUE);

    // wywołanie metody, którą chcemy przetestować
    boolean result = team.addHeroToTeam(hero);

    // sprawdzanie wyniku
    assertTrue(result);
    assertTrue(team.getHeroes().contains(hero));
  }

  @Test
  public void shouldReturnFalseIfHeroHasDifferentTypeThenTeam() {
    SuperHero hero = new SuperHero(
        "hero",
        new HeroStatistics(1, 1, 1),
        TeamType.RED);
    Team team = new Team(TeamType.BLUE);

    boolean result = team.addHeroToTeam(hero);

    assertFalse(result);
    assertFalse(team.getHeroes().contains(hero));
  }

  @Test
  public void shouldReturnMostPowerfulHeroAsTeamLeader() {
    SuperHero weakHero = new SuperHero(
        "hero1",
        new HeroStatistics(1, 1, 1),
        TeamType.RED);
    SuperHero powerfulHero = new SuperHero(
        "hero2",
        new HeroStatistics(100, 100, 100),
        TeamType.RED);
    Team team = new Team(TeamType.RED);
    team.addHeroToTeam(powerfulHero);
    team.addHeroToTeam(weakHero);

    AbstractHero teamLeader = team.getTeamLeader();

    assertEquals(powerfulHero, teamLeader);
  }

  @Test
  public void shouldBuffTeamOnlyOnce() {
    SuperHero superhero = new SuperHero(
        "hero1",
        new HeroStatistics(1, 1, 1),
        TeamType.RED);
    Villlain villain = new Villlain(
        "hero2",
        new HeroStatistics(100, 100, 100),
        TeamType.RED);
    Team team = new Team(TeamType.RED);
    team.addHeroToTeam(superhero);
    team.addHeroToTeam(villain);

    team.buffTeam();
    team.buffTeam();

    assertEquals(11, superhero.getStats().getDefense());
    assertEquals(160, villain.getStats().getHealth());
  }
}