plugins {
    java
    `maven-publish`
    id("com.gradleup.shadow") version "8.3.0"
}

group = "com.gmail.nossr50.mcMMO"
version = "2.2.041-SNAPSHOT"
description = "mcMMO"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
//    withSourcesJar()
//    withJavadocJar()
}

val kyoriAdventureVersion = "4.23.0"
val kyoriAdventurePlatformVersion = "4.4.1"
val kyoriOptionVersion = "1.1.0"
val spigotVersion = "1.21.1-R0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://maven.enginehub.org/repo/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://repo.aikar.co/content/groups/aikar/")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
    maven("https://repo.tcoded.com/releases/")
}

dependencies {
    // Provided
    compileOnly("org.spigotmc:spigot-api:$spigotVersion")
    compileOnly("me.clip:placeholderapi:2.11.6")

    // Compile
    implementation("com.google.guava:guava:33.2.0-jre")
    implementation("org.apache.tomcat:tomcat-jdbc:10.1.24")
    implementation("org.apache.tomcat:tomcat-juli:10.1.24")
    implementation("org.bstats:bstats-base:3.0.2")
    implementation("org.bstats:bstats-bukkit:3.0.2")
    implementation("co.aikar:acf-bukkit:0.5.1-SNAPSHOT")
    implementation("com.tcoded:FoliaLib:0.5.1")
    implementation("com.comphenix.protocol:ProtocolLib:5.3.0")
    implementation("com.sk89q.worldedit:worldedit-bukkit:7.2.0-SNAPSHOT")
    implementation("com.sk89q.worldguard:worldguard-core:7.0.7") {
        exclude("com.google.code.findbugs", "jsr305")
    }
    implementation("com.sk89q.worldguard:worldguard-legacy:7.0.0-SNAPSHOT") {
        exclude("org.bukkit", "bukkit")
    }
    implementation("org.apache.maven.scm:maven-scm-provider-gitexe:2.1.0")
    implementation("org.jetbrains:annotations:24.1.0")

    // Kyori
    implementation("net.kyori:adventure-api:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-key:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-nbt:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-platform-api:$kyoriAdventurePlatformVersion")
    implementation("net.kyori:adventure-platform-bukkit:$kyoriAdventurePlatformVersion")
    implementation("net.kyori:adventure-platform-facet:$kyoriAdventurePlatformVersion")
//    implementation("net.kyori:adventure-platform-viaversion:$kyoriAdventurePlatformVersion")
    implementation("net.kyori:adventure-text-serializer-bungeecord:$kyoriAdventurePlatformVersion")
    implementation("net.kyori:adventure-text-serializer-commons:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-text-serializer-gson:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-text-serializer-gson-legacy-impl:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-text-serializer-json:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-text-serializer-json-legacy-impl:$kyoriAdventureVersion")
    implementation("net.kyori:adventure-text-serializer-legacy:$kyoriAdventureVersion")
//    implementation("net.kyori:examination-api:$kyoriAdventureVersion")
//    implementation("net.kyori:examination-string:$kyoriAdventureVersion")
    implementation("net.kyori:option:$kyoriOptionVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
    archiveClassifier.set("")
    relocate("net.kyori", "com.gmail.nossr50.mcmmo.kyori")
    relocate("co.aikar.commands", "com.gmail.nossr50.mcmmo.acf")
    relocate("co.aikar.locales", "com.gmail.nossr50.mcmmo.locales")
    relocate("org.apache.commons.logging", "com.gmail.nossr50.mcmmo.commons.logging")
    relocate("org.apache.juli", "com.gmail.nossr50.mcmmo.database.tomcat.juli")
    relocate("org.apache.tomcat", "com.gmail.nossr50.mcmmo.database.tomcat")
    relocate("org.bstats", "com.gmail.nossr50.mcmmo.metrics.bstats")
    relocate("com.tcoded.folialib", "com.gmail.nossr50.mcmmo.folialib")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "neetgames"
            url = uri(
                if (version.toString().endsWith("SNAPSHOT"))
                    "https://nexus.neetgames.com/repository/maven-snapshots/"
                else
                    "https://nexus.neetgames.com/repository/maven-releases/"
            )
        }
    }
}