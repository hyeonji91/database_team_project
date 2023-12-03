import javax.swing.*;
import java.sql.*;
import java.util.*;
//수정되고있는파일
public class Database {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost/halo";    //dbstudy 스키마
    String user = "root";
    String passwd = "1225";        //본인이 설정한 root 계정의 비밀번호를 입력하면 된다.
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
    boolean logincheck(String _i, String _p) {
        boolean flag = false;

        String id = _i;
        String pw = _p;

        try {
            String checkingStr = "SELECT password FROM user WHERE id='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            int count = 0;
            while (result.next()) {
                if (pw.equals(result.getString("password"))) {
                    flag = true;
                    System.out.println("로그인 성공");
                } else {
                    flag = false;
                    System.out.println("로그인 실패");
                }
                count++;

            }
        } catch (Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
        }

        return flag;
    }

    boolean joinCheck(String _i, String _pw, String _c, String _d, String _e, String _ph) {
        boolean flag = false;

        String id = _i;
        String pw = _pw;
        String cho = _c;
        String name = _d;
        String email = _e;
        String phone = _ph;

        try {
            String insertStr = "INSERT INTO user VALUES('" + id + "', '" + pw + "', '" + cho+ "', '" +name+ "', '"+email+"', '" + phone + "')";
            stmt.executeUpdate(insertStr);

            flag = true;
            System.out.println("회원가입 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("회원가입 실패 > " + e.toString());
        }

        return flag;
    }

    /*게시물 올리기 (우리가만든 쿼리문 사용)*/
    boolean inputpost( String _lken, String _cxt, String _created, String _ui) {
        boolean flag = false;

     
        
        String like_num = _lken;
        String context = _cxt;
        String created_at = _created;
        String user_id = _ui;
        


        try {
            String insertStrpost = "INSERT INTO article VALUES('" + like_num + "', '" + context +"', '" + created_at + "', '" + user_id+"')";
            //like_num,context,created_at,user_id
            // String insertStr = "INSERT INTO User VALUES('" + user_id + "', '" + name +"', '" + password + "', '" + gender+ "', '" + phone_number + "', '" + address +"')";
            stmt.executeUpdate(insertStrpost);


            flag = true;
            JOptionPane.showMessageDialog(null, "글 넣기 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("글 삽입 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "글 넣기 실패");
        }
        return flag;
    }
    Integer idx;
    
    /*댓글 개수 뽑아오는거임 (새로운 쿼리문 만듦) */
    boolean comment_idx(String _ai, String _cc) {
        boolean flag = false;
        String article_id = _ai;
        String comment_count = _cc;
 
       
      

        try {
            String output = "SELECT COUNT(*) as comment_count FROM comment WHERE article_id = '" + article_id + "'";
            rs = stmt.executeQuery(output);
            while (rs.next()) {
                idx = rs.getInt("comment_count");
            }
            flag = true;

        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
    /*댓글 달기 (우리가 사용한 쿼리문)*/
    /*id = 댓글 개수 우리거에는 댓글 개수가 추가가 안되어 있음*/
    boolean inputcomment(String _c, String _ai, String _ci, String _gn, String _hir, String _ui,   String _ca, String _cc) {
        boolean flag = false;
        
        String article_id = _ai;
        String comment_id = _ci;
        String context = _c;
        String group_num = _gn;
        String hierarchy = _hir;
        String user_id = _ui;;
        String created_at = _ca;
        String comment_count = _cc;

        comment_idx(_ai, _cc);
        Integer index = idx+1; //comment_count
        try {
            String insertStr = "INSERT INTO comment (context,group_num,hierarchy,user_id,article_id,created_at) VALUES('" +_c+ "', '" + _gn + "', '" + _hir + "', '" + _ui + "', '" + _ai + "','" + _ca + "')";

            stmt.executeUpdate(insertStr);


            flag = true;
            JOptionPane.showMessageDialog(null, "댓글 쓰기 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("댓글 삽입 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "댓글 쓰기 실패");
        }
        return flag;
    }

    ArrayList<String> data = new ArrayList<String>();

    /*프로필에서 게시글의 이미지를 선택하여 해당 게시글로 이동하는 기능(우리쿼리) */
    boolean fetchPostDetailsWithImages(String _ai) {
        boolean flag = false;
        data.clear(); // 이전 데이터 초기화
        String article_id = _ai;

        try {
            String query = "SELECT a.article_id, a.like_num, a.context, a.user_id, a.created_at, " +
                           "c.comment_count, img.imgUrlList " +
                           "FROM article a " +
                           "LEFT JOIN (SELECT article_id, COUNT(comment_id) AS comment_count FROM comment GROUP BY article_id) c ON a.article_id = c.article_id " +
                           "LEFT JOIN (SELECT article_id, GROUP_CONCAT(url) AS imgUrlList FROM image GROUP BY article_id) img ON a.article_id = img.article_id " +
                           "WHERE a.article_id = '" + _ai + "'";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                data.add(rs.getString("article_id"));
                data.add(rs.getString("like_num"));
                data.add(rs.getString("context"));
                data.add(rs.getString("user_id"));
                data.add(rs.getString("created_at"));
                data.add(rs.getString("comment_count"));
                data.add(rs.getString("imgUrlList")); // 이미지 URL 목록
            }
            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println("게시물 상세 조회 오류 > " + e.toString());
        }
        return flag;
    }

    
    
   
    
    /*user_id에 대한 게시물 보여주기 좋아요수 댓글수(새로 만든 쿼리문)*/
    boolean outputpost(String _ui) {
        boolean flag = false;
        data.clear();
        
        String user_id = _ui;
        //String context = _cxt;
        //String article_id =_ai;
        //String like_num= _lken;
        //String created_at = _ca;
        //String comment_count = _cc;
        

        try {
            String outputStrpost = "SELECT a.*, "
                    + "(SELECT COUNT(*) FROM likes WHERE article_id = a.article_id) AS like_num, "
                    + "(SELECT COUNT(*) FROM comment WHERE article_id = a.article_id) AS comment_count "
                    + "FROM article a WHERE user_id = '" + _ui + "'";
            rs = stmt.executeQuery(outputStrpost);
            while (rs.next()) {
                data.add(rs.getString("context"));
                data.add(rs.getString("article_id"));
                data.add(rs.getString("like_num"));
                data.add(rs.getString("created_at"));
                data.add(rs.getString("comment_count"));
            }


            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println("글 불러오기 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "새로고침 실패");

        }
        return flag;

    }
    ArrayList<String> c_data = new ArrayList<String>();
    
    
    /*게시물 댓글 불러오기 -> 특정게시물에대한 댓글대댓글 (우리가 만든 쿼리문)*/
    boolean outputcomment(String _ai) {
        boolean flag = false;
        c_data.clear();
        String article_id = _ai;

        try {
            String outputStrpost = "SELECT c1.comment_id AS parent_comment_id, c1.context AS parent_comment, c2.comment_id AS reply_comment_id, c2.context AS reply_comment FROM Comment AS c1 LEFT JOIN Comment AS c2 ON c1.comment_id = c2.group_num AND c2.hierarchy = 2 WHERE c1.article_id = '" + article_id + "' AND c1.hierarchy = 1";
            rs = stmt.executeQuery(outputStrpost);
            while (rs.next()) {
                c_data.add(rs.getString("parent_comment_id")); //원본 댓글 정보
                c_data.add(rs.getString("parent_comment"));
                c_data.add(rs.getString("reply_comment_id"));//답글 정보
                c_data.add(rs.getString("reply_comment"));
            }


            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println("댓글 불러오기 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "새로고침 실패");

        }
        return flag;

    }
    
    /*댓글에 대한 user_id 수집 (새로만든쿼리문)*/
    boolean collectCommentUserIds(String _ai) {
        boolean flag = false;
        String article_id = _ai; // 게시물 ID
        ArrayList<String> userIds = new ArrayList<>();

        try {
            String query = "SELECT c.user_id FROM Comment AS c WHERE c.article_id = '" + article_id + "' GROUP BY c.user_id, c.article_id";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                userIds.add(rs.getString("user_id"));
            }
            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println("댓글 작성자 ID 수집 오류 > " + e.toString());
        }
        // userIds에 수집된 사용자 ID를 처리하는 로직이 필요할 수 있습니다.
        return flag;
    }

    
    /*타인의 article 불러오기 -> 이건 이미 위에서 해씀*/
    /*boolean outputtpost(String _u) {
        boolean flag = false;
        data.clear();

        try {
            String outputStrpost = "SELECT * FROM post where user_id = '" + _u + "'";
            rs = stmt.executeQuery(outputStrpost);
            while (rs.next()) {
                data.add(rs.getString("id"));
                data.add(rs.getString("postinner"));
            }


            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println("글 불러오기 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "새로고침 실패");

        }
        return flag;

    }*/
    
    /*모든 게시물 삭제 -> 할 이유가 있나?*/
    /*boolean alldeletepost() {
        boolean flag = false;

        try {
            String deleteStrpost = "delete FROM post where user_id = '" + o.mf.uuid + "'";
            String delete_Strpost = "ALTER TABLE post AUTO_INCREMENT=1;";
            stmt.executeUpdate(deleteStrpost);
            stmt.executeUpdate(delete_Strpost);
            data.clear();

            flag = true;
            JOptionPane.showMessageDialog(null, "글 삭제 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("글 불러오기 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "글 삭제 실패");

        }
        return flag;

    }*/
    
    /*게시물 삭제 (우리 쿼리문) */
    boolean deletepost(String _ai) {
        boolean flag = false;
        String article_id = _ai;

        try {
            //Integer setdelete = Integer.parseInt(_d); 게시물 수 줄어드는 것
            String deleteStrpost = "DELETE FROM Article WHERE article_id = '" + article_id + "' AND user_id = '" + o.mf.uuid + "'";
            stmt.executeUpdate(deleteStrpost);
            data.clear();

            flag = true;
            JOptionPane.showMessageDialog(null, "글 삭제 성공");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "숫자를 입력해주세요");
        } catch (Exception e) {
            flag = false;
            System.out.println("글 불러오기 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "글 삭제 실패");

        }
        return flag;

    }
    
    /*댓글 삭제 (새로만든쿼리문)*/
    boolean deletecomment(String _ai, String _ci) {
        boolean flag = false;
        String article_id = _ai; // 게시물 ID
        String comment_id = _ci; // 댓글 ID


        try {

            String deleteStr = "DELETE FROM Comment WHERE comment_id = '" + comment_id + "' AND article_id = '" + article_id + "' AND user_id = '" + o.mf.uuid + "'";
            stmt.executeUpdate(deleteStr);
            c_data.clear();

            flag = true;
            JOptionPane.showMessageDialog(null, "댓글 삭제 성공");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "숫자를 입력해주세요");
        } catch (Exception e) {
            flag = false;
            System.out.println("댓글 불러오기 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "댓글 삭제 실패");

        }
        return flag;

    }
    /*좋아요 추가(우리 쿼리문)*/
    boolean addLike(String _ai, String _ui) {
        boolean flag = false;
        String article_id = _ai; // 게시물 ID
        String user_id = _ui; // 사용자 ID

        try {
            String insertStr = "INSERT INTO Likes (user_id, article_id) VALUES('" + user_id + "', '" + article_id + "')";
            stmt.executeUpdate(insertStr);

            flag = true;
            JOptionPane.showMessageDialog(null, "좋아요 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("좋아요 추가 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "좋아요 추가 실패");
        }
        return flag;
    }
    
    /*좋아요 취소(우리뭐리문)*/
    boolean removeLike(String _ai, String _ui) {
        boolean flag = false;
        String article_id = _ai; // 게시물 ID
        String user_id = _ui; // 사용자 ID

        try {
            String deleteStr = "DELETE FROM Likes WHERE user_id = '" + user_id + "' AND article_id = '" + article_id + "'";
            stmt.executeUpdate(deleteStr);

            flag = true;
            JOptionPane.showMessageDialog(null, "좋아요 취소 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("좋아요 취소 오류 > " + e.toString());
            JOptionPane.showMessageDialog(null, "좋아요 취소 실패");
        }
        return flag;
    }

    
    ArrayList<String> follow = new ArrayList<String>();

    boolean followchcek() {
        boolean flag = false;


        try {
            String outputStrfollow = "SELECT * FROM follow where follow_user_id = '" + o.mf.uuid + "'";
            rs = stmt.executeQuery(outputStrfollow);
            while (rs.next()) {
                follow.add(rs.getString("followed_user_id"));
            }
            flag = true;
            System.out.println("팔로우 확인 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("팔로우 확인 실패 > " + e.toString());
        }
        return flag;
    }

    ArrayList<String> followed = new ArrayList<String>();

    boolean followedchcek() {
        boolean flag = false;


        try {
            String outputStrfollow = "SELECT * FROM follow where followed_user_id = '" + o.mf.uuid + "'";
            rs = stmt.executeQuery(outputStrfollow);
            while (rs.next()) {
                followed.add(rs.getString("follow_user_id"));
            }
            flag = true;
            System.out.println("팔로우ed 확인 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("팔로우ed 확인 실패 > " + e.toString());
        }
        return flag;
    }


    ArrayList<String> stid = new ArrayList<String>();

    boolean setid() {
        boolean flag = false;


        try {
            String outputStrfollow = "SELECT * FROM user ";
            rs = stmt.executeQuery(outputStrfollow);
            while (rs.next()) {
                stid.add(rs.getString("id"));
            }
            flag = true;
            System.out.println("id 불러오기 성공");
        } catch (Exception e) {
            flag = false;
            System.out.println("id 불러오기 실패 > " + e.toString());
        }
        return flag;
    }

    ArrayList<String> inner = new ArrayList<String>();
    boolean seek_follow_post(String _fd) {
        boolean flag = false;
        inner.clear();
        String followed = _fd;

        try {
            String seek = "SELECT * FROM post where user_id = '" + followed + "'";
            rs = stmt.executeQuery(seek);
            while (rs.next()) {
                inner.add(rs.getString("id"));
                inner.add(rs.getString("postinner"));
            }

            flag = true;
        } catch (Exception e) {
            flag = false;
            System.out.println("글 불러오기 오류 > " + e.toString());

        }
        return flag;
    }
    boolean insertfollow(String _fd) {
        boolean flag = false;

        String followed = _fd;


        try {
            String insertStrfollow = "INSERT INTO follow (follow_user_id, followed_user_id) VALUES('" + o.mf.uuid + "','" + followed + "')";
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

    boolean deletefollow(String _df) {
        boolean flag = false;

        String df = _df;


        try {
            String deleteStrfollow = "delete FROM follow where followed_user_id = '" + df + "' and follow_user_id = '" + o.mf.uuid + "'";
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

    boolean changename(String _cn) {
        boolean flag = false;

        String cn = _cn;


        try {
            String changeStrname = "update user set uname = '" + cn + "' where id = '" + o.mf.uuid + "'";
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

    boolean changepassword(String _cp) {
        boolean flag = false;

        String cp = _cp;


        try {
            String changeStrname = "update user set password = '" + cp + "' where id = '" +o.mf.uuid+ "'";
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


}

