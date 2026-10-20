package com.github.marcoral.versatia.example.beans

import com.github.marcoral.versatia.di.LocalBean
import java.time.Instant
import java.util.logging.Logger

/** Every plugin has a `Logger` bean, its own `plugin.logger`; each bean here takes it to log. */
@LocalBean
class Clock(logger: Logger) {
    init {
        logger.info("Clock created")
    }

    fun now() = Instant.now()
}

/** Constructor injection: the runtime creates `Clock` first. */
@LocalBean
class Greeter(private val clock: Clock, logger: Logger) {
    init {
        logger.info("Greeter created, Clock injected")
    }

    fun greeting() = "Hello! It is ${clock.now()}."
}

@LocalBean
class Banner(greeter: Greeter, logger: Logger) {
    init {
        logger.info("Banner created; Greeter says: ${greeter.greeting()}")
    }
}
