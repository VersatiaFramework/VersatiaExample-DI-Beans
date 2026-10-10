    # VersatiaExample-DI-Beans

    Three `@LocalBean` classes created in dependency order, one of them taking the plugin instance, which is a bean without any annotation.

    Part of the [Versatia examples](https://github.com/VersatiaFramework/VersatiaExamples); documentation: [Dependency injection](https://versatiaframework.github.io/VersatiaDocs/docs/dependency-injection/).

    **Start with** [`Beans.kt`](src/main/kotlin/com/github/marcoral/versatia/example/beans/Beans.kt).

    ## What the log shows

    ```
    [Clock] created
[Greeter] created, Clock injected
[Banner] created; VersatiaExample-DI-Beans says: Hello! It is ...
    ```


## Things to try

- Make `Greeter` depend on `Banner`: the build fails with `Dependency cycle: Banner -> Greeter -> Banner`.
- Rename a class: the bean names change with it, nothing else does.

## Building

Requires JDK 21 and VersatiaAPI in your local Maven repository (`./gradlew publishToMavenLocal`
in its checkout); running it requires a Paper 1.21.4 server with VersatiaCore installed.

```bash
./gradlew build
```

To have the JAR copied to your server after every build, copy `local.properties.example` to
`local.properties` and set `pluginsDir`. The generated descriptor is in
`build/generated/ksp/main/kotlin`; open it to see exactly what the runtime executes.
