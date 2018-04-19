public class Status {
    /*200: "OK"
            201: "Created"
            202: "Accepted"
            203: "Non-Authoritative Information"
            204: "No Content"
            205: "Reset Content"
            206: "Partial Content"*/
    private int code;

    public Status(int code) {
        this.code = code;
    }
}
