package in.co.thingsdata.gurukul.services.request;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.co.thingsdata.gurukul.data.common.UserData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;

import static in.co.thingsdata.gurukul.services.helper.CommonRequest.RequestType.COMMON_REQUEST_GET_USER_DATA;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_ACCESS_TOKEN;

/**
 * Created by Vikas on 2/11/2017.
 */

public class GetUserDataRequest extends CommonRequest {
    public GetUserDataRequest(Context context, String accessToken) {
        super(context, COMMON_REQUEST_GET_USER_DATA, CommonRequestMethod.COMMON_REQUEST_METHOD_GET, null);

        Map<String, String> param = new HashMap<>();
        param.put(JSON_FIELD_ACCESS_TOKEN, accessToken);
        setPostHeader(param);
    }

    @Override
    public void onResponseHandler(JSONObject response) {
        //TODO: Parse response and fill the static class UserData.
    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
