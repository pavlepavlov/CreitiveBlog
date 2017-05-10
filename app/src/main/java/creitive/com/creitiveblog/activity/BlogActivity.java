package creitive.com.creitiveblog.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import creitive.com.creitiveblog.R;
import creitive.com.creitiveblog.fragment.BlogListFragment;

public class BlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        loadFragment(new BlogListFragment());
    }

    private void loadFragment(Fragment blogListFragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.flContent,blogListFragment).commit();
    }
}
