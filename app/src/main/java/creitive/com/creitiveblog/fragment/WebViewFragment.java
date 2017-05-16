package creitive.com.creitiveblog.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import creitive.com.creitiveblog.R;
import creitive.com.creitiveblog.data.DataSource;
import creitive.com.creitiveblog.model.Blog;
import creitive.com.creitiveblog.network.WebController;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {

    private static final String KEY_ID = "com.creitive.creitiveblog.id";

    private WebView mWebView;


    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mWebView = (WebView) inflater.inflate(R.layout.fragment_web_view, container, false);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setVerticalScrollBarEnabled(true);

        int id = getArguments().getInt(KEY_ID);

        WebController.getBlog(this,id,DataSource.getInstance().getToken().getToken());

        return mWebView;
    }

    public static WebViewFragment getInstance(int id) {
        WebViewFragment instance = new WebViewFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_ID,id);
        instance.setArguments(args);
        return instance;
    }

    public void onBlogLoaded(Blog blog) {
        mWebView.loadData(blog.getHtmlContent(),"text/html","charset=UTF-8");
    }
}
