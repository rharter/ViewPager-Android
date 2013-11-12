# ViewPager-Android

Based on the Android support library's ViewPager class, this ViewPager supports both horizontal and vertical paging views.

# Usage

## ViewPager

This ViewPager is a drop in replacement for the support library version.  Simply reference the library and replace your ViewPager imports with this version.

Reference in your XML like this.

```xml
<com.ryanharter.viewpager.ViewPager
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/pager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:orientation="vertical"/>
```

Notice that you can use `app:orientation="vertical"` to easily set the orientation of the ViewPager to vertical.  Orientation defaults to horizontal.

You can also set orientation in code using `mViewPager.setOrientation(ViewPager.ORIENTATION_VERTICAL)`.

## PagerAdapter

Again, the PagerAdapter included here is a drop in replacement.  Simply change you import from `android.support.v4.view.PagerAdapter` to `com.ryanharter.viewpager.PagerAdapter` and you're good to go.

I still need to add `FragmentPagerAdapter` and FragmentStatePagerAdapter` subclasses to easily replace those, but if you need them now it shouldn't be difficult.
