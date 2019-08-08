package oldtraining.domain;

public class RootUser {
    private String rname;
    private String rpwd;

    public RootUser(String runame, String rpwd) {
        this.rname = runame;
        this.rpwd = rpwd;
    }

    public String getRuname() {
        return rname;
    }

    public void setRuname(String runame) {
        this.rname = runame;
    }

    public String getRpwd() {
        return rpwd;
    }

    public void setRpwd(String rpwd) {
        this.rpwd = rpwd;
    }

    @Override
    public String toString() {
        return "RootUser{" +
                "runame='" + rname + '\'' +
                ", rpwd='" + rpwd + '\'' +
                '}';
    }
}
