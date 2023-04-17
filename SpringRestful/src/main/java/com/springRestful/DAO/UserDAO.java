package com.springRestful.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.annotations.Mapper;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.springRestful.Entity.Users;

//@Repository
//public interface UserRepository extends JpaRepository<Users, String> { JpaRepository 를 상속받아 사용하는 방식 
//}
//@Repository
//public class userRepository {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    public List<Users> selectAllData() { //
//        String query = "SELECT\r\n" + 
//        		"	IFNULL(user_id, '') AS user_id,\r\n" + 
//        		"	IFNULL(user_name, '') AS user_name,\r\n" + 
//        		"	IFNULL(user_password, '') AS user_password,\r\n" + 
//        		"	IFNULL(user_role, '') AS user_role,\r\n" + 
//        		"	IFNULL(email, '') AS email,\r\n" + 
//        		"	created_date,\r\n" + 
//        		"	delete_date\r\n" + 
//        		"FROM\r\n" + 
//        		"	Users;";
//
//        List<Users> users = jdbcTemplate.query(query, new RowMapper<Users>() {
//            @Override
//            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Users user = new Users();
//                user.setUser_id(rs.getString("user_id"));
//                user.setUser_name(rs.getString("user_name"));
//                user.setUser_password(rs.getString("user_password"));
//                user.setUser_role(rs.getString("user_role"));
//                user.setEmail(rs.getString("email"));
//                user.setCreated_date(rs.getTimestamp("created_date").toLocalDateTime());
//                user.setDelete_date(rs.getTimestamp("delete_date").toLocalDateTime());
//                return user;
//            }
//        });
//
//        return users;
//    }      
//}

@Mapper
public interface UserDAO {
    List<Users> selectAllData();
}


