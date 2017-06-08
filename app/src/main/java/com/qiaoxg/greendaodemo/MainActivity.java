package com.qiaoxg.greendaodemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.qiaoxg.greendaodemo.Entity.DaoMaster;
import com.qiaoxg.greendaodemo.Entity.DaoSession;
import com.qiaoxg.greendaodemo.Entity.UserBean;
import com.qiaoxg.greendaodemo.Entity.UserBeanDao;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);

                    insertUser("xiaoming", "beijing");

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);

                    insertUser("xiaoqiang", "beijing,chaoyang");
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);

                    insertUser("xiaowang", "beijing");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUserDao();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /**
     * 获取StudentDao
     */
    DaoMaster daoMaster;
    DaoSession daoSession;
    UserBeanDao userDao;

    private void getUserDao() {
        // 创建数据
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "greendaodemo.db", null);
        daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
        userDao = daoSession.getUserBeanDao();
    }

    private void insertUser(String name, String address) {
        UserBean bean = new UserBean();
        bean.setId(null);//必须设为null，因为在table里边是自增的，如果不setId，会报错：SQLiteConstraintException:UNIQUE constraint failed
        bean.setAddress(address);
        bean.setName(name);
        String uuid = UUID.randomUUID().toString();
        bean.setUuid(uuid);
        long id = userDao.insert(bean);
    }

}
