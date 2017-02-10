package in.co.thingsdata.gurukul.services.request;

import android.content.Context;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.co.thingsdata.gurukul.data.GetStudentListInClassData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;

import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_ACCESS_TOKEN;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_CLASS_ID;
import static in.co.thingsdata.gurukul.services.helper.JSONParsingEnum.JSON_FIELD_SECTION_ID;

/**
 * Created by Vikas on 2/10/2017.
 */

public class GetStudentListInClassReq extends CommonRequest {
    private GetStudentListInClassData mData;

    public interface GetStudentListInClassCallback {
        void onGetStudentListResponse(ResponseCode res, GetStudentListInClassData data);
    }
    private GetStudentListInClassCallback mAppCallback;

    public GetStudentListInClassReq(Context context, GetStudentListInClassData data, GetStudentListInClassCallback cb) {
        super(context, RequestType.COMMON_REQUEST_GET_STUDENT_LIST_IN_CLASS,
                CommonRequestMethod.COMMON_REQUEST_METHOD_POST, null);
        mData = data; mAppCallback = cb;

        Map<String, String> param = new HashMap<>();
        param.put(JSON_FIELD_ACCESS_TOKEN, data.getAccessToken());
        param.put(JSON_FIELD_CLASS_ID, Integer.toString(data.getClassId()));
        param.put(JSON_FIELD_SECTION_ID, Integer.toString(data.getSectionId()));
        setParam(param);
    }

    @Override
    public void onResponseHandler(JSONObject response) {
        //TODO: Parse and add data into mData student list
        mAppCallback.onGetStudentListResponse(ResponseCode.COMMON_RES_SUCCESS, mData);
    }

    @Override
    public void onErrorHandler(VolleyError error) {

    }
}
