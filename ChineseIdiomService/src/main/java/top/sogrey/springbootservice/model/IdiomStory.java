package top.sogrey.springbootservice.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 成语故事
 * @author Sogrey
 *
 */
@TableName(value = "table_idiom_story")
public class IdiomStory {
	@TableId(value = "id")
	private int id;
	@TableField(value = "word")
	private String word;
	@TableField(value = "story")
	private String story;
	public IdiomStory() {
		super();
	}
	public IdiomStory(int id, String word, String story) {
		super();
		this.id = id;
		this.word = word;
		this.story = story;
	}

	public int getId() {
		return id;
	}

	public IdiomStory setId(int id) {
		this.id = id;
		return this;
	}

	public String getWord() {
		return word;
	}

	public IdiomStory setWord(String word) {
		this.word = word;
		return this;
	}


	public String getStory() {
		return story;
	}

	public IdiomStory setStory(String story) {
		this.story = story;
		return this;
	}

	@Override
	public String toString() {
		return "IdiomStory [id=" + id + ", word=" + word + ", story=" + story + "]";
	}

}
