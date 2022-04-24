package iam.doky.thejavatest;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    public Study(int limit) {
        if ( limit < 0 ) {
            throw new IllegalArgumentException("limit은 0이상 이어야 한다.");
        }
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
