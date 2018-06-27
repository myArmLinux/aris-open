package com.ss.aris.open.pipes.impl;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.net.URISyntaxException;

public class ShareIntent {

    private Intent intent;

    public ShareIntent(String action) {
        intent = new Intent(action);
    }

    public ShareIntent() {
        String action = Intent.ACTION_VIEW;
        intent = new Intent(action);
    }

    public void setAction(String action){
        intent.setAction(action);
    }

    public String getAction(){
        return intent.getAction();
    }

    public void setType(String type){
        intent.setType(type);
    }

    public void setData(String data){
        intent.setData(Uri.parse(data));
    }

    public void setComponentName(String pkg, String cls){
        intent.setComponent(new ComponentName(pkg, cls));
    }

    public void setComponentName(String componentName){
        if (componentName.contains(",")){
            String[] split = componentName.split(",");
            intent.setComponent(new ComponentName(split[0], split[1]));
        }
    }

    public void putExtra(String key, String value){
        intent.putExtra(key, value);
    }

    public String getStringExtra(String key){
        return intent.getStringExtra(key);
    }

    public boolean containsKey(String key){
        Bundle bundle = intent.getExtras();
        return bundle != null && bundle.containsKey(key);
    }

    @Override
    public String toString() {
        return intent.toUri(0);
    }

    public static ShareIntent from(String uri) {
        if(uri.startsWith("android-app:")){
            try {
                ShareIntent intent = new ShareIntent();
                intent.intent = Intent.parseUri(uri, 0);
                return intent;
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public Intent toIntent() {
        return intent;
    }

}
