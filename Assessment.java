class Assessment implements Keyable {
    private final String key;
    private final String grade;

    Assessment(String key, String value) {
        this.key = key;
        this.grade = value;
    }

    String getGrade() {
        return this.grade;
    }

    public String getKey() {
        return this.key;
    }

    public String toString() {
        return String.format("{%s: %s}", this.key, this.grade);
    }
}
