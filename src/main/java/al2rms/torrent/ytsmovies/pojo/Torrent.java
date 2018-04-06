package al2rms.torrent.ytsmovies.pojo;

public class Torrent {

    private String url;
    private String hash;
    private String quality;
    private int seeds;
    private int peers;
    private String size;
    private String size_bytes;
    private String date_uploaded;
    private String date_uploaded_unix;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getSeeds() {
        return seeds;
    }

    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    public int getPeers() {
        return peers;
    }

    public void setPeers(int peers) {
        this.peers = peers;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize_bytes() {
        return size_bytes;
    }

    public void setSize_bytes(String size_bytes) {
        this.size_bytes = size_bytes;
    }

    public String getDate_uploaded() {
        return date_uploaded;
    }

    public void setDate_uploaded(String date_uploaded) {
        this.date_uploaded = date_uploaded;
    }

    public String getDate_uploaded_unix() {
        return date_uploaded_unix;
    }

    public void setDate_uploaded_unix(String date_uploaded_unix) {
        this.date_uploaded_unix = date_uploaded_unix;
    }
}
