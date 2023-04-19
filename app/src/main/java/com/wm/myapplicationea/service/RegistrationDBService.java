import static com.wm.myapplicationea.utils.DbUtilHelper.DB_REGISTRATION_TABLE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wm.myapplicationea.dto.RegistrationDto;
import com.wm.myapplicationea.utils.DbUtilHelper;

import java.util.ArrayList;
import java.util.List;

public class RegistrationDBService {
    private DbUtilHelper helper;

    public RegistrationDBService(Context context){
        helper = new DbUtilHelper(context);
    }

    public void addRegistration(RegistrationDto registrationDto){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues value = new ContentValues();
    }

    public List<RegistrationDto> findAll(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(DB_REGISTRATION_TABLE, columns, null, null, null, null, null);
        //TODO
        return new ArrayList<>();
    }
}
