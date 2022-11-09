package ao.co.mapaDeBuraco.enums;


public enum CommentStatus {
    OPEN(0, "OPEN"),
    APPROVED(1, "APPROVED"),
    REMOVED(2, "REMOVED");

    private final Integer code;
    private final String description;

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private CommentStatus(int code, String description) {
        this.code = code;
        this.description = description;

   }

   public  static CommentStatus fromCode(Integer code) {
       if (code == null) {
           return null;
       }
        for (CommentStatus commentStatus : CommentStatus.values()) {
            if (commentStatus.getCode() == code) {
                return commentStatus;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
