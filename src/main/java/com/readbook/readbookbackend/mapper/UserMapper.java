package com.readbook.readbookbackend.mapper;

import com.readbook.readbookbackend.pojo.BanLog;
import com.readbook.readbookbackend.pojo.User;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Mapper//在运行时,会自动生成该接口的实现类对象(代理对象), 并且将该对象交给IOC容器管理
public interface UserMapper {

    @Select("SELECT * FROM user")
    @Result(property = "id", column = "user_id")
    List<User> selectAllUsers();

    String getUserNameById(BigInteger userId);

    // 根据username查找用户,用于注册时检查用户名是否已存在
    User checkUsernameExists(String userName); //必须设置类id和数据库主键映射

    // 根据username和密码检验查找有无此人（登录检验）
    User checkLoginCredentials(String userName, String password);//必须设置类id和数据库主键映射

    // 根据id查找用户
    User selectUserByIdAndPassword(BigInteger userId, String password);//必须设置类id和数据库主键映射

    // 插入用户
    int insertUser(User user);//改参数id

    // 更新邮箱
    int updateEmail(BigInteger userId, String email, LocalDateTime updatedTime);

    // 更新密码
    int updatePassword(BigInteger userId, String newPassword, LocalDateTime updatedTime);

    // 更新上一次登录失败时间和连续登录失败次数
    int updateLoginFailureInfo(String userName, LocalDateTime lastFailureOnLogin, int failuresOnLogin);

    // 登录并且更新连续登录失败次数并且返回用户信息
    int updateFailCountZero(String userName);

    // 删除用户（可根据实际需求添加此方法，这里仅为示例完整的CRUD操作）
    int deleteUser(String userName);

    User getUserById(BigInteger userid);

    void banUser(BanLog banLog);

    LocalDateTime getLatestUnbanTimeByUserId(BigInteger userId);
}
