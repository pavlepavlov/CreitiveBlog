package creitive.com.creitiveblog.network;

import android.widget.Toast;

import creitive.com.creitiveblog.model.Token;
import creitive.com.creitiveblog.model.User;
import creitive.com.creitiveblog.presenter.UserPresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */

public class WebController {

    public static void userLogin(final UserPresenter presenter, User user) {
        Token token = new Token();
        token.setToken("12312312jdsajnd asd");
        presenter.onTokenReceived(token);

//        Observable<Token> userLogin = RestClient.getInstance().service.userLogin(user);
//        userLogin.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        new Consumer<Token>() {
//                            @Override
//                            public void accept(Token token) throws Exception {
//                                presenter.onTokenReceived(token);
//                            }
//                        },
//                        new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//                                //TODO: Handle erros
//                                Toast.makeText(presenter.getContext(), "Error", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                );

    }
}
