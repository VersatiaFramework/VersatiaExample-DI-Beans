package com.github.marcoral.versatia.example.beans

import com.github.marcoral.versatia.di.LocalBean
import java.time.Instant

/** The main class is injectable by its own type or any supertype (`JavaPlugin`, `Plugin`); each bean here takes it for its logger. */
@LocalBean
class Clock(plugin: BeansPlugin) {
    init {
        plugin.logger.info("Clock created")
    }

    fun now() = Instant.now()
}

/** Constructor injection: the runtime creates `Clock` first. */
@LocalBean
class Greeter(private val clock: Clock, plugin: BeansPlugin) {
    init {
        plugin.logger.info("Greeter created, Clock injected")
    }

    fun greeting() = "Hello! It is ${clock.now()}."
}

@LocalBean
class Banner(greeter: Greeter, plugin: BeansPlugin) {
    init {
        plugin.logger.info("Banner created; Greeter says: ${greeter.greeting()}")
    }
}
