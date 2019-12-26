
package football.input.data.leagues;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "standings",
    "fixtures",
    "players",
    "topScorers",
    "predictions",
    "odds"
})
public class Coverage {

    @JsonProperty("standings")
    private Boolean standings;
    @JsonProperty("fixtures")
    private Fixtures fixtures;
    @JsonProperty("players")
    private Boolean players;
    @JsonProperty("topScorers")
    private Boolean topScorers;
    @JsonProperty("predictions")
    private Boolean predictions;
    @JsonProperty("odds")
    private Boolean odds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("standings")
    public Boolean getStandings() {
        return standings;
    }

    @JsonProperty("standings")
    public void setStandings(Boolean standings) {
        this.standings = standings;
    }

    @JsonProperty("fixtures")
    public Fixtures getFixtures() {
        return fixtures;
    }

    @JsonProperty("fixtures")
    public void setFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
    }

    @JsonProperty("players")
    public Boolean getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(Boolean players) {
        this.players = players;
    }

    @JsonProperty("topScorers")
    public Boolean getTopScorers() {
        return topScorers;
    }

    @JsonProperty("topScorers")
    public void setTopScorers(Boolean topScorers) {
        this.topScorers = topScorers;
    }

    @JsonProperty("predictions")
    public Boolean getPredictions() {
        return predictions;
    }

    @JsonProperty("predictions")
    public void setPredictions(Boolean predictions) {
        this.predictions = predictions;
    }

    @JsonProperty("odds")
    public Boolean getOdds() {
        return odds;
    }

    @JsonProperty("odds")
    public void setOdds(Boolean odds) {
        this.odds = odds;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
