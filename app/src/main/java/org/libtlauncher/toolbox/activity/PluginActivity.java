package org.libtlauncher.toolbox.activity;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.Utils.pluginUtil.PluginAdapter;
import org.libtlauncher.toolbox.Utils.pluginUtil.T_Plugin;
import org.libtlauncher.toolbox.Utils.pluginUtil.base.RecyclerBaseAdapter;
import org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.readInfo;
import org.libtlauncher.toolbox.xposed.info.publicInfo;
import org.libtlauncher.toolbox.debug.LOG;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import xyz.hasnat.sweettoast.SweetToast;

import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.JsInitLoader;

public class PluginActivity extends AppCompatActivity {

    private static List<T_Plugin> plugins =new ArrayList<T_Plugin>();

    private RecyclerView recyclerView;
    private PluginAdapter adapter;
    private Handler handler=new Handler(){
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    LOG.LOGD(LOG.LOG_Java,"Recive msg");
                    adapter.notifyDataSetChanged();
                    break;
                default:
                   break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plugin);

        JsInitLoader(this, readInfo.hpk,false);
        SweetToast.info(this,"Loading...");
       // TextView Title = findViewById(R.id.titleqwq);

        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr,"font/Sans.ttf");
       // Title.setTypeface(tf);

        getWindow().setStatusBarColor(0xFFFFFFFF);

        recyclerView=findViewById(R.id.MainRecyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,1));



        adapter=new PluginAdapter(this,R.layout.plugin_item,plugins);
        adapter.setItemClickListener(new RecyclerBaseAdapter.OnItemClickListener(){
            @Override
            public void onItemClickListener(View view, int position) {
            }
            @Override
            public void onItemLongClickListener(View view, int position){
            }
            @Override
            public void onItemDoubleTapListener(View view, int position){
            }
        });
        recyclerView.setAdapter(adapter);


        Bmob.initialize(this, publicInfo.InfoKey);
        BmobQuery<T_Plugin> bmobQuery = new BmobQuery<T_Plugin>();
        bmobQuery.findObjects(new FindListener<T_Plugin>() {
            @Override
            public void done(List<T_Plugin> list, BmobException e) {
                if(e==null){
                    plugins.clear();
                    //list.size();
                    plugins.addAll(list);
                    Message msg=new Message();
                    msg.what=1;
                    msg.obj=list;
                    handler.sendMessage(msg);
                }else{
                    LOG.LOGD(LOG.LOG_Java,e.toString());
                }
            }
        });
    }

    public void BackActivity(View v){
        this.finish();
    }


}
