package top.sogrey.springbootservice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import top.sogrey.springbootservice.model.Idiom;

/**
 * @author Sogrey
 * @data 2022/3/12
 */
@Mapper
public interface IdiomMapper extends BaseMapper<Idiom> {

//	@Select("select * from user where id = #{id}")
//	User selectUserById(@Param("id") Integer id);

	@SelectProvider(type = IdiomDaoProvider.class, method = "fuzzyQueryByWord")
	List<Idiom> fuzzyQueryByWord(String word);

	/**
	 * The type Idiom dao provider.
	 */
	class IdiomDaoProvider {
		/**
		 * 模糊查询成语
		 * 
		 * @param word 成语或部分关键词
		 * @return 返回所有符合匹配条件的条目
		 */
		public String fuzzyQueryByWord(String word) {
			String sql = "SELECT * FROM table_idiom";
			if (!StringUtils.isEmpty(word)) {
				sql += " WHERE word LIKE '%" + word + "%'";
			}
			return sql;
		}
	}

}
