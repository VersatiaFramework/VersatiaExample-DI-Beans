package com.github.marcoral.versatia.example.beans

import com.github.marcoral.versatia.di.LocalBean
import java.time.Instant

@LocalBean
class Clock {
    init {
        log("created")
    }

    fun now() = Instant.now()
}

/** Constructor injection: the runtime creates `Clock` first. */
@LocalBean
class Greeter(private val clock: Clock) {
    init {
        log("created, Clock injected")
    }

    fun greeting() = "Hello! It is ${clock.now()}."
}

/** The main class is injectable by its own type or any supertype (`JavaPlugin`, `Plugin`). */
@LocalBean
class Banner(greeter: Greeter, plugin: BeansPlugin) {
    init {
        log("created; ${plugin.name} says: ${greeter.greeting()}")
    }
}
