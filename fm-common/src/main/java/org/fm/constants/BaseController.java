package org.fm.constants;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.api.R;
import org.fm.bean.ResponseBean;
import org.fm.bean.ResponseEnum;
import org.fm.util.CamelCaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * author: GuoQing
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 请求成功
     *
     * @param <T>  对象泛型
     * @param data 数据内容
     * @return ignore
     */
    protected <T> ResponseBean<T> success(T data) {
        return ResponseBean.success(data);
    }

    /**
     * 请求失败
     *
     * @param msg 提示内容
     * @return ignore
     */
    protected <T> ResponseBean<T> failed(String msg) {
        return ResponseBean.error(ResponseEnum.INCORRECT_PARAMS.getCode(),msg);
    }

    /**
     * 请求失败
     *
     * @param errorCode 请求错误码
     * @return ignore
     */
    protected <T> R<T> failed(IErrorCode errorCode) {
        return R.failed(errorCode);
    }



    public HashMap<String, Object> buildFilter(HttpServletRequest request) {
        Map<?, ?> filter = request.getParameterMap();
        HashMap<String, Object> filters = new HashMap<String, Object>();
        filters = (HashMap<String, Object>) copyQueryMap(filter, filters);
        return filters;
    }

    /**
     * 取得查询条件
     *
     * @param filter
     * @param queryMap
     */
    public static Map<String, Object> copyQueryMap(Map<?, ?> filter, Map<String, Object> queryMap) {
        for (Map.Entry<?, ?> entry : filter.entrySet()) {
            String[] value = (String[]) entry.getValue();
            if (value != null && !"".equals(value[0]) && !" ".equals(value[0])) {
                queryMap.put(entry.getKey().toString(), value[0].trim());
            }
        }
        return queryMap;
    }

    /**
     * 取得查询条件(驼峰转下划线)
     * @param request
     * @return
     */
    public HashMap<String, Object> buildFilter2(HttpServletRequest request) {
        Map<?, ?> filter = request.getParameterMap();
        HashMap<String, Object> filters = new HashMap<String, Object>();
        filters = (HashMap<String, Object>) copyQueryMap(filter, filters);
        return filters;
    }

    /**
     * 取得查询条件(驼峰转下划线)
     *
     * @param filter
     * @param queryMap
     */
    public static Map<String, Object> copyQueryMap2(Map<?, ?> filter, Map<String, Object> queryMap) {
        for (Map.Entry<?, ?> entry : filter.entrySet()) {
            String[] value = (String[]) entry.getValue();
            if (value != null && !"".equals(value[0]) && !" ".equals(value[0])) {
                queryMap.put(CamelCaseUtil.toUnderlineName(entry.getKey().toString()), value[0].trim());
            }
        }
        return queryMap;
    }


    /**
     * 同一天日期比较 B2B AND B2C
     *
     * @param maps
     */
    public static Map<String, Object> String2Date(Map<String, Object> maps) {
        Map<String, Object> newMaps = new HashMap<String, Object>();
        for (Map.Entry<String, Object> item : maps.entrySet()) {
            String key = item.getKey().toLowerCase();
            if (key.contains("end") && key.contains("time")) {
                String endTime = item.getValue().toString();
                if (!endTime.contains("23:59:59")) {
                    endTime = endTime + " 23:59:59";
                }
                newMaps.put(item.getKey(), endTime);
            } else if (key.contains("start") && key.contains("time")) {
                String startTime = item.getValue().toString();
                if (!startTime.contains("00:00:00")) {
                    startTime = startTime + " 00:00:00";
                }
                newMaps.put(item.getKey(), startTime);
            } else {
                newMaps.put(item.getKey(), item.getValue());
            }

        }
        return newMaps;
    }

    protected String dateFormat(Object object) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	return sdf.format(object);
	}
    
    protected String dateFormatHS(Object object) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return sdf.format(object);
	}
}
