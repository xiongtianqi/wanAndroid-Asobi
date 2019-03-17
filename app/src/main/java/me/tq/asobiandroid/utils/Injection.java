package me.tq.asobiandroid.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import me.tq.asobiandroid.arch.mvp.IPresenter;
import me.tq.asobiandroid.data.DataManager;

/**
 * author:Tianqi
 * date:2019/3/16
 */
public class Injection {


    @SuppressWarnings("unchecked")
    public static <T extends IPresenter> T getPresenter(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getConstructor(DataManager.class);
            return (T) constructor.newInstance(DataManager.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
