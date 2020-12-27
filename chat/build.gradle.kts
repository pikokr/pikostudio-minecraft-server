tasks {
    shadowJar {
        archiveBaseName.set("chat")
    }

    create<Copy>("installToServer") {
        from(shadowJar)
        var dest = File(rootDir, "server/plugins")
        if (File(dest, shadowJar.get().archiveFileName.get()).exists()) dest = File(dest, "update")
        into(dest)
        doLast { println("${shadowJar.get().archiveFileName.get()} copied to ${dest.path}") }
    }
}

dependencies {
    implementation("im.kimcore:inko.kt:1.1")
}
