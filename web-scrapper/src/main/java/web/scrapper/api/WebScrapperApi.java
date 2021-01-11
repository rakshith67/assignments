/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package web.scrapper.api;

import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import web.scrapper.config.ErrorResponse;
import web.scrapper.resources.models.ScrapperOutput;

@RequestMapping(value = "/webScrapper/v1")
public interface WebScrapperApi {

	Logger log = LoggerFactory.getLogger(WebScrapperApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "", nickname = "webScrapper", notes = "This will remove access to all the users except admins and adds the users that are given in the input.", response = Object.class, tags = {
			"webScrapper", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Scrapped Data", response = Object.class),
			@ApiResponse(code = 400, message = "Bad Request errors.", response = ErrorResponse.class),
			@ApiResponse(code = 405, message = "Invalid Method Type", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Errors", response = ErrorResponse.class) })
	@PostMapping(value = "/data", produces = { "application/json" }, consumes = { "multipart/form-data" })
	public ResponseEntity<ScrapperOutput> webScrapper(
			@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file,
			@ApiParam(value = "file details") @RequestPart("config") MultipartFile config) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("multipart/form-data")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue("", ScrapperOutput.class),
							HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default RemoveAccessToAllUsersApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}