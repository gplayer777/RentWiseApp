package pl.spring.rentwise;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User with this PESEL already exists")
public class DuplicatePeselException extends RuntimeException{
}
