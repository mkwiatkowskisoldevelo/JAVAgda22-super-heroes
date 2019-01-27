package exceptions;

import model.AbstractHero;
import model.Team;

public class InvalidHeroTeamException extends RuntimeException {

  public InvalidHeroTeamException(String message) {
    super(message);
  }

  public InvalidHeroTeamException(Team team, AbstractHero hero) {
    this("Different team types encountered while adding hero with type "
        + hero.getType()
        + " to team with type "
        + team.getType());
  }
}
