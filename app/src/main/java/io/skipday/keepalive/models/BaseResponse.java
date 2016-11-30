package io.skipday.keepalive.models;

/**
 * Created by jagamypriera on 28/11/16.
 */

public class BaseResponse {
    private String result,message;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
