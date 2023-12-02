import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Database {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost/halo";    //dbstudy 스키마
    String user = "root";
    String passwd = "1234";        //본인이 설정한 root 계정의 비밀번호를 입력하면 된다.
    Operator o = null;

    Database(Operator _o) {    //데이터베이스에 연결한다.
        o = _o;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
            System.out.println("MySQL 서버 연동 성공");
        } catch (Exception e) {
            System.out.println("MySQL 서버 연동 실패 > " + e.toString());
        }
    }

    /* 로그인 정보를 확인 */
    boolean logincheck(String _ui, String _p) {
        boolean flag = false;

        String user_id = _ui;
        String pw = _p;

        try {
            String checkingStr = "SELECT password FROM User WHERE user_id='" + user_id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            while (result.next()) {
                if (pw.equals(result.getString("password"))) {
                    flag = true;
                    System.out.println("로그인 성공");
                } else {
                    flag = false;
                    System.out.println("로그인 실패");
                }
            }
        } catch (Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
        }

        return flag;
    }
    
    /* 회원가입 정보를 확인*/
    boolean joinCheck(String _ui, String _n, String _pw, String _bd, String _g, String _ph,String _ad) {
        boolean flag = false;

        String user_id = _ui;
        String name = _n;
        String password = _pw;
        String birth = _bd;
        String gender = _g;
        String phone_number = _ph;
        String address = _ad;
        try {
            String insertStr = "INSERT INTO User VALUES('" + user_id + "', '" + name +"', '" + password + "', '" + 
            		birth +"', '" + gender+ "', '" + phone_number + "', '" + address +"')";
            stmt.executeUpdate(insertStr);

            flag = true;
            System.out.println("회원가입 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("회원가입 실패 > " + e.toString());
        }

        return flag;
    }

    /*팔로잉 정보를 확인*/
    ArrayList<String> following = new ArrayList<String>();
    boolean followchcek() {
        boolean flag = false;

        //o.mf 부분은 프레임에서 넘겨받은 변수명으로 수정해야됨.
        try {
            String outputStrfollow = "SELECT * FROM Follow where following_id = '" + o.mf.user_id + "'";
            rs = stmt.executeQuery(outputStrfollow);
            while (rs.next()) {
                following.add(rs.getString("follower_id"));
            }
            flag = true;
            System.out.println("팔로우 확인 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("팔로우 확인 실패 > " + e.toString());
        }
        return flag;
    }
    
    /*팔로잉 수 반환*/
    int followingnum() {
    	return following.size();
    }
    
    /*팔로워 정보 확인*/
    ArrayList<String> follower = new ArrayList<String>();
    boolean followedchcek() {
        boolean flag = false;


        try {
            String outputStrfollow = "SELECT * FROM Follow where follower_id = '" + o.mf.user_id + "'";
            rs = stmt.executeQuery(outputStrfollow);
            while (rs.next()) {
                follower.add(rs.getString("following_id"));
            }
            flag = true;
            System.out.println("팔로워 확인 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("팔로워 확인 실패 > " + e.toString());
        }
        return flag;
    }

    /*팔로잉 수 반환*/
    int followernum() {
    	return follower.size();
    }
    
    /*유저 아이디 불러오기*/
    ArrayList<String> stid = new ArrayList<String>();
    boolean setid() {
        boolean flag = false;


        try {
            String outputStrfollow = "SELECT * FROM User ";
            rs = stmt.executeQuery(outputStrfollow);
            while (rs.next()) {
                stid.add(rs.getString("user_id"));
            }
            flag = true;
            System.out.println("user_id 불러오기 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("user_id 불러오기 실패 > " + e.toString());
        }
        return flag;
    }
    
    ArrayList<String> inner = new ArrayList<String>();
    boolean seek_follow_post(String _fd) {
        boolean flag = false;
        inner.clear();
        String follower = _fd;

        try {
            String seek = "SELECT * FROM post where user_id = '" + follower + "'";
            rs = stmt.executeQuery(seek);
            while (rs.next()) {
                inner.add(rs.getString("user_id"));
                inner.add(rs.getString("postinner"));
            }

            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println("글 불러오기 오류 > " + e.toString());

        }
        return flag;
    }
    
    /*팔로우 추가*/
    boolean insertfollow(String _fd) {
        boolean flag = false;

        String follower = _fd;


        try {
            String insertStrfollow = "INSERT INTO Follow (following_id, follower_id) VALUES('" + o.mf.user_id + "','" + follower + "')";
            stmt.executeUpdate(insertStrfollow);

            flag = true;
            JOptionPane.showMessageDialog(null, "팔로우 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("팔로우 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "팔로우 실패");
        }
        return flag;
    }
    
    /*팔로우 취소*/
    boolean deletefollow(String _df) {
        boolean flag = false;

        String df = _df;


        try {
            String deleteStrfollow = "DELETE FROM Follow where follower_id = '" + df + "' and following_id = '" + o.mf.user_id + "'";
            stmt.executeUpdate(deleteStrfollow);

            flag = true;
            JOptionPane.showMessageDialog(null, "팔로우 삭제 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("팔로우 삭제 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "팔로우 삭제 실패");
        }
        return flag;
    }

    /*유저 이름 변경*/
    boolean changename(String _cn) {
        boolean flag = false;

        String cn = _cn;


        try {
            String changeStrname = "UPDATE Profile set nickname = '" + cn + "' where user_id = '" + o.mf.user_id + "'";
            stmt.executeUpdate(changeStrname);

            flag = true;
            JOptionPane.showMessageDialog(null, "이름 변경 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("이름 변경 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "이름 변경 실패");
        }
        return flag;
    }

    /*유저 비밀번호 변경*/
    boolean changepassword(String _cp) {
        boolean flag = false;

        String cp = _cp;


        try {
            String changeStrname = "UPDATE User set password = '" + cp + "' where user_id = '" +o.mf.user_id+ "'";
            stmt.executeUpdate(changeStrname);

            flag = true;
            JOptionPane.showMessageDialog(null, "비밀번호 변경 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("비밀번호 변경 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "비밀번호 변경 실패");
        }
        return flag;
    }

    /*유저의 게시글 정보를 확인*/
    ArrayList<String> article = new ArrayList<String>();
    boolean Articlechcek() {
    	boolean flag = false;
        try {
            String outputStrfollow = "SELECT * FROM Article` where user_id = '" + o.mf.user_id + "'";
            rs = stmt.executeQuery(outputStrfollow);
            while (rs.next()) {
                article.add(rs.getString("article_id"));
            }
            flag = true;
            System.out.println("게시글 확인 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("게시글 확인 실패 > " + e.toString());
        }
        return flag;
    }

    /*게시글 수 반환*/
    int articlenum() {
    	return article.size();
    }
    
}

