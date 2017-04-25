package creitive.com.creitiveblog.presenter;

import android.widget.Toast;

import creitive.com.creitiveblog.LoginActivity;
import creitive.com.creitiveblog.model.User;

/**
 * Handles click events from LoginActivity and manages User object
 */

public class UserPresenter {

    private LoginActivity mView;

    public LoginActivity getView() {
        return mView;
    }

    public void onLoginClicked(User user){
        //TODO: HANDLE LOGIN CLICKED
        Toast.makeText(mView, "User's email "+user.getEmail(), Toast.LENGTH_SHORT).show();
    }

    public void bind(LoginActivity view) {
        mView = view;
    }
}
