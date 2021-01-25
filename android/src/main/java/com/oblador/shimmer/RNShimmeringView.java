package com.oblador.shimmer;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

public class RNShimmeringView extends ShimmerFrameLayout {

    private Shimmer.Builder builder = new Shimmer.AlphaHighlightBuilder();

    public RNShimmeringView(Context context) {
        super(context);
    }

    public RNShimmeringView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RNShimmeringView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RNShimmeringView(
            Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void updateShimmer() {
        setShimmer(builder.build());
    }

    public Shimmer.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Shimmer.Builder builder) {
        this.builder = builder;
    }
}