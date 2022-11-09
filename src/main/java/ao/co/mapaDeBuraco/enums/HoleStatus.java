package ao.co.mapaDeBuraco.enums;

import lombok.Getter;

import java.util.Objects;


public enum HoleStatus {

    OPEN(0, "OPEN"),
    IN_WORKS(1, "IN_WORKS"),
    COVERED(2, "COVERED");

    private final Integer code;
    private final String description;

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private HoleStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public  static HoleStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (HoleStatus holeStatus : HoleStatus.values()) {
            if (Objects.equals(holeStatus.getCode(), code)) {
                return holeStatus;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
