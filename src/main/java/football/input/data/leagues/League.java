
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
    "league_id",
    "name",
    "type",
    "country",
    "country_code",
    "season",
    "season_start",
    "season_end",
    "logo",
    "flag",
    "standings",
    "is_current",
    "coverage"
})
public class League {

    @JsonProperty("league_id")
    private Integer leagueId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("season")
    private Integer season;
    @JsonProperty("season_start")
    private String seasonStart;
    @JsonProperty("season_end")
    private String seasonEnd;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("standings")
    private Integer standings;
    @JsonProperty("is_current")
    private Integer isCurrent;
    @JsonProperty("coverage")
    private Coverage coverage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("league_id")
    public Integer getLeagueId() {
        return leagueId;
    }

    @JsonProperty("league_id")
    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("season")
    public Integer getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(Integer season) {
        this.season = season;
    }

    @JsonProperty("season_start")
    public String getSeasonStart() {
        return seasonStart;
    }

    @JsonProperty("season_start")
    public void setSeasonStart(String seasonStart) {
        this.seasonStart = seasonStart;
    }

    @JsonProperty("season_end")
    public String getSeasonEnd() {
        return seasonEnd;
    }

    @JsonProperty("season_end")
    public void setSeasonEnd(String seasonEnd) {
        this.seasonEnd = seasonEnd;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("flag")
    public String getFlag() {
        return flag;
    }

    @JsonProperty("flag")
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @JsonProperty("standings")
    public Integer getStandings() {
        return standings;
    }

    @JsonProperty("standings")
    public void setStandings(Integer standings) {
        this.standings = standings;
    }

    @JsonProperty("is_current")
    public Integer getIsCurrent() {
        return isCurrent;
    }

    @JsonProperty("is_current")
    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
    }

    @JsonProperty("coverage")
    public Coverage getCoverage() {
        return coverage;
    }

    @JsonProperty("coverage")
    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
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
