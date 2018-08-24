package com.biz.exception;

import com.biz.pojo.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@ControllerAdvice
@RestControllerAdvice
public class MyExceptionHandler {

	public static final String IMOOC_ERROR_VIEW = "error";

	/*@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
    		HttpServletResponse response, Exception e) throws Exception {

    	e.printStackTrace();

		ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", reqest.getRequestURL());
        mav.setViewName(IMOOC_ERROR_VIEW);
        return mav;
    }*/
	
	@ExceptionHandler(value = Exception.class )
    public Object errorHandler(HttpServletRequest reqest,
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
		if (isAjax(reqest)) {
			System.out.println("-------------isAjax-----------------");
			return JSONResult.errorException(e.getMessage());
		} else {
			System.out.println("---------------isNotAjax---------------");
			ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
    	}
    }
	
	/**
	 * @Description: 判断是否是ajax请求
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}
}
