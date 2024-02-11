package com.fitanywhere.user.model;

public interface UserDAO {
	
    
	//註冊用戶並將用戶數據寫入MySQL。
    UserVO registerUser(UserVO user);

    //檢查用戶資料    
	boolean registerCheck(String uNickname, String uPhone, String uMail);
	
	

}
