package pl.spring.rentwise.inventory.asset;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No equipment with such id")
public class AssetNotFoundException extends RuntimeException{
}
