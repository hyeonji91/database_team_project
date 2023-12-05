package utile;

import java.sql.Timestamp;

public class ArticleStruct {
	private int article_id, like_num;
	private String context, user_id;
	private Timestamp created_at;
	
	public ArticleStruct(int article_id, String context, Timestamp created_at, String user_id, int like_num){
		this.article_id=article_id;
		this.context=context;
		this.created_at=created_at;
		this.user_id=user_id;
		this.like_num=like_num;
	}

	public int getArticle_id() {
		return article_id;
	}

	public String getContext() {
		return context;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public String getUser_id() {
		return user_id;
	}
	
	public int getLike_num() {
		return like_num;
	}
}