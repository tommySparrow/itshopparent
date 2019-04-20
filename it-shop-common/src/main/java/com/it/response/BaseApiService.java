package com.it.response;

import com.it.constans.BaseApiConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：返回信息封装类
 * @ throws
 */
public class BaseApiService {

    /**
     *
     * @methodDesc: 功能描述:(返回错误)
     * @param: @param
     *             msg
     * @param: @return
     */
    public Map<String, Object> setResultError(String msg) {
        return setResult(BaseApiConstants.HTTP_500_CODE, msg, null);
    }
    /**
     *
     * @methodDesc: 功能描述:(返回成功)
     * @param: @param
     *             msg
     * @param: @return
     */
    public Map<String, Object> setResultSuccessData(Object data) {
        return setResult(BaseApiConstants.HTTP_200_CODE, BaseApiConstants.HTTP_SUCCESS_NAME, data);
    }
    /**
     *
     * @methodDesc: 功能描述:(返回成功,无data)
     * @param: @param
     *             msg
     * @param: @return
     */
    public Map<String, Object> setResultSuccess() {
        return setResult(BaseApiConstants.HTTP_200_CODE, BaseApiConstants.HTTP_SUCCESS_NAME, null);
    }

    /**
     *
     * @methodDesc: 功能描述:(返回成功)
     * @param: @param
     *             msg
     * @param: @return
     */
    public Map<String, Object> setResultSuccess(String msg) {
        return setResult(BaseApiConstants.HTTP_200_CODE, msg, null);
    }

    /**
     *
     * @methodDesc: 功能描述:(自定义返回)
     * @param: @param
     *             code
     * @param: @param
     *             msg
     * @param: @param
     *             data
     * @param: @return
     */
    public Map<String, Object> setResult(Integer code, String msg, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put(BaseApiConstants.HTTP_CODE_NAME, code);
        result.put(BaseApiConstants.HTTP_200_NAME, msg);
        if (data != null) {
            result.put(BaseApiConstants.HTTP_DATA_NAME, data);
        }
        return result;
    }
}
