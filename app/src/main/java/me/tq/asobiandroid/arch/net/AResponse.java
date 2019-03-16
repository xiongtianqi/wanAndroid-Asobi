package me.tq.asobiandroid.arch.net;

public class AResponse<T> {

    private int errorCode;
    private String errorMessage;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "errorCode = "+errorCode+
                "errorMessage = "+errorMessage+
                "data = "+data;
    }
}
