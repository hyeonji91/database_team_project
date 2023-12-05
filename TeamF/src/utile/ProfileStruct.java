package utile;

public class ProfileStruct {
	private int follower, following;
	private String nickname, info, user_id, profile_img;
	
	public ProfileStruct(int follower, int following, String nickname, String info, String user_id, String profile_img){
		this.follower=follower;
		this.following=following;
		this.nickname=nickname;
		this.info=info;
		this.user_id=user_id;
		this.profile_img=profile_img;
	}

	public int getFollower() {
		return follower;
	}

	public int getFollowing() {
		return following;
	}

	public String getNickname() {
		return nickname;
	}

	public String getInfo() {
		return info;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getProfile_img() {
		return profile_img;
	}
}
