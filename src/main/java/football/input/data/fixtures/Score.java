
package football.input.data.fixtures;

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
    "halftime",
    "fulltime",
    "extratime",
    "penalty"
})
public class Score {

    @JsonProperty("halftime")
    private String halftime;
    @JsonProperty("fulltime")
    private String fulltime;
    @JsonProperty("extratime")
    private Object extratime;
    @JsonProperty("penalty")
    private Object penalty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("halftime")
    public String getHalftime() {
        return halftime;
    }

    @JsonProperty("halftime")
    public void setHalftime(String halftime) {
        this.halftime = halftime;
    }

    @JsonProperty("fulltime")
    public String getFulltime() {
        return fulltime;
    }

    @JsonProperty("fulltime")
    public void setFulltime(String fulltime) {
        this.fulltime = fulltime;
    }

    @JsonProperty("extratime")
    public Object getExtratime() {
        return extratime;
    }

    @JsonProperty("extratime")
    public void setExtratime(Object extratime) {
        this.extratime = extratime;
    }

    @JsonProperty("penalty")
    public Object getPenalty() {
        return penalty;
    }

    @JsonProperty("penalty")
    public void setPenalty(Object penalty) {
        this.penalty = penalty;
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
