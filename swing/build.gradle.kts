plugins {
    application
}

application {
    mainClass.set("alive.SwingApplication")
}

dependencies {
    implementation(project(":model"))
    implementation("org.springframework.boot:spring-boot-autoconfigure")
}