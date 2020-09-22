import android.content.Context

class Contextor {

    companion object {

        private lateinit var context: Context

        fun setContext(context: Context) {
            this.context = context
        }

        fun getContext(): Context {
            return context
        }
    }
}