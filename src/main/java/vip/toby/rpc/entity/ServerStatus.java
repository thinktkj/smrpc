package vip.toby.rpc.entity;

import com.alibaba.fastjson2.JSONObject;

/**
 * rpc调用状态码
 *
 * @author toby
 */
public enum ServerStatus {

    // 调用成功
    SUCCESS(1, "Call Success"),
    // 调用失败
    FAILURE(0, "Call Failure"),
    // 调用不存在
    NOT_EXIST(-1, "Service Not Exist"),
    // 调用超时, 服务不可用
    UNAVAILABLE(-2, "Service Unavailable");

    private final int status;
    private final String message;

    ServerStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static ServerStatus getServerStatus(Integer status) {
        if (status == null) {
            return FAILURE;
        }
        for (ServerStatus e : ServerStatus.values()) {
            if (e.status == status) {
                return e;
            }
        }
        return FAILURE;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("status", this.status);
        json.put("message", this.message);
        return json;
    }

}
