package top.sogrey.springbootservice.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 成语详情
 * 
 * @author Sogrey
 *
 */
@TableName(value = "table_idiom")
public class Idiom {
	@TableId(value = "id")
	private int id;
	@TableField(value = "word")
	private String word;
	@TableField(value = "length")
	private int length;
	@TableField(value = "pinyin")
	private String pinyin;
	@TableField(value = "explanation")
	private String explanation;
	@TableField(value = "source")
	private String source;
	@TableField(value = "tPinyin")
	private String tPinyin;
	@TableField(value = "abbreviation")
	private String abbreviation;
	@TableField(value = "firstWordPinyin")
	private String firstWordPinyin;
	@TableField(value = "lastWordPinyin")
	private String lastWordPinyin;
	@TableField(value = "firstchar")
	private String firstchar;
	@TableField(value = "lastchar")
	private String lastchar;

	public Idiom() {
		super();
	}

	public String getFirstchar() {
		return firstchar;
	}

	public Idiom setFirstchar(String firstchar) {
		this.firstchar = firstchar;
		return this;
	}

	public String getLastchar() {
		return lastchar;
	}

	public Idiom setLastchar(String lastchar) {
		this.lastchar = lastchar;
		return this;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public Idiom setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}

	public int getId() {
		return id;
	}

	public Idiom setId(int id) {
		this.id = id;
		return this;
	}

	public String getWord() {
		return word;
	}

	public Idiom setWord(String word) {
		this.word = word;
		this.firstchar = word.substring(0, 1);
		this.lastchar = word.substring(word.length() - 1, word.length());

		return this;
	}

	public int getLength() {
		return length;
	}

	public Idiom setLength(int length) {
		this.length = length;
		return this;
	}

	public String getpinyin() {
		return pinyin;
	}

	public Idiom setpinyin(String pinyin) {
		this.pinyin = pinyin;
		return this;
	}

	public String getExplanation() {
		return explanation;
	}

	public Idiom setExplanation(String explanation) {
		this.explanation = explanation;
		return this;
	}

	public String getSource() {
		return source;
	}

	public Idiom setSource(String source) {
		this.source = source;
		return this;
	}

	public String gettPinyin() {
		return tPinyin;
	}

	public Idiom settPinyin(String tPinyin) {
		this.tPinyin = tPinyin;
		System.out.println(tPinyin);
		String[] tPinyinArray = tPinyin.replaceAll("，", " ").replaceAll(",", " ").split(" ");
		this.abbreviation = "";
		for (String string : tPinyinArray) {
			if(string.length()>0)
			this.abbreviation += string.trim().substring(0, 1);
		}
		this.setFirstWordPinyin(tPinyinArray[0]);
		this.setLastWordPinyin(tPinyinArray[tPinyinArray.length-1]);
		return this;
	}

	public String getFirstWordPinyin() {
		return firstWordPinyin;
	}

	public Idiom setFirstWordPinyin(String firstWordPinyin) {
		this.firstWordPinyin = firstWordPinyin;
		return this;
	}

	public String getLastWordPinyin() {
		return lastWordPinyin;
	}

	public Idiom setLastWordPinyin(String lastWordPinyin) {
		this.lastWordPinyin = lastWordPinyin;
		return this;
	}

	@Override
	public String toString() {
		return "Idiom [id=" + id + ", word=" + word + ", length=" + length + ", pinyin=" + pinyin + ", explanation="
				+ explanation + ", source=" + source + ", tPinyin=" + tPinyin + ", abbreviation=" + abbreviation
				+ ", firstWordPinyin=" + firstWordPinyin + ", lastWordPinyin=" + lastWordPinyin + ", firstchar="
				+ firstchar + ", lastchar=" + lastchar + "]";
	}

}
