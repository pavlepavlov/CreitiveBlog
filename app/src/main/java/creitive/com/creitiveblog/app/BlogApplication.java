package creitive.com.creitiveblog.app;

import android.app.Application;

import creitive.com.creitiveblog.data.DataSource;

/**
 * Created by User779PC on 25-Apr-17.
 */

public class BlogApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataSource.getInstance().setContext(this);
    }
}
