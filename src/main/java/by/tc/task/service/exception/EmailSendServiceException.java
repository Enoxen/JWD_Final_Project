package by.tc.task.service.exception;

/**
 * Created by Y50-70 on 12.02.2018.
 */
public class EmailSendServiceException extends ServiceException {
    public EmailSendServiceException() {
    }

    public EmailSendServiceException(String message) {
        super(message);
    }

    public EmailSendServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailSendServiceException(Throwable cause) {
        super(cause);
    }
}
