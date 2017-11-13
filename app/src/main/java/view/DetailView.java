package view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.Justin.Yuan.ClinicalSkillApp.MainActivity;
import com.Justin.Yuan.ClinicalSkillApp.R;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.IOException;
import java.io.InputStream;

import model.DetailModel;

/**
 * Created by RUI on 2017/5/28.
 */

public class DetailView extends Fragment {
    private  MainActivity mainActivity;
    DetailModel detailModel;
    HtmlTextView htmlTextView;

    public DetailView(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    public void refresh(DetailModel detailModel, MainActivity mainActivity) {
//        FragmentManager f=mainActivity.getSupportFragmentManager();
//        FragmentTransaction transaction =  f.beginTransaction();
//        transaction.replace(R.id.webview,this);
//        transaction.commit();
        this.detailModel=detailModel;
        // 装载web
        if(htmlTextView!=null){

                htmlTextView.setHtml(readAssetsTxt(mainActivity,detailModel.getHtml()+".htm"), new HtmlHttpImageGetter(htmlTextView));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout recyclerView = (LinearLayout) inflater.inflate(
                R.layout.detail, container, false);
        htmlTextView = (HtmlTextView) recyclerView.findViewById(R.id.html_text);
//// 设置可以支持缩放
//        webView.getSettings().setSupportZoom(true);
//// 设置出现缩放工具
//        webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setDisplayZoomControls(false);
////扩大比例的缩放
//        webView.getSettings().setUseWideViewPort(true);
////自适应屏幕
//        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//
//        webView.getSettings().setLoadWithOverviewMode(true);

        refresh(detailModel,mainActivity);
        return recyclerView;
    }

    /**
     * 读取assets下的txt文件，返回utf-8 String
     * @param context
     * @param fileName
     * @return
     */
    public static String readAssetsTxt(Context context, String fileName){
        try {
            //Return an AssetManager instance for your application's package
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "gb2312");
            // Finally stick the string into the text view.
            return text;
        } catch (IOException e) {
            // Should never happen!
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return "读取错误，请检查文件名";
    }
}
