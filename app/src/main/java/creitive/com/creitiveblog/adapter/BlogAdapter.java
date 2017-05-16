package creitive.com.creitiveblog.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import creitive.com.creitiveblog.R;
import creitive.com.creitiveblog.databinding.BlogListItemBinding;
import creitive.com.creitiveblog.model.Blog;
import creitive.com.creitiveblog.presenter.BlogPresenter;

/**
 * Displays Blog object into blog_list_item.xml
 */

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {

    private List<Blog> mList;
    private Context mContext;
    private BlogPresenter mPresenter;

    public BlogAdapter(List<Blog> list, BlogPresenter presenter){
        mList = list;
        mPresenter = presenter;
    }


    @Override
    public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        BlogListItemBinding binding = DataBindingUtil.inflate(inflater,R.layout.blog_list_item,parent,false);

        binding.setPresenter(mPresenter);

        return new BlogViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BlogViewHolder holder, int position) {
        Blog blog = mList.get(position);
        holder.bind(blog);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class BlogViewHolder extends RecyclerView.ViewHolder {

        private BlogListItemBinding mBinding;

        public BlogViewHolder(BlogListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Blog blog){
            mBinding.setBlog(blog);
        }
    }
}
