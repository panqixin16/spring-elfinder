package cn.kong.web.utils;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cjbi@outlook.com
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private int code;

    private String msg;

    private T data;

    private Map<String, Object> extra;

    public Result<T> addExtraIfTrue(boolean val, String key, Object value) {
        if (val) {
            addExtra(key, value);
        }
        return this;
    }

    public Result<T> addExtra(String key, Object value) {
        extra = extra == null ? new HashMap<>(16) : extra;
        extra.put(key, value);
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public Result<T> setExtra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public static <T> Result<T> success() {
        return Result.success(null);
    }

    public static Result failure(ResultCodeEnum resultCodeEnum) {
        return new Result()
                .setSuccess(false)
                .setCode(resultCodeEnum.getCode())
                .setMsg(resultCodeEnum.getMsg());
    }

    public static <T> Result<T> success(T obj) {
        return new Result()
                //为null统一给前端{}
                .setData(obj == null ? Collections.EMPTY_MAP : obj)
                .setCode(ResultCodeEnum.OK.getCode())
                .setMsg(ResultCodeEnum.OK.getMsg())
                .setSuccess(true);
    }

}
