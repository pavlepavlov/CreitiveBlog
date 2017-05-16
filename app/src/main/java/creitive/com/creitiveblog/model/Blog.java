
package creitive.com.creitiveblog.model;

import android.databinding.BindingAdapter;
import android.os.Build;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import creitive.com.creitiveblog.R;

public class Blog {

    public static final String GET_LIST = "blogs";
    public static final String GET_SINGLE = "blogs/{id}";

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("content")
    @Expose
    private String htmlContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @BindingAdapter("bind:imgUrl")
    public static void setImageUrl(ImageView iv,String url){
        Picasso.with(iv.getContext())
                .load(url)
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerInside()
                .into(iv);
    }

    @BindingAdapter("bind:textHtml")
    public static void setHtmlText(TextView tv, String html){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tv.setText(Html.fromHtml(html,Html.FROM_HTML_MODE_COMPACT));
        }
        else{
            tv.setText(Html.fromHtml(html));
        }
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
