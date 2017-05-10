package creitive.com.creitiveblog.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import creitive.com.creitiveblog.R;
import creitive.com.creitiveblog.data.DataSource;
import creitive.com.creitiveblog.databinding.ActivityLoginBinding;
import creitive.com.creitiveblog.model.User;
import creitive.com.creitiveblog.presenter.UserPresenter;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(DataSource.getInstance().getToken() != null){
            Intent intent = new Intent(this, BlogActivity.class);
            this.startActivity(intent);
            this.finish();
        }

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        UserPresenter presenter = new UserPresenter();
        presenter.bind(this);

        binding.setUser(DataSource.getInstance().getUser());
        binding.setPresenter(presenter);
    }
}
