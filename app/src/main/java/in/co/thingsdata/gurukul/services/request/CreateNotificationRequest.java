package in.co.thingsdata.gurukul.services.request;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.co.thingsdata.gurukul.data.CreateNotificationData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;

import static in.co.thingsdata.gurukul.services.helper.CommonRequest.RequestType.COMMON_REQUEST_CREATE_NOTIFICATION;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_ACCESS_TOKEN;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_NOTIFICATION_CREATE_DATE;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_NOTIFICATION_DESCRIPTION;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_NOTIFICATION_EXPIRY_DATE;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_NOTIFICATION_TITLE;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_NOTIFICATION_TYPE;

/**
 * Created by Vikas on 2/24/2017.
 */

public class CreateNotificationRequest extends CommonRequest {
    private CreateNotificationData mData;

    public interface CreateNotificationCallback {
        void onCreateNotificationResponse(ResponseCode res, CreateNotificationData data);
    }
    private CreateNotificationCallback mAppCallback;

    public CreateNotificationRequest(Context context, CreateNotificationData data, CreateNotificationCallback cb) {
        super(context, COMMON_REQUEST_CREATE_NOTIFICATION, CommonRequestMethod.COMMON_REQUEST_METHOD_POST, null);

        mAppCallback = cb; mData = data;
        Map<String, String> param = new HashMap<>();
        param.put(JSON_FIELD_ACCESS_TOKEN, data.getAccessToken());
        param.put(JSON_FIELD_NOTIFICATION_CREATE_DATE, data.getCreateDate());
        param.put(JSON_FIELD_NOTIFICATION_EXPIRY_DATE, data.getExpiryDate());
        param.put(JSON_FIELD_NOTIFICATION_TITLE, data.getTitle());
        param.put(JSON_FIELD_NOTIFICATION_DESCRIPTION, data.getDescription());
        param.put(JSON_FIELD_NOTIFICATION_TYPE, data.getNotificationType().toString());
        setParam(param);
    }

    @Override
    public void onResponseHandler(JSONObject response) {
        mAppCallback.onCreateNotificationResponse(ResponseCode.COMMON_RES_SUCCESS, mData);
    }

    @Override
    public void onErrorHandler(VolleyError error) {
        mAppCallback.onCreateNotificationResponse(ResponseCode.COMMON_RES_FAILED_TO_CONNECT, mData);
    }
}
