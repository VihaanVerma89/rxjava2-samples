package com.vihaan.rxjava2.ui.networking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.vihaan.rxjava2.R;
import com.vihaan.rxjava2.models.ApiUser;
import com.vihaan.rxjava2.models.User;
import com.vihaan.rxjava2.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class NetworkingActivity extends AppCompatActivity {
    public static final String TAG = NetworkingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);
    }

    public void map(View view) {

        Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUser/{userId}")
                .addPathParameter("userId", "1")
                .build()
                .getObjectObservable(ApiUser.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ApiUser, User>() {
                    @Override
                    public User apply(ApiUser apiUser) throws Exception {
                        return new User(apiUser);
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "user : " + user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.logError(TAG, e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private Observable<List<User>> getCricketFanObservable() {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllCricketFans")
                .build()
                .getObjectListObservable(User.class);
    }

    private Observable<List<User>> getFootballFansObservable() {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFootballFans")
                .build()
                .getObjectListObservable(User.class);
    }

    public void zip(View view) {
        findUsersWhoLovesBoth();
    }

    private void findUsersWhoLovesBoth() {
        Observable.zip(getCricketFanObservable(), getFootballFansObservable(),
                new BiFunction<List<User>, List<User>, List<User>>() {
                    @Override
                    public List<User> apply(List<User> users, List<User> users2) throws Exception {
                        List<User> userWhoLovesBoth =
                                filterUserWhoLovesBoth(users, users2);
                        return userWhoLovesBoth;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> users) {

                        // do anything with user who loves both
                        Log.d(TAG, "userList size : " + users.size());
                        for (User user : users) {
                            Log.d(TAG, "user : " + user.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.logError(TAG, e);
                    }


                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }

                });
    }

    private List<User> filterUserWhoLovesBoth
            (List<User> cricketFans, List<User> footballFans) {
        List<User> userWhoLovesBoth = new ArrayList<>();
        for (User cricketFan : cricketFans) {
            for (User footballFan : footballFans) {
                if (cricketFan.id == footballFan.id) {
                    userWhoLovesBoth.add(cricketFan);
                }
            }
        }
        return userWhoLovesBoth;
    }

    private Observable<List<User>> getAllMyFriendsObservable() {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFriends/{userId}")
                .addPathParameter("userId", "1")
                .build()
                .getObjectListObservable(User.class);
    }

    public void flatMapAndFilter(View view) {

        getAllMyFriendsObservable()
                .flatMap(new Function<List<User>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(List<User> users) throws Exception {
                        return Observable.fromIterable(users);
                    }
                })
                ;


    }
}
