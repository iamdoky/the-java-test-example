package iam.doky.thejavatest;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    public Study(int limit) {
        this.limit = limit;
    }

    public StudyStatus getStatus() {

        return this.status;
    }

    public int limit() {
        return limit;
    }

    public Study setLimit(int limit) {
        this.limit = limit;
        return this;
    }
}
