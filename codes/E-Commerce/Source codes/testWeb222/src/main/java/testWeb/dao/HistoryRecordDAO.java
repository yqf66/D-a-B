package testWeb.dao;

import java.util.ArrayList;

import testWeb.vo.HistoryRecord;
import testWeb.vo.UserInfo;

public interface HistoryRecordDAO {

	public int addRecord(HistoryRecord a);
	public ArrayList<HistoryRecord> selectRecord(UserInfo user);
	public int deleteRecord(HistoryRecord a);
	public int selectID(HistoryRecord a);
	public int UserSearch(UserInfo user);
}
