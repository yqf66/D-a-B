package testWeb.dao;
import testWeb.vo.*;

public interface userDAO {
	public int queryByUserInfo(UserInfo userinfo) throws Exception;
}
