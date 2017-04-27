package creitive.com.creitiveblog.presenter;

import android.content.Context;
import android.content.Intent;

import creitive.com.creitiveblog.activity.BlogActivity;
import creitive.com.creitiveblog.activity.LoginActivity;
import creitive.com.creitiveblog.data.DataSource;
import creitive.com.creitiveblog.model.Token;
import creitive.com.creitiveblog.model.User;
import creitive.com.creitiveblog.network.WebController;

/**
 * Handles click events from LoginActivity and manages User object
 */

public class UserPresenter {

    private LoginActivity mView;

    public LoginActivity getView() {
        return mView;
    }

    public void onLoginClicked(User user){
        if(!User.areFieldsValid(this,user)) return;
        WebController.userLogin(this,user);
    }

    public void bind(LoginActivity view) {
        mView = view;
    }

    public void onTokenReceived(Token token) {
        DataSource.getInstance().setToken(token);
        Intent intent = new Intent(mView, BlogActivity.class);
        mView.startActivity(intent);
        mView.finish();
    }

    public Context getContext() {
        return getView();
    }
}
