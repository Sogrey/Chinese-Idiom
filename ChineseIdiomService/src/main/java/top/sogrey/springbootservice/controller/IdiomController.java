package top.sogrey.springbootservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.sogrey.springbootservice.dao.IdiomAllusionMapper;
import top.sogrey.springbootservice.dao.IdiomMapper;
import top.sogrey.springbootservice.dao.IdiomStoryMapper;
import top.sogrey.springbootservice.model.Idiom;
import top.sogrey.springbootservice.model.IdiomStory;
import top.sogrey.springbootservice.model.idiomAllusion;
import top.sogrey.springbootservice.model.response.BaseResult;
import top.sogrey.springbootservice.model.response.StandardResult;

/**
 * 通过Mybatis Plus查询数据
 * 
 * @author Sogrey
 *
 */
@RestController
@RequestMapping("/idiom")
public class IdiomController {
	@Autowired
	private IdiomMapper idiomMapper;
	@Autowired
	private IdiomStoryMapper idiomStoryMapper;
	@Autowired
	private IdiomAllusionMapper idiomAllusionMapper;

	/**
	 * 根据Id查询数据
	 * 
	 * @example http://localhost:10119/idiom/queryById?id=17074
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryById", method = RequestMethod.GET)
	public BaseResult queryById(@RequestParam("id") int id) {
		try {
			Idiom idiom = idiomMapper.selectById(id);

			StandardResult<Idiom> result = new StandardResult<>(0, "queryById:查询成功。");
			if (idiom != null) {
				result.setData(idiom);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "queryById，操作失败:" + e.getMessage());
		}
	}

	/**
	 * 根据成语 查询数据
	 * 
	 * @example http://localhost:10119/idiom/queryByWord?word=七上八下
	 * 
	 * @param word
	 * @return
	 */
	@RequestMapping(value = "/queryByWord", method = RequestMethod.GET)
	public BaseResult queryByWord(@RequestParam("word") String word) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("word", word);
			List<Idiom> allIdioms = idiomMapper.selectByMap(params);

			StandardResult<Idiom> result = new StandardResult<>(0, "queryByWord:查询成功。");
			result.addDatas(allIdioms);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "queryByWord，操作失败:" + e.getMessage());
		}
	}
	
	/**
	 * 根据关键词模糊查找成语
	 * 
	 * @example http://localhost:10119/idiom/fuzzyQueryByWord?word=朝三
	 * @param word
	 * @return
	 */
	@RequestMapping(value = "/fuzzyQueryByWord", method = RequestMethod.GET)
	public BaseResult fuzzyQueryByWord(@RequestParam("word") String word) {
		try {
			List<Idiom> allIdioms = idiomMapper.fuzzyQueryByWord(word);

			StandardResult<Idiom> result = new StandardResult<>(0, "fuzzyQueryByWord:查询成功。");
			result.addDatas(allIdioms);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "fuzzyQueryByWord，操作失败:" + e.getMessage());
		}
	}
	
	/**
	 * 随机查询指定条数条目
	 * 
	 * @example http://localhost:10119/idiom/randomQuery?limit=1
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/randomQuery", method = RequestMethod.GET)
	public BaseResult randomQuery(@RequestParam("limit") String limit) {
		try {
			List<Idiom> allIdioms = idiomMapper.randomQuery(limit);

			StandardResult<Idiom> result = new StandardResult<>(0, "randomQuery:查询成功。");
			result.addDatas(allIdioms);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "randomQuery，操作失败:" + e.getMessage());
		}
	}
	
	
	// 修复拼音，数据清洗
	@RequestMapping(value = "/pinyinRepair", method = RequestMethod.GET)
	public BaseResult pinyinRepair() {
		try {
			List<Idiom> allIdioms = idiomMapper.selectList(null);
			StandardResult<Idiom> result = new StandardResult<Idiom>(0, "queryAll:查询成功。");
			if(allIdioms.size()>0) {
				for (int i = 0; i < allIdioms.size(); i++) {
					Idiom idiom = allIdioms.get(i);
					idiom.settPinyin(idiom.gettPinyin());
					
					idiomMapper.updateById(idiom);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "queryAll,操作失败:" + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/idUpdate", method = RequestMethod.GET)
	public BaseResult idUpdate(int id,int id2) {
		try {
			Idiom idiom = idiomMapper.selectById(id);
			Idiom idiom2 = idiomMapper.selectById(id2);
			// idiom <=== idiom2
			idiom2.setId(idiom.getId());
			idiomMapper.updateById(idiom2);
			idiomMapper.deleteById(id2);
			StandardResult<Idiom> result = new StandardResult<Idiom>(0, "queryAll:查询成功。");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "queryAll,操作失败:" + e.getMessage());
		}
	}
	
	/**
	 * 根据成语 查询数据
	 * 
	 * @example http://localhost:10119/idiom/queryStoryByWord?word=朝三暮四
	 * 
	 * @param word
	 * @return
	 */
	@RequestMapping(value = "/queryStoryByWord", method = RequestMethod.GET)
	public BaseResult queryStoryByWord(@RequestParam("word") String word) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("word", word);
			List<IdiomStory> allIdioms = idiomStoryMapper.selectByMap(params);

			StandardResult<IdiomStory> result = new StandardResult<>(0, "queryStoryByWord:查询成功。");
			result.addDatas(allIdioms);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "queryStoryByWord，操作失败:" + e.getMessage());
		}
	}
	
	/**
	 * 根据成语 查询数据
	 * 
	 * @example http://localhost:10119/idiom/queryAllusionByWord?word=朝三暮四
	 * 
	 * @param word
	 * @return
	 */
	@RequestMapping(value = "/queryAllusionByWord", method = RequestMethod.GET)
	public BaseResult queryAllusionByWord(@RequestParam("word") String word) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("word", word);
			List<idiomAllusion> allIdioms = idiomAllusionMapper.selectByMap(params);

			StandardResult<idiomAllusion> result = new StandardResult<>(0, "queryAllusionByWord:查询成功。");
			result.addDatas(allIdioms);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "queryAllusionByWord，操作失败:" + e.getMessage());
		}
	}

	/**
	 * 查询所有数据
	 * 
	 * @example http://localhost:10119/idiom/queryAll
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryAll", method = RequestMethod.GET)
	public BaseResult queryAll() {
		try {
			List<Idiom> allIdioms = idiomMapper.selectList(null);
			StandardResult<Idiom> result = new StandardResult<Idiom>(0, "queryAll:查询成功。");
			result.setDatas(allIdioms);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseResult(1, "queryAll,操作失败:" + e.getMessage());
		}
	}
}
