package creitive.com.creitiveblog.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.setInitialScale(1);

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
        Log.d("HTML",blog.getHtmlContent());
        String parsedHtml = parseHtml(blog.getHtmlContent());
        mWebView.loadData(parsedHtml,"text/html","charset=UTF-8");
    }

    private String parseHtml(String htmlContent) {
        Pattern pattern = Pattern.compile("<p><img");
        Matcher matcher = pattern.matcher(htmlContent);
        if(matcher.find()){
            return matcher.replaceAll("<p><img style=\"width: 80%; height: auto;\"");
        }
        else{
            return htmlContent;
        }
    }
}
