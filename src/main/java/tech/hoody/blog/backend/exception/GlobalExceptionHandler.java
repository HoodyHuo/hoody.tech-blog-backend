package tech.hoody.blog.backend.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.hoody.blog.backend.controller.RespWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
@Order(3)
class GlobalExceptionHandler {
//    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class)
    /**
     * 未知异常处理
     * @param request
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(value = ProjectException.class)
    public RespWrapper<String> handleProjectException(HttpServletRequest request, ProjectException e) {
        return new RespWrapper<>( 40000, e.getMessage());
    }

    /**
     * 处理参数映射异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public RespWrapper<String> handleProjectException(HttpServletRequest request, ConstraintViolationException e) {
        return new RespWrapper<String>( 40001,  e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public RespWrapper<String> handleRuntimeException(HttpServletRequest request, RuntimeException e) {
//        log.error("发生了未知运行时异常", e)
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        String msg = "URL:"+request.getRequestURI() + ",\n"
                +"params:"+request.getParameterMap().toString() + ",\n"
                +  " error:"+ e.getMessage();
        return new RespWrapper<>( 50001,  msg);
    }
    /**
     * 未知异常处理
     * @param request
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public RespWrapper<String> handleUnknownException(HttpServletRequest request, Exception e, Model model) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        String msg = "URL:"+request.getRequestURI() + ",\n"
                +"params:"+request.getParameterMap().toString() + ",\n"
                +  " error:"+ e.getMessage();
        return new RespWrapper<>( 50000,  msg);
    }

}
