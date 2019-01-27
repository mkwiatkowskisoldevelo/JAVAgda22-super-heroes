package util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testingutils.TeamDataBuilder;

public class TeamUtilsTest {

  private Team weakTeam;
  private Team powerfulTeam;

  @BeforeEach
  public void setUp() {
    weakTeam = new TeamDataBuilder()
        .withWeakHeroes()
        .build();
    powerfulTeam = new TeamDataBuilder()
        .buildPowerfulTeam();
  }

  @Test
  public void shouldReturnTrueIfFirstTeamIsStronger() {
    boolean result = TeamUtils.compareTeams(powerfulTeam, weakTeam);

    assertTrue(result);
  }

  @Test
  public void shouldReturnFalseIfFirstTeamIsWeaker() {
    assertFalse(TeamUtils.compareTeams(weakTeam, powerfulTeam));
  }
}