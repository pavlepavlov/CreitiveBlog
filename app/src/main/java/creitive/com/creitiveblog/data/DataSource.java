package creitive.com.creitiveblog.data;

import android.content.Context;
import android.content.SharedPreferences;

import creitive.com.creitiveblog.model.Token;
import creitive.com.creitiveblog.model.User;

/**
 * This class manages memory and caches objects
 */

public class DataSource {

    private static final String TOKEN_KEY = "com.creitive.creitiveblogs.token";
    private static final String PREFS_KEY = "com.creitive.creitiveblogs";

    private User mUser;
    private SharedPreferences mPrefs;
    private Context mContext;
    private Token mToken;

    private static DataSource sInstance;

    private DataSource(){}

    public static DataSource getInstance(){
        if(sInstance == null){
            sInstance = new DataSource();
        }
        return sInstance;
    }

    public User getUser() {
        if(mUser == null){
            mUser = new User();
        }
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public void setToken(Token token) {
        mPrefs.edit().putString(TOKEN_KEY,token.getToken()).apply();
        mToken = token;
    }

    public void setContext(Context context) {
        mContext = context;
        mPrefs = context.getSharedPreferences(PREFS_KEY,Context.MODE_PRIVATE);
    }

    public Token getToken() {
        String tokenString = mPrefs.getString(TOKEN_KEY,"");
        if(tokenString.isEmpty()){
            return null;
        }
        Token token = new Token();
        token.setToken(tokenString);
        return token;
    }
}
