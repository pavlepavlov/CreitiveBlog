package creitive.com.creitiveblog.network;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import creitive.com.creitiveblog.fragment.BlogListFragment;
import creitive.com.creitiveblog.model.Blog;
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

        Observable<Token> userLogin = RestClient.getInstance().service.userLogin(user);
        userLogin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<Token>() {
                            @Override
                            public void accept(Token token) throws Exception {
                                presenter.onTokenReceived(token);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                GenericErrorHandler.handleError(presenter.getContext(),throwable,GenericErrorHandler.FLAG_LOGIN);
                            }
                        }
                );

    }

    public static void getBlogList(final BlogListFragment fragment, Token token) {
        Observable<List<Blog>> getBlogList = RestClient.getInstance().
                service.getBlogList(token.getToken());

        getBlogList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Blog>>() {
                               @Override
                               public void accept(List<Blog> blogs) throws Exception {
                                   fragment.onBlogListLoaded(blogs);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                GenericErrorHandler.handleError(fragment.getContext(),throwable,GenericErrorHandler.FLAG_LOGIN);
                            }
                        });
    }
}
