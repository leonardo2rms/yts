package al2rms.torrent.ytsmovies.pojo;

public class YtsResponse {

    private String status;
    private String status_message;
    private DataYts data;

    public DataYts getData() {
        return data;
    }

    public void setData(DataYts data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    @Override
    public String toString() {
        return "YtsResponse{" +
                "status='" + status + '\'' +
                ", status_message='" + status_message + '\'' +
                '}';
    }
}
