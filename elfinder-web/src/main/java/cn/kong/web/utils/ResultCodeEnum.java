package cn.kong.web.utils;

/**
 * @author cjbi
 */
public enum ResultCodeEnum {

    OK(20000, "处理成功"),
    BAD_REQUEST(400, "请求参数有误"),
    UNAUTHORIZED(401, "未授权"),
    PARAMS_MISS(483, "缺少接口中必填参数"),
    PARAM_ERROR(484, "参数非法"),
    FAILED_DEL_OWN(485, "不能删除自己"),
    FAILED_USER_ALREADY_EXIST(486, "该用户已存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    NOT_IMPLEMENTED(501, "业务异常"),
	EXCEPTION(101, "异常");

    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
