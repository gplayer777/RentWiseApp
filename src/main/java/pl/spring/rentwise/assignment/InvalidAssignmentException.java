package pl.spring.rentwise.assignment;

public class InvalidAssignmentException extends RuntimeException{
    public InvalidAssignmentException(String message) {
        super(message);
    }
}
