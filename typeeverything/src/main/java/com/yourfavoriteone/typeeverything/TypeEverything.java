package com.yourfavoriteone.typeeverything;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Sriram S on 1/18/2017.
 */

public class TypeEverything {
    private static final String TAG="TypeEverything";
    private static HashMap<String, Typeface> mFontMap=null;

    public static void with(Context context){
        initialize(context);
        ViewGroup viewRoot = (ViewGroup)((Activity)context).getWindow().getDecorView().getRootView();
        parseViewByTag(context, viewRoot);

    }


    private static void initialize(Context context){
        if(null==mFontMap){
            mFontMap = new HashMap<>();
        }
    }

    private static void parseViewByTag(Context context, ViewGroup viewRoot ){
        int childCount = viewRoot.getChildCount();
        for(int i=0; i<childCount; i++){
            View child = viewRoot.getChildAt(i);
            if(child instanceof ViewGroup){
                parseViewByTag(context, viewRoot);
            }else{
                String childTag = (String)child.getTag(R.id.font_path);
                if(childTag!=null){
                    if(child instanceof TextView){
                        TextView tvChild = (TextView)child;
                        int typeStyle = tvChild.getTypeface().getStyle();
                        tvChild.setTypeface();
                    }
                }

            }
        }
    }



}
