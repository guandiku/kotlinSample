package com.xiamen.www.myapplication3.kotlin.test.hotrepaire;

import android.content.Context;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * Created by White on 2018/4/6.
 */

public class FixDexUtils {

    private static HashSet<File> loadedDex = new HashSet<>();

    static {
        loadedDex.clear();
    }


    public static void loadFixedDex(Context context) {
        if (context == null) return;
        File fileDir = context.getDir(MyConstants.DEX_DIR, Context.MODE_PRIVATE);
        File[] listFiles = fileDir.listFiles();
        for (File file : listFiles) {
            if (file.getName().startsWith("classes") && file.getName().endsWith(".dex")) {
                loadedDex.add(file);
            }
        }

        //和之前apk里面的dex合并
        doDexInject(context, fileDir, loadedDex);
    }

    private static void doDexInject(Context context, File fileDir, HashSet<File> loadedDex) {
        String optimizeDir = fileDir.getAbsolutePath() + File.separator + "opt_dex";
        File fopt = new File(optimizeDir);
        if (!fopt.exists()) {
            fopt.mkdirs();
        }

        //1.加载应用程序的dex
        //拿到系统的dex
        PathClassLoader pathloader = (PathClassLoader) context.getClassLoader();
        //2.拿到自己的dex 由谁加载呢
        for (File dex : loadedDex) {
            DexClassLoader classLoader = new DexClassLoader(
                    dex.getAbsolutePath(), fopt.getAbsolutePath(), null, pathloader);
            //3.合并
            //BaseDexClassLoader ->DexPathList
            //DexPathList --->Element[] dexElements
            //把Element[] dexElements 改了--->合并
            try {
                Object dexObj = getPathList(classLoader);
                Object mDexElementsList = getDexElements(dexObj);


                Object patObj = getPathList(pathloader);
                Object pathDexElementsList = getDexElements(patObj);

                //合并
                Object dexElements = combineArray(mDexElementsList, pathDexElementsList);
                //需要重新赋值给DexPathList.dexElements
                setFiled(patObj, patObj.getClass(), "dexElements", dexElements);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    //合并数组
    private static Object combineArray(Object arrayLhs, Object arrayRhs) {
        Class<?> localClass = arrayLhs.getClass().getComponentType();
        int i = Array.getLength(arrayLhs);
        int j = i + Array.getLength(arrayRhs);
        Object result = Array.newInstance(localClass, j);
        for (int k = 0; k < j; ++k) {
            if (k < i) {
                Array.set(result, k, Array.get(arrayLhs, k));
            } else {
                Array.set(result, k, Array.get(arrayRhs, k - i));
            }
        }
        return result;
    }

    private static Object getDexElements(Object dexObj) throws NoSuchFieldException, IllegalAccessException {

        return getField(dexObj, dexObj.getClass(), "dexElements");

    }


    private static Object getPathList(Object pathClassLoader) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return getField(pathClassLoader, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }


    private static Object getField(Object obj, Class<?> cl, String field) throws NoSuchFieldException, IllegalAccessException {
        //获取到baseDexClassLoader里面的名字叫做field的成员
        Field localField = cl.getDeclaredField(field);
        localField.setAccessible(true);
        return localField.get(obj);
    }

    private static void setFiled(Object patObj, Class<?> aClass, String dexElements, Object obj) throws NoSuchFieldException, IllegalAccessException {
        Field localField = aClass.getDeclaredField(dexElements);
        localField.setAccessible(true);
        localField.set(patObj, obj);
    }


}
