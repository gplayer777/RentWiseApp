package pl.spring.rentwise.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No user with such id exists")
public class UserNotFoundException extends RuntimeException {


}
