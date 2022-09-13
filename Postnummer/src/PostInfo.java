public class PostInfo {

    private String postNummer;
    private String by;

    PostInfo(String postNummer, String by){
        this.postNummer = postNummer;
        this.by = by;
    }

    public String getPostNummer() {
        return postNummer;
    }

    public void setPostNummer(String postNummer) {
        this.postNummer = postNummer;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String toString() {
        return "Postnummer: " + postNummer + ", By: " + by;
    }
}
