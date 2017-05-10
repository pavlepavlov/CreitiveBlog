package creitive.com.creitiveblog.network;

import android.content.Context;
import android.widget.Toast;

import java.net.UnknownHostException;

import creitive.com.creitiveblog.R;
import retrofit2.HttpException;

/**
 * Handles errors from server and displays according message
 */

public class GenericErrorHandler {

    public static final int FLAG_LOGIN = 37;
    public static final int FLAG_BLOG = 3737;

    /*
    406 (if the media type is unsupported, e.g. candicate sends wrong or no “Accept” header)
    415 (if the “Content-Type” is not “application/json” on the /login route)
    400 (if the request is bad on /login route, e.g. forgot email or password)
    401 on login route IF credentials are wrong
    401 on /blogs and /blogs/{id} if token is missing
    404 on /blogs/{id} if the ID does not exist
     */
    public static void handleError(Context context, Throwable error, int flagRoute) {
        if (error instanceof HttpException) {
            HttpException exception = (HttpException) error;
            switch (exception.code()) {
                case 400:
                    Toast.makeText(context, R.string.missing_parameter, Toast.LENGTH_SHORT).show();
                    break;
                case 401:
                    if(flagRoute == FLAG_LOGIN){
                        Toast.makeText(context, R.string.wrong_credentials, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(context, R.string.missing_token, Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 404:
                    Toast.makeText(context, R.string.blog_doesnt_exist, Toast.LENGTH_SHORT).show();
                    break;
                case 406:
                    Toast.makeText(context, R.string.missing_header, Toast.LENGTH_SHORT).show();
                    break;
                case 415:
                    Toast.makeText(context, R.string.missing_header, Toast.LENGTH_SHORT).show();

            }
        }
        else if( error instanceof UnknownHostException){
            Toast.makeText(context, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, R.string.parsing_error, Toast.LENGTH_SHORT).show();
        }
    }
}
