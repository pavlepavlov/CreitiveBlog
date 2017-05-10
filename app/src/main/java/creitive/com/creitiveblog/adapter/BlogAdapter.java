package creitive.com.creitiveblog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import creitive.com.creitiveblog.R;
import creitive.com.creitiveblog.model.Blog;

/**
 * Displays Blog object into blog_list_item.xml
 */

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {

    private List<Blog> mList;
    private Context mContext;

    public BlogAdapter(List<Blog> list){
        mList = list;
    }


    @Override
    public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.blog_list_item,parent,false);

        return new BlogViewHolder(view);
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

        private TextView tvTitle;
        private TextView tvDescription;
        private ImageView ivPicture;

        public BlogViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            ivPicture = (ImageView) itemView.findViewById(R.id.ivPicture);
        }

        public void bind(Blog blog){
            tvTitle.setText(blog.getTitle());
            tvDescription.setText(blog.getDescription());
            Picasso.with(mContext).load(blog.getImageUrl()).placeholder(R.drawable.placeholder).fit().into(ivPicture);
        }

    }
}
