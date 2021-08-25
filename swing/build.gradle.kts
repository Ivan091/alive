plugins {
    application
}

application {
    mainClass.set("alive.SwingApplication")
}

dependencies {
    implementation(project(":model"))
    implementation("org.springframework:spring-beans")
    implementation("org.springframework:spring-core")
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-core")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
}