# VersatiaExample-DI-Beans

Three `@LocalBean` classes created in dependency order, each taking the plugin's `Logger`, a bean every plugin has without declaring it.

Part of the [Versatia examples](https://github.com/VersatiaFramework/VersatiaExamples); documentation: [Dependency injection](https://versatiaframework.github.io/VersatiaDocs/docs/dependency-injection).

**Start with** [`Beans.kt`](src/main/kotlin/com/github/marcoral/versatia/example/beans/Beans.kt).

## What the log shows

```
[VersatiaExample-DI-Beans] Clock created
[VersatiaExample-DI-Beans] Greeter created, Clock injected
[VersatiaExample-DI-Beans] Banner created; Greeter says: Hello! It is ...
```

## Things to try

- Make `Greeter` depend on `Banner`: the build fails with `Dependency cycle: ...Greeter -> ...Banner -> ...Greeter`.
- Rename a class: the bean names change with it, nothing else does.
- Replace `logger: Logger` in `Clock` with `plugin: BeansPlugin` and log with `plugin.logger`: the
  main class is a bean too, named `plugin`, injectable by its own type or any supertype
  (`JavaPlugin`, `Plugin`). Take it when you need more than its logger.

## Building

Requires JDK 21 and VersatiaStarter with what it exports (VersatiaAPI, the module APIs) in your
local Maven repository (`./gradlew publishToMavenLocal` in each checkout; see
[Building the framework](https://versatiaframework.github.io/VersatiaDocs/docs/contributing/building));
running it requires a Paper 1.21.4 server with VersatiaCore installed.

```bash
./gradlew build
```

To have the JAR copied to your server after every build, copy `local.properties.example` to
`local.properties` and set `pluginsDir`. The generated descriptor is in
`build/generated/ksp/main/kotlin`; open it to see exactly what the runtime executes.
