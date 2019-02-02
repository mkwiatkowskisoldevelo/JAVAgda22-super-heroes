package util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.Team;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
    // given
    // inicjowanie danych

    // when
    boolean result = TeamUtils.compareTeams(powerfulTeam, weakTeam);

    // then
    assertTrue(result);
  }

  @Test
  public void shouldReturnFalseIfFirstTeamIsWeaker() {
    assertFalse(TeamUtils.compareTeams(weakTeam, powerfulTeam));
  }

  @AfterEach
  public void tearDown() {
    // przywracanie stanu z przed testu
  }
}