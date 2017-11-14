package vn.easycredit.common.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import lombok.Value;

/**
 * @author HienNT
 *
 */

@Value
@JsonInclude(Include.NON_EMPTY)
public class InfoGroup implements Serializable{
	
	private static final long serialVersionUID = 1L;
    List<ErrorInfo> errors;

    @JsonCreator
    public InfoGroup(
            @JsonProperty("errors") List<ErrorInfo> errors) {
        this.errors = errors != null ? ImmutableList.copyOf(errors) : ImmutableList.of();
    }
}
