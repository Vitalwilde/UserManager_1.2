package entity;

public enum UserProfiling {
    ISTEROID("Истероид"),
    EPILEPTOID("Эпилептоид"),
    PARANOID("Паранойальный"),
    EMOTIVE("Эмотивный"),
    SHIZOID("Шизоид"),
    HYPERTIM("Гипертим");

    private final String psychotype;

    UserProfiling(String psychotype) {
        this.psychotype= psychotype;
    }

    public String getPsychotype() {
        return psychotype;
    }
}
