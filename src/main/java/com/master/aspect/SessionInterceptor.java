package com.master.aspect;

import com.alibaba.fastjson2.JSONObject;
import com.master.annotation.AccessLimit;
import com.master.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * SessionInterceptor
 * </p>
 * TODO
 *
 * @author MDX
 * @since 2023/4/12 15:02
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (null == accessLimit) {
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean needLogin = accessLimit.needLogin();

            if (needLogin) {
                //判断是否登录
            }
            String ip = request.getRemoteAddr();
            String key = request.getServletPath() + ":" + ip;
            Integer count = (Integer) redisTemplate.opsForValue().get(key);

            if (null == count || -1 == count) {
                redisTemplate.opsForValue().set(key, 1, seconds, TimeUnit.SECONDS);
                return true;
            }

            if (count < maxCount) {
                count = count + 1;
                redisTemplate.opsForValue().set(key, count, 0);
                return true;
            }

            if (count >= maxCount) {
//                response 返回 json 请求过于频繁请稍后再试


                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                Response<Object> result = new Response<>();
                result.setCode("9999");
                result.setMsg("操作过于频繁,请稍后再提交");
                Object obj = JSONObject.toJSONString(result);
                response.getWriter().write(JSONObject.toJSONString(obj));


                return false;
            }
        }

        return true;
    }
}
