package br.com.piback.ecomerce.Domain;

public class StatusResponse {

    private String msg;
    private String status;

    public StatusResponse() {
        this.msg = "mensagem default";
        this.status = "status default";
    }

    public StatusResponse(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
