package com.violympic.general;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.violympic.toanlop1.R;


@Keep
public class AdmobManager {

    public static InterstitialAd mInterstitialAd;

    public static void doInitialize(Context context) {
        try {
            MobileAds.initialize(context, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                }
            });
        } catch (Exception e) {

        }
    }

    public static void doLoadInterstitialAd(Context context) {
        try {
            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(context, context.getString(R.string.admob_inapp), adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    // The mInterstitialAd reference will be null until
                    // an ad is loaded.
                    mInterstitialAd = interstitialAd;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    // Handle the error
                    mInterstitialAd = null;
                }
            });
        } catch (Exception e) {

        }
    }

    public static void doShowInterstitialAd(Activity activity) {
        try {
            if (mInterstitialAd != null) {
                mInterstitialAd.show(activity);
            } else {

            }
        } catch (Exception e) {

        }
    }


}
