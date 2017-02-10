package in.co.thingsdata.gurukul.services.request;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.co.thingsdata.gurukul.data.MarkSheetData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;

import static in.co.thingsdata.gurukul.services.helper.CommonRequest.RequestType.COMMON_REQUEST_GET_RESULT;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_ACCESS_TOKEN;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_EXAM_TYPE;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_ROLL_NUMBER;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_YEAR;

/**
 * Created by Vikas on 2/10/2017.
 */

public class GetResultReq extends CommonRequest {
    MarkSheetData mData;

    public interface GetResultCallback {
        void onResultResponse(ResponseCode res, MarkSheetData data);
    }
    private GetResultCallback mAppCallback;

    public GetResultReq(Context context, MarkSheetData data, GetResultCallback cb) {
        super(context, COMMON_REQUEST_GET_RESULT, CommonRequestMethod.COMMON_REQUEST_METHOD_POST, null);
        mData = data; mAppCallback = cb;

        Map<String, String> param = new HashMap<>();
        param.put(JSON_FIELD_ACCESS_TOKEN, data.getAccessToken());
        param.put(JSON_FIELD_ROLL_NUMBER, Integer.toString(data.getRollNumber()));
        param.put(JSON_FIELD_YEAR, Integer.toString(data.getExamYear()));
        param.put(JSON_FIELD_EXAM_TYPE, data.getExamType());

        setParam(param);
    }

    @Override
    public void onResponseHandler(JSONObject response) {
        //TODO: Parse response and add subject wise marks in mData.
        mAppCallback.onResultResponse(ResponseCode.COMMON_RES_SUCCESS, mData);
    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
