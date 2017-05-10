package creitive.com.creitiveblog.network;

import java.util.List;

import creitive.com.creitiveblog.model.Blog;
import creitive.com.creitiveblog.model.Token;
import creitive.com.creitiveblog.model.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Defines an interface that creates a client that commuunicates with the server
 */

interface APIService {

    @Headers({
            "X-Client-Platform: Android",
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("login")
    Observable<Token> userLogin(@Body User user);

    @Headers({
            "X-Client-Platform: Android",
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET(Blog.GET_LIST)
    Observable<List<Blog>> getBlogList(@Header("X-Authorize") String token);
}
