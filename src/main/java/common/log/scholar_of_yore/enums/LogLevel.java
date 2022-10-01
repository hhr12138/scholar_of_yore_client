package common.log.scholar_of_yore.enums;

public enum LogLevel {
    ERR("error"),WARN("warn"),INFO("info"),DEBUG("debug");
    private String level;

    LogLevel(String level) {
        this.level = level;
    }
    public String getLevel(){
        return this.level;
    }
}
