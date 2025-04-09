package com.klenovn.game.presentation.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import com.klenovn.game.R
import kotlin.math.min

class ChessBoardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var cellWidth = 0f
    private var cellHeight = 0f
    private val lightPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val darkPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        attrs?.let {
            context.withStyledAttributes(it, R.styleable.ChessBoardView) {
                lightPaint.color = getColor(
                    R.styleable.ChessBoardView_lightColor,
                    ContextCompat.getColor(context, R.color.chess_light)
                )
                darkPaint.color = getColor(
                    R.styleable.ChessBoardView_darkColor,
                    ContextCompat.getColor(context, R.color.chess_dark)
                )
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = min(
            MeasureSpec.getSize(widthMeasureSpec),
            MeasureSpec.getSize(heightMeasureSpec)
        )
        setMeasuredDimension(size, size)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        cellWidth = (w / 8).toFloat()
        cellHeight = (h / 8).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (row in 0 until 8) {
            for (col in 0 until 8) {
                val left = col * cellWidth
                val top = row * cellHeight
                val paint = if ((row + col) % 2 == 0) lightPaint else darkPaint

                canvas.drawRect(left, top, left + cellWidth, top + cellHeight, paint)
            }
        }
    }
}