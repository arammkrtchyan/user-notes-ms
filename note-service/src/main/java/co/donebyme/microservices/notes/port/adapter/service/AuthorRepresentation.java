package co.donebyme.microservices.notes.port.adapter.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AuthorRepresentation {

    private String name;

    private String id;

    @JsonCreator
    public AuthorRepresentation(
            @JsonProperty(value = "id") String id,
            @JsonProperty(value = "name") String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
