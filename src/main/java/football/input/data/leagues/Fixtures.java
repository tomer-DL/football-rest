
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
    "events",
    "lineups",
    "statistics",
    "players_statistics"
})
public class Fixtures {

    @JsonProperty("events")
    private Boolean events;
    @JsonProperty("lineups")
    private Boolean lineups;
    @JsonProperty("statistics")
    private Boolean statistics;
    @JsonProperty("players_statistics")
    private Boolean playersStatistics;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("events")
    public Boolean getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(Boolean events) {
        this.events = events;
    }

    @JsonProperty("lineups")
    public Boolean getLineups() {
        return lineups;
    }

    @JsonProperty("lineups")
    public void setLineups(Boolean lineups) {
        this.lineups = lineups;
    }

    @JsonProperty("statistics")
    public Boolean getStatistics() {
        return statistics;
    }

    @JsonProperty("statistics")
    public void setStatistics(Boolean statistics) {
        this.statistics = statistics;
    }

    @JsonProperty("players_statistics")
    public Boolean getPlayersStatistics() {
        return playersStatistics;
    }

    @JsonProperty("players_statistics")
    public void setPlayersStatistics(Boolean playersStatistics) {
        this.playersStatistics = playersStatistics;
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
