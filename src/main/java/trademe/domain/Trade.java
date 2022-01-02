package trademe.domain;

public enum Trade {

    ELECTRICIAN("Electrician"), MASON("Mason"), PLUMBER("Plumber"), CARPENTER("Carpenter");

    private String job ;

    private Trade(String job) {
        this.job = job ;
    }

    public String getJob() {
        return  this.job ;
    }

}
