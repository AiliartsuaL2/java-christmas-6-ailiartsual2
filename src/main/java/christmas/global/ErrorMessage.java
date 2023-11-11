package christmas.global;

public enum ErrorMessage {
    INPUT_DAY_VALIDATION_EXCEPTION("유효하지 않은 날짜입니다.다시 입력해 주세요.");

    private static String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
