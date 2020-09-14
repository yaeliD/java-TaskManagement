package classes;

public class friends {
    private int code;
    private String fullName;
    private String email;

    public friends(int code, String fullName, String email) {
        this.code = code;
        this.setFullName(fullName);
        this.setEmail(email);
    }

    public friends() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.charAt('@')!=0&&email.charAt('@')!=-1&&!email.endsWith("@"))
           this.email = email;
        else{
            throw new IllegalArgumentException("wrong email");
        }
    }

    @Override
    public String toString() {
        return "full name: "+ this.getFullName()+" email: "+ this.getEmail();
    }
}
