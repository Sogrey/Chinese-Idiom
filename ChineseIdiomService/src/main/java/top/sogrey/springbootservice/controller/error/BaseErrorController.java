package top.sogrey.springbootservice.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统一错误处理
 * 
 * @author SOgrey
 *
 */
@Controller
@RequestMapping("/error")
public class BaseErrorController implements ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(BaseErrorController.class);

	@Override
	public String getErrorPath() {
		logger.info("程序出错");
		return "error/error";
	}

	@RequestMapping
	public String error(ModelMap map) {
		map.put("error", "错误信息是！！！！");
		return "error/error";
	}

}