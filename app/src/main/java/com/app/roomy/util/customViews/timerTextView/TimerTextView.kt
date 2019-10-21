package com.app.roomy.util.customViews.timerTextView

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView

import java.util.Timer
import java.util.TimerTask

class TimerTextView : AppCompatTextView {
    private var onTimerTextViewEventsWatcher: OnTimerTextViewEventsWatcher? = null
    private var SchedulerTask: Timer? = null
    private var timerHandler: Handler? = null
    private var totalTime: Int = 0
    private var period = 1000
    private var delay = 0

    fun setPeriod(period: Int) {
        this.period = period
    }

    fun setDelay(delay: Int) {
        this.delay = delay
    }

    constructor(context: Context, p: Int) : super(context) {
        timerHandler = Handler(context.mainLooper)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        timerHandler = Handler(context.mainLooper)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        timerHandler = Handler(context.mainLooper)
    }

    fun setOnTimerTextViewEventsWatcher(onTimerTextViewEventsWatcher: OnTimerTextViewEventsWatcher) {
        this.onTimerTextViewEventsWatcher = onTimerTextViewEventsWatcher
    }

    fun startCounting(totalSeconds: Int) {

        this.totalTime = totalSeconds
        timerHandler!!.post {
            if (onTimerTextViewEventsWatcher != null) {
                onTimerTextViewEventsWatcher!!.onStarCounting()
            }
        }

        if (SchedulerTask != null) {
            SchedulerTask!!.cancel()
            SchedulerTask = null
        }
        SchedulerTask = Timer()
        SchedulerTask!!.schedule(object : TimerTask() {
            override fun run() {

                if (totalTime > 0) {
                    val minuets = totalTime / 60
                    val seconds = totalTime % 60
                    totalTime -=1
                    timerHandler!!.post {
                        if (onTimerTextViewEventsWatcher != null) {
                            onTimerTextViewEventsWatcher!!.onCounting()
                        }
                        text="زمان باقی مانده تا ارسال مجدد کد $minuets دقیقه و $seconds ثانیه میباشد."
                    }
                } else {
                    timerHandler!!.post {
                        visibility=View.INVISIBLE
                        if (onTimerTextViewEventsWatcher != null) {
                            onTimerTextViewEventsWatcher!!.onStopCounting()
                        }
                    }


                    SchedulerTask!!.cancel()
                    SchedulerTask = null
                }
            }
        }, delay.toLong(), period.toLong())

    }


}
