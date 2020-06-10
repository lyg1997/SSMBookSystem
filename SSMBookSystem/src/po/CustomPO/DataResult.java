package po.CustomPO;


/**
 * @description: 调用服务 返回的状态码
 */

public class DataResult {

    private Integer status;
    private String message;
    private Object data;

    public DataResult(Integer status) {
        this.status = status;
    }

    public DataResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public DataResult(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static DataResult ok() {

        return new DataResult(200);
    }

    public static DataResult ok(Object data) {

        return new DataResult(200, data);
    }

    public static DataResult build(Integer status, String message) {
        return new DataResult(status, message);
    }
}
