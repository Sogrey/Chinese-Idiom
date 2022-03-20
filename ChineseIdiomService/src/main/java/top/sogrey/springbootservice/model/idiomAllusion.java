package top.sogrey.springbootservice.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 成语典故
 * @author Sogrey
 *
 */
@TableName(value = "table_idiom_allusion")
public class idiomAllusion {
	@TableId(value = "id")
	private int id;
	@TableField(value = "word")
	private String word;
	@TableField(value = "allusion")
	private String allusion;
	public idiomAllusion() {
		super();
	}
	public idiomAllusion(int id, String word, String allusion) {
		super();
		this.id = id;
		this.word = word;
		this.allusion = allusion;
	}

	public int getId() {
		return id;
	}

	public idiomAllusion setId(int id) {
		this.id = id;
		return this;
	}

	public String getWord() {
		return word;
	}

	public idiomAllusion setWord(String word) {
		this.word = word;
		return this;
	}

	public String getAllusion() {
		return allusion;
	}

	public idiomAllusion setAllusion(String allusion) {
		this.allusion = allusion;
		return this;
	}
	@Override
	public String toString() {
		return "idiomAllusion [id=" + id + ", word=" + word + ", allusion=" + allusion + "]";
	}

}
