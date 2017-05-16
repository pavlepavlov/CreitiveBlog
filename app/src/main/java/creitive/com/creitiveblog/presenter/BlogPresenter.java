package creitive.com.creitiveblog.presenter;

import android.content.Context;
import android.widget.Toast;

import creitive.com.creitiveblog.activity.BlogActivity;
import creitive.com.creitiveblog.fragment.BlogListFragment;
import creitive.com.creitiveblog.fragment.WebViewFragment;
import creitive.com.creitiveblog.model.Blog;

/**
 * Handles events from blog_list_item.xml
 */

public class BlogPresenter {

    private BlogListFragment mView;

    public BlogListFragment getView() {
        return mView;
    }

    public void bind(BlogListFragment view){
        mView = view;
    }

    public void onBlogClicked(Blog blog){
        ((BlogActivity)getView().getActivity()).loadFragment(WebViewFragment.getInstance(blog.getId()));
    }

    public Context getContext() {
        return getView().getContext();
    }
}
