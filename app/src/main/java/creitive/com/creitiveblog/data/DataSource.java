package creitive.com.creitiveblog.data;

import creitive.com.creitiveblog.model.User;

/**
 * This class manages memory and caches objects
 */

public class DataSource {

    private User mUser;

    private static DataSource mInstance;

    private DataSource(){}

    public static DataSource getInstance(){
        if(mInstance == null){
            mInstance = new DataSource();
        }
        return mInstance;
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

    public static DataSource getmInstance() {
        return mInstance;
    }

    public static void setmInstance(DataSource mInstance) {
        DataSource.mInstance = mInstance;
    }
}
