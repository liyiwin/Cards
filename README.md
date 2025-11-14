# Cards
![](https://i.imgur.com/Tr3uhpg.png)

## 使用的Animation

* ### 翻牌效果 :

    
   #### 卡片放縮小
    ```
    <scale
        android:fromXScale="100%"
        android:fromYScale="100%"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="0%"
        android:toYScale="100%">

    </scale>
    ```
    
    #### 卡片放大
    ```
    <scale
        android:fromXScale="0%"
        android:fromYScale="100%"
        android:pivotX="50%"
        android:pivotY="50%"
        android:toXScale="100%"
        android:toYScale="100%">

    </scale>
    ```

* ### 消失效果 :

```
<alpha xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromAlpha="1.0"
    android:toAlpha="0.0"
    android:duration="3000"
    android:fillAfter="true">
</alpha>
```

* ### 震動效果 :

```
<translate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="1000"
    android:fromXDelta="0"
    android:toXDelta="10"
    android:interpolator="@anim/cycle" />

```
