package classes;

public class implementFriend extends friends {
    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    private int rating;

    public implementFriend(int code, String fullName, String email,int rating) {
        super(code, fullName, email);
        this.rating=rating;
    }
}
