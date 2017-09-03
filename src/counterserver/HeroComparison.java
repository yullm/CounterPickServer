
package counterserver;

public class HeroComparison implements java.io.Serializable {
    
    private String heroName;
    private double advantage;
    private double winRate;
    private int matches;

    public HeroComparison() {
        this.heroName = "";
        this.advantage = 0;
        this.winRate = 0;
        this.matches = 0;
    }
    
    public HeroComparison(String heroName, double advantage, double winRate, int matches) {
        this.heroName = heroName;
        this.advantage = advantage;
        this.winRate = winRate;
        this.matches = matches;
    }
    
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public double getAdvantage() {
        return advantage;
    }

    public void setAdvantage(double advantage) {
        this.advantage = advantage;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
    
}
