package util;

import model.Team;

public class TeamUtils {

  public static boolean compareTeams(Team teamA, Team teamB) {
    if (teamA.getTeamPower() > teamB.getTeamPower()) {
      return true;
    }
    return false;
  }

  public static boolean compareBuffedTeams(Team teamA, Team teamB) {
    teamA.buffTeam();
    teamB.buffTeam();

    return compareTeams(teamA, teamB);
  }
}
