package com.oblador.shimmer;


import android.graphics.Color;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.shimmer.Shimmer;

public class RNShimmerManager extends ViewGroupManager<RNShimmeringView> {

    public static final String REACT_CLASS = "RNShimmeringView";

    private Shimmer.Builder builder = new Shimmer.AlphaHighlightBuilder();

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public RNShimmeringView createViewInstance(ThemedReactContext context) {
        return new RNShimmeringView(context);
    }

    @ReactProp(name = "useColors", defaultBoolean = false)
    public void useColors(RNShimmeringView view, boolean value) {
        if (value) {
            builder = new Shimmer.ColorHighlightBuilder();
        } else {
            builder = new Shimmer.AlphaHighlightBuilder();
        }
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "highlightColor", defaultInt = 0xFFFFFFFF)
    public void setHighlightColor(RNShimmeringView view, String value) {
        if (this.builder instanceof Shimmer.ColorHighlightBuilder) {
            ((Shimmer.ColorHighlightBuilder)this.builder).setHighlightColor(Color.parseColor(value));
        }
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "baseColor", defaultInt = 0x4cffffff)
    public void setBaseColor(RNShimmeringView view, String value) {
        if (this.builder instanceof Shimmer.ColorHighlightBuilder) {
            ((Shimmer.ColorHighlightBuilder)this.builder).setBaseColor(Color.parseColor(value));
        }
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "animating", defaultBoolean = true)
    public void setAnimating(RNShimmeringView view, boolean value) {
        this.builder.setAutoStart(value);
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "shimmeringOpacity", defaultFloat = 0.5f)
    public void setBaseOpacity(RNShimmeringView view, float value) {
        if (value > 1.0f) {
            value = 1.0f;
        }
        if (value < 0.0f) {
            value = 0.0f;
        }

        this.builder.setBaseAlpha(value);
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "animationOpacity", defaultFloat = 1.0f)
    public void setHighlightOpacity(RNShimmeringView view, float value) {
        if (value > 1.0f) {
            value = 1.0f;
        }
        if (value < 0.0f) {
            value = 0.0f;
        }

        this.builder.setHighlightAlpha(value);
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "shimmeringDirection")
    public void setDirection(RNShimmeringView view, String value) {
        int direction = Shimmer.Direction.LEFT_TO_RIGHT;
        switch (value) {
            case "up":
                direction = Shimmer.Direction.BOTTOM_TO_TOP;
                break;
            case "left":
                direction = Shimmer.Direction.RIGHT_TO_LEFT;
                break;
            case "down":
                direction = Shimmer.Direction.TOP_TO_BOTTOM;
                break;
            case "right":
            default:
                break;
        }

        this.builder.setDirection(direction);
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "duration", defaultInt = 1000)
    public void setDuration(RNShimmeringView view, int value) {
        if (value < 0) {
            value = 0;
        }

        this.builder.setDuration(value);
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "pauseDuration", defaultInt = 400)
    public void setPauseDuration(RNShimmeringView view, int value) {
        if (value < 0) {
            value = 0;
        }

        this.builder.setRepeatDelay(value);
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "tilt", defaultFloat = 0.0f)
    public void setTilt(RNShimmeringView view, int value) {
        this.builder.setTilt(value);
        view.updateShimmer(this.builder);
    }

    @ReactProp(name = "intensity", defaultFloat = 0.0f)
    public void setIntensity(RNShimmeringView view, float value) {
        if (value > 1.0f) {
            value = 1.0f;
        }
        if (value < 0.0f) {
            value = 0.0f;
        }

        this.builder.setIntensity(value);
        view.updateShimmer(this.builder);
    }
}
