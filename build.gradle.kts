plugins {
    id("org.openrewrite.build.language-library") version "latest.release"
}

description = "Rewrite Toml"

val latest = if (project.hasProperty("releasing")) {
    "latest.release"
} else {
    "latest.integration"
}

tasks.register<JavaExec>("generateAntlrSources") {
    mainClass.set("org.antlr.v4.Tool")

    args = listOf(
        "-o", "src/main/java/org/openrewrite/toml/internal/grammar",
        "-package", "org.openrewrite.toml.internal.grammar",
        "-visitor"
    ) + fileTree("src/main/antlr").matching { include("**/*.g4") }.map { it.path }

    classpath = sourceSets["main"].runtimeClasspath
}

dependencies {
    implementation(platform("org.openrewrite:rewrite-bom:${latest}"))
    implementation("org.openrewrite:rewrite-core")
    implementation("org.antlr:antlr4-runtime:4.11.1")
    implementation("io.micrometer:micrometer-core:1.9.+")

    compileOnly("org.openrewrite:rewrite-test")

    testImplementation("org.openrewrite:rewrite-test")
}
