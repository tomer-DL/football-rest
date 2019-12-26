
package football.input.data.leagues;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results",
    "leagues"
})
public class Api {

    @JsonProperty("results")
    private Integer results;
    @JsonProperty("leagues")
    private List<League> leagues = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("results")
    public Integer getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(Integer results) {
        this.results = results;
    }

    @JsonProperty("leagues")
    public List<League> getLeagues() {
        return leagues;
    }

    @JsonProperty("leagues")
    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
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
