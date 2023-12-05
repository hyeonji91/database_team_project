package utile;

import java.sql.Timestamp;

public class CommentStruct {
	private int comment_id,article_id, group_num,hierarchy;
	private String context, user_id;
	private Timestamp create_at;
	
	public CommentStruct(int comment_id,int article_id, int group_num, int hierarchy, Timestamp create_at, String context, String user_id){
		this.comment_id=comment_id;
		this.article_id=article_id;
		this.group_num = group_num;
		this.hierarchy=hierarchy;
		this.create_at=create_at;
		this.context=context;
		this.user_id=user_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public int getGroup_num() {
		return group_num;
	}
	public int getHierarchy() {
		return hierarchy;
	}

	public Timestamp getCreate_at() {
		return create_at;
	}

	public String getContext() {
		return context;
	}

	public String getUser_id() {
		return user_id;
	}
}
