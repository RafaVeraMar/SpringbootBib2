package es.babel.biblioteca.web.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

	private Integer status;
	private String code;
	private String message;
}
