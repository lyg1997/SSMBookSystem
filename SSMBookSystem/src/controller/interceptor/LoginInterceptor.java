package controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import po.ActiveAdmin;
import po.ActiveUser;
import utils.ResourcesUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户身份拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //在执行handler之前来执行的
    //用于用户认证校验、用户权限校验
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //得到请求的url
        String url = request.getRequestURI();
        //判断公开地址
        //实际开发中需要公开的地址在配置文件中
        //从配置文件中取出匿名访问的url
        List<String> open_urls = ResourcesUtil.gekeyList("anonymousURL");

        //遍历公开地址。如果访问的是公开地址就放行
        for (String open_url : open_urls) {
            if (open_url.equals(url)) {
//            如果是公开地址，则放行
                return true;
            }
        }

        //        从配置文件中取出公共访问地址
        List<String> adminCommon_urls = ResourcesUtil.gekeyList("AdmincommonURL");
//        遍历公用地址，如果是公用地址则放行
        for (String common_url : adminCommon_urls) {
            if (common_url.equals(url)) {
                //判断用户身份在session中是否存在
                HttpSession session = request.getSession();
                ActiveAdmin activeAdmin = new ActiveAdmin();
                activeAdmin = (ActiveAdmin) session.getAttribute("activeAdmin");
                //如果用户的身份在session中存在
                if (activeAdmin != null) {
                    return true;
                }
            }
        }

        //        从配置文件中取出公共访问地址
        List<String> userCommon_urls = ResourcesUtil.gekeyList("UsercommonURL");
//        遍历公用地址，如果是公用地址则放行
        for (String common_url : userCommon_urls) {
            if (common_url.equals(url)) {
                //判断用户身份在session中是否存在
                HttpSession session = request.getSession();
                ActiveUser activeUser = new ActiveUser();
                activeUser = (ActiveUser) session.getAttribute("activeUser");
                //如果用户的身份在session中存在
                if (activeUser != null) {
                    return true;
                }
            }
        }
        //执行到这里，进行拦截，跳转到登陆页面，用户进行身份验证
        request.setAttribute("msg", "非法访问！");
        request.setAttribute("url", "/login.action");
        request.getRequestDispatcher("/WEB-INF/jsp/user/error.jsp").forward(request, response);
        return false;
    }

    //在执行handler返回modelAndView之前来执行
    //如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现 从modelAndView入手
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    //执行handler之后执行此方法
    //作系统 统一异常处理，进行方法执行性能监控，在preHandle中设置一个时间点，在afterCompletion设置一个时间，两个时间点的差就是执行时长
    //实现 系统 统一日志记录
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
