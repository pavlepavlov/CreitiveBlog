package creitive.com.creitiveblog.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import creitive.com.creitiveblog.R;
import creitive.com.creitiveblog.adapter.BlogAdapter;
import creitive.com.creitiveblog.data.DataSource;
import creitive.com.creitiveblog.model.Blog;
import creitive.com.creitiveblog.network.WebController;

/**
 * Displays list of blog items
 */
public class BlogListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public BlogListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blog_list, container ,false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvBlog);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        WebController.getBlogList(this, DataSource.getInstance().getToken());


        return view;
    }

    public void onBlogListLoaded(List<Blog> blogs) {
        mAdapter = new BlogAdapter(blogs);
        mRecyclerView.setAdapter(mAdapter);
    }
}
