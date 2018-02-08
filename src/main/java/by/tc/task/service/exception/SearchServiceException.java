package by.tc.task.service.exception;

/**
 * Created by Y50-70 on 08.02.2018.
 */
public class SearchServiceException extends ServiceException {
    public SearchServiceException() {
    }

    public SearchServiceException(String message) {
        super(message);
    }

    public SearchServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchServiceException(Throwable cause) {
        super(cause);
    }
}
