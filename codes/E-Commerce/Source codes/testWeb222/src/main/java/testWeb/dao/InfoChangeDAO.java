package testWeb.dao;

import testWeb.vo.*;

public interface InfoChangeDAO {
	public int InfoChange(HistoryRecord r,UserInfo u,Exploration e);
	public int DataChange(HistoryRecord r);
	public HistoryRecord selectByID(Integer valueOf);
}
