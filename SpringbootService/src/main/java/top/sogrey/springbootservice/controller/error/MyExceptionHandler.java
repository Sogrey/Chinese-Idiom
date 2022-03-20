package top.sogrey.springbootservice.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 运行异常捕获
 * 
 * @author: Sogrey
 */
@ControllerAdvice
public class MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

	@ExceptionHandler( RuntimeException.class )
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(RuntimeException exception) {
		logger.info("运行时异常");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myException", exception.getMessage());
		modelAndView.setViewName("/error/500");
		return modelAndView;
	}

	/**
	 * 统一异常处理
	 *
	 * @param exception exception
	 * @return
	 */
	@ExceptionHandler( Exception.class )
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processException(Exception exception) {
		logger.info("异常");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myException", exception.getMessage());
		modelAndView.setViewName("error/500");
		return modelAndView;
	}

}