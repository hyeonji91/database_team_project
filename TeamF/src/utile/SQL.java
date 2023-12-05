package utile;

import java.sql.Timestamp;
import java.sql.*;
import java.util.*;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class SQL {
	private Connection con=null;
	public SQL (){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/instagram";
	        String user = "root", passwd = "0429";
	        con = DriverManager.getConnection(url, user, passwd);
	        System.out.println(con);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Done
	public boolean checkPassword(String ID, String PW) {
		boolean isRight=false;
		
		Statement stmt=null;
		ResultSet result=null; 
		String query = "SELECT password From user WHERE user_id = \""+ID+"\"";
		try {
			stmt=con.createStatement();
			result = stmt.executeQuery(query);
			
			result.next();
			if(!result.wasNull()){
				if(result.getString(1).equals(PW)) {
					isRight=true;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			return false;
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(result !=null && !result.isClosed())result.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isRight;
	}

	//Done
	public boolean createUser(UserStruct newUser, String nickname) {
		boolean isFinish= false;
		PreparedStatement pstmtToUser = null;
		PreparedStatement pstmtToProfile = null;
		try {
			String queryToUser = "INSERT INTO user VALUE (?,?,?,?,?,?,?)";
			String queryToProfile = "INSERT INTO profile VALUE (?,?,?,?,?,?)";
			
			pstmtToUser = con.prepareStatement(queryToUser);
			pstmtToProfile = con.prepareStatement(queryToProfile);
			
			pstmtToUser.setString(1, newUser.getUser_id());
			pstmtToUser.setString(2, newUser.getName());
			pstmtToUser.setString(3, newUser.getPassword());
			pstmtToUser.setString(4, newUser.getBirth());
			pstmtToUser.setString(5, newUser.getGender());
			pstmtToUser.setString(6, newUser.getPhone_number());
			pstmtToUser.setString(7, newUser.getAddress());
			
			pstmtToProfile.setString(1, nickname);
			pstmtToProfile.setInt(2, 0);
			pstmtToProfile.setInt(3,0);
			pstmtToProfile.setString(4, null);
			pstmtToProfile.setString(5,newUser.getUser_id());
			pstmtToProfile.setString(6,"https://github.com/hyeonji91/database_team_project/assets/150224614/db46612d-11d0-43a1-be36-6fc33e6497ff");
		
			int toUser = pstmtToUser.executeUpdate();
			int toProfile = pstmtToProfile.executeUpdate();
			
			if(toUser==1 && toProfile==1) {
				isFinish=true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmtToUser !=null && !pstmtToUser.isClosed())pstmtToUser.close();
			if(pstmtToProfile !=null&& !pstmtToProfile.isClosed())pstmtToProfile.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isFinish;
	}
	
	//Done
	public String getNickname(String user_id) {
		String result = null;
		
		Statement stmt=null;
		ResultSet rs=null; 
		String query = "SELECT nickname from profile where user_id =\""+user_id+"\"";
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			result = rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Done
	public String getImage(int article_id) {
		String result = null;
		
		Statement stmt=null;
		ResultSet rs=null; 
		String query = "SELECT URL from image where article_id = "+article_id;
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			if(!rs.wasNull())
				result = rs.getString(1);
			else
				result = "https://mblogthumb-phinf.pstatic.net/MjAyMDA5MDNfMjk0/MDAxNTk5MTI1ODQzMTAy.vvvvkfj2ujzZx1TXfyHk6lcXsyWuptP1OcRUXfUnYUcg.tUDit1T4ppM07McaG4-8g1Uc3TRSOeQwGhQ79bRtjqkg.PNG.shshspdla/16%EB%8C%8010.png?type=w800";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e ) {
			result = "https://mblogthumb-phinf.pstatic.net/MjAyMDA5MDNfMjk0/MDAxNTk5MTI1ODQzMTAy.vvvvkfj2ujzZx1TXfyHk6lcXsyWuptP1OcRUXfUnYUcg.tUDit1T4ppM07McaG4-8g1Uc3TRSOeQwGhQ79bRtjqkg.PNG.shshspdla/16%EB%8C%8010.png?type=w800";
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//Done
	public String getProfileImg(String user_id) {
		String result = null;
		
		Statement stmt=null;
		ResultSet rs=null; 
		String query = "SELECT profile_img from profile where user_id =\""+user_id+"\"";
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			result = rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Done
	public ArticleStruct[] loadArticle(String User_id) {
		int len=findFollowing(User_id).length;
		String[] user_list = new String[len];
		user_list=findFollowing(User_id);
		int num=0;
				
		Statement stmt = null;
		ResultSet rs = null;
		String query=null;
		
		ArrayList<Integer> article_id= new ArrayList<>();
		ArrayList<Integer> like_num=new ArrayList<>();
		ArrayList<String> context=new ArrayList<>();
		ArrayList<Timestamp> created_at=new ArrayList<>();
		ArrayList<String>user_id=new ArrayList<>();
		
		try {
			stmt=con.createStatement();
			
			query="select * from article where user_id = " + "\""+User_id+"\"";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				article_id.add(rs.getInt(1));
				like_num.add(rs.getInt(2));
				context.add(rs.getString(3));
				created_at.add(rs.getTimestamp(4));
				user_id.add(rs.getString(5));
				num+=1;
			}
			
			for(int i=0;i<len;i++) {
				query="select * from article where user_id = " + "\""+user_list[i]+"\"";
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					article_id.add(rs.getInt(1));
					like_num.add(rs.getInt(2));
					context.add(rs.getString(3));
					created_at.add(rs.getTimestamp(4));
					user_id.add(rs.getString(5));
					num+=1;
				}
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		ArticleStruct[] result = new ArticleStruct[num];
		for(int i=0;i<num;i++) {
			result[i]=new ArticleStruct(article_id.get(i), context.get(i),created_at.get(i),user_id.get(i),like_num.get(i));
		}	
		
		return result;
	}
	
	//Done
	public String[] findFollower(String User_id) {
		ArrayList<String> list = new ArrayList<>();
		int i=0;
		
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT distinct follower_id from follow where following_id = \""+User_id+"\"";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				if(!rs.wasNull()) {
					list.add(rs.getString(1));
					i++;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		String[] result = new String[i];
		for(int j=0;j<result.length;j++) {
			result[j]=new String();
			result[j]=list.get(j);
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Done
	public String[] findFollowing(String User_id){
		ArrayList<String> list = new ArrayList<>();
		int i=0;
		
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT distinct following_id from follow where follower_id = \""+User_id+"\"";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				if(!rs.wasNull()) {
					list.add(rs.getString(1));
					i++;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		String[] result = new String[i];
		for(int j=0;j<result.length;j++) {
			result[j]=new String();
			result[j]=list.get(j);
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//Done
	public String[] getUser_Id() {
		ArrayList<String> list = new ArrayList<>();
		int i=0;
		
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT user_id from user";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				if(!rs.wasNull()) {
					list.add(rs.getString(1));
					i++;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		String[] result = new String[i];
		for(int j=0;j<result.length;j++) {
			result[j]=new String();
			result[j]=list.get(j);
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Done
	public boolean upLike(int article_id) {
		boolean result = false;
		
		Statement stmt = null;
		try {
			stmt=con.createStatement();
			String query = "UPDATE article set like_num = like_num + 1 where article_id =\""+article_id+"\"";
			int count = stmt.executeUpdate(query);
			if(count == 1) {
				result=true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (stmt != null && !stmt.isClosed()) stmt.close();	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//Done
	public boolean createArticle(String user_id, String context, String URL) {
		boolean isFinish= false;
		PreparedStatement pstmtToArticle = null;
		PreparedStatement pstmtToImage = null;
		try {
			String queryToArticle = "INSERT INTO article(context, user_id, like_num, created_at) VALUE (?,?,?,?)";
			String queryToImage = "INSERT INTO image(URL, article_id) VALUE (?,?)";
			
			pstmtToArticle = con.prepareStatement(queryToArticle);
			pstmtToImage = con.prepareStatement(queryToImage);
			
			Timestamp Time = new Timestamp(System.currentTimeMillis());
			
			pstmtToArticle.setString(1, context);
			pstmtToArticle.setString(2, user_id);
			pstmtToArticle.setInt(3, 0);
			pstmtToArticle.setTimestamp(4, Time);
			
			int toUser = pstmtToArticle.executeUpdate();

			pstmtToImage.setString(1, URL);
			pstmtToImage.setInt(2, find_article_id(Time));
					
			int toProfile = pstmtToImage.executeUpdate();
			
			if(toUser==1 && toProfile==1) {
				isFinish=true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmtToArticle !=null && !pstmtToArticle.isClosed())pstmtToArticle.close();
			if(pstmtToImage !=null&& !pstmtToImage.isClosed())pstmtToImage.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isFinish;
	}
	
	//Done
	private int find_article_id(Timestamp time) {
		Statement stmt=null;
		ResultSet rs=null; 
		int result = 0;
		String query = "SELECT article_id from article where created_at = \""+time+"\"";
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery(query);
			
			rs.next();
			result = rs.getInt(1);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Done
	public boolean addComment(CommentStruct newone) {
		boolean isFinish = false;
		PreparedStatement pstmt = null;
		
		try {
			String query = "INSERT INTO comment(context, user_id, article_id, group_num, hierarchy, created_at) VALUES(?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, newone.getContext());
			pstmt.setString(2, newone.getUser_id());
			pstmt.setInt(3, newone.getArticle_id());
			pstmt.setInt(4, newone.getGroup_num());
			pstmt.setInt(5, newone.getHierarchy());
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			
			if(1 == pstmt.executeUpdate())
				isFinish=true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt !=null && !pstmt.isClosed())pstmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isFinish;
	}

	//Done
	public int find_group(int article_id, String user_id, String comment) {
		Statement stmt = null;
		ResultSet rs = null;
		int result=  0;
		
		String query = "SELECT group_num FROM comment where article_id ="+article_id+" and user_id = \""+user_id+"\" and context =\""+comment+"\"";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			rs.next();
			result = rs.getInt(1);
		}
		catch(NullPointerException e) {
			try {
			query = "SELECT count(group_num) FROM comment group by group_num";
			rs=stmt.executeQuery(query);
			
			rs.next();
			result = rs.getInt(1);
			}
			catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Done
	public void delete_comment(int  article_id, int group_num){
		Statement stmt = null;
		String query = "DELETE FROM comment where article_id = "+article_id+" and group_num = "+group_num;
		
		try {
			stmt =con.createStatement();
			stmt.executeUpdate(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Done
	public CommentStruct[] getComment(int article_id) {
		Statement stmt = null;
		ResultSet rs =null;
		String query ="Select * From comment where article_id = \""+article_id+"\"";
		
		int n=0;
		ArrayList<CommentStruct> list = new ArrayList<>();
		int comment_id;
		int group_num;
		int hierarchy;
		Timestamp create_at;
		String context;
		String user_id;
		
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery(query);
					
			while(rs.next()) {
				if(!rs.wasNull()) {
					comment_id = rs.getInt(1);
					create_at = rs.getTimestamp(7);
					context = rs.getString(2);
					user_id = rs.getString(5);
					group_num = rs.getInt(3);
					hierarchy = rs.getInt(4);
					
					CommentStruct temp = new CommentStruct(comment_id, article_id, group_num, hierarchy,create_at, context, user_id);
					list.add(temp);
					n++;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		CommentStruct[] result = new CommentStruct[n];
		for(int i=0;i<n;i++) {
			result[i]=list.get(i);
		}
		
		return result;
	}
	
	public int find__next_group(int article_id) {
		int result = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select max(group_num) from comment where article_id = "+article_id;
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			rs.next();
			result=rs.getInt(1)+1;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null && !rs.isClosed())rs.close();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public UserStruct getUser(String user_id) {
		UserStruct result = null;
		Statement stmt =null;
		ResultSet rs = null;
		String query = "select * from user where user_id = \""+user_id+"\"";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			rs.next();
			result = new UserStruct(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),	rs.getString(6),rs.getString(7));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void changeUser(UserStruct newone) {
		Statement stmt = null;
		
		String query = "Update user set name = \""+newone.getName()+"\" ,password = \""+newone.getPassword()+"\" ,birth = \""+newone.getBirth()+"\" ,gender = \"" + newone.getGender()+"\" ,phone_number = \""+newone.getPhone_number()+"\" ,address = \""+newone.getAddress()+"\" where user_id = \""+newone.getUser_id()+"\"";
		
		try {
			stmt=con.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArticleStruct[] getUserArticle(String user_id){
		ArrayList<ArticleStruct> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs =null;
		int n=0;
		String query="Select * from article where user_id = \""+user_id+"\"";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				if(!rs.wasNull()) {
					ArticleStruct temp = new ArticleStruct(rs.getInt(1), rs.getString(3), rs.getTimestamp(4),rs.getString(5),rs.getInt(2));
					list.add(temp);
					n++;
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArticleStruct[] result = new ArticleStruct[n];
		for (int i=0;i<n;i++) {
			result[i]=list.get(i);
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null&& !rs.isClosed())rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void changeProfileImg(String newone, String user_id) {
		Statement stmt = null;
		String query="update article set profile_img = \""+newone+"\" where user_id = \""+user_id+"\"";
	
		try {
			stmt=con.createStatement();
			stmt.executeUpdate(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String nameToID(String name) {
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select user.user_id from user natural join profile where profile.nickname = \""+name+"\"";
		String result=null;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			rs.next();
			result = rs.getString(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt !=null&& !stmt.isClosed())stmt.close();
			if(rs !=null&& !rs.isClosed())rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Done
	public void close() {
		try {
			if (con != null && !con.isClosed()) con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}