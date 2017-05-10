package creitive.com.creitiveblog.model;

import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import creitive.com.creitiveblog.R;
import creitive.com.creitiveblog.presenter.UserPresenter;

/**
 * This is a model representation of login screen
 */

public class User {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean areFieldsValid(UserPresenter presenter,User user) {
        if (!isEmailValid(user.getEmail())) {
            Toast.makeText(presenter.getContext(), R.string.error_email, Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(user.password) || user.password.length() < 6){
            Toast.makeText(presenter.getContext(), R.string.error_password, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
}
