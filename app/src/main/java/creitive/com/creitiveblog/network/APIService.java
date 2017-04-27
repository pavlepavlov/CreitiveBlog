package creitive.com.creitiveblog.network;

import creitive.com.creitiveblog.model.Token;
import creitive.com.creitiveblog.model.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 */

interface APIService {

    @Headers({
            "X-Client-Platform: Android",
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("login")
    Observable<Token> userLogin(@Body User user);
}
