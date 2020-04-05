import godot.tasks.GenerateApiTask
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

//TODO: this needs to be properly configured! This is just a basic setup to be able to implement the annotations
kotlin {
    macosX64("macos")
    linuxX64("linux")
    mingwX64("windows")

    val internalSourceSet = sourceSets.create("nativeInternal")
    val coreSourceSet = sourceSets.create("nativeCore") { dependsOn(internalSourceSet) }
    val generatedSourceSet = sourceSets.create("nativeGen") { dependsOn(coreSourceSet) }
    val publicSourceSet = sourceSets.create("nativePublic") { dependsOn(generatedSourceSet) }


    targets.withType<KotlinNativeTarget> {
        compilations.getByName("main") {
            defaultSourceSet {
                dependsOn(internalSourceSet)
                dependsOn(generatedSourceSet)
                dependsOn(coreSourceSet)
                dependsOn(publicSourceSet)
            }
            val gdnative by cinterops.creating {
                defFile("src/nativeInterop/cinterop/godot.def")
                includeDirs("$rootDir/godot-kotlin/godot-headers/", "src/nativeInterop/cinterop")
            }
        }
    }
}

val generateAPI by tasks.creating(GenerateApiTask::class) {
    source.set(project.file("$rootDir/godot-kotlin/godot-headers/api.json"))
    outputDirectory.set(project.file("$rootDir/godot-kotlin/godot-library/src/nativeGen/kotlin/"))
}

tasks {
    build {
        dependsOn(generateAPI)
    }
}