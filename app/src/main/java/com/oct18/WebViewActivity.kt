package com.oct18

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.oct18.databinding.ActivityWebViewBinding

private const val TAG = "WebViewActivity"

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val url="https://www.google.com/"
        //binding.webView.loadUrl(url)

        binding.webView.loadUrl("file:///android_asset/hello.html")
        with(binding.webView.settings) {
            builtInZoomControls = true
            javaScriptEnabled = true
        }

        binding.webView.webViewClient= object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.progressBar.visibility= View.VISIBLE
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                Log.i(TAG, "Error Received")
                view!!.loadUrl("file:///android_asset/error.html")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBar.visibility=View.GONE
            }
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return super.shouldOverrideUrlLoading(view, url)
            }
        }
    }


    override fun onBackPressed() {
        if(binding.webView.canGoBack()){
            binding.webView.goBack()
        }else {
            super.onBackPressed()
        }
    }


}