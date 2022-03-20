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
	@TableField(value = "pingyin")
	private String pingyin;
	@TableField(value = "explanation")
	private String explanation;
	@TableField(value = "source")
	private String source;
	@TableField(value = "tPintin")
	private String tPintin;
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

	public String getPingyin() {
		return pingyin;
	}

	public Idiom setPingyin(String pingyin) {
		this.pingyin = pingyin;
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

	public String gettPintin() {
		return tPintin;
	}

	public Idiom settPintin(String tPintin) {
		this.tPintin = tPintin;
		String[] tPintinArray = tPintin.split(" ");
		this.abbreviation = "";
		for (String string : tPintinArray) {
			this.abbreviation += string.substring(0, 1);
		}
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
		return "Idiom [id=" + id + ", word=" + word + ", length=" + length + ", pingyin=" + pingyin + ", explanation="
				+ explanation + ", source=" + source + ", tPintin=" + tPintin + ", abbreviation=" + abbreviation
				+ ", firstWordPinyin=" + firstWordPinyin + ", lastWordPinyin=" + lastWordPinyin + ", firstchar="
				+ firstchar + ", lastchar=" + lastchar + "]";
	}

}
