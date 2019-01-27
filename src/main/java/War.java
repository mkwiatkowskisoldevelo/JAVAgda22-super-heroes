import lombok.AllArgsConstructor;
import model.AbstractHero;
import model.Team;

@AllArgsConstructor
public class War {

  private Team teamA;
  private Team teamB;

  public Team startWar() {
    while (teamA.isAnyHeroStillAlive()
        && teamB.isAnyHeroStillAlive()) {
      AbstractHero heroA = teamA.getRandomAliveHero();
      AbstractHero heroB = teamB.getRandomAliveHero();

      duel(heroA, heroB);
    }

    return getWinnerTeam(teamA, teamB);
  }

  private void duel(AbstractHero heroA, AbstractHero heroB) {
    if (heroA.getPower() > heroB.getPower()) {
      System.out.println(heroA + " won over " + heroB);
      heroB.killHero();
    } else if (heroA.getPower() < heroB.getPower()) {
      System.out.println(heroB + " won over " + heroA);
      heroA.killHero();
    } else {
      System.out.println(heroA + " and " + heroB + " killed each other!");
      heroB.killHero();
      heroA.killHero();
    }
  }

  private Team getWinnerTeam(Team teamA, Team teamB) {
    if (teamA.isAnyHeroStillAlive()) {
      return teamA;
    } else if (teamB.isAnyHeroStillAlive()) {
      return teamB;
    } else {
      return null;
    }
  }
}
