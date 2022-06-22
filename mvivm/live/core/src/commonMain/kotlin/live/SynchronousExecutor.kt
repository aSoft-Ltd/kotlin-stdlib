@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package live

import functions.Runnable
import koncurrent.Executor
import kotlin.js.JsExport
import kotlin.jvm.JvmField

class SynchronousExecutor(val name: String) : Executor {

    companion object {
        @JvmField
        val Default = SynchronousExecutor("Default Synchronous Executor")
    }

    override fun execute(runnable: Runnable) = runnable.run()
}