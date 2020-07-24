package br.com.envolvedesenvolve.infocapoeira;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Cristiano M. on 23/07/2020
 */

public class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }
}
